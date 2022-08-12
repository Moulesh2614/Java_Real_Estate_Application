import java.util.*;

//Parent abstract class
abstract class Properties {

    private String address;
    private String city;
    private String state;
    private int postalCode;
    private int numOfBedrooms;
    private int numOfBathrooms;

    Properties(String address, String city, String state, int postalCode, int numOfBedrooms, int numOfBathrooms){

        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.numOfBedrooms = numOfBedrooms;
        this.numOfBathrooms = numOfBathrooms;
    };

    public void setAddress(String address) {this.address = address;}

    public void setCity(String city) {this.city = city;}

    public void setState(String state) {this.state = state;}

    public void setPostalCode(int postalCode) {this.postalCode = postalCode;}

    public void setNumOfBedrooms(int numOfBedrooms) {this.numOfBedrooms = numOfBedrooms;}

    public void setNumOfBathrooms(int numOfBathrooms) {this.numOfBathrooms = numOfBathrooms;}



    public String getAddress() {return address;}

    public String getCity() {return city;}

    public String getState() {return state;}

    public int getPostalCode() {return postalCode;}

    public int getNumOfBedrooms() {return numOfBedrooms;}

    public int getNumOfBathrooms() {return numOfBathrooms;}

}
