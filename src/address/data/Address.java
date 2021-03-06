package address.data;

public class Address {
    private String street;
    private String city;
    private String state;
    private int zip;

    Address(){
        street = "";
        city = "";
        state = "";
        zip = 0;
    }

    Address(String str, String c, String stt, int z){
        street = str;
        city = c;
        state = stt;
        zip = z;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }


}
