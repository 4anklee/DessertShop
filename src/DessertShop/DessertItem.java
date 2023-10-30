/* Name: Frank Lee
 * Project: Lab6b
 * Instructor: Brother Alex May
 * Date: Oct 12, 2023
 * Description: Dessert Shop Part 8
 */
package DessertShop;
import java.lang.Comparable;
public abstract class DessertItem implements Packaging, Comparable<DessertItem> {
    private String name;
    private double taxPercentage = 7.25;
    private String packaging;

    public DessertItem() {
        this.name = "";
    }

    public DessertItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public double calculateTax(DessertItem item){
        return (item.calculateCost() * taxPercentage / 100);
    }

    public abstract double calculateCost();

    @Override
    public String getPackaging(){
        return packaging;
    }

    @Override
    public void setPackaging(String packaging){
        this.packaging = packaging;
    }

    @Override
    public int compareTo(DessertItem dessertItem){
        return Double.compare(this.calculateCost(), dessertItem.calculateCost());
    }
}
