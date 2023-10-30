/* Name: Frank Lee
 * Project: Lab5b
 * Instructor: Brother Alex May
 * Date: Oct 9, 2023
 * Description: Dessert Shop Part 6
 */
package DessertShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SundaeTest {

    private Sundae sundae;

    @BeforeEach
    void setUp() {
        sundae = new Sundae();
    }

    @Test
    void getToppingName() {
        assertEquals("", sundae.getToppingName());
    }

    @Test
    void setToppingName() {
        sundae.setToppingName("Crunch");
        assertEquals("Crunch", sundae.getToppingName());
    }

    @Test
    void getToppingPrice() {
        assertEquals(0, sundae.getPricePerScoop());
    }

    @Test
    void setToppingPrice() {
        sundae.setToppingPrice(200);
        assertEquals(200, sundae.getToppingPrice());
    }

    @Test
    void calculateCost() {
        sundae.setScoopCount(3);
        sundae.setPricePerScoop(20);
        sundae.setToppingPrice(10);
        assertEquals((sundae.getScoopCount() * sundae.getPricePerScoop() + sundae.getToppingPrice()),
                sundae.calculateCost(), 0.0001);
    }

    @Test
    void calculateTax(){
        sundae.setScoopCount(4);
        sundae.setPricePerScoop(13);
        sundae.setToppingPrice(5);
        assertEquals(((sundae.getScoopCount() * sundae.getPricePerScoop() + sundae.getToppingPrice())
                * sundae.getTaxPercentage() / 100), sundae.calculateTax(sundae));
    }

    @Test
    void getPackaging(){
        assertEquals("", sundae.getPackaging());
    }

    @Test
    void setPackaging(){
        sundae.setPackaging("none");
        assertEquals("none", sundae.getPackaging());
    }
}