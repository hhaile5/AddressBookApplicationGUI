package address.data;

/**
 *
 * @author Group 7
 * @version 1.0
 * @since  March 2021
 *
 * purpose: This class is used to represent the address fields in an address entry.
 * address.Address: street, city, state, zip code.
 *
 */

public class Address {

    /**
     * String variable for street.
     */
    private String street;

    /**
     * String variable for city.
     */
    private String city;

    /**
     * String variable for state.
     */
    private String state;

    /**
     * int variable for zip code.
     */
    private int zip;

    /**
     * Address Constructor
     * Initializes an address object.
     */
    Address(){
        street = "";
        city = "";
        state = "";
        zip = 0;
    }

    /**
     * Returns a new address.address initalized to parameter values.
     * @param str is the ID of the entry.
     * @param c is the name instance.
     * @param stt is the address instance.
     * @param z is the phone number.
     */
    Address(String str, String c, String stt, int z){
        street = str;
        city = c;
        state = stt;
        zip = z;
    }

// GETTERS

    /**
     * Returns address.Address object's street.
     * @return address.AddressEntry object's street.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Returns address.Address object's city.
     * @return address.AddressEntry object's city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns address.Address object's state.
     * @return address.AddressEntry object's state.
     */
    public String getState() {
        return state;
    }

    /**
     * Returns address.Address object's zip code.
     * @return address.AddressEntry object's zip code.
     */
    public int getZip() {
        return zip;
    }


//  SETTERS

    /**
     * Takes a String and set's it to an address.Address object's street.
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Takes a String and set's it to an address.Address object's zip.
     * @param zip
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * Takes a String and set's it to an address.Address object's city.
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Takes a String and set's it to an address.Address object's state.
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }






}
