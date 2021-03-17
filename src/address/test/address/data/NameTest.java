package address.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void getFirstName() {
        //Create test entry
        Name testEntry = new Name("FirstName", "LastName");
        //Check if FirstName matched testEntry.getFirstName()
        assertEquals("FirstName", testEntry.getFirstName());
    }

    @Test
    void getLastName() {
        //Create test name
        Name testEntry = new Name("FirstName", "LastName");
        //Check if FirstName matched testEntry.getLastName()
        assertEquals("LastName", testEntry.getLastName());
    }

    @Test
    void setFirstName() {
        //Create test entry
        Name testEntry = new Name("FirstName", "LastName");
        //Check if FirstName matched testEntry.getFirstName()
        assertEquals("FirstName", testEntry.getFirstName());
    }

    @Test
    void setLastName() {
        //Create test name
        Name testEntry = new Name("FirstName", "LastName");
        //Check if FirstName matched testEntry.getLastName()
        assertEquals("LastName", testEntry.getLastName());
    }
}