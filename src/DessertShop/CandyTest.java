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

class CandyTest {

    private Candy candy;

    @BeforeEach
    void setUp() {
        candy = new Candy();
    }

    @Test
    void getCandyWeight() {
        assertEquals(0, candy.getCandyWeight());
    }

    @Test
    void setCandyWeight() {
        candy.setCandyWeight(3);
        assertEquals(3, candy.getCandyWeight());
    }

    @Test
    void getPricePerPound() {
        assertEquals(0, candy.getPricePerPound());
    }

    @Test
    void setPricePerPound() {
        candy.setPricePerPound(3);
        assertEquals(3, candy.getPricePerPound());
    }

    @Test
    void calculateCost() {
        candy.setCandyWeight(3);
        candy.setPricePerPound(20);
        assertEquals(candy.getCandyWeight() * candy.getPricePerPound(), candy.calculateCost(), 0.0001);
    }

    @Test
    void calculateTax(){
        candy.setCandyWeight(4);
        candy.setPricePerPound(31);
        assertEquals((candy.getCandyWeight() * candy.getPricePerPound() * candy.getTaxPercentage() / 100), candy.calculateTax(candy));
    }

    @Test
    void getPackaging(){
        assertEquals("", candy.getPackaging());
    }

    @Test
    void setPackaging(){
        candy.setPackaging("none");
        assertEquals("none", candy.getPackaging());
    }

    @Test
    void isSameAs(){
        Candy candyTest1 = new Candy("", 1, 0);
        assertTrue(candy.isSameAs(candyTest1));
        Candy candyTest2 = new Candy("", 0, 1);
        assertFalse(candy.isSameAs(candyTest2));
    }
}