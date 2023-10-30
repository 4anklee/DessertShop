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

class CondoTest {

    private Condo condo;

    @BeforeEach
    void setUp() {
        condo = new Condo();
    }

    @Test
    void getFloorLvl() {
        assertEquals(0, condo.getFloorLvl());
    }

    @Test
    void setFloorLvl() {
        condo.setFloorLvl(2);
        assertEquals(2, condo.getFloorLvl());
    }

    @Test
    void calculateAppraisalPrice(){
        condo.setSqFootage(1);
        condo.setBedCount(1);
        condo.setBathCount(1);
        condo.setFloorLvl(1);
        assertEquals(18088, condo.calculateAppraisalPrice());
    }
}