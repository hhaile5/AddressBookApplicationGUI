package address.gui;

import address.data.AddressEntry;
import address.AddressBookApplication;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Purpose: AddEntry creates input text fields for a user to add an entry.
 * Fields: first name, last name, city, street, state, zipcode, phone number, email.
 * Add button disabled until all fields filled out.
*/
public class AddEntry extends JFrame {
    /**
     * JPanel panel
     */
    JPanel panel;

    //FIRSTNAME
    /**
     * JLabel firstNameLabel label for first name input
     */
    JLabel firstNameLabel;

    /**
     * JtextField firstNameText text field for first name input
     */
    JTextField firstNameText;

    /**
     * String variable first name.
     */
    String fName="";

    //LASTNAME
    /**
     * JLabel lastNameLabel label for last name input
     */
    JLabel lastNameLabel;

    /**
     * JtextField lastNameText text field for last name input
     */
    JTextField lastNameText;

    /**
     * String variable for last name.
     */
    String lName="";

    //CITY
    /**
     * JLabel cityLabel label for city input
     */
    JLabel cityLabel;

    /**
     * JtextField cityText text field for city input
     */
    JTextField cityText;

    /**
     * String variable for city.
     */
    String city="";

    //STREET
    /**
     * JLabel streetLabel label for street input
     */
    JLabel streetLabel;

    /**
     * JtextField streetText text field for street input
     */
    JTextField streetText;

    /**
     * String variable for street.
     */
    String street="";

    //STATE
    /**
     * JLabel stateLabel label for state input
     */
    JLabel stateLabel;
    /**
     * JtextField stateText text field for state input
     */
    JTextField stateText;

    /**
     * String variable for state.
     */
    String state="";

    //ZIP CODE
    /**
     * JLabel zipLabel label for zip code input
     */
    JLabel zipLabel;

    /**
     * JtextField zipText text field for zip input
     */
    JTextField zipText;

    /**
     * int variable for zip.
     */
    int zip=0;

    //EMAIL
    /**
     * JLabel emailLabel label for email input
     */
    JLabel emailLabel;

    /**
     * JtextField emailText text field for email input
     */
    JTextField emailText;

    /**
     * String variable for email.
     */
    String email="";

    //PHONE
    /**
     * JLabel phoneLabel label for phone number input
     */
    JLabel phoneLabel;

    /**
     * JtextField phoneText text field for phone input
     */
    JTextField phoneText;

    /**
     * String variable for phone
     */
    String phone="";

    /**
     * JButton addButton for add button to add entry.
     */
    JButton addButton = new JButton();

    /**
     * Calls the initialize method to create address entry form and button.
     */
    public AddEntry(){
        initialize();
    }

