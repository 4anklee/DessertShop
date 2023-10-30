/* Name: Frank Lee
 * Project: Lab6i
 * Instructor: Brother Alex May
 * Date: Oct 16, 2023
 * Description: Real Estate Office
 */
package RealEstate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    Property property;

    @BeforeEach
    void setUp() {
        property = new House();
    }

    @Test
    void getStreetAddress() {
        assertEquals("", property.getStreetAddress());
    }

    @Test
    void setStreetAddress() {
        property.setStreetAddress("580 N 100 E, Provo, UT");
        assertEquals("580 N 100 E, Provo, UT", property.getStreetAddress());
    }

    @Test
    void getZip() {
        assertEquals("", property.getZip());
    }

    @Test
    void setZip() {
        property.setZip("84606");
        assertEquals("84606", property.getZip());
    }

    @Test
    void getListPrice(){
        assertEquals(0, property.getListPrice());
    }

    @Test
    void setListPrice(){
        property.setListPrice(10000);
        assertEquals(10000, property.getListPrice());
    }

    @Test
    void getAppraisalPrice(){
        assertEquals(0, property.getAppraisalPrice());
    }

    @Test
    void setAppraisalPrice(){
        property.setAppraisalPrice(20);
        assertEquals(20, property.getAppraisalPrice());
    }
}