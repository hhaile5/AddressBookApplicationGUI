package address.gui;

import address.AddressBook;
import address.data.Address;
import address.data.AddressEntry;
import address.data.Name;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * AddressBookAppSwing
 * Purpose: Creates the main frame for AddressBookApplicationGUI
 * Displays three buttons and a Jlist containing selectable address entries.
 * The address entries are sorted alphabetically by last name
 */
public class AddressBookAppSwing extends JFrame {
    /**
     * JPanel PanelMain creates new JPanel
     */
    public JPanel PanelMain = new JPanel();

    //BUTTONS
    /**
     * JButton displayButton displays entries
     */
    private JButton displayButton = new JButton();
    /**
     * JButton newButton opens new frame that allows user to enter a new entry
     */
    private JButton newButton = new JButton();
    /**
     * JButton removeButton is disabled until the user selects an entry
     * removes an entry selected by the user in the JList
     */
    private JButton removeButton = new JButton();

    //JList
    /**
     * JList listEntries to hold the entries in a selectable list
     */
     JList listEntries;

    /**
     * JList listEntriesFind for entries found
     */
    JList listEntriesFind = new JList();

     /**
      * defaultListModel addressEntryListModel to transfer entries from arrayList to JList ListEntries
      */
     static DefaultListModel addressEntryListModel;

    /**
     * defaultListModel addressEntryListModelFind to transfer entries
     * from foundEntries to JList ListEntriesFound
     */
    static DefaultListModel addressEntryListModelFind = new DefaultListModel();

    /**
     * AddressBook book1 creates an AddressBook object to hold all entries in addressEntryList
     */
    static AddressBook book1 = new AddressBook();

    /**
     * JScrollPane scroll create scrollpane for JList
     */
    JScrollPane scroll;

    /**
     * JScrollPane scroll create scrollpane for JList listEntriesFound
     */
    JScrollPane scrollFind;

    /**
     * Title of AddressBookApp
     */
    JLabel title;

    /**
     * JLabel findLabel label for findTextField
     */
    JLabel findLabel = new JLabel("Find ");

    /**
     * JTextField findText text field for user to enter last name
     */
    JTextField findText = new JTextField(25);

    /**
     * JButton findButton Button on click opens new frame with found entries
     */
    JButton findButton = new JButton("FIND");

    /**
     * String findLastName to store user entry
     */
    String findLastName="";


    /**
     * Purpose: Creates a frame with a scrollable JList and three buttons: display, remove, and new
     */
    public AddressBookAppSwing(){
        //book1.readFromFile("src/testEntry2.txt");

        //Read entries from database and save in book1 addressEntryList
        book1.readDataBase();
        book1.sortEntries();


        //Initialize addressEntryListModel to new DefaultListModel()
        this.addressEntryListModel = new DefaultListModel();

        //Add all entries in addressEntryList to addressEntryListModel
        for(int i=0; i < book1.addressEntryList.size(); i++){
            this.addressEntryListModel.add(i, this.book1.addressEntryList.get(i));
        }

        //Add addressEntryListModel elements to JList listEntries
        this.listEntries = new JList<AddressEntry>(this.addressEntryListModel);

        //Set selection mode to single selection
        this.listEntries.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        scroll = new JScrollPane(listEntries);
        scroll.setViewportView(listEntries);

        //Set listEntries to horizontal_wrap for display
        listEntries.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        //Set the selection color to orange
        listEntries.setSelectionBackground(Color.orange);
        listEntries.setVisibleRowCount(-1);

        //Set display button text to DISPLAY
        displayButton.setText("DISPLAY");

        //Set new button text to NEW
        newButton.setText("NEW");

        //Set remove button text to REMOVE
        removeButton.setText("REMOVE");

        //Set remove button to disabled
        removeButton.setEnabled(false);

        //Set vertical and horizontal scrollbars in scrollpane scroll
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);


        //Enable scroll
        scroll.setEnabled(true);
        //Allow scrolling with mouse wheel
        scroll.setWheelScrollingEnabled(true);



        //Set title to ADDRESS BOOK
        title = new JLabel("ADDRESS BOOK");
        //Set font to monaco an
        title.setFont(new Font("Monaco", Font.BOLD, 16));


