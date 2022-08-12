//This is a Java console application developed for a Realty Company
// This application helps the company manage the properties they sell or rent to potential buyers.

import java.util.*;

public class Main {
    //Declaring Global variables
    static String address;
    static String city;
    static String state;
    static int postCode;
    static int numOfBedrooms;
    static int numOfBathrooms;
    static double purchasePriceHouse;
    static double taxHouse;
    static double purchasePriceCondominium;
    static double taxCondominium;
    static double monthlyFeeCondominium;
    static double monthlyRentalFee;
    static int leasePeriod;
    static Object[][] houseListings = new Object[10][10];
    static Object[][] condominiumListings = new Object[10][10];
    static Object[][] apartmentListings = new Object[10][10];
    static int m,n,o = 0;

    public static void main(String[] args) {
        // Just one function call in the Main to keep it clean and readable.
        Welcome();

    }

    public static void Welcome() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Welcome to Real Estate Management Application");
        System.out.println("-----------------------------------------------------");

        Listings();
    }

    public static void Listings(){
        // Displays the list of selectable options
        System.out.println("-----------------------------------------------------");
        System.out.println("Choose from the numbers in the following list");
        System.out.println("1. Create house listing");
        System.out.println("2. Create condominium listing");
        System.out.println("3. Create apartment listing");
        System.out.println("4. Show listings");
        System.out.println("5. Exit");
        System.out.println("-----------------------------------------------------");



        boolean isNumber;
        Scanner listing = new Scanner(System.in);

        do {
            if (listing.hasNextInt()) {

                int listingID = listing.nextInt();
                do {

                    if (listingID == 1) {
                        System.out.println("You chose House");
                        House();
                    } else if (listingID == 2){
                        Condominium();
                    }else if (listingID == 3){
                        Apartment();
                    }else if (listingID == 4){
                        ShowListings();
                    }else if (listingID == 5){
                        System.out.println("Are You Sure You Want To Exit? (Y/N)");
                        Scanner exit = new Scanner(System.in);
                        String exitProgram = exit.next();
                        if ((!"y".equals(exitProgram))&&(!"Y".equals(exitProgram))) {
                            Listings();
                        }else {

                            System.out.println("------------------------------------------------------------------------------------------");
                            System.out.println("Program is Terminating... Thank you for using this application.");
                            System.out.println("------------------------------------------------------------------------------------------");
                            System.exit(0);
                        }
                    }
                    else {
                        System.out.println("Please enter between 1-5");
                        listingID = Integer.parseInt(listing.next());
                    }
                }while (listingID>5);

                isNumber = true;
            } else {
                System.out.println("Invalid input, please enter a Number from the list!");
                isNumber = false;
                listing.next();
            }
        } while (!(isNumber));

    }

    //Records House specific details in addition to the common details and stores them in a 2D array.
    public static void House(){
        details();
        boolean isDouble = false;
        Scanner houseDetails = new Scanner(System.in);
        do {
            System.out.println("Enter Purchase Price Of The House");
            String purchasePrice = houseDetails.nextLine();
            if (RegexCheck(purchasePrice)) {
                if(ExitCheck(purchasePrice)) {
                    purchasePriceHouse = Double.parseDouble(purchasePrice);

                do{
                    System.out.println("Enter Annual Amount Of Taxes For The House");
                    String tax = houseDetails.nextLine();
                    if (RegexCheck(tax)) {
                        if(ExitCheck(tax)) {
                            taxHouse = Double.parseDouble(tax);

                        House h = new House(purchasePriceHouse,taxHouse,address,city,state,postCode,numOfBedrooms,numOfBathrooms);
                            System.out.println("------------------------------------------------------------------------------------------");
                            System.out.println("Details Recorded Successfully");
                            System.out.println("------------------------------------------------------------------------------------------");

                        houseListings[m][0] = h.getAddress();
                        houseListings[m][1] = h.getCity();
                        houseListings[m][2] = h.getState();
                        houseListings[m][3] = h.getPostalCode();
                        houseListings[m][4] = h.getNumOfBedrooms();
                        houseListings[m][5] = h.getNumOfBathrooms();
                        houseListings[m][6] = h.getPurchasePrice();
                        houseListings[m][7] = h.getAnnualTaxAmount();

                        m++;
                        //System.out.println(m);
                        Listings();
                        isDouble = true;
                        }else{
                            Exit();
                        }
                    }else {
                        System.out.println("Invalid input, please enter a Number!");
                        isDouble = false;
                        houseDetails.next();
                    }
                }while (!(isDouble));
                }else{
                    Exit();
                }
            } else {
                System.out.println("Invalid input, please enter a Number!");
                isDouble = false;
                houseDetails.next();
            }
        } while (!(isDouble));
    }

    //Records Condominium specific details in addition to the common details and stores them in a 2D array.
    public static void Condominium(){
        details();
        boolean isDouble = false;
        Scanner condominiumDetails = new Scanner(System.in);
        do {
            System.out.println("Enter Purchase Price Of The Condominium");
            String purchasePrice = condominiumDetails.nextLine();
            if (RegexCheck(purchasePrice)) {
                if(ExitCheck(purchasePrice)) {
                purchasePriceCondominium = Double.parseDouble(purchasePrice);
                do{
                    System.out.println("Enter Annual Amount Of Taxes For The Condominium");
                    String tax = condominiumDetails.nextLine();
                    if (RegexCheck(tax)) {
                        if(ExitCheck(tax)) {
                        taxCondominium = Double.parseDouble(tax);
                        do{
                            System.out.println("Enter Monthly Management Fee");
                            String monthlyFee = condominiumDetails.nextLine();
                            if (RegexCheck(monthlyFee)) {
                                if(ExitCheck(monthlyFee)) {

                                monthlyFeeCondominium = Double.parseDouble(monthlyFee);
                                Condominium c = new Condominium(monthlyFeeCondominium, purchasePriceCondominium, taxCondominium, address, city, state, postCode, numOfBedrooms, numOfBathrooms);
                                System.out.println("------------------------------------------------------------------------------------------");
                                System.out.println("Details Recorded Successfully");
                                System.out.println("------------------------------------------------------------------------------------------");

                                condominiumListings[n][0] = c.getAddress();
                                condominiumListings[n][1] = c.getCity();
                                condominiumListings[n][2] = c.getState();
                                condominiumListings[n][3] = c.getPostalCode();
                                condominiumListings[n][4] = c.getNumOfBedrooms();
                                condominiumListings[n][5] = c.getNumOfBathrooms();
                                condominiumListings[n][6] = c.getPurchasePrice();
                                condominiumListings[n][7] = c.getAnnualTaxAmount();
                                condominiumListings[n][8] = c.getMonthlyFees();

                                n++;

                                Listings();
                                isDouble = true;
                            }else{
                                    Exit();
                                }
                            }else {
                                System.out.println("Invalid input, please enter a Number!");
                                isDouble = false;
                                condominiumDetails.next();
                            }
                        }while (!(isDouble));
                        }else{
                            Exit();
                        }

                    }else {
                        System.out.println("Invalid input, please enter a Number!");
                        isDouble = false;
                        condominiumDetails.next();
                    }
                }while (!(isDouble));
                }else{
                    Exit();
                }

            } else {
                System.out.println("Invalid input, please enter a Number!");
                isDouble = false;
                condominiumDetails.next();
            }
        } while (!(isDouble));
    }

    //Records Apartment specific details in addition to the common details and stores them in a 2D array.
    public static void Apartment(){
        details();
        boolean isDouble = false;
        Scanner apartmentDetails = new Scanner(System.in);
        do {
            System.out.println("Enter Monthly Rental Fee For The Apartment");
            String rentalFee = apartmentDetails.nextLine();
            if (RegexCheck(rentalFee)) {
                if(ExitCheck(rentalFee)) {
                    monthlyRentalFee = Double.parseDouble(rentalFee);
                    do{
                        System.out.println("Enter Number Of Months For The Lease Period");
                        String lease = apartmentDetails.nextLine();
                        if (RegexCheck(lease)) {
                            if(ExitCheck(lease)) {
                                leasePeriod = Integer.parseInt(lease);
                                Apartment a = new Apartment(monthlyRentalFee, leasePeriod, address, city, state, postCode, numOfBedrooms, numOfBathrooms);
                                System.out.println("------------------------------------------------------------------------------------------");
                                System.out.println("Details Recorded Successfully");
                                System.out.println("------------------------------------------------------------------------------------------");
                                apartmentListings[o][0] = a.getAddress();
                                apartmentListings[o][1] = a.getCity();
                                apartmentListings[o][2] = a.getState();
                                apartmentListings[o][3] = a.getPostalCode();
                                apartmentListings[o][4] = a.getNumOfBedrooms();
                                apartmentListings[o][5] = a.getNumOfBathrooms();
                                apartmentListings[o][6] = a.getMonthlyRentalFee();
                                apartmentListings[o][7] = a.getLeasePeriod();

                                o++;

                                Listings();
                                isDouble = true;
                            }
                            else{
                                Exit();
                            }
                        }else {
                            System.out.println("Invalid input, please enter a Number!");
                            isDouble = false;
                            apartmentDetails.next();
                        }
                    }while (!(isDouble));
                }
                else{
                    Exit();
                }

            } else {
                System.out.println("Invalid input, please enter a Number!");
                isDouble = false;
                apartmentDetails.next();
            }
        } while (!(isDouble));
    }

    //Records the common details and stores them in the pre-defined variables.
    public static void details(){
        boolean isAlphanumeric = false;
        Scanner addressScanner = new Scanner(System.in);
        do{
            System.out.println("Enter Street address of the property");
            String check = addressScanner.next();
            if(check.matches("[a-zA-Z0-9]+")){
                if(ExitCheck(check)){
                address = check;
                isAlphanumeric = true;
                }else{
                    Exit();
                }
            }else {
                System.out.println("Invalid Characters, Only Alphanumeric Entry Allowed");
                isAlphanumeric = false;
            }
        }while (!isAlphanumeric);

        boolean isAlphabet = false;
        Scanner details = new Scanner(System.in);
        do{
        System.out.println("Enter City");
        String cityCheck = details.nextLine();

            if(cityCheck.matches("[a-zA-Z ]+")){
                if(ExitCheck(cityCheck)) {
                    city = cityCheck;
                    do {
                        System.out.println("Enter State");
                        String stateCheck = details.nextLine();

                        if (stateCheck.matches("[a-zA-Z ]+")) {
                            if(ExitCheck(stateCheck)) {

                                state = stateCheck;
                                isAlphabet = true;

                            }else{
                                Exit();
                            }
                        } else {
                            System.out.println("Invalid Characters, Only Alphabet Entry Allowed");
                            isAlphabet = false;
                        }
                    } while (!isAlphabet);
                }else{
                    Exit();
                }
            }else{
                System.out.println("Invalid Characters, Only Alphabet Entry Allowed");
                isAlphabet = false;
            }

        }while (!isAlphabet);

        boolean isNumber = false;
        do{
        System.out.println("Enter Postal Code");

            String postCodeCheck = details.nextLine();
            if(RegexCheck(postCodeCheck)) {
                if(ExitCheck(postCodeCheck)) {
                postCode = Integer.parseInt(postCodeCheck);
                do {
                    System.out.println("Enter Number of Bedrooms");
                    String nOBedCheck = details.nextLine();
                    if (RegexCheck(nOBedCheck)) {
                        if(ExitCheck(nOBedCheck)) {
                        numOfBedrooms = Integer.parseInt(nOBedCheck);
                        do {
                            System.out.println("Enter Number of Bathrooms");
                            String nOBathCheck = details.nextLine();
                            if (RegexCheck(nOBathCheck)) {
                                if(ExitCheck(nOBathCheck)) {
                                    numOfBathrooms = Integer.parseInt(nOBathCheck);
                                    isNumber = true;}
                                else{
                                    Exit();
                                }
                            } else {
                                System.out.println("Invalid Characters, Only Numbers Entry Allowed");
                                isNumber = false;
                                //details.next();
                            }
                        } while (!isNumber);
                    }else{
                        Exit();
                    }
                    } else {
                        System.out.println("Invalid Characters, Only Numbers Entry Allowed");
                        isNumber = false;
                        //details.next();
                    }

                } while (!isNumber);
            }else{
                Exit();
            }
            }else{
                System.out.println("Invalid Characters, Only Numbers Entry Allowed");
                isNumber = false;
                //details.next();
            }
        } while (!isNumber);
    }

    //Displays all the available listings. Asks the user to make a new listing if none available.
    public static void ShowListings(){
        if(houseListings[0][0]!=null||condominiumListings[0][0]!=null||apartmentListings[0][0]!=null) {

            if (houseListings[0][0] != null) {
                int j = 0;
                for (int k = 0; k < m; k++) {
                    System.out.println("-----------------------------------------------------");
                    System.out.println("House " + (k + 1));
                    System.out.println("Address: " + houseListings[k][j] + " ");
                    j++;
                    System.out.println("City: " + houseListings[k][j] + " ");
                    j++;
                    System.out.println("State: " + houseListings[k][j] + " ");
                    j++;
                    System.out.println("Postal Code: " + houseListings[k][j] + " ");
                    j++;
                    System.out.println("Number of Bedrooms: " + houseListings[k][j] + " ");
                    j++;
                    System.out.println("Number of Bathrooms: " + houseListings[k][j] + " ");
                    j++;
                    System.out.println("Purchase Price: $" + houseListings[k][j] + " ");
                    j++;
                    System.out.println("Annual Taxes: $" + houseListings[k][j] + " ");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("");
                    j = 0;
                }

            }
            if (condominiumListings[0][0] != null) {
                int j = 0;
                for (int k = 0; k < n; k++) {
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Condominium " + (k + 1));
                    System.out.println("Address: " + condominiumListings[k][j] + " ");
                    j++;
                    System.out.println("City: " + condominiumListings[k][j] + " ");
                    j++;
                    System.out.println("State: " + condominiumListings[k][j] + " ");
                    j++;
                    System.out.println("Postal Code: " + condominiumListings[k][j] + " ");
                    j++;
                    System.out.println("Number of Bedrooms: " + condominiumListings[k][j] + " ");
                    j++;
                    System.out.println("Number of Bathrooms: " + condominiumListings[k][j] + " ");
                    j++;
                    System.out.println("Purchase Price: $" + condominiumListings[k][j] + " ");
                    j++;
                    System.out.println("Annual Taxes: $" + condominiumListings[k][j] + " ");
                    j++;
                    System.out.println("Monthly Fee: $" + condominiumListings[k][j] + " ");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("");
                    j = 0;
                }

            }
            if (apartmentListings[0][0] != null) {
                int j = 0;
                for (int k = 0; k < o; k++) {
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Apartment " + (k + 1));
                    System.out.println("Address: " + apartmentListings[k][j] + " ");
                    j++;
                    System.out.println("City: " + apartmentListings[k][j] + " ");
                    j++;
                    System.out.println("State: " + apartmentListings[k][j] + " ");
                    j++;
                    System.out.println("Postal Code: " + apartmentListings[k][j] + " ");
                    j++;
                    System.out.println("Number of Bedrooms: " + apartmentListings[k][j] + " ");
                    j++;
                    System.out.println("Number of Bathrooms: " + apartmentListings[k][j] + " ");
                    j++;
                    System.out.println("Monthly Rental Fee: $" + apartmentListings[k][j] + " ");
                    j++;
                    System.out.println("Lease Period: " + apartmentListings[k][j] + " Months");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("");
                    j = 0;
                }

            }
            Listings();
        }
        else{
            System.out.println("-----------------------------------------------------");
            System.out.println("No Listing Available To Display, Create A New Listing");
            System.out.println("-----------------------------------------------------");
            System.out.println("");
            Listings();
        }

    }

    //Function to exit out of the program anytime during entering the details. Erases all the data entered.
    public static void Exit(){
        System.out.println("Are You Sure You Want To Exit? (Y/N)");
        Scanner exit = new Scanner(System.in);
        String exitProgram = exit.next();
        if ((!"y".equals(exitProgram))&&(!"Y".equals(exitProgram))) {
            Listings();
        }else {
            address = null;
            city = null;
            state = null;
            postCode = 0;
            numOfBedrooms = 0;
            numOfBathrooms = 0;
            purchasePriceHouse = 0;
            taxHouse = 0;
            purchasePriceCondominium = 0;
            taxCondominium = 0;
            monthlyFeeCondominium = 0;
            monthlyRentalFee = 0;
            leasePeriod = 0;
            houseListings = null;
            condominiumListings = null;
            apartmentListings = null;
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("Program is Terminating... Thank you for using this application.");
            System.out.println("------------------------------------------------------------------------------------------");
            Listings();
        }
    }

    //Input check for numeric input and for escape values to exit the program.
    public static boolean RegexCheck(String input){
        return input.matches("[qQ0-9]+")||input.matches("Quit")||input.matches("quit")||input.matches("Abort")||input.matches("abort");
    }

    //Input check for escape values to exit the program
    public static boolean ExitCheck(String input){
        return (!"q".equals(input))&&(!"Q".equals(input))&&(!"Quit".equals(input))&&(!"quit".equals(input))&&(!"Abort".equals(input))&&(!"abort".equals(input));
    }
}
