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

class ResidentialTest {

    private Residential residential;

    @BeforeEach
    void setUp() {
        residential = new Condo();
    }

    @Test
    void getBedCount() {
        assertEquals(0, residential.getBedCount());
    }

    @Test
    void setBedCount() {
        residential.setBedCount(1);
        assertEquals(1, residential.getBedCount());
    }

    @Test
    void getBathCount() {
        assertEquals(0, residential.getBathCount());
    }

    @Test
    void setBathCount() {
        residential.setBathCount(2);
        assertEquals(2, residential.getBathCount());
    }

    @Test
    void getSqFootage() {
        assertEquals(0, residential.getSqFootage());
    }

    @Test
    void setSqFootage() {
        residential.setSqFootage(3.1);
        assertEquals(3.1, residential.getSqFootage());
    }
}