        //Add title to PanelMain
        PanelMain.add(title, BorderLayout.CENTER);

        //Add scroll to PanelMain
        PanelMain.add(scroll, BorderLayout.CENTER);

        //Add display button to PanelMain
        PanelMain.add(displayButton);

        //Add new button to PanelMain
        PanelMain.add(newButton);

        //Add remove button to PanelMain
        PanelMain.add(removeButton);

        //Set Background color
        PanelMain.setBackground(Color.pink);

        //Set size to show all entries on open
        PanelMain.setPreferredSize(new Dimension(1200, 350));


        PanelMain.add(findLabel, BorderLayout.PAGE_END);
        PanelMain.add(findText, BorderLayout.PAGE_END);
        PanelMain.add(findButton);

        //Call initialize to create actionListeners for buttons
        initialize();
    }


    private void initialize(){

        /**
         * Event listener for display button.
         * When clicked show the updated list
         * Clear selection
         */
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listEntries.clearSelection();
                listEntries.removeAll();
                addressEntryListModel.removeAllElements();


                //Add all entries in addressEntryList to addressEntryListModel
                for(int i=0; i < book1.addressEntryList.size(); i++){
                    addressEntryListModel.add(i, book1.addressEntryList.get(i));
                }

                //Add addressEntryListModel elements to JList listEntries
                listEntries = new JList<AddressEntry>(addressEntryListModel);

                //Set selection mode to single selection
                listEntries.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                listEntries.setSelectionBackground(Color.orange);
                scroll.setViewportView(listEntries);
                listEntries.addListSelectionListener(new ListSelectionListener() {
                    /**
                     * Calls the checkSelection() method if value changes in listEntries JList
                     * @param e listSelectionEvent for JList listEntries
                     */
                    public void valueChanged(ListSelectionEvent e) {
                        //Call checkSelection to check if an entry is selected by the user
                        checkSelection();
                    }
                });

            }
        });

        /**
         * New button action listener
         * Opens a new frame for user to fill out address entry form.
         * Adds the new entry to JList listEntries and AddressBook object book1's addressEntryList.
         */
        newButton.addActionListener(new ActionListener() {
            /**
             * When newButton is clicked
             * Creates and displays a new frame from AddEntry GUI class
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                //Create JFrame frame with the title AddEntry
                JFrame frame = new JFrame("Add an Entry");

                //Create and set up the content pane.
                frame.setContentPane(new AddEntry().panel);

                //Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });

        /**
         * Remove button action listener
         * Removes an address entry
         * Updates JList listEntries and AddressBook object book1's addressEntryList
         */
        removeButton.addActionListener(new ActionListener() {
            /**
             * Remove a selected entry if JList element selected
             * @param arg0
             */
            @Override
            public void actionPerformed(ActionEvent arg0) {

                // Get the index of the select JList entry
                int index = listEntries.getSelectedIndex();

                //If entry is selected
                if(index != -1)

                {   //retrieve the DeffaultListModel associated
                    // JList listEntries and remove from it the AddressEntry at this index
                    ((DefaultListModel<AddressEntry>) (listEntries.getModel())).remove(index);
                    String n = book1.addressEntryList.get(index).getName().getFirstName() + " " +
                            book1.addressEntryList.get(index).getName().getLastName();
                    //Remove from addressEntryList
                    book1.addressEntryList.remove(index);
                    book1.removeDataBase(n);

                    //Update the index of the entries after the entry is removed
                    for(int i=index; i < book1.addressEntryList.size(); i++) {
                        book1.addressEntryList.get(i).setID(i+1);
                    }

                }
            }
        });
        /**
         * Check if an entry in JList listEntries is selected
         */
        listEntries.addListSelectionListener(new ListSelectionListener() {
            /**
             * Calls the checkSelection() method if value changes in listEntries JList
             * @param e listSelectionEvent for JList listEntries
             */
            public void valueChanged(ListSelectionEvent e) {
                //Call checkSelection to check if an entry is selected by the user
                checkSelection();
            }
        });
        /**
         * findButton action listener
         * When findButton clicked a new window opens with found entries
         */
        findButton.addActionListener(new ActionListener() {
            /**
             * Check if text field is not empty then enable findButton
             * Open a new window displaying all entries found
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //Clear previous entries
                listEntriesFind.clearSelection();
                listEntriesFind.removeAll();
                addressEntryListModelFind.removeAllElements();

                //Store user entry in text field to String findLastName
                findLastName = findText.getText();


                //Return ArrayList of all entries found with search and into foundEntry ArrayList
                ArrayList<AddressEntry> foundEntry = book1.findGUI(findLastName);

                //If no entries found
                // then display in text field "No entries found"
                if(foundEntry.isEmpty()){
                    findText.setText("No Entries Found");
                }
                else{
                    //else create window showing all the entries found

                    //Initialize addressEntryListModelFind to new DefaultListModel()
                    addressEntryListModelFind = new DefaultListModel();

                    //Add all entries in foundEntry to addressEntryListModelFind
                    for(int i=0; i < foundEntry.size(); i++){
                        addressEntryListModelFind.add(i, foundEntry.get(i));
                    }

                    //Add addressEntryListModelFind elements to JList listEntriesFind
                    listEntriesFind = new JList<AddressEntry>(addressEntryListModelFind);

                    //Set selection mode to single selection
                    listEntriesFind.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

                    //Create scrollFind using JList listEntriesFound and set ViewPort
                    scrollFind = new JScrollPane(listEntriesFind);
                    scrollFind.setViewportView(listEntriesFind);

                    //Set vertical and horizontal scrollbars in scrollpane scroll
                    scrollFind.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollFind.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

                    //Set listEntriesFind to horizontal_wrap for display
                    listEntriesFind.setLayoutOrientation(JList.HORIZONTAL_WRAP);
                    listEntriesFind.setVisibleRowCount(-1);

                    //Create JFrame frame with the title AddEntry
                    JFrame frame = new JFrame("Entries Found");

                    //Create and set up the content pane.
                    frame.setContentPane(scrollFind);

                    //Display the window.
                    frame.pack();

                    frame.setVisible(true);

                    //Set text fields to empty when entry added
                    findText.setText("");
                }

            }

        });
        /**
         * DocumentListener to check find text field
         * Check if field is not empty
         */
        DocumentListener textListener = new DocumentListener() {
            /**
             * Text is updated in text field.
             * @param e
             */
            public void changedUpdate(DocumentEvent e) {
                //Call checkTextField() to enable findButton
                //if  the text field is not empty enable the addButton
                checkTextField();
            }

            /**
             * Text is removed from the text field.
             * @param e
             */
            public void removeUpdate(DocumentEvent e) {
                //Call checkTextField() to enable findButton
                //if the text field is not empty enable the findButton
                checkTextField();
            }

            /**
             * Text is inserted into the text field.
             * @param e
             */
            public void insertUpdate(DocumentEvent e) {
                //Call checkTextField() to enable findButton
                //if the text fields is not empty enable the findButton
                checkTextField();
            }
        };

        //Add DocumentListener to findText text field
        findText.getDocument().addDocumentListener(textListener);
    }


    /**
     * Create the GUI and show it.
     */
    private static void createAndShowGUI() {


        //Create and set up the window.
        JFrame frame = new JFrame("AddressBookAppSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        frame.setContentPane(new AddressBookAppSwing().PanelMain);

        //Display the window.
        frame.pack();
        //frame.setSize(1000,600);
        frame.setVisible(true);
    }

    void addComp(JScrollPane p){
        PanelMain.add(p);
    }

    /**
     * Main calls the createAndShowGUI() method to create and display the frame
     * @param args
     */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Check if the Jlist listEntries has an entry selected
     * to enable or disable removeButton
     */
    public void checkSelection() {
        //If not selected
        if (listEntries.isSelectionEmpty() )
        {
            // then removeButton is disabled
            removeButton.setEnabled(false);
        }
        //Jlist entry selected
        else{
            //Enable remove button
            removeButton.setEnabled(true);
        }
    }

    /**
     * Validates the user input in the address entry text fields
     */
    public void checkTextField() {

        //Check if field is not empty
        //Check if zip code consists of ONLY numbers and matches regex
        if (findText.getText().isEmpty()  )
        {
            //If field is not filled out
            //disable button
            findButton.setEnabled(false);
        }
        else{
            //If field is not filled out
            //enable button
            findButton.setEnabled(true);
        }
    }
}

