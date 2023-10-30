/* Name: Frank Lee
 * Project: Lab6b
 * Instructor: Brother Alex May
 * Date: Oct 12, 2023
 * Description: Dessert Shop Part 8
 */
package DessertShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DessertItemTest {

    private Candy candy;
    private Cookie cookie;
    private IceCream iceCream;
    private Sundae sundae;

    @BeforeEach
    public void setUp(){
        candy = new Candy();
        cookie = new Cookie("c", 1, 1);
        iceCream = new IceCream("i", 1,100);
        sundae = new Sundae("s", 1, 100, "t", 0);
    }

    @Test
    void getName() {
        assertEquals("", candy.getName());
    }

    @Test
    void setName() {
        candy.setName("McFlurry");
        assertEquals("McFlurry", candy.getName());
    }

    @Test
    void getTaxPercentage(){
        assertEquals(7.25, candy.getTaxPercentage());
    }

    @Test
    void setTaxPercentage(){
        candy.setTaxPercentage(6.25);
        assertEquals(6.25, candy.getTaxPercentage());
    }

    @Test
    void compareTo(){
        assertEquals(-1,cookie.compareTo(iceCream));
        assertEquals(0, sundae.compareTo(iceCream));
        assertEquals(1, sundae.compareTo(cookie));
    }
}