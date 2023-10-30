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

class CookieTest {

    private Cookie cookie;

    @BeforeEach
    void setUp() {
        cookie = new Cookie();
    }

    @Test
    void getCookieQty() {
        assertEquals(0, cookie.getCookieQty());
    }

    @Test
    void setCookieQty() {
        cookie.setCookieQty(3);
        assertEquals(3, cookie.getCookieQty());
    }

    @Test
    void getPricePerDozen() {
        assertEquals(0, cookie.getPricePerDozen());
    }

    @Test
    void setPricePerDozen() {
        cookie.setPricePerDozen(20);
        assertEquals(20, cookie.getPricePerDozen());
    }

    @Test
    void calculateCost() {
        cookie.setCookieQty(3);
        cookie.setPricePerDozen(20);
        assertEquals((cookie.getCookieQty() * cookie.getPricePerDozen() / 12), cookie.calculateCost(), 0.0001);
    }

    @Test
    void calculateTax(){
        cookie.setCookieQty(4);
        cookie.setPricePerDozen(31);
        assertEquals((((cookie.getCookieQty() * cookie.getPricePerDozen() / 12 ) * cookie.getTaxPercentage()) / 100), cookie.calculateTax(cookie));
    }

    @Test
    void getPackaging(){
        assertEquals("", cookie.getPackaging());
    }

    @Test
    void setPackaging(){
        cookie.setPackaging("none");
        assertEquals("none", cookie.getPackaging());
    }

    @Test
    void isSameAs(){
        Cookie cookieTest1 = new Cookie("", 1, 0);
        assertTrue(cookie.isSameAs(cookieTest1));
        Cookie cookieTest2 = new Cookie("", 0, 1);
        assertFalse(cookie.isSameAs(cookieTest2));
    }
}