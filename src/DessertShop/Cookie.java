/* Name: Frank Lee
 * Project: Lab5b
 * Instructor: Brother Alex May
 * Date: Oct 9, 2023
 * Description: Dessert Shop Part 6
 */
package DessertShop;

class Cookie extends DessertItem implements SameItem<Cookie>{
    private int cookieQty;
    private double pricePerDozen;
    public Cookie(){
        super();
        this.cookieQty = 0;
        this.pricePerDozen = 0;
        super.setPackaging("");
    }

    public Cookie(String name, int cookieQty, double pricePerDozen){
        super(name);
        this.cookieQty = cookieQty;
        this.pricePerDozen = pricePerDozen;
        super.setPackaging("Box");
    }

    public int getCookieQty() {
        return cookieQty;
    }

    public void setCookieQty(int cookieQty) {
        this.cookieQty = cookieQty;
    }

    public double getPricePerDozen() {
        return pricePerDozen;
    }

    public void setPricePerDozen(double pricePerDozen) {
        this.pricePerDozen = pricePerDozen;
    }

    @Override
    public String getName(){
        return  super.getName();
    }

    @Override
    public double calculateCost() {
        return (cookieQty * pricePerDozen) / 12;
    }

    @Override
    public String toString(){
        String name = (cookieQty == 1) ? String.format("%s Cookie (%s)", this.getName(), this.getPackaging()) :
                        String.format("%s Cookies (%s)", this.getName(), this.getPackaging()),
                qnp = (cookieQty == 1) ? String.format("%d cookie @ $%.2f", this.cookieQty, this.pricePerDozen) :
                        String.format("%d cookies @ $%.2f/dozen", this.cookieQty, this.pricePerDozen),
                cost = String.format("$%.2f", calculateCost()),
                tax = String.format("[Tax: $%.2f]", calculateTax(this));

        return String.format("%s\n\t%-45s%10s%17s\n", name, qnp, cost,tax);
    }

    @Override
    public boolean isSameAs(Cookie other){
        return this.getName().equalsIgnoreCase(other.getName()) && this.pricePerDozen == other.pricePerDozen;
    }
}
