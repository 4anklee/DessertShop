/* Name: Frank Lee
 * Project: Lab5b
 * Instructor: Brother Alex May
 * Date: Oct 9, 2023
 * Description: Dessert Shop Part 6
 */
package DessertShop;

public interface Packaging {

    default String getPackaging(){
        return "";
    }

    default void setPackaging(String packaging){
    }
}
