package address.data;

// You need to import the java.sql package to use JDBC

import address.AddressBook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DataBaseConnect {
    public String userName = "";
    public String password = "";

    /**
     * @param args
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException{

        // Load the Oracle JDBC driver
        Class.forName ("oracle.jdbc.OracleDriver"); //name of driver may change w/ versions

        //check Oracle documentation online
        // Or could do DriverManager.registerDriver (new oracle.jdbc.OracleDriver());

        String [] login = readLogin("src/oracleDatabase.txt");

//        System.out.println(login[0]);
//        System.out.println(login[1]);



        // Connect to the database
        // generic host url = jdbc:oracle:thin:login/password@host:port/SID for Oracle SEE Account INFO you
        // were given by our CS tech in an email ---THIS WILL BE DIFFERENT
        //jdbc:oracle:thin:@//adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu
        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:"+ login[0] +"/"+login[1]+"@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");

        // Create a Statement
        Statement stmt = conn.createStatement ();



        // Select the all (*) from the table JAVATEST

        ResultSet rset = stmt.executeQuery("SELECT * FROM ADDRESSENTRYTABLE");

        System.out.println(rset);



        // Iterate through the result and print the employee names

        while (rset.next ()) //get next row of table returned

        {         for(int i=1; i<=rset.getMetaData().getColumnCount(); i++) //visit each column

            System.out.print(rset.getString(i) + " | ");

            System.out.println(" ");

            System.out.println("========================================");

        }



        //Close access to everything...will otherwise happen when disconnect

        // from database.

        rset.close();

        stmt.close();

        conn.close();

    }

    public static String[] readLogin(String filename){
        //AddressBook adBook = new AddressBook();
        //try catch if filename not found
        String [] login = new String[]{};
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
//                System.out.println(login[0]);
//                System.out.println(login[1]);




//                return login;
                line = br.readLine();
            }
//            u = login[0];
//            p = login[1];




            //Close file
            br.close();


        } catch(FileNotFoundException fe){
            //Catch if file not found
            System.out.println("File not found: " + filename);
        } catch(IOException ioe){
            //Catch if file not read properly
            System.out.println("Can't read from file: " + filename);
        }

    return login;
    }

    public void setUser(String p){
        this.userName = p;
    }
    public void setPass(String p){
        this.password = p;
    }
}
