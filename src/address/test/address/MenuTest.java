package address;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void prompt_FirstName() {
        String[] firstName = {"Jin", "Name", ""};

        //Check if string name is not empty
        //Expect True --> "Jin"
        assertTrue(!firstName[0].isEmpty());

        //Expect True --> "Name"
        assertTrue(!firstName[1].isEmpty());

        //Expect False --> ""
        assertFalse(!firstName[2].isEmpty());


    }

    @Test
    void prompt_LastName() {
        String[] lastName = {"Daye", "Limh", ""};

        //Check if string name is not empty
        //Expect True --> "Daye"
        assertTrue(!lastName[0].isEmpty());

        //Expect True --> "Limh"
        assertTrue(!lastName[1].isEmpty());

        //Expect False --> ""
        assertFalse(!lastName[2].isEmpty());
    }

    @Test
    void prompt_Street() {
        String[] street = {"Albert Rd.", "Street", ""};

        //Check if string name is not empty
        //Expect True --> "Albert Rd."
        assertTrue(!street[0].isEmpty());

        //Expect True --> "Street"
        assertTrue(!street[1].isEmpty());

        //Expect False --> ""
        assertFalse(!street[2].isEmpty());
    }

    @Test
    void prompt_City() {
        String[] city = {"Treasure", "Hayward", ""};

        //Check if string name is not empty
        //Expect True --> "Treasure"
        assertTrue(!city[0].isEmpty());

        //Expect True --> "Hayward"
        assertTrue(!city[1].isEmpty());

        //Expect False --> ""
        assertFalse(!city[2].isEmpty());
    }

    @Test
    void prompt_State() {
        String[] state = {"CA.", "California", ""};

        //Check if string name is not empty
        //Expect True --> "CA."
        assertTrue(!state[0].isEmpty());

        //Expect True --> "California"
        assertTrue(!state[1].isEmpty());

        //Expect False --> ""
        assertFalse(!state[2].isEmpty());
    }

    @Test
    void prompt_Phone() {
        //System.out.print("\nEnter 10-digit phone number (800-555-1234): ");
        String[] phoneNumbers = {"123-555-1234","1234", "510-777-9999", "gew-hssj-ksldk", " "};

        //Valid phone number format 800-555-1234
        String validPhoneNumberRegex = "\\d{3}-\\d{3}-\\d{4}";

        //Expected True --> "123-555-1234"
        assertTrue(phoneNumbers[0].matches(validPhoneNumberRegex));

        //Expected False --> "1234"
        assertFalse(phoneNumbers[1].matches(validPhoneNumberRegex));

        //Expected True --> "510-777-9999"
        assertTrue(phoneNumbers[2].matches(validPhoneNumberRegex));

        //Expected False --> "gew-hssj-ksldk"
        assertFalse(phoneNumbers[3].matches(validPhoneNumberRegex));

        //Expected False --> " "
        assertFalse(phoneNumbers[4].matches(validPhoneNumberRegex));

    }

    @Test
    void prompt_Email() {
        //System.out.print("\nEnter 10-digit phone number (800-555-1234): ");
        String[] email = {"@","email@add.c", "@day.edu", "gday@csueastbay.edu", " "};

        //Valid email format email@address.com
        String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        //Expected False --> "@"
        assertFalse(email[0].matches(emailRegex));

        //Expected False --> "email@add.c"
        assertFalse(email[1].matches(emailRegex));

        //Expected False --> "@day.edu"
        assertFalse(email[2].matches(emailRegex));

        //Expected True --> "gday@csueastbay.edu"
        assertTrue(email[3].matches(emailRegex));

        //Expected False --> " " --> empty
        assertFalse(email[4].matches(emailRegex));
    }

    @Test
    void prompt_Zip() {
        int[] zip = {1234, -1234, 90210};

        //Check if zip code is a positive integer
        //Expect True --> 1234
        assertTrue(zip[0] > 0);

        //Expect false --> -1234
        assertFalse(zip[1] > 0);

        //Expect true --> 90210
        assertTrue(zip[2] > 0);

    }
}