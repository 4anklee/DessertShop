/* Name: Frank Lee
 * Project: Lab2b
 * Instructor: Brother Alex May
 * Date: Sep 18, 2023
 * Description: Junit testing
 */
package week2;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person();
    }

    @Test
    public void getName() {
        assertEquals(person.getName(), "Frank");
    }

    @Test
    public void getDob() {
        assertEquals(person.getDob(), LocalDate.of(1999, 9, 17));
    }

    @Test
    public void getGender() {
        assertEquals(person.getGender(), "male");
    }

    @Test
    public void getPhone() {
        assertEquals(person.getPhone(), "385-202-8820");
    }

    @Test
    public void setName() {
        person.setName("Joe");
        assertEquals("Joe", person.getName());
    }

    @Test
    public void setDob() {
        person.setDob("2000-01-01");
        assertEquals(LocalDate.parse("2000-01-01"), person.getDob());
    }

    @Test
    public void setGender() {
        person.setGender("non-binary");
        assertEquals("non-binary", person.getGender());
    }

    @Test
    public void setPhone() {
        person.setPhone("000-000-0000");
        assertEquals("000-000-0000", person.getPhone());
    }
}