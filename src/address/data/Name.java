package address.data;

public class Name {
    private String firstName;


    private String lastName;

    Name(){
        firstName = "";
        lastName = "";
    }

    Name(String fName, String lName){
        firstName = fName;
        lastName = lName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
