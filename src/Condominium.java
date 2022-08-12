import java.util.*;

public class Condominium extends Purchase_Property{

    private double monthlyFees;

    Condominium(double monthlyFees,double purchasePrice,double annualTaxAmount, String address, String city, String state, int postalCode, int numOfBedrooms, int numOfBathrooms) {
        super(purchasePrice,annualTaxAmount,address,city,state,postalCode,numOfBedrooms,numOfBathrooms);
        this.monthlyFees = monthlyFees;
    }

    public double getMonthlyFees() {return monthlyFees;}

    public void setMonthlyFees(double monthlyFees) {this.monthlyFees = monthlyFees;}

}
