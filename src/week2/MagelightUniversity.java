/* Name: Frank Lee
 * Project: Lab2c
 * Instructor: Brother Alex May
 * Date: Sep 18, 2023
 * Description: Magelight University
 */
package week2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;

public class MagelightUniversity {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        Person Rachel = new Person("Rachel", "1993-05-12", "Female", "801-555-1212"),
        Jose = new Person("Jose", "2004-12-01", "Male", "480-555-1212"),
        Prya = new Person("Prya", "2001-02-27", "Female", "385-555-1212"),
        Bob = new Person("Bob", "1984-06-06", "Male", "916-555-1212");

        Collections.addAll(people, Rachel, Jose, Prya, Bob);
        LocalDate today = LocalDate.now();

        System.out.println("The people at the MageLight University include:\n");
        System.out.printf("%-10s%-5s%-7s%15s\n", "Name", "Age", "Gender", "Phone Number");
        System.out.println("---------------------------------------");


        for(Person person: people){
            System.out.printf("%-10s%-5s%-7s%15s\n", person.getName(), Period.between(person.getDob(), today).getYears(), person.getGender(), person.getPhone());
        }
    }
}
