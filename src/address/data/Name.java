package address.data;

/**
 *
 * @author Group 7
 * @version 1.0
 * @since  March 2021
 *
 * purpose: This class is used to represent the name fields in an address entry.
 * address.Name: first name, last name.
 *
 */

public class Name {

    /**
     * String variable first name.
     */
    private String firstName;

    /**
     * String variable for last name.
     */
    private String lastName;

    /**
     * Name Constructor
     * Initializes a name object.
     */
    Name(){
        firstName = "";
        lastName = "";
    }

    /**
     * Returns a new address.Name initialized to parameter values.
     * @param fName is the first name of the entry.
     * @param lName is the last name of the entry.
     */
    Name(String fName, String lName){
        firstName = fName;
        lastName = lName;
    }

    /**
     * Returns a the first name of the name instance.
     * @return address.Name object's first name.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns address.Name object's last name.
     * @return address.Name object's last name.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Takes a String and set's it to an address.Name object's first name.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Takes a String and set's it to an address.Name objects last name.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
