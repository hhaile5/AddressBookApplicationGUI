package address.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressEntryTest {

    @Test
    void testToString() {
        //Create address entry as a string in the toString() format
        String displayEntry = " " +
                "ID  :   " + 1 + "     " +
                " |     First Name: " + "FirstName" + "     " +
                " |     Last Name : " + "LastName"+ "     " +
                " |     Street: " + "Street" + "     " +
                " |     City: " + "City" + "     " +
                " |     State: " + "State"  + "     " +
                " |     Zip: " + "90210"  + "     " +
                " |     Phone: " + "555-555-5555" + "     " +
                " |     Email: " + "email@email.edu";

        //Create new address entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");

        //Check if testEntry information as a string matches testEntry.toString()
        assertEquals(displayEntry, testEntry.toString());
        //System.out.println(testEntry.toString());
    }

    @Test
    void setID() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(2, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");

        //Set the ID as 2
        testEntry.setID(2);

        //Check if testEntry.getFirstName() matches TestName
        assertEquals(2, testEntry.getID());
    }

    @Test
    void setFirstName() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(2, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");

        //Set the first name as "TestName"
        testEntry.setFirstName("TestName");

        //Check if testEntry.getFirstName() matches TestName
        assertEquals("TestName", testEntry.getFirstName());
    }

    @Test
    void setLastName() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(3, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");

        //Set the last name as "TestName"
        testEntry.setLastName("TestName");

        //Check if testEntry.getLastName() matches TestName
        assertEquals("TestName", testEntry.getLastName());
    }

    @Test
    void setCity() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(4, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Set the city as "TestCity"
        testEntry.setCity("TestCity");
        //Check if testEntry.getCity() matches TestCity
        assertEquals("TestCity", testEntry.getCity());
    }

    @Test
    void setState() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Set the state as "TestState"
        testEntry.setState("TestState");
        //Check if testEntry.getState() matches TestState
        assertEquals("TestState", testEntry.getState());
    }

    @Test
    void setStreet() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Set the street as "TestStreet"
        testEntry.setStreet("TestStreet");
        //Check if testEntry.getStreet() matches TestStreet
        assertEquals("Street", testEntry.getStreet());
    }

    @Test
    void setPhone() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Set the phone number as "510-555-9999"
        testEntry.setPhone("510-555-9999");
        //Check if testEntry.getPhone() matches 510-555-9999
        assertEquals("510-555-9999", testEntry.getPhone());
    }

    @Test
    void setZip() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Set the zip as 90210
        testEntry.setZip(90210);
        //Check if testEntry.getZip() matches 90210
        assertEquals(90210, testEntry.getZip());
    }

    @Test
    void setEmail() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Set the email as "email@cool.gov"
        testEntry.setEmail("email@cool.gov");
        //Check if testEntry.getEmail() matches email@cool.gov
        assertEquals("email@cool.gov", testEntry.getEmail());
    }

    @Test
    void getName() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Check if testEntry.getName() matches name
        Name n = new Name("FirstName", "LastName");
        assertEquals(n.getFirstName(), testEntry.getFirstName());
        assertEquals(n.getLastName(), testEntry.getLastName());
    }

    @Test
    void getAddress() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Check if Name matches testEntry name
        Address a = new Address("Street", "City", "State", 90210);
        assertEquals(a.getStreet(), testEntry.getStreet());
        assertEquals(a.getCity(), testEntry.getCity());
        assertEquals(a.getState(), testEntry.getState());
        assertEquals(a.getZip(), testEntry.getZip());
    }

    @Test
    void getID() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Check if testEntry.getEmail() matches email@cool.gov
        assertEquals(1, testEntry.getID());
    }

    @Test
    void getFirstName() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Check if testEntry.getFirstName() matches "FirstName"
        assertEquals("FirstName", testEntry.getFirstName());
    }

    @Test
    void getLastName() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Check if testEntry.getLastName() matches "LastName"
        assertEquals("LastName", testEntry.getLastName());
    }

    @Test
    void getCity() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Check if testEntry.getCity() matches "City"
        assertEquals("City", testEntry.getCity());
    }

    @Test
    void getState() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Check if testEntry.getState() matches "State"
        assertEquals("State", testEntry.getState());
    }

    @Test
    void getStreet() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Check if testEntry.getStreet() matches "Street"
        assertEquals("Street", testEntry.getStreet());
    }

    @Test
    void getPhone() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Check if testEntry.getPhone() matches 555-555-5555
        assertEquals("555-555-5555", testEntry.getPhone());
    }

    @Test
    void getZip() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Check if testEntry.getZip() matches 90210
        assertEquals(90210, testEntry.getZip());
    }

    @Test
    void getEmail() {
        //Create test entry
        AddressEntry testEntry = new AddressEntry(1, "FirstName", "LastName", "Street", "City", "State", 90210, "555-555-5555", "email@email.edu");
        //Check if testEntry.getEmail() matches email@email.edu
        assertEquals("email@email.edu", testEntry.getEmail());
    }
}