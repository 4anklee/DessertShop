package RealEstate;

import java.util.Scanner;

public class REO {
    public static Scanner in = new Scanner(System.in);
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
                                        case "1" -> System.out.println("Add House");
                                        case "2" -> System.out.println("Add Condo");
                                        case "" ->{}
                                    }
                                }while(!addListingChoices.isEmpty());
                            }
                            case "2" -> System.out.println("Show Listings");
                            case "3" -> System.out.println("Auto Populate Listings (Dev tool)");
                            case "" ->{}
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
                            case "" ->{}
                            default -> System.out.println("Invalid response!");
                        }
                    }while(!bidChoices.isEmpty());
                }
                default -> System.out.println("Invalid response!");
            }
        }
    }
}
