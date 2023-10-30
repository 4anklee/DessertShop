/* Name: Frank Lee
 * Project: Lab5b
 * Instructor: Brother Alex May
 * Date: Oct 9, 2023
 * Description: Dessert Shop Part 6
 */
package DessertShop;

class IceCream extends DessertItem{
    private int scoopCount;
    private double pricePerScoop;
    public IceCream() {
        super();
        this.scoopCount = 0;
        this.pricePerScoop = 0;
        super.setPackaging("");
    }

    public IceCream(String name, int scoopCount, double pricePerScoop){
        super(name);
        this.scoopCount = scoopCount;
        this.pricePerScoop = pricePerScoop;
        super.setPackaging("Bowl");
    }

    public int getScoopCount() {
        return scoopCount;
    }

    public void setScoopCount(int scoopCount) {
        this.scoopCount = scoopCount;
    }

    public double getPricePerScoop() {
        return pricePerScoop;
    }

    public void setPricePerScoop(double pricePerScoop) {
        this.pricePerScoop = pricePerScoop;
    }

    @Override
    public double calculateCost(){
        return scoopCount * pricePerScoop;
    }

    @Override
    public String toString(){
        String name = String.format("%s Ice Cream (%s)", this.getName(), this.getPackaging()),
                qnp = (scoopCount == 1) ? String.format("%d scoop @ $%.2f scoop", this.scoopCount, this.pricePerScoop) :
                        String.format("%d scoops @ $%.2f/scoop", this.scoopCount, this.pricePerScoop),
                cost = String.format("$%.2f", calculateCost()),
                tax = String.format("[Tax: $%.2f]", calculateTax(this));

        return String.format("%s\n\t%-45s%10s%17s\n", name, qnp, cost,tax);
    }
}
