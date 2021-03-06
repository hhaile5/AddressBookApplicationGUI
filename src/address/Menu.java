package address;

import address.data.AddressEntry;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Helen Haile
 * @version 1.0
 * @since  February 2021
 *
 * purpose: This class is used to create a menu for an address book application.
 * Displays a menu from which a user can choose an option:
 *      a) Load From File, b) Add, c) Remove, d) Find, e) List, f) Quit
 */
public class Menu {
    /**
     * Creates a new AddressBook object initialized to nothing.
     */
    //AddressBook book1 = new AddressBook();

//PROMPT METHODS
//PROMPT USER --> READ ENTRY --> RETURN VALUE

    /**
     * Prompts the user for the first name of an entry.
     * @return the first name entered by the user.
     */
    static String prompt_FirstName()
    {
        //User input first name
        Scanner scanner = new Scanner(System.in);
        String fname = "";
        System.out.print("\nEnter first name: ");
        fname = scanner.nextLine();

        //Check that firstName is not empty: 0 characters
        while(fname.isEmpty()){
            System.out.print("\nPlease enter a valid first name: ");
            fname = scanner.nextLine();
        }

        return fname;
    }

    /**
     * Prompts the user for the last name of an entry.
     * @return the last name entered by the user.
     */
    static String prompt_LastName()
    {
        //User input last name
        Scanner scanner = new Scanner(System.in);
        String lname = "";
        System.out.print("\nEnter last name: ");
        lname = scanner.nextLine();

        //Check that lastName is not empty: 0 characters
        while(lname.isEmpty()){
            System.out.print("\nPlease enter a valid last name: ");
            lname = scanner.nextLine();
        }

        return lname;
    }

    /**
     * Prompts the user for the street of an entry.
     * @return the street entered by the user.
     */
    static String prompt_Street()
    {
        //user input for street
        Scanner scanner = new Scanner(System.in);
        String s = "";
        System.out.print("\nEnter street: ");
        s = scanner.nextLine();

        //Check that street is not empty: 0 characters
        while(s.isEmpty()){
            System.out.print("\nPlease enter a valid street: ");
            s = scanner.nextLine();
        }

        return s;
    }

    /**
     * Prompts the user for the city of an entry.
     * @return the city entered by the user.
     */
    static String prompt_City()
    {
        //User input city
        Scanner scanner = new Scanner(System.in);
        String c = "";
        System.out.print("\nEnter city: ");
        c = scanner.nextLine();

        //Check that city is not empty
        while(c.isEmpty()){
            System.out.print("\nPlease enter a valid city: ");
            c = scanner.nextLine();
        }

        return c;
    }

    /**
     * Prompts the user for the state of an entry.
     * @return the state entered by the user.
     */
    static String prompt_State()
    {
        //User input state
        Scanner scanner = new Scanner(System.in);
        String s = "";
        System.out.print("\nEnter state: ");
        s = scanner.nextLine();

        //Check that state is not empty
        while(s.isEmpty()){
            System.out.print("\nPlease enter a valid state: ");
            s = scanner.nextLine();
        }

        return s;
    }

    /**
     * Prompts the user for the phone number of an entry.
     * @return the phone number entered by the user.
     */
    static String prompt_Phone()
    {
        //CODE FOR REGEX MATCHING ***VALIDATION NOT NECESSARY***
//        //Boolean value initially set to false
//        //Indicates if the phone number entered
//        //is valid 10-digit number
//        boolean validPhone = false;
//        String validReturnNum = "";
//
//        //While user keeps entering invalid numbers
//        //Keep asking for a valid number
//        while(validPhone == false) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("\nEnter 10-digit phone number (800-555-1234): ");
//            String p = scanner.nextLine();
//            //if phone number entered has 10 digits
//            if(p.matches("\\d{3}-\\d{3}-\\d{4}")){
//                validReturnNum =p;
//                validPhone = true;
//            }
//            else{
//                System.out.println("Please enter a valid 10-digit number");
//            }
//        }
//        return validReturnNum;

        //User input state
        Scanner scanner = new Scanner(System.in);
        String phone = "";
        System.out.print("\nEnter phone number (8005551234): ");
        phone = scanner.nextLine();

        //Check that state is not empty
        while(phone.isEmpty()){
            System.out.print("\nPlease enter a valid phone number: ");
            phone = scanner.nextLine();
        }

        return phone;
    }

