package address.data;

/**
 *
 * @author Helen Haile
 * @version 1.0
 * @since  February 2021
 *
 * purpose: This class is used to represent an entry in an address list.
 * Allow operation toString() to format address entry as a string.
 * address.Address Entry: ID, name, address, email, phone
 *
 */
public class AddressEntry {


    /**
     * ID number of entry
     */
    int ID;

    /**
     * Instance of Name
     */
    Name name;

    /**
     * Instance of address
     */
    Address address;


    /**
     * The email address of an address entry.
     */
    String email;

    /**
     * The phone number of an address entry.
     */
    String phone;


    //CONSTRUCTOR

    /**
     * Returns a new address.AddressEntry initalized to nothing.
     *   * @return A new address.AddressEntry object initialized to nothing.
     */
    public AddressEntry(){
        ID = 0;
        name = new Name();
        address = new Address();
        phone = "";
        email = "";
    }

    //CONSTRUCTOR

    /**
     * Returns a new address.AddressEntry initalized to parameter values.
     * @param id is the ID of the entry.
     * @param n is the name instance.
     * @param a is the address instance.
     * @param p is the phone number.
     * @param e is the email address.
     */
    public AddressEntry(int id, Name n, Address a, String p, String e){
        ID = id;
        name = new Name(n.getFirstName(), n.getLastName());
        address = new Address(a.getStreet(), a.getCity(), a.getState(), a.getZip());
        address = a;
        phone = p;
        email = e;
    }


    public AddressEntry(int id, String fName, String lName, String str, String c,
                        String stte, int z, String p, String e){
        ID = id;
        name = new Name();
        address = new Address();
        name.setLastName(lName);
        name.setFirstName(fName);
        address.setCity(c);
        address.setStreet(str);
        address.setState(stte);
        address.setZip(z);
        phone = p;
        email = e;
    }


    //PRINT ENTRY INFORMATION

    /**
     * Returns a formatted string of an address.AddressEntry objects information.
     * @return a string of address.AddressEntry object's information
     */
	public String toString() {
		String entryInfo = " " +
                "ID |" + this.ID + "     " +
                " |      First Name: " + this.name.getFirstName() + "     " +
                " |      Last Name : " + this.name.getLastName()+ "     " +
                " |      Street: " + this.address.getStreet() + "     " +
                " |      City: " + this.address.getCity() + "     " +
                " |      State: " + this.address.getState()  + "     " +
                " |      Zip: " + this.address.getZip()  + "     " +
                " |      Phone: " + this.phone + "     " +
                " |      Email: " + this.email;

		return entryInfo;
	}

//SETTERS

    /**
     * Takes a String and set's it to an address.AddressEntry object's first name.
     * @param f
     */
    public void setFirstName(String f)
    {
        name.setFirstName(f);
    }

    /**
     * Takes a String and set's it to an address.AddressEntry object's last name.
     * @param l
     */
    public void setLastName(String l)
    {
        name.setLastName(l);
    }

    /**
     * Takes a String and set's it to an address.AddressEntry object's city.
     * @param c
     */
    public void setCity(String c)
    {
        address.setCity(c);
    }

    /**
     * Takes a String and set's it to an address.AddressEntry object's state.
     * @param s
     */
    public void setState(String s)
    {
        address.setState(s);
    }

    /**
     * Takes a String and set's it to an address.AddressEntry object's street.
     * @param s
     */
    public void setStreet(String s)
    {
        address.setState(s);
    }

    /**
     * Takes a String and set's it to an address.AddressEntry object's phone.
     * @param p
     */
    public void setPhone(String p){
        this.phone = p;
    }

    /**
     * Takes an int and set's it to an address.AddressEntry object's zip.
     * @param z
     */
    public void setZip(Integer z)
    {
        address.setZip(z);
    }

    /**
     * Takes a String and set's it to an address.AddressEntry object's email.
     * @param e
     */
    public void setEmail(String e)
    {
        this.email = e;
    }


//GETTERS

    public Name getName(){
        return this.name;
    }

    Address getAddress(){
        return this.address;
    }
//    String getAddress(){
//        return name.getFirstName() + " " + name.getLastName();
//    }


    public int getID()
    {
        return this.ID;
    }
    public void setID(int i)
    {
        this.ID = i;
    }
    /**
     * Returns an address.AddressEntry object's first name.
     * @return address.AddressEntry object's first name
     */
    public String getFirstName()
    {
        return name.getFirstName();
    }

    /**
     * Returns an address.AddressEntry object's last name.
     * @return address.AddressEntry object's last name
     */
    String getLastName()
    {
        return name.getLastName();
    }

    /**
     * Returns an address.AddressEntry object's city.
     * @return address.AddressEntry object's city
     */
    String getCity()
    {
        return address.getCity();
    }

    /**
     * Returns an address.AddressEntry object's state.
     * @return address.AddressEntry object's state.
     */
    String getState()
    {
        return address.getState();
    }

    /**
     * Returns an address.AddressEntry object's street.
     * @return address.AddressEntry object's street.
     */
    String getStreet()
    {
        return address.getStreet();
    }

    /**
     * Returns an address.AddressEntry object's phone number.
     * @return address.AddressEntry object's phone number as string.
     */
    String getPhone()
    {
        return phone;
    }

    /**
     * Returns an address.AddressEntry object's zip code as an integer.
     * @return address.AddressEntry object's zip code as an integer.
     */
    Integer getZip()
    {
        return address.getZip();
    }

    /**
     * Returns an address.AddressEntry object's email address.
     * @return address.AddressEntry object's email address.
     */
    String getEmail()
    {
        return email;
    }


}
