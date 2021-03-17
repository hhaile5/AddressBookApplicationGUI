package address.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void getStreet() {
        //Create test entry
        Address testEntry = new Address("Street", "City", "State", 90210);
        //Check if testEntry.getCity() matches "City"
        assertEquals("Street", testEntry.getStreet());
    }

    @Test
    void getCity() {
        //Create test entry
        Address testEntry = new Address("Street", "City", "State", 90210);
        //Check if testEntry.getCity() matches "City"
        assertEquals("City", testEntry.getCity());
    }

    @Test
    void getState() {
        //Create test entry
        Address testEntry = new Address("Street", "City", "State", 90210);
        //Check if testEntry.getCity() matches "City"
        assertEquals("State", testEntry.getState());
    }

    @Test
    void getZip() {
        //Create test entry
        Address testEntry = new Address( "Street", "City", "State", 90210);
        //Check if testEntry.getZip() matches 90210
        assertEquals(90210, testEntry.getZip());
    }

    @Test
    void setStreet() {
        //Create test entry
        Address testEntry = new Address("Street", "City", "State", 90210);

        //Set the last name as "TestName"
        testEntry.setStreet("TestName");

        //Check if testEntry.getLastName() matches TestName
        assertEquals("TestName", testEntry.getStreet());
    }

    @Test
    void setCity() {
        //Create test entry
        Address testEntry = new Address("Street", "City", "State", 90210);

        //Set the last name as "TestName"
        testEntry.setCity("TestName");

        //Check if testEntry.getLastName() matches TestName
        assertEquals("TestName", testEntry.getCity());
    }

    @Test
    void setState() {
        //Create test entry
        Address testEntry = new Address("Street", "City", "State", 90210);

        //Set the last name as "TestName"
        testEntry.setState("TestName");

        //Check if testEntry.getLastName() matches TestName
        assertEquals("TestName", testEntry.getState());
    }
}