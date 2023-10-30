/* Name: Frank Lee
 * Project: Lab6a
 * Instructor: Brother Alex May
 * Date: Oct 12, 2023
 * Description: Dessert Shop Part 7
 */
package DessertShop;

public interface Payable {
    enum PayType{
        CASH,
        CARD,
        PHONE
    }

    PayType getPayType();

    void setPayType(PayType value);
}