    /**
     * Prompts the user for the email of an entry.
     * @return the email entered by the user.
     */
    static String prompt_Email()
    {
        String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        //Boolean value initially set to false
        //Indicates if the email entered
        //is valid email@address.com
        boolean validEmail = false;
        String validReturnEmail = "";

        //While user keeps entering invalid numbers
        //Keep asking for a valid email
        while(validEmail == false) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter an email address (email@add.com): ");
            String e = scanner.nextLine();
            //if email matches email@add.com
            if(e.matches(emailRegex)){
                validReturnEmail = e;
                validEmail = true;
            }
            else{
                System.out.println("\nPlease enter a valid email address.");
            }
        }
        return validReturnEmail;
    }

    /**
     * Prompts the user for the zip code of an entry.
     * @return the first zip code entered by the user.
     */
    static int prompt_Zip()
    {
        //Any positive integer is accepted
        boolean validZip = false;
        int returnZip = -1;
        Scanner scanner = new Scanner(System.in);
        int z = 0;

        do {
            try {
                System.out.print("\nEnter a zip code: ");
                z = scanner.nextInt();
                while (z < 0) {
                    System.out.print("\nPlease enter a valid zip code: ");
                    z = scanner.nextInt();
                }

            } catch (InputMismatchException exception) {
                System.out.println("Please enter a valid zip.");
                scanner.next();
            }
        }while(z < 0);
        return z;
    }

//DISPLAY MENU, PROMPT USER FOR CHOICE

    /**
     * Displays the menu for the application.
     * Loops until the user enters f (quit).
     * @param book1 use Address Book created in main in AddressBookApplication
     */
    void showMenu(AddressBook book1){
        //OPTION VARIABLE FOR USER ENTRY
        char option='\0';
        Scanner scanner = new Scanner(System.in);


        //DISPLAY MENU
        System.out.println(" ______________________");
        System.out.println("|         MENU         |");
        System.out.println("|======================|");
        System.out.println("| a) Load from file    |");
        System.out.println("| b) Add               |");
        System.out.println("| c) Remove            |");
        System.out.println("| d) Find              |");
        System.out.println("| e) Listing           |");
        System.out.println("|                      |");
        System.out.println("| f) Quit              |");
        System.out.println("|______________________|");

        //DO WHILE USER ENTRY (option) IS NOT 'f'
        do {
            //PROMPT USER FOR OPTION
            System.out.print("\nEnter an option: ");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            //SWITCH CASE FOR USER ENTRY
            //User enters option a, b, c, d, e, f
            switch(option)
            {
                case 'a':
                    //load from file

                    //Prompt user for a file name
                    Scanner scanFileName = new Scanner(System.in);
                    System.out.print("Enter file name: ");
                    String filename = scanFileName.nextLine();

                    //call readFromFile with parameter filename entered by user
//                    book1.readFromFile(filename);

                    break;
                case 'b':
                    //add entry

                    //Prompt user for entry information
                    //CALL EACH PROMPT FUNCTIONS
                    System.out.println("Please enter the following information: ");
                    String f = prompt_FirstName();
                    String l = prompt_LastName();
                    String c = prompt_City();
                    String street = prompt_Street();
                    String state = prompt_State();
                    int z = prompt_Zip();
                    String p = prompt_Phone();
                    String e = prompt_Email();

                    //Create a new AddressEntry with user entered info
                    AddressEntry newEntry = new AddressEntry(book1.addressEntryList.size(), f, l, street, c,
                                                            state, z, p, e);

                    //Add new entry to AddressBook
                    book1.add(newEntry);

                    break;
                case 'c':
                    //remove entry

                    //Prompt user for last name to remove
                    Scanner scanRemove = new Scanner(System.in);
                    System.out.print("\nEnter last name to remove entry: ");
                    String removeEntry = scanRemove.nextLine();

                    //Call the remove function to remove entry
                    book1.remove(removeEntry);


                    break;
                case 'd':
                    //find entry

                    //Prompt user to for last name to find
                    Scanner scanFind = new Scanner(System.in);
                    System.out.print("\nEnter last name to find entry: ");
                    String findEntry = scanFind.nextLine();

                    //Call the find function to search for entry
                    book1.find(findEntry);

                    break;
                case 'e':
                    //List all entries alphabetically by last name

                    //Check if list contains entries
                    if(book1.addressEntryList.isEmpty()){
                        System.out.println("The address book is currently empty.");
                    }
                    else{
                        book1.list();
                    }
                    break;
                case 'f':
                    //quit --> END PROGRAM
                    //Print end message
                    System.out.println("Program Ending. Have a nice day!");
                    break;
                default:
                    //Invalid entry
                    System.out.println("Invalid option: Please try again.");
                    break;
            }
        }while(option != 'f'); // END if 'f' is entered
    }

}
