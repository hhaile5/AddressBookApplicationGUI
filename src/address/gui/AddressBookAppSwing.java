package address.gui;

import address.AddressBook;
import address.data.Address;
import address.data.AddressEntry;
import address.data.Name;

import javax.swing.*;
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
      * defaultListModel addressEntryListModel to transfer entries from arrayList to JList ListEntries
      */
     static DefaultListModel addressEntryListModel;

    /**
     * AddressBook book1 creates an AddressBook object to hold all entries in addressEntryList
     */
    static AddressBook book1 = new AddressBook();

    /**
     * JScrollPane scroll create scrollpane for JList
     */
    JScrollPane scroll;

    /**
     * Purpose: Creates a frame with a scrollable JList and three buttons: display, remove, and new
     */
    public AddressBookAppSwing(){
        //book1.readFromFile("src/testEntry2.txt");

        //Read entries from database and save in book1 addressEntryList
        book1.readDataBase();
        book1.sortEntries();
//        book1.list();


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

//        this.listEntries.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//        listEntries.setFont( new Font("monospaced", Font.PLAIN, 10) );
//        this.listEntries.setFixedCellWidth(100);

//        this.listEntries.setVisibleRowCount(-1);
//        this.listEntries.setFixedCellWidth(50);

        //Create scrollpane scroll from listEntries
//        scroll = new JScrollPane(listEntries);

        scroll = new JScrollPane(listEntries);
//        scroll.setViewportView(listEntries);

        //Set listEntries to horizontal_wrap for display
        listEntries.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listEntries.setSelectionBackground(Color.pink);

//        PanelMain.add(scroll);

        //
//        GroupLayout layout = new GroupLayout(PanelMain);

        //Set display button text to DISPLAY
        displayButton.setText("DISPLAY");

        //Set new button text to NEW
        newButton.setText("NEW");

        //Set remove button text to REMOVE
        removeButton.setText("REMOVE");

        //Set remove button to disabled
        removeButton.setEnabled(false);


//        scroll.getViewport().setPreferredSize(new Dimension(512,448));

        //Set vertical and horizontal scrollbars in scrollpane scroll
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);


//        scroll.setPreferredSize(new Dimension(1200, 300));
//        scroll.updateUI();

        //Enable scroll
        scroll.setEnabled(true);
        //Allow scrolling with mouse wheel
        scroll.setWheelScrollingEnabled(true);
//        scroll.pack();

//        scroll.setPreferredSize(new Dimension(250, 250));




        JLabel title = new JLabel("ADDRESS BOOK APP");

        PanelMain.add(title, BorderLayout.PAGE_START);
        //Add scroll to PanelMain
        PanelMain.add(scroll, BorderLayout.CENTER);

        //Add display button to PanelMain
        PanelMain.add(displayButton);

        //Add new button to PanelMain
        PanelMain.add(newButton);

        //Add remove button to PanelMain
        PanelMain.add(removeButton);


        /**
         * Event listener for display button.
         * When clicked show the updated list
         *
         */
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listEntries.clearSelection();
//                PanelMain.remove(scroll);
//                scroll = new JScrollPane(listEntries);
//                PanelMain.add(scroll);



//        scroll.setViewportView(listEntries);

//
//                addressEntryListModel.removeAllElements();
//                listEntries.removeAll();
//
//                for(int i=0; i < book1.addressEntryList.size(); i++){
//                    addressEntryListModel.add(i, book1.addressEntryList.get(i));
//                }
//
////                listEntries = new JList<AddressEntry>(addressEntryListModel);
//                ((DefaultListModel<AddressEntry>) (listEntries.getModel())).addAll((Collection<? extends AddressEntry>) addressEntryListModel);

//                listEntries.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//
//                listEntries.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//
//                listEntries.setVisibleRowCount(-1);
//
//
//                scroll = new JScrollPane(listEntries);
//                scroll.setViewportView(listEntries);
//                listEntries.setLayoutOrientation(JList.HORIZONTAL_WRAP);

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
                JFrame frame = new JFrame("AddEntry");

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

}

