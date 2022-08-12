import java.util.*;

public class Purchase_Property extends Properties{

    private double purchasePrice;
    private double annualTaxAmount;

    Purchase_Property(double purchasePrice,double annualTaxAmount, String address, String city, String state, int postalCode, int numOfBedrooms, int numOfBathrooms) {
        super(address,city,state,postalCode,numOfBedrooms,numOfBathrooms);
        this.purchasePrice = purchasePrice;
        this.annualTaxAmount = annualTaxAmount;
    }

    public double getPurchasePrice() {return purchasePrice;}

    public void setPurchasePrice(double purchasePrice) {this.purchasePrice = purchasePrice;}

    public double getAnnualTaxAmount() {return annualTaxAmount;}

    public void setAnnualTaxAmount(double annualTaxAmount) {this.annualTaxAmount = annualTaxAmount;}
}
