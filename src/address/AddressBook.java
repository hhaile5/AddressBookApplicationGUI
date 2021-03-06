package address;
import address.data.AddressEntry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Helen Haile
 * @version 1.0
 * @since  February 2021
 *
 * purpose: This class is used to represent an address book containing address entries.
 *  It has an ArrayList addressEntryList that contains all the entries.
 *  Entries can be added, removed, search/find with operations.
 *  Entries can be added from a file with the function readFromFile();
 */
public class AddressBook {

    /**
     * Creates a new arraylist of AddressEntry objects called addressEntryList.
     */
    public ArrayList<AddressEntry> addressEntryList;


    /**
     * AddressBook constructor
     */
    public AddressBook(){
        addressEntryList = new ArrayList<AddressEntry>();
    }

    /**
     * Prints out all the entries in the addressEntryList arraylist.
     * Entries are sorted in alphabetically ordered.
     */
    public void list(){
        //iterate through addressEntryList
        //for each item call toString & print it out

        //call sort() to sort addressEntryList
        //alphabetically by lastname
//        sortEntries();

        //counter to list number of entries
        int x = 0;

        //Print every item in addressEntryList
        for(int i=0; i < addressEntryList.size(); i++){
            x = i+1;
            System.out.println("\nEntry #" + x);
            System.out.println(addressEntryList.get(i).toString());
        }
    }

    /**
     *Sorts all entries in addressEntryList alphabetically by last name.
     *
     */
    public void sortEntries(){
        //temp to hold address entry for swap
        AddressEntry temp;
        int tempIndex;

        //For every entry in list check if ordered alphabetically
        for(int i=0; i < addressEntryList.size(); i++){

            //Check entry next to i
            for (int j = i + 1; j < addressEntryList.size(); j++) {
                //If entry next to i is not sorted alphabetically
                //swap entries at index i and j
                if (addressEntryList.get(i).getName().getLastName().toLowerCase().compareTo(addressEntryList.get(j).getName().getLastName().toLowerCase())>0)
                {
                    //swap entries at i and j
                    temp = addressEntryList.get(i);
//                    tempIndex = i;
                    addressEntryList.set(i, addressEntryList.get(j));
//                    addressEntryList.get(i).setID(j);
                    addressEntryList.set(j, temp);
//                    addressEntryList.get(j).setID(tempIndex);

//                    addressEntryList.get(i).setID(j);
//                    addressEntryList.get(j).setID(i);


                }
            }
        }

        for(int i=0; i < addressEntryList.size(); i++) {
            addressEntryList.get(i).setID(i+1);
        }
    }


    /**
     * Finds all entries with the last name entered.
     * The user then selected which entry to remove.
     * @param lastName is the last name of the entry to be removed from the list.
     */
    void remove(String lastName){
        //call find()
        //Prints entries that contain lastName
        //returns true if entries found
        if(find(lastName)) {
            //String to hold full name to delete
            String removeName="";

            //indicates if name found
            boolean found=false;

            //User enters last name to delete
            Scanner findName = new Scanner(System.in);
            System.out.print("Enter the full name you would like to delete: ");
            String lName = findName.nextLine();

            //Find the last name to delete
            for (int i = 0; i < addressEntryList.size(); i++)
            {
                //Create full name
                removeName = addressEntryList.get(i).getName().getFirstName().toLowerCase()+
                        " " + addressEntryList.get(i).getName().getLastName().toLowerCase();
                //If lname matches the name entered the entry
                if (removeName.contentEquals(lName.toLowerCase()))
                {
                    System.out.println(addressEntryList.get(i).getName().getFirstName() + " "
                            + addressEntryList.get(i).getName().getLastName() + " will be removed.");
                    addressEntryList.remove(i);
                    found= true;
                }
            }
            if(found ==false){
                //Notify user full name entered not found.
                System.out.println(lName + " is not found.");
            }
        }
        else{
            //Last name is not in the list
            //Display "no entries found"
            System.out.println("No entries found.");
        }

    }

    /**
     * Adds a new addressEntry object to addressEntryList arraylist.
     *
     * @param newEntry an AddressEntry instance
     */
    void add(AddressEntry newEntry){
        //add new addressEntry object to addressEntryList
        newEntry.setID(addressEntryList.size()+1);
        addressEntryList.add(newEntry);
    }

//READ FROM FILE START
    /**
     * A file is read to create new address entries are created.
     * The entries are added to the arraylist.
     * @param filename is the file name entered by the user in the menu.
     */
    public void readFromFile(String filename){
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
                AddressEntry newEntry = new AddressEntry(addressEntryList.size()+1,entry[0],
                        entry[1], entry[2], entry[3], entry[4],
                        Integer.parseInt(entry[5]), entry[6], entry[7]);

                //Add entry to addressEntryList
                addressEntryList.add(newEntry);
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

//READ FROM FILE END
    /**
     * Searches addressEntryList to find if there are entry last names
     * that contain startof_lastName.
     * @param startof_lastName is the part of a last name that can be found in the arraylist.
     * @return boolean value indicating if value is found or not.
     */
    boolean find(String startof_lastName){
        //int foundIndex = 0;
        //Create new arraylist to store entries found
        // containing start_of_lastname
        //ArrayList<Integer> foundIndex = new ArrayList<Integer>();

        //flag indicates if start_of_lastname found in addressEntryList
        boolean flag = false;

        //Iterate through the list
        //To find entries that contain start_of_lastName
        for(int i=0; i < addressEntryList.size(); i++){
            //if entry contains start_of_lastName
            if(addressEntryList.get(i).getName().getLastName().toLowerCase().contains(startof_lastName.toLowerCase())){
                //foundIndex.add(i);
                //Print out entry
                System.out.println(addressEntryList.get(i).toString());
                flag = true;
            }
        }
        if(flag == false){
            //If start_of_lastName is not found in addressEntryList
            System.out.println("No entries found.");
        }

        //return true if found
        //return false if not found
        return flag;
    }

}
