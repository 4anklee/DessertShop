/* Name: Frank Lee
 * Project: Lab1i
 * Instructor: Brother Alex May
 * Date: Sep 11, 2023
 * Description: Java Basics Review
 */
package week1;
//import everything
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

//main class
public class Lab1i {
    //main method
    public static void main(String[] args) {
        //variables
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        //program header
        System.out.println("In this program, you will enter a list of numbers.");

        //do-while loop for user to enter numbers
        while(true){
            //instruction
            System.out.print("Please enter a number (or hit the <Enter> key to stop):");
            //variables
            int number;
            String response = input.nextLine();
            //try-catch statement for press-enter-to-stop feature
            try {
                if (response.isEmpty()) {
                    break;
                }
                number = Integer.parseInt(response);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.printf("Invalid response. '%s' is not a number.\n", response);
            }//end of try-catch statement
        }//end of while loop

        //print out results
        System.out.printf("\nThe total of the list of numbers is: %d\n", addNumbers(numbers));
        System.out.printf("The biggest number in the list is: %d", largestNumber(numbers));
    }//end of main method

    //addNumbers method
    public static int addNumbers(ArrayList<Integer>numbers){
        //variable
        int result = 0;
        //for loop to accumulate numbers
        for(int number : numbers){
            result += number;
        }//end of for loop
        return result;//return result
    }//end of addNumbers method

    //largestNumber method
    public static int largestNumber(ArrayList<Integer>numbers){
        //variable
        int result = 0;
        //sort numbers and get the biggest one
        Collections.sort(numbers);
        //try-catch statement to prevent index to be less 0
        try {
            int arraySize = numbers.size();
            result = numbers.get(arraySize - 1);
        }catch(IndexOutOfBoundsException ignored){
        }//end of try-catch statement
        return result;//return result
    }//end of largestNumber method

}//end of Lab1i