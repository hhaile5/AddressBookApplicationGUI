package address;

//import address.data.AddressEntry;

import address.data.AddressEntry;
import address.gui.AddressBookAppSwing;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *   @author Group 7
 *   @version 1.0
 *   @since  March 2021
 *
 *   Purpose:
 *
 */
public class AddressBookApplication {

    /**
     * Reads a file and parses data to create a new address entry
     * @param filename file with address entries
     */
    public static void init(String filename, AddressBook adBook){
        //AddressBook adBook = new AddressBook();
        //try catch if filename not found
        try {
            //Create new BufferedReader for filename
            BufferedReader br = new BufferedReader(new FileReader(filename));
            //Read a line in file
            String line = br.readLine();

            //Read until the end of the file
            while (line != null) {
                //Store line to a String data
                String data = line;
                //Store the line in an array (entry)
                //split by comma
                String[] entry = data.split(", ");

                //Create new AddressEntry with line read from file
                AddressEntry newEntry = new AddressEntry(adBook.addressEntryList.size()+1, entry[0],
                        entry[1], entry[2], entry[3], entry[4],
                        Integer.parseInt(entry[5]), entry[6], entry[7]);

                //Add entry to addressEntryList
                adBook.addressEntryList.add(newEntry);
                line = br.readLine();
            }

            //Close file
            br.close();

        } catch(FileNotFoundException fe){
            //Catch if file not found
            System.out.println("File not found: " + filename);
        } catch(IOException ioe){
            //Catch if file not read properly
            System.out.println("Can't read from file: " + filename);
        }

    }


    /**
     * Creates two new address entries.
     * Adds the two entries to AddressBook ab.
     * Lists the contents of ab.
     * @param ab
     */
    public static void  initAddressBookExercise(AddressBook ab){
        // Create 2 instances of AddressEntry

        //AddressEntry instance 1
        AddressEntry entry1 = new AddressEntry();
        entry1.setFirstName("Abe");
        entry1.setLastName("Lemon");
        entry1.setCity("Dublin");
        entry1.setPhone("999-888-1234");
        entry1.setStreet("Green Rd");
        entry1.setState("Oklahoma");
        entry1.setZip(90210);
        entry1.setEmail("abeL@gmail.com");

        //AddressEntry instance 2
        AddressEntry entry2 = new AddressEntry(ab.addressEntryList.size()+1,"Loola", "Bee", "Road Rd.", "Tracy", "CA",
        93678, "888-555-4444", "loo@hotmail.edu");

        //Add both entries to ab AddressBook
        ab.add(entry1);
        ab.add(entry2);

        //List the contents of address book
        ab.list();

    }

    public static void main(String[] args) {
//        JPanel PanelMain;

        //create an instance of AddressBook called ab
        AddressBook ab = new AddressBook();

        //Call initAddressBookExercise
//        initAddressBookExercise(ab);

        //Call init(filename, ab)
//        init("src/com/AddressBookApp/testEntry.txt", ab);
//        ab.list();

        //Display menu
//        Menu menu = new Menu();
//        menu.showMenu(ab);

        JFrame frame = new JFrame("AddressBookAppSwing");
        frame.setContentPane(new AddressBookAppSwing().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}