    /**
     * Initializes addressEntry attributes and creates the action listener and address entry form.
     */
    public void initialize(){

        //initialize first name label and text field
        firstNameLabel = new JLabel("First Name: ");
        firstNameText = new JTextField(25);

        //initialize last name label and text field
        lastNameLabel = new JLabel("Last Name: ");
        lastNameText = new JTextField(25);

        //initialize city label and text field
        cityLabel = new JLabel("City: ");
        cityText = new JTextField(25);

        //initialize street label and text field
        streetLabel = new JLabel("Street: ");
        streetText = new JTextField(25);

        //initialize state label and text field
        stateLabel = new JLabel("State: ");
        stateText = new JTextField(25);

        //initialize zip label and text field
        zipLabel = new JLabel("Zip Code (DIGITS ONLY): ");
        zipText = new JTextField(25);

        //initialize phone label and text field
        phoneLabel = new JLabel("Phone: ");
        phoneText = new JTextField(25);

        //initialize email label and text field
        emailLabel = new JLabel("Email: ");
        emailText = new JTextField(25);


        //set addButton text to Add Entry
        addButton.setText("Add Entry");

        //Create JPanel panel
        panel = new JPanel();
        //set panel with setLayout
        panel.setLayout(new FlowLayout());


        //create addButton and set text to Add
        addButton = new JButton("Add");
        //set add button to disabled
        addButton.setEnabled(false);

        // Add event listener to button
        /**
         * addButton action listener
         * When addButton clicked a new entry is created
         * JList listEntries and AddressBook object book1 is updated
         */
        addButton.addActionListener(new ActionListener() {
            /**
             * Check if all text fields are not empty then enable addButton
             * Add the entry to the address book and the JList
             * when the add button is clicked
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

//                int id = scroll.addressBook.getAddressEntryList().size() + 1;
                //get user input from text fields and set them to string variiables
                lName = lastNameText.getText();
                fName = firstNameText.getText();
                city = cityText.getText();
                street = streetText.getText();
                state = stateText.getText();
                zip = Integer.parseInt(zipText.getText());
                phone = phoneText.getText();
                email = emailText.getText();

                //Create new AddressEntry object newEntry with string variables
                //set id variable first
                AddressEntry newEntry = new AddressEntry(AddressBookAppSwing.book1.addressEntryList.size()+1, fName, lName, street,
                                            city, state, zip, phone, email);

                //Add newEntry to addressEntryList in book1 AddressBook
                AddressBookAppSwing.book1.add(newEntry);
                //Sort entries alphabetically by  last name
                AddressBookAppSwing.book1.sortEntries();
                //remove current elements from addressEntryListModel
                AddressBookAppSwing.addressEntryListModel.removeAllElements();
                //Add sorted elements into addressEntryListModel
                AddressBookAppSwing.addressEntryListModel.addAll(AddressBookAppSwing.book1.addressEntryList);

                setVisible(false);

                //Set text fields to empty when entry added
                lastNameText.setText("");
                firstNameText.setText("");
                cityText.setText("");
                streetText.setText("");
                stateText.setText("");
                zipText.setText("");
                phoneText.setText("");
                emailText.setText("");
            }
        });


        /**
         * DocumentListener to check address entry text fields
         * Check if fields are not empty
         */
        DocumentListener textListener = new DocumentListener() {
            /**
             * Text is updated in text field.
             * @param e
             */
            public void changedUpdate(DocumentEvent e) {
                //Call checkTextField() to enable addButton
                //if all the text fields are not empty enable the addButton
                checkTextField();
            }

            /**
             * Text is removed from the text field.
             * @param e
             */
            public void removeUpdate(DocumentEvent e) {
                //Call checkTextField() to enable addButton
                //if all the text fields are not empty enable the addButton
                checkTextField();
            }

            /**
             * Text is inserted into the text field.
             * @param e
             */
            public void insertUpdate(DocumentEvent e) {
                //Call checkTextField() to enable addButton
                //if all the text fields are not empty enable the addButton
                checkTextField();
            }
        };

        //Add DocumentListener to each text field in address entry form
        firstNameText.getDocument().addDocumentListener(textListener);
        lastNameText.getDocument().addDocumentListener(textListener);
        cityText.getDocument().addDocumentListener(textListener);
        streetText.getDocument().addDocumentListener(textListener);
        stateText.getDocument().addDocumentListener(textListener);
        zipText.getDocument().addDocumentListener(textListener);
        phoneText.getDocument().addDocumentListener(textListener);
        emailText.getDocument().addDocumentListener(textListener);

        //Create a 9X2 grid layout
        panel.setLayout(new GridLayout(9,2));
        panel.doLayout();
//        panel.setBackground(Color.PINK);
//        frame2.setSize(300,300);

        Border border = BorderFactory.createLineBorder(Color.BLUE, 2);

        // set the border of this component
//        firstNameText.setBorder(border);
//        lastNameLabel.setBorder(border);
//        panel.setBorder(border);
//        addButton.setBorder(border);
        panel.setBackground(Color.orange);

        //Add address entry form labels and text fields to panel
        panel.add(firstNameLabel);
        panel.add(firstNameText);
        panel.add(lastNameLabel);
        panel.add(lastNameText);
        panel.add(streetLabel);
        panel.add(streetText);
        panel.add(cityLabel);
        panel.add(cityText);
        panel.add(stateLabel);
        panel.add(stateText);
        panel.add(zipLabel);
        panel.add(zipText);
        panel.add(phoneLabel);
        panel.add(phoneText);
        panel.add(emailLabel);
        panel.add(emailText);
        panel.add(addButton);
        panel.add(addButton);


        panel.setForeground(Color.pink);

//        addButton.setBackground(Color.pink);
    }

    /**
     * Validates the user input in the address entry text fields
     */
    public void checkTextField() {
        String regex = "[0-9]+";

        //Check if all fields are not empty
        //Check if zip code consists of ONLY numbers and matches regex
        if (firstNameText.getText().isEmpty() || lastNameText.getText().isEmpty() ||
            cityText.getText().isEmpty() || streetText.getText().isEmpty() ||
            stateText.getText().isEmpty() ||
            (zipText.getText().isEmpty() || !zipText.getText().matches(regex)) ||
            phoneText.getText().isEmpty() || emailText.getText().isEmpty() )
        {
            //If at least one field is not filled out
            //disable button
            addButton.setEnabled(false);
        }
        else{
            //If all fields are not filled out
            //enable button
            addButton.setEnabled(true);
        }
    }

}
