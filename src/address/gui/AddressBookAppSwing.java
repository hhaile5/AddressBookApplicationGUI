package address.gui;

import address.AddressBook;
import address.data.AddressEntry;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookAppSwing extends JFrame {

    public JPanel PanelMain = new JPanel();

    //BUTTONS
    private JButton displayButton = new JButton();
    private JButton newButton = new JButton();
    private JButton removeButton = new JButton();

    //JList
     JList listEntries;
     static DefaultListModel addressEntryListModel;


    static AddressBook book1 = new AddressBook();

    JScrollPane scroll;





    public AddressBookAppSwing(){
        book1.readFromFile("src/testEntry2.txt");
        book1.sortEntries();
        book1.list();

//CREATE ENTRY WITH CONSTRUCTOR
//        AddressEntry entry1 = new AddressEntry();
//        entry1.setID(0);
//        entry1.setFirstName("Abe");
//        entry1.setLastName("Lemon");
//        entry1.setCity("Dublin");
//        entry1.setPhone("999-888-1234");
//        entry1.setStreet("Green Rd");
//        entry1.setState("Oklahoma");
//        entry1.setZip(90210);
//        entry1.setEmail("abeL@gmail.com");
//        book1.addressEntryList.add(entry1);


        this.addressEntryListModel = new DefaultListModel();
        String entry="";

        for(int i=0; i < book1.addressEntryList.size(); i++){
            this.addressEntryListModel.add(i, this.book1.addressEntryList.get(i));
        }

//        addressEntryListModel.getElementAt(0).
        this.listEntries = new JList<AddressEntry>(this.addressEntryListModel);


        this.listEntries.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

//        this.listEntries.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//        listEntries.setFont( new Font("monospaced", Font.PLAIN, 10) );
//        this.listEntries.setFixedCellWidth(100);

        this.listEntries.setVisibleRowCount(-1);
//        this.listEntries.setFixedCellWidth(50);

        scroll = new JScrollPane(listEntries);
//        scroll.setViewportView(listEntries);
        listEntries.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//        listEntries.setSelectionBackground(Color c);

//        PanelMain.add(scroll);

        GroupLayout layout = new GroupLayout(PanelMain);





        displayButton.setText("DISPLAY");
        newButton.setText("NEW");
        removeButton.setText("REMOVE");
        removeButton.setEnabled(false);


//        scroll.getViewport().setPreferredSize(new Dimension(512,448));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scroll.setPreferredSize(new Dimension(1200, 300));
//        scroll.updateUI();

        scroll.setEnabled(true);
        scroll.setWheelScrollingEnabled(true);
//        scroll.pack();

//        scroll.setPreferredSize(new Dimension(250, 250));




//        scroll.add(displayButton);
//        scroll.add(newButton);
//        scroll.add(removeButton);
        PanelMain.add(scroll, BorderLayout.CENTER);
        PanelMain.add(displayButton);
        PanelMain.add(newButton);
        PanelMain.add(removeButton);



//        PanelMain.add(listScrollPane, BorderLayout.CENTER);



        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listEntries.clearSelection();


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
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JPanel panel = new JPanel();
                JFrame frame = new JFrame("AddEntry");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //Create and set up the content pane.
                frame.setContentPane(new AddEntry().panel);


                //Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                removeButton.setEnabled(true);
                int index = listEntries.getSelectedIndex();

                if(index != -1)//something is selected otherwise do nothing

                {   //retrieve the DeffaultListModel associated
                    // with our JList and remove from it the AddressEntry at this index
//                    int removeIndex = listEntries.getSelectedIndex();
                    ((DefaultListModel<AddressEntry>) (listEntries.getModel())).remove(index);

                    //Remove from addressEntryList
                    book1.addressEntryList.remove(index);
                    book1.list();
                    for(int i=index; i < book1.addressEntryList.size(); i++) {
                        book1.addressEntryList.get(i).setID(i+1);
                    }
                    // NOTE in your project 2 you will also remove it from your AddressBook.addressEntryList
                    // AND ALSO remove it from the associated database table

                }
                else{
//                    removeButton.setEnabled(false);
                }
            }
        });
        listEntries.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
//                removeButton.setEnabled(true);//Enable here
                checkSelection();
            }
        });

    }



    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {

//        JFrame frame = new JFrame("AddressBookAppSwing");
//        frame.setContentPane(new AddressBookAppSwing().PanelMain);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);


        //Create and set up the window.
        JFrame frame = new JFrame("AddressBookAppSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        frame.setContentPane(new AddressBookAppSwing().PanelMain);




//        JComponent newContentPane = new JComponent() {
//        };
//        newContentPane.setOpaque(true); //content panes must be opaque
//        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
//        frame.setSize(1000,600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public void checkSelection() {
        if (listEntries.isSelectionEmpty() )
        {
            removeButton.setEnabled(false);
        }
        else{
            removeButton.setEnabled(true);
        }
    }



}

