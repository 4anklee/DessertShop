/* Name: Frank Lee
 * Project: Lab7b
 * Instructor: Brother Alex May
 * Date: Oct 12, 2023
 * Description: Dessert Shop Part 10
 */
package DessertShop;

import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private String custName;
    private final ArrayList<Order>orderHistory;
    private final int custID;
    private static int nextCustID = 1000;

    public Customer(String custName){
        this.custName = custName;
        this.orderHistory = new ArrayList<>();
        this.custID = nextCustID;
        nextCustID ++;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getCustID() {
        return custID;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addToHistory(Order...orders){
        Collections.addAll(orderHistory, orders);
    }

    public static void resetNextCustID() {
        nextCustID = 1000;
    }
}
