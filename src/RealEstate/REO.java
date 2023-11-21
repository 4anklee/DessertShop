package RealEstate;

import java.util.Scanner;

public class REO {
    public static Scanner in = new Scanner(System.in);
    public static Listings listingsDB = new Listings();
    public static void main(String[] args) {
        while(true){
            System.out.print("""
                    
                    -----------------------------------------
                                    Main Menu
                    -----------------------------------------
                    1. Listing
                    2. Bids
                    
                    What would you like to do?(1-2):\s""");
            String choices = in.nextLine().trim();
            switch (choices){
                case "1" -> {
                    String listingChoices;
                    do {
                        System.out.print("""
                                
                                -----------------------------------------
                                              Listing Menu
                                -----------------------------------------
                                1: Add Listing
                                2: Show Listings
                                3: Auto Populate Listings (Dev tool)
                                ENTER: Exit back to previous menu
                                                                
                                What would you like to do? (1-3):\s""");
                        listingChoices = in.nextLine().trim();
                        switch(listingChoices){
                            case "1" ->{
                                String addListingChoices;
                                do{
                                    System.out.print("""
                                            
                                            -----------------------------------------
                                                         Add Listing Menu
                                            -----------------------------------------
                                            1: Add House
                                            2: Add Condo
                                            ENTER: Exit back to previous menu
                                            
                                            What would you like to do?(1-2):\s""");
                                    addListingChoices = in.nextLine().trim();
                                    switch (addListingChoices){
                                        case "1" -> AddHouseListing();
                                        case "2" -> AddCondoListing();
                                        case "" -> {}
                                        default -> System.out.println("Invalid response!");
                                    }
                                }while(!addListingChoices.isEmpty());
                            }
                            case "2" -> System.out.printf("""
                                    Current listings for REO:
                                    %s
                                    """, listingsDB);
                            case "3" -> autoPopulate();
                            case "" -> {}
                            default -> System.out.println("Invalid response!");
                        }
                    } while (!listingChoices.isEmpty());
                }
                case "2" ->{
                    String bidChoices;
                    do {
                        System.out.println("""
                                
                                -----------------------------------------
                                                 Bid Menu
                                -----------------------------------------
                                1: Add New Bid
                                2: Show Existing Bids
                                3: Auto Populate Bids (Dev Tool)
                                ENTER：EXIt Dock to previous menu
                                
                                What would you like to do? (1-3):\s""");
                        bidChoices = in.nextLine().trim();
                        switch (bidChoices){
                            case "1" -> System.out.println("Add New Bid");
                            case "2" -> System.out.println("Show Existing Bids");
                            case "3" -> System.out.println("Auto Populate Bids (Dev Tool)");
                            case "" -> {}
                            default -> System.out.println("Invalid response!");
                        }
                    }while(!bidChoices.isEmpty());
                }
                default -> System.out.println("Invalid response!");
            }
        }
    }

    public static void AddHouseListing(){
        String address = StringInputValidation("Please enter the street address for the residence: ");
        String zip = StringInputValidation("Please enter the zip code for residence: ");
        int bedCount = IntegerInputValidation("Please enter the number of bedroom: ");
        int bathCount = IntegerInputValidation("Please enter the number of bathroom: ");
        double sqFootage = DoubleInputValidation("Please enter the square footage of the residence: ");
        double yardSize = DoubleInputValidation("Please enter size of the yard in acre: ");

        House house = new House(address, zip, bedCount, bathCount, sqFootage, yardSize, 0, 0);

        System.out.printf("Appraisal Price for this property is: %s\n", house.calculateAppraisalPrice());
        house.setAppraisalPrice(house.calculateAppraisalPrice());
        double listPrice = DoubleInputValidation("Please enter the list price for the property: ");
        house.setListPrice(listPrice);
        listingsDB.addListing(address, house);
        System.out.println("\nYou have created a new listing!");
        System.out.println(house);
    }

    public static void AddCondoListing(){
        String address = StringInputValidation("Please enter the street address for the residence: ");
        String zip = StringInputValidation("Please enter the zip code for residence: ");
        int bedCount = IntegerInputValidation("Please enter the number of bedroom: ");
        int bathCount = IntegerInputValidation("Please enter the number of bathroom: ");
        double sqFootage = DoubleInputValidation("Please enter the square footage of the residence: ");
        int floorLvl = IntegerInputValidation("Please enter floor level of the condo: ");

        Condo condo = new Condo(address, zip, bedCount, bathCount, sqFootage, floorLvl, 0, 0);

        System.out.printf("Appraisal Price for this property is: %s\n", condo.calculateAppraisalPrice());
        condo.setAppraisalPrice(condo.calculateAppraisalPrice());
        double listPrice = DoubleInputValidation("Please enter the list price for the property: ");
        condo.setListPrice(listPrice);
        listingsDB.addListing(address, condo);
        System.out.println("\nYou have created a new listing!");
        System.out.println(condo);
    }

    public static void autoPopulate(){
//        int currentSize = listingsDB.getListings().size();
        House house1 = new House("34 Elm","95129", 3, 2, 2200,0.2, 0, 0);
        house1.setListPrice(house1.calculateAppraisalPrice() * 1.1);
        listingsDB.addListing("34 Elm", house1);

        House house2 = new House("42 Hitchhikers","95136", 4, 3, 2800, 0.3,0, 0);
        house2.setListPrice(house2.calculateAppraisalPrice() * 1.1);
        listingsDB.addListing("42 Hitchhikers", house2);

        Condo condo1 = new Condo("4876 Industrial", "95177", 3, 1, 1800, 3,0,0);
        condo1.setListPrice(condo1.calculateAppraisalPrice() * 1.1);
        listingsDB.addListing("4876 Industrial", condo1);

        House house3 = new House("2654 Oak","84062", 5, 53, 4200, 0.5, 0, 0);
        house3.setListPrice(house3.calculateAppraisalPrice() * 1.1);
        listingsDB.addListing("2654 Oak", house3);

        Condo condo2 = new Condo("9875 Lexington", "84603", 2, 1, 1500, 1, 0, 0);
        condo2.setListPrice(condo2.calculateAppraisalPrice() * 1.1);
        listingsDB.addListing("9875 Lexington", condo2);

        Condo condo3 = new Condo("3782 Market", "84066", 3, 1, 1800, 2, 0, 0);
        condo3.setListPrice(condo3.calculateAppraisalPrice() * 1.1);
        listingsDB.addListing("3782 Market", condo3);

        House house4 = new House("7608 Glenwood", "84055", 6, 3, 3900, 0.4, 0, 0);
        house4.setListPrice(house4.calculateAppraisalPrice() * 1.1);
        listingsDB.addListing("7608 Glenwood", house4);

        House house5 = new House("1220 Apple", "84057", 8, 7, 7900, 1, 0, 0);
        house5.setListPrice(house5.calculateAppraisalPrice() * 1.1);
        listingsDB.addListing("1220 Apple", house5);
    }

    public static String StringInputValidation(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return in.nextLine().trim();
            } catch (Exception e) {
                System.out.println("Invalid entry!");
            }
        }
    }

    public static int IntegerInputValidation(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(in.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid entry!");
            }
        }
    }

    public static Double DoubleInputValidation(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(in.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid entry!");
            }
        }
    }
}
