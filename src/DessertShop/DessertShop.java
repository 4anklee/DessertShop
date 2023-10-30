/* Name: Frank Lee
 * Project: Lab6b
 * Instructor: Brother Alex May
 * Date: Oct 12, 2023
 * Description: Dessert Shop Part 8
 */
package DessertShop;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import DessertShop.Payable.PayType;


public class DessertShop {
    static Scanner in = new Scanner(System.in);
    public static String PaymentMethod;
    public static Map<String, Customer> customerDB = new HashMap<>();

    public static void main(String[] args) {

        do {
            Order order = new Order();
            String choice;

            while (true) {
                System.out.print("""

                        1. Candy
                        2. Cookie
                        3. IceCream
                        4. Sundae

                        What would you like to add to your order?(1-4, enter for done):
                        """);
                choice = in.nextLine().trim();

                if (choice.isEmpty()) {
                    break;
                } else {
                    switch (choice) {
                        case "1" -> order.add(userPromptCandy());
                        case "2" -> order.add(userPromptCookie());
                        case "3" -> order.add(userPromptIceCream());
                        case "4" -> order.add(userPromptSundae());
                        default ->
                                System.out.println("Invalid response. Please enter 1-4 for adding items to the order or" +
                                        " press enter for done.");
                    }
                }
            }

            Candy candyCorn = new Candy("Candy Corn", 1.5, 0.25);
            Candy gummyBears = new Candy("Gummy Bears", 0.25, 0.35);
            Cookie chocolateChip = new Cookie("Chocolate Chip", 6, 3.99);
            IceCream pistachio = new IceCream("Pistachio", 2, 0.79);
            Sundae vanilla = new Sundae("Vanilla", 3, 0.69, "Hot Fudge", 1.29);
            Cookie oatmealRaisin = new Cookie("Oatmeal Raisin", 2, 3.45);

            order.add(candyCorn, gummyBears, chocolateChip, pistachio, vanilla, oatmealRaisin);

            Customer customer = buildCustomerInfo(order);

            while (true) {
                System.out.println("What type of payment will be used?(Cash, Card, Phone): ");
                PaymentMethod = in.nextLine().toUpperCase();

                try {
                    order.setPayType(PayType.valueOf(PaymentMethod));

                    switch (order.getPayType()) {
                        case CASH, CARD, PHONE -> {
                            Collections.sort(order.getOrderList());
                            System.out.println(order);
                            System.out.println("------------------------------------------------------------------" +
                                    "-----------------------------------");
                            System.out.printf("Customer Name: %s     Customer ID: %d     Total Orders: %d",
                                    customer.getCustName(), customer.getCustID(), customer.getOrderHistory().size());
                        }
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("That's not a valid form of payment.");
                }
            }

            System.out.println("\nStart! (Hit enter to start a new order)");
        } while (in.nextLine().trim().isEmpty());

//        for (DessertItem item : order.getOrderList()) {
//            System.out.printf("%-25s$%-8.2f[Tax:$%.2f]\n", item.getName(), item.calculateCost(), item.calculateTax(item));
//        }
//        System.out.println("----------------------------------------------");
//        System.out.printf("%-25s$%-8.2f[Tax:$%.2f]\n", "Order Subtotals",order.orderCost(), order.orderTax());
//        System.out.printf("%-25s$%-8.2f\n", "Order Total", order.orderCost() + order.orderTax());
//        System.out.printf("Total number of items in order: %d", order.itemCount());

    }

    private static DessertItem userPromptCandy(){
        String candy = StringInputValidation("Enter the type of candy: ");
        double weight = DoubleInputValidation("Enter the weight purchased: ");
        double price = DoubleInputValidation("Enter the price per pound: ");
        return new Candy(candy.trim(), weight, price);
    }

    private static DessertItem userPromptCookie(){
        String cookie = StringInputValidation("Enter the type of cookie: ");
        int quantity = IntegerInputValidation("Enter the quantity purchased: ");
        double price = DoubleInputValidation("Enter the price per dozen: ");
        return new Cookie(cookie.trim(), quantity, price);
    }

    private static DessertItem userPromptIceCream(){
        String iceCream = StringInputValidation("Enter the type of ice cream: ");
        int scoop = IntegerInputValidation("Enter the number of scoops: ");
        double price = DoubleInputValidation("Enter the price per scoop: ");
        return new IceCream(iceCream.trim(), scoop, price);
    }

    private static DessertItem userPromptSundae(){
        String iceCream = StringInputValidation("Enter the type of ice cream: ");
        int quantity = IntegerInputValidation("Enter the number of scoop: ");
        double price = DoubleInputValidation("Enter the price per scoop: ");
        String topping = StringInputValidation("Enter the kind of topping used: ");
        double toppingPrice = DoubleInputValidation("Enter the price for the topping: ");
        return new Sundae(iceCream.trim(), quantity, price, topping.trim(), toppingPrice);
    }

    public static String StringInputValidation(String prompt){
        while(true) {
            try {
                System.out.println(prompt);
                return in.nextLine().trim();
            }catch(Exception e){
                System.out.println("Invalid entry!");
            }
        }
    }

    public static int IntegerInputValidation(String prompt){
        while(true) {
            try {
                System.out.println(prompt);
                return Integer.parseInt(in.nextLine().trim());
            }catch(Exception e){
                System.out.println("Invalid entry!");
            }
        }
    }

    public static Double DoubleInputValidation(String prompt){
        while(true) {
            try {
                System.out.println(prompt);
                return Double.parseDouble(in.nextLine().trim());
            }catch(Exception e){
                System.out.println("Invalid entry!");
            }
        }
    }

    public static Customer buildCustomerInfo(Order order){
        String custName = StringInputValidation("Enter the customer name: ");
        if(customerDB.containsKey(custName)){
            customerDB.get(custName).addToHistory(order);
            return customerDB.get(custName);
        }else{
            Customer customer = new Customer(custName);
            customerDB.put(customer.getCustName(), customer);
            customerDB.get(custName).addToHistory(order);
            return customer;
        }
    }
}