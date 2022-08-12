import java.util.*;

public class Apartment extends Rental_Property{

    private double monthlyRentalFee;
    private int leasePeriod;

    Apartment(double monthlyRentalFee,int leasePeriod, String address, String city, String state, int postalCode, int numOfBedrooms, int numOfBathrooms) {
        super(address,city,state,postalCode,numOfBedrooms,numOfBathrooms);
        this.monthlyRentalFee = monthlyRentalFee;
        this.leasePeriod = leasePeriod;
    }

    public double getMonthlyRentalFee() {return monthlyRentalFee;}

    public void setMonthlyRentalFee(double monthlyRentalFee) {this.monthlyRentalFee = monthlyRentalFee;}

    public int getLeasePeriod() {return leasePeriod;}

    public void setLeasePeriod(int leasePeriod) {this.leasePeriod = leasePeriod;}

}
