/* Name: Frank Lee
 * Project: Lab7b
 * Instructor: Brother Alex May
 * Date: Oct 12, 2023
 * Description: Dessert Shop Part 10
 */
package DessertShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer customer;
    Order order;

    @BeforeEach
    void setUp(){
        Customer.resetNextCustID();
        customer = new Customer("Customer");
        order = new Order();
    }

    @Test
    void getCustName() {
        assertEquals("Customer", customer.getCustName());
    }

    @Test
    void setCustName() {
        customer.setCustName("Customer1");
        assertEquals("Customer1", customer.getCustName());
    }

    @Test
    void getCustID() {
        assertEquals(1000, customer.getCustID());
    }

    @Test
    void getOrderHistory() {
        assertEquals(new ArrayList<Order>(), customer.getOrderHistory());
    }

    @Test
    void addToHistory() {
        customer.addToHistory(order);
        assertTrue(customer.getOrderHistory().size() == 1);
    }
}