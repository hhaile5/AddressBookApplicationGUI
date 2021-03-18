package address;
import address.data.AddressEntry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Group 7
 * @version 1.0
 * @since  March 2021
 *
 * purpose: This class is used to represent an address book containing address entries.
 *  It has an ArrayList addressEntryList that contains all the entries.
 *  Entries can be added, removed, search/find with operations.
 *  Entries can be added from a file with the function readFromFile();
 *  Entries can be read, added, and removed from a database
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
        addressEntryList = new ArrayList<>();
    }

    /**
     * Prints out all the entries in the addressEntryList arraylist.
     * Entries are sorted in alphabetically ordered.
     */
    public void list(){
        //iterate through addressEntryList
        //for each item call toString & print it out

        //counter to list number of entries
        int x=0;
//        sortEntries();
        //Print every item in addressEntryList
        for(int i=0; i < this.addressEntryList.size(); i++){
            x = i+1;
            System.out.println("\nEntry #" + x);
            System.out.println(this.addressEntryList.get(i).toString());
        }
    }

    /**
     *Sorts all entries in addressEntryList alphabetically by last name.
     *
     */
    public void sortEntries(){
        //temp to hold address entry for swap
        AddressEntry temp;

        //For every entry in list check if ordered alphabetically
        for(int i=0; i < this.addressEntryList.size(); i++){

            //Check entry next to i
            for (int j = i + 1; j < this.addressEntryList.size(); j++) {
                //If entry next to i is not sorted alphabetically
                //swap entries at index i and j
                if (this.addressEntryList.get(i).getName().getLastName().toLowerCase().compareTo(this.addressEntryList.get(j).getName().getLastName().toLowerCase())>0)
                {
                    //Swap
                    temp = this.addressEntryList.get(i);
                    this.addressEntryList.set(i, this.addressEntryList.get(j));
                    this.addressEntryList.set(j, temp);
                }
            }
        }

        //Set ID for all entries
        for(int i=0; i < this.addressEntryList.size(); i++) {
            this.addressEntryList.get(i).setID(i+1);
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
    public void add(AddressEntry newEntry){
        //add new addressEntry object to addressEntryList
        newEntry.setID(addressEntryList.size()+1);
        addressEntryList.add(newEntry);
        sortEntries();

        addDataBase(newEntry);

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
                        entry[1].replaceAll(" ", ""), entry[2], entry[3], entry[4],
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


    /**
     * Searches addressEntryList to find if there are entry last names
     * that contain startof_lastName.
     * @param startof_lastName is the part of a last name that can be found in the arraylist.
     * @return boolean value indicating if value is found or not.
     */
    public boolean find(String startof_lastName){
//        Create new arraylist to store entries found
//         containing start_of_lastname
        ArrayList<Integer> foundIndex = new ArrayList<Integer>();

        //flag indicates if start_of_lastname found in addressEntryList
        boolean flag = false;

        //Iterate through the list
        //To find entries that contain start_of_lastName
        for(int i=0; i < addressEntryList.size(); i++){
            //if entry contains start_of_lastName
            if(addressEntryList.get(i).getName().getLastName().toLowerCase().contains(startof_lastName.toLowerCase())){
                foundIndex.add(i);
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

    /**
     * Searches addressEntryList to find if there are entry last names
     * that contain startof_lastName.
     * @param startof_lastName is the part of a last name that can be found in the arraylist.
     * @return ArrayList foundEntry containing found entries
     */
    public ArrayList findGUI(String startof_lastName){
            // Create new arraylist to store entries found
            //containing start_of_lastname
        ArrayList<AddressEntry> foundIndex = new ArrayList<AddressEntry>();

        //flag indicates if start_of_lastname found in addressEntryList
        boolean flag = false;

        //Iterate through the list
        //To find entries that contain start_of_lastName
        for(int i=0; i < addressEntryList.size(); i++){
            //if entry contains start_of_lastName
            if(addressEntryList.get(i).getName().getLastName().toLowerCase().contains(startof_lastName.toLowerCase())){
                foundIndex.add(addressEntryList.get(i));
                //Print out entry
                System.out.println(addressEntryList.get(i).toString());
                flag = true;
            }
        }
        if(flag == false){
            //If start_of_lastName is not found in addressEntryList
            System.out.println("No entries found.");
        }

        //return ArrayList of all entries found
        return foundIndex;
    }

    /**
     * Reads the username and password to access database
     * @param filename file containing the login information
     * @return String[] login containing username at index 0 and password at index 1
     */
    String[] readLogin(String filename){

        //try catch if filename not found
        /**
         * String array login
         */
        String [] login = new String[]{};

        //try catch file input
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
                login = data.split(",");
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

        //Return String array login[]
        return login;
    }

    /**
     * Access Oracle database
     * Get username and password by reading separate file containing credentials
     * Read in all database entries and create a new AddressEntry object
     * Add the new AddressEntry object to the addressEntryList
     */
    public void readDataBase() {
        //throws SQLException, ClassNotFoundException
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.OracleDriver"); //name of driver may change w/ versions

            //check Oracle documentation online
            // Or could do DriverManager.registerDriver (new oracle.jdbc.OracleDriver());

            String[] login = readLogin("src/oracleDatabase.txt");

            //login[0] is username
            //login[1] is password


            // Connect to the database
            // generic host url = jdbc:oracle:thin:login/password@host:port/SID for Oracle SEE Account INFO you
            // were given by our CS tech in an email ---THIS WILL BE DIFFERENT
            //jdbc:oracle:thin:@//adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu
            Connection conn =
                    DriverManager.getConnection("jdbc:oracle:thin:" + login[0] + "/" + login[1] + "@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");

            // Create a Statement
            Statement stmt = conn.createStatement();


            // Select the all (*) from the table JAVATEST

            ResultSet rset = stmt.executeQuery("SELECT * FROM ADDRESSENTRYTABLE");

//            System.out.println(rset);


            //Variables to store database rows
            int id = 0;
            String[] name = new String[2];
            String[] address = new String[3];
            int zip = 0;
            String phone = "";
            String email = "";
            // Iterate through the result and create a new AddressEntry object
            while (rset.next()) //get next row of table returned

            {
                //Save COLUMN values ID==1 NAME==2 ADDRESS==3 EMAIL==4 PHONE==5
                for (int i = 1; i <= rset.getMetaData().getColumnCount(); i++) { //visit each column

                    if (i == 1) {
                        id = Integer.parseInt(rset.getString(i));
                    } else if (i == 2) {
                        name = rset.getString(i).split(" ");
                    } else if (i == 3) {
                        address = rset.getString(i).split(", ");
                    } else if (i == 4) {
                        email = rset.getString(i);
                    } else if (i == 5) {
                        phone = rset.getString(i);
                    } else {
                    }

                }
                //Create new AddressEntry object
                AddressEntry newEntry = new AddressEntry(id, name[0],
                    name[1], address[0], address[1], address[2],
                    Integer.parseInt(address[3]), phone, email);

                //Add newEntry to addressEntryList
                this.addressEntryList.add(newEntry);

            }


            //Close access to database
            rset.close();

            stmt.close();

            conn.close();

        }catch(SQLException se){
            se.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    /**
     * Access Oracle database
     * Get username and password by reading separate file containing credentials
     * Read in all database entries and create a new AddressEntry object
     * Add the new AddressEntry object to the addressEntryList
     * @param newEntry AddressEntry object to add to the database
     */
    void addDataBase(AddressEntry newEntry) {
        //throws SQLException, ClassNotFoundException
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.OracleDriver"); //name of driver may change w/ versions

            //check Oracle documentation online
            // Or could do DriverManager.registerDriver (new oracle.jdbc.OracleDriver());

            String[] login = readLogin("src/oracleDatabase.txt");


            // Connect to the database
            // generic host url = jdbc:oracle:thin:login/password@host:port/SID for Oracle SEE Account INFO you
            // were given by our CS tech in an email ---THIS WILL BE DIFFERENT
            //jdbc:oracle:thin:@//adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu
            Connection conn =
                    DriverManager.getConnection("jdbc:oracle:thin:" + login[0] + "/" + login[1] + "@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");

            // Create a Prepared Statement sql
            String sql = "INSERT INTO ADDRESSENTRYTABLE (ID, NAME, ADDRESS, EMAIL, PHONE ) VALUES (?, ?, ?, ?, ?)";

            Statement stmt = conn.createStatement();
            String query = ("SELECT * FROM ADDRESSENTRYTABLE WHERE ID=(SELECT max(ID) FROM ADDRESSENTRYTABLE)");
            ResultSet rs = stmt.executeQuery(query);
            rs.next();

            // Create a Prepared Statement st
            PreparedStatement st = conn.prepareStatement(sql);

            int i = 0;
            if(rs.getInt(1) == addressEntryList.size()){
                while(rs.getInt(1) == addressEntryList.size()+i){
                    i++;

                }
                st.setInt(1, addressEntryList.size()+i);
            }
            else{
                st.setInt(1, addressEntryList.size());
            }

            // Set column 2 NAME
            st.setString(2, newEntry.getFirstName()+" "+newEntry.getLastName());

            // Set column 3 ADDRESS
            st.setString(3, newEntry.getCity()+", "+ newEntry.getStreet()
                        + ", " + newEntry.getState() + ", " + newEntry.getZip());

            // Set column 4 EMAIL
            st.setString(4, newEntry.getEmail());

            // Set column 5 PHONE
            st.setString(5, newEntry.getPhone());

            // Update database to add entry with PreparedStatement st
            st.executeUpdate();

            stmt.close();
            rs.close();

            //Close access to st
            st.close();
            //Close access to connection
            conn.close();

        }catch(SQLException se){
            se.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    /**
     * Access database
     * Remove a selected entry from the database.
     * @param index Row to delete from the database
     */
    public void removeDataBase(String index) {
        //throws SQLException, ClassNotFoundException
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.OracleDriver"); //name of driver may change w/ versions

            //check Oracle documentation online
            // Or could do DriverManager.registerDriver (new oracle.jdbc.OracleDriver());

            String[] login = readLogin("src/oracleDatabase.txt");


            // Connect to the database
            // generic host url = jdbc:oracle:thin:login/password@host:port/SID for Oracle SEE Account INFO you
            // were given by our CS tech in an email ---THIS WILL BE DIFFERENT
            //jdbc:oracle:thin:@//adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu
            Connection conn =
                    DriverManager.getConnection("jdbc:oracle:thin:" + login[0] + "/" + login[1] + "@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");


            // Delete index from the database
            // String sql with variable index to deleted from ADDRESSENTRYTABLE
            String sql = "DELETE FROM ADDRESSENTRYTABLE WHERE NAME = ?";

            // PreparedStatement stmt from String sql
            PreparedStatement stmt = conn.prepareStatement(sql);

            //Set string from selected index
            stmt.setString(1, index);

            // execute the preparedstatement
            stmt.execute();


            //Close access to st
            stmt.close();
            //Close access to connection
            conn.close();

        }catch(SQLException se){
            se.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}
