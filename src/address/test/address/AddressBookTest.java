package address;

import address.data.AddressEntry;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {
    //Create new address book
    AddressBook bookTest = new AddressBook();
    //Create a new addressEntryList
    ArrayList<AddressEntry> addressEntryList = new ArrayList<>();
    //Create entries to add to addressEntryList
    AddressEntry testEntry1 = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-5555", "email@email.edu");
    AddressEntry testEntry2 = new AddressEntry(2, "FirstName2", "LastName2", "Street2", "City2", "State2", 90210, "555-5555", "email@email.edu");
    AddressEntry testEntry3 = new AddressEntry(3, "FirstName3", "LastName3", "Street3", "City3", "State3", 90210, "555-5555", "email@email.edu");

    //Empty string list
    String list ="";

    //Entries as a string formatted the same as toString()
    String displayEntry1 = " " +
            "ID  :   " + 1 + "     " +
            " |     First Name: " + "FirstName" + "     " +
            " |     Last Name : " + "LastName"+ "     " +
            " |     Street: " + "Street" + "     " +
            " |     City: " + "City" + "     " +
            " |     State: " + "State"  + "     " +
            " |     Zip: " + "90210"  + "     " +
            " |     Phone: " + "555-5555" + "     " +
            " |     Email: " + "email@email.edu";
    String displayEntry2 = " " +
            "ID  :   " + 2 + "     " +
            " |     First Name: " + "FirstName2" + "     " +
            " |     Last Name : " + "LastName2"+ "     " +
            " |     Street: " + "Street2" + "     " +
            " |     City: " + "City2" + "     " +
            " |     State: " + "State2"  + "     " +
            " |     Zip: " + "90210"  + "     " +
            " |     Phone: " + "555-5555" + "     " +
            " |     Email: " + "email@email.edu";
    String displayEntry3 = " " +
            "ID  :   " + 3 + "     " +
            " |     First Name: " + "FirstName3" + "     " +
            " |     Last Name : " + "LastName3"+ "     " +
            " |     Street: " + "Street3" + "     " +
            " |     City: " + "City3" + "     " +
            " |     State: " + "State3"  + "     " +
            " |     Zip: " + "90210"  + "     " +
            " |     Phone: " + "555-5555" + "     " +
            " |     Email: " + "email@email.edu";


    public void addEntries(){
        //Called before functions to add entries
        //Add entries to testEntry addressEntryList
        bookTest.addressEntryList.add(testEntry1);
        bookTest.addressEntryList.add(testEntry2);
        bookTest.addressEntryList.add(testEntry3);
    }

    @Test
    void list() {
        //Add three entries (testEntry1, testEntry2, testEntry3)
        addEntries();

        //Create display string that displays all entries
        String displayList = displayEntry1 + displayEntry2 + displayEntry3;

        //Create entry list with all entries in addressEntryList
        for (AddressEntry addressEntry : bookTest.addressEntryList) {
            list += addressEntry.toString();
        }

        //Create a wrong string that doesn't display all entries
        String displayListFalse = displayEntry1;

        //Expected True --> lists match
        assertEquals(list, displayList);

        //Expected True --> lists do not match
        assertNotEquals(list, displayListFalse);
    }

    @Test
    void remove() {
        //Add functions before remove()
        addEntries();

        //Remove 2nd entry in list
        bookTest.addressEntryList.remove(testEntry2);

        //Create a string with testEntry2 removed
        String displayListRemoved = displayEntry1 + displayEntry3;

        //Create a string with testEntry2 removed
        String displayListFalse = displayEntry1 + displayEntry2 + displayEntry3;

        for (AddressEntry addressEntry : bookTest.addressEntryList) {
            list += addressEntry.toString();
        }
        //Check if addressEntryList removed testEntry2
        //Expected True --> removed
        assertEquals(list, displayListRemoved);
        //Expected True --> not removed
        assertNotEquals(list, displayListFalse);
    }

    @Test
    void add() {
        //Add entries
        addEntries();

        //Create new entry
        AddressEntry newEntry = new AddressEntry(addressEntryList.size()+1,"Green", "Day", "Town Rd.", "September", "CA",
                92334, "555-1034", "green.day@gmail.com");

        //Append entry to list
        bookTest.addressEntryList.add(newEntry);

        //Create new displayList with all entries
        String displayListAdded = displayEntry1 + displayEntry2 + displayEntry3 + newEntry.toString();
        for (AddressEntry addressEntry : bookTest.addressEntryList) {
            list += addressEntry.toString();
        }

        //Expected True --> Entry is added to end of list
        assertEquals(displayListAdded, list);
    }

    @Test
    void find() {
        addEntries();

        //find() returns true if entries containing "Lin" found
        //Expected True --> "lin" is in the list
        assertTrue(bookTest.find("LastName"));

        //find() returns true if entries containing "LIN" found
        //Checks if find() is case-sensitive
        //Expected true
        assertTrue(bookTest.find("LASTNAME2"));

        //Expected True --> Dayed is not in the list
        assertFalse(bookTest.find("Dayed"));
    }
}