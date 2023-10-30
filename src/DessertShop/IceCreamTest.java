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

class IceCreamTest {

    private IceCream iceCream;

    @BeforeEach
    void setUp() {
        iceCream = new IceCream();
    }

    @Test
    void getScoopCount() {
        assertEquals(0, iceCream.getScoopCount());
    }

    @Test
    void setScoopCount() {
        iceCream.setScoopCount(3);
        assertEquals(3, iceCream.getScoopCount());
    }

    @Test
    void getPricePerScoop() {
        assertEquals(0, iceCream.getPricePerScoop());
    }

    @Test
    void setPricePerScoop() {
        iceCream.setPricePerScoop(2);
        assertEquals(2, iceCream.getPricePerScoop());
    }

    @Test
    void calculateCost() {
        iceCream.setScoopCount(3);
        iceCream.setPricePerScoop(20);
        assertEquals(iceCream.getScoopCount() * iceCream.getPricePerScoop(), iceCream.calculateCost(), 0.0001);
    }

    @Test
    void calculateTax(){
        iceCream.setPricePerScoop(4);
        iceCream.setPricePerScoop(31);
        assertEquals((iceCream.getScoopCount() * iceCream.getPricePerScoop() * iceCream.getTaxPercentage() / 100), iceCream.calculateTax(iceCream));
    }

    @Test
    void getPackaging(){
        assertEquals("", iceCream.getPackaging());
    }

    @Test
    void setPackaging(){
        iceCream.setPackaging("none");
        assertEquals("none", iceCream.getPackaging());
    }
}