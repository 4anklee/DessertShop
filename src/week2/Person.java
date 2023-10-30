/* Name: Frank Lee
 * Project: Lab2a
 * Instructor: Brother Alex May
 * Date: Sep 18, 2023
 * Description: Person Class
 */
package week2;

import java.time.LocalDate;

//Person class
public class Person {

    //instances
    private String name;
    private LocalDate dob;
    private String gender;
    private String phone;

    //default constructor
    public Person(){
        this.name = "Frank";
        this.dob = LocalDate.parse("1999-09-17");
        this.gender = "male";
        this.phone = "385-202-8820";
    }

    //constructor
    public Person(String name, String dob, String gender, String phone){
        this.name = name;
        this.dob = LocalDate.parse(dob);
        this.gender = gender;
        this.phone = phone;
    }

    //name getter
    public String getName(){
        return name;
    }

    //name setter
    public void setName(String name){
        this.name = name;
    }

    //dob getter
    public LocalDate getDob(){
        return dob;
    }

    //dob setter
    public void setDob(String dob){
        this.dob = LocalDate.parse(dob);
    }

    //gender getter
    public String getGender(){
        return gender;
    }

    //gender setter
    public void setGender(String gender){
        this.gender = gender;
    }

    //phone getter
    public String getPhone(){
        return phone;
    }

    //phone setter
    public void setPhone(String phone){
        this.phone = phone;
    }
}

