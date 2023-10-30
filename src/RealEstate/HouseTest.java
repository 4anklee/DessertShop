/* Name: Frank Lee
 * Project: Lab6i
 * Instructor: Brother Alex May
 * Date: Oct 2, 2023
 * Description: Real Estate Office
 */
package RealEstate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    private House house;

    @BeforeEach
    void setUp() {
        house = new House();
    }

    @Test
    void getYardAcres() {
        assertEquals(0, house.getYardAcres());
    }

    @Test
    void setYardAcres() {
        house.setYardAcres(2.3);
        assertEquals(2.3, house.getYardAcres());
    }

    @Test
    void calculateAppraisalPrice(){
        house.setSqFootage(1);
        house.setBedCount(1);
        house.setBathCount(1);
        house.setYardAcres(1);
        assertEquals(482097, house.calculateAppraisalPrice());
    }
}