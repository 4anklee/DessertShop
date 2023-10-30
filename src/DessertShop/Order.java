/* Name: Frank Lee
 * Project: Lab6a
 * Instructor: Brother Alex May
 * Date: Oct 12, 2023
 * Description: Dessert Shop Part 7
 */
package DessertShop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static DessertShop.DessertShop.PaymentMethod;

public class Order implements Payable{
    final private ArrayList<DessertItem> order;
    PayType payMethod;

    public Order(){
        this.order = new ArrayList<>();
        setPayType(PayType.CASH);
    }

    public ArrayList<DessertItem> getOrderList(){
        return order;
    }

    public void add(DessertItem... dessertItem) {

        List<DessertItem> itemToAdd = new ArrayList<>(Arrays.asList(dessertItem));

        for(DessertItem item: dessertItem){
            if(item instanceof Candy){
                for(DessertItem existingItem: getOrderList()){
                    if(existingItem instanceof Candy){
                        if(((Candy) item).isSameAs((Candy) existingItem)){
                            ((Candy) existingItem).setCandyWeight(((Candy) item).getCandyWeight()
                                    + ((Candy) existingItem).getCandyWeight());
                            itemToAdd.remove(item);
                        }
                    }
                }
            }else if(item instanceof Cookie) {
                for (DessertItem existingItem : getOrderList()) {
                    if (existingItem instanceof Cookie) {
                        if (((Cookie) item).isSameAs((Cookie) existingItem)) {
                            ((Cookie) existingItem).setCookieQty(((Cookie) item).getCookieQty()
                                    + ((Cookie) existingItem).getCookieQty());
                            itemToAdd.remove(item);
                        }
                    }
                }
            }
        }

        Collections.addAll(order, itemToAdd.toArray(new DessertItem[0]));
    }


    public int itemCount(){
        return order.size();
    }

    public double orderCost(){
        double result = 0;
        for(DessertItem item: order){
            result += item.calculateCost();
        }
        return result;
    }

    public double orderTax(){
        double result = 0;
        for(DessertItem item: order){
            result += (item.calculateCost() * item.getTaxPercentage() / 100);
        }
        return result;
    }

    public String toString(){
        StringBuilder finalOutput = new StringBuilder();
        finalOutput.append("------------------------------------Receipt----------------------------------------------------------\n");
        for(DessertItem item : getOrderList()){
            finalOutput.append(item.toString());
        }
        finalOutput.append("-----------------------------------------------------------------------------------------------------\n");
        String summary = String.format("""
                Total number of items in order: %d
                %-49s%10s%17s
                %-42s%17s
                """,
                itemCount(),
                "Order Subtotals:",
                String.format("$%.2f", orderCost()),
                String.format("[Tax: $%.2f]",orderTax()),
                "Order Total:",
                String.format("$%.2f", (orderCost() + orderTax())));
        finalOutput.append(summary);
        finalOutput.append("-----------------------------------------------------------------------------------------------------\n");
        finalOutput.append(String.format("Paid with %s", PaymentMethod));
        return finalOutput.toString();
    }

    public PayType getPayType() {
        return payMethod;
    }

    public void setPayType(PayType value){
        payMethod = value;
    }
}
