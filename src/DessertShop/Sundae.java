/* Name: Frank Lee
 * Project: Lab5b
 * Instructor: Brother Alex May
 * Date: Oct 9, 2023
 * Description: Dessert Shop Part 6
 */
package DessertShop;


class Sundae extends IceCream{
    private String toppingName;
    private double toppingPrice;
    public Sundae() {
        super();
        this.toppingName = "";
        this.toppingPrice = 0;
        super.setPackaging("");
    }

    public Sundae(String name, int scoopCount, double pricePerScoop, String toppingName, double toppingPrice){
        super(name, scoopCount, pricePerScoop);
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
        super.setPackaging("Boat");
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    @Override
    public double calculateCost(){
        return super.getScoopCount() * super.getPricePerScoop() + toppingPrice;
    }

    @Override
    public String getName(){
        return toppingName + " " + super.getName() + " Sundae";
    }

    @Override
    public String toString(){
        String name = String.format("%s (%s)", this.getName(), this.getPackaging()),
                qnp = (this.getScoopCount() == 1) ? String.format("%d scoop of %s ice cream @ $%.2f", this.getScoopCount(), super.getName(), this.getPricePerScoop()) :
                        String.format("%d scoops of %s ice cream @ $%.2f/scoop", this.getScoopCount(), super.getName(), this.getPricePerScoop()),
                cost = String.format("$%.2f", calculateCost()),
                tax = String.format("[Tax: $%.2f]", calculateTax(this)),
                tNnP = String.format("%s Topping @ $%.2f", toppingName, toppingPrice);

        return String.format("""
                %s
                \t%-45s
                \t%-45s%10s%17s
                """, name, qnp, tNnP, cost,tax);
    }
}
