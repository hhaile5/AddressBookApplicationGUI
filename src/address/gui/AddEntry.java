package address.gui;

import address.data.AddressEntry;
import address.AddressBookApplication;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEntry extends JFrame {
    JPanel panel;
    JLabel firstNameLabel;
    JTextField firstNameText;

    String fName="";

    JLabel lastNameLabel;
    JTextField lastNameText;
    String lName="";

    JLabel cityLabel;
    JTextField cityText;
    String city="";

    JLabel streetLabel;
    JTextField streetText;
    String street="";

    JLabel stateLabel;
    JTextField stateText;
    String state="";

    JLabel zipLabel;
    JTextField zipText;
    int zip=0;

    JLabel emailLabel;
    JTextField emailText;
    String email="";

    JLabel phoneLabel;
    JTextField phoneText;
    String phone="";

    protected JButton addButton = new JButton();

    public AddEntry(){
        initialize();
    }

    public void initialize(){
        firstNameLabel = new JLabel("First Name: ");
        firstNameText = new JTextField(25);

        lastNameLabel = new JLabel("Last Name: ");
        lastNameText = new JTextField(25);

        cityLabel = new JLabel("City: ");
        cityText = new JTextField(25);

        streetLabel = new JLabel("Street: ");
        streetText = new JTextField(25);

        stateLabel = new JLabel("State: ");
        stateText = new JTextField(25);

        zipLabel = new JLabel("Zip Code: ");
        zipText = new JTextField(25);

        phoneLabel = new JLabel("Phone: ");
        phoneText = new JTextField(25);

        emailLabel = new JLabel("Email: ");
        emailText = new JTextField(25);

        addButton.setText("Add Entry");

        panel = new JPanel();
        panel.setLayout(new FlowLayout());


;

        // Create a panel to hold the Add button
//        JPanel panel = new JPanel();
//        panel.setLayout(new FlowLayout());
//        addBtn = new JButton("Add");
//        addBtn.setEnabled(false);


        addButton = new JButton("Add");
        addButton.setEnabled(false);

        // Add event listener to button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                int id = scroll.addressBook.getAddressEntryList().size() + 1;
                lName = lastNameText.getText();
                fName = firstNameText.getText();
                city = cityText.getText();
                street = streetText.getText();
                state = stateText.getText();
                zip = Integer.parseInt(zipText.getText());
                phone = phoneText.getText();
                email = emailText.getText();

                AddressEntry newEntry = new AddressEntry(AddressBookAppSwing.book1.addressEntryList.size()+1, fName, lName, street,
                                            city, state, zip, phone, email);

                AddressBookAppSwing.book1.addressEntryList.add(newEntry);
                AddressBookAppSwing.book1.sortEntries();
                AddressBookAppSwing.addressEntryListModel.removeAllElements();
                AddressBookAppSwing.addressEntryListModel.addAll(AddressBookAppSwing.book1.addressEntryList);
                AddressBookAppSwing.book1.list();
                setVisible(false);

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

        DocumentListener textListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                fName = firstNameText.getText();
                checkTextField();
            }
            public void removeUpdate(DocumentEvent e) {
                fName = firstNameText.getText();
                checkTextField();
            }
            public void insertUpdate(DocumentEvent e) {
                fName = firstNameText.getText();
                checkTextField();
            }
        };

        firstNameText.getDocument().addDocumentListener(textListener);
        lastNameText.getDocument().addDocumentListener(textListener);
        cityText.getDocument().addDocumentListener(textListener);
        streetText.getDocument().addDocumentListener(textListener);
        stateText.getDocument().addDocumentListener(textListener);
        zipText.getDocument().addDocumentListener(textListener);
        phoneText.getDocument().addDocumentListener(textListener);
        emailText.getDocument().addDocumentListener(textListener);

        panel.setLayout(new GridLayout(9,2));
        panel.doLayout();
//        panel.setBackground(Color.PINK);
//        frame2.setSize(300,300);
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
//        container.add(panel);
    }

    public void checkTextField() {
        if (firstNameText.getText().isEmpty() || lastNameText.getText().isEmpty() ||
            cityText.getText().isEmpty() || streetText.getText().isEmpty() ||
            stateText.getText().isEmpty() || zipText.getText().isEmpty() ||
            phoneText.getText().isEmpty() || emailText.getText().isEmpty() )
        {
            addButton.setEnabled(false);
        }
        else{
            addButton.setEnabled(true);
        }
    }
}
