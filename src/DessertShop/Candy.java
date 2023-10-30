/* Name: Frank Lee
 * Project: Lab5b
 * Instructor: Brother Alex May
 * Date: Oct 9, 2023
 * Description: Dessert Shop Part 6
 */
package DessertShop;

class Candy extends DessertItem implements SameItem<Candy>{
    private double candyWeight;
    private double pricePerPound;
    public Candy() {
        super();
        this.candyWeight = 0;
        this.pricePerPound = 0;
        super.setPackaging("");
    }

    public Candy(String name, double candyWeight, double pricePerPound) {
        super(name);
        this.candyWeight = candyWeight;
        this.pricePerPound = pricePerPound;
        super.setPackaging("Bag");
    }

    public double getCandyWeight() {
        return candyWeight;
    }

    public void setCandyWeight(double candyWeight) {
        this.candyWeight = candyWeight;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

    public void setPricePerPound(double pricePerPound) {
        this.pricePerPound = pricePerPound;
    }


    public double calculateCost(){
        return candyWeight * pricePerPound;
    }

    @Override
    public String toString(){
        String name = String.format("%s (%s)", this.getName(), this.getPackaging()),
                qnp = (candyWeight == 1) ? String.format("%.2f lb. @ $%.2f lb.", this.candyWeight, this.pricePerPound) :
                        String.format("%.2f lbs. @ $%.2f/lb.", this.candyWeight, this.pricePerPound),
                cost = String.format("$%.2f", calculateCost()),
                tax = String.format("[Tax: $%.2f]", calculateTax(this));

        return String.format("%s\n\t%-45s%10s%17s\n", name, qnp, cost,tax);
    }

    @Override
    public boolean isSameAs(Candy other){
        return this.getName().equalsIgnoreCase(other.getName()) && this.pricePerPound == other.pricePerPound;
    }
}
