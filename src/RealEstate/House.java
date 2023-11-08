/* Name: Frank Lee
 * Project: Lab6i
 * Instructor: Brother Alex May
 * Date: Oct 16, 2023
 * Description: Real Estate Office
 */
package RealEstate;

public class House extends Residential {

    private double yardAcres;

    public House(){
        super();
        this.yardAcres = 0;
    }

    public House(String streetAddress, String zip, int bedCount, int bathCount, double sqFootage, double yardAcres, double listPrice, double appraisalPrice){
        super(streetAddress, zip, bedCount, bathCount, sqFootage, listPrice, appraisalPrice);
        this.yardAcres = yardAcres;
    }

    public double getYardAcres() {
        return yardAcres;
    }

    public void setYardAcres(double yardAcres) {
        this.yardAcres = yardAcres;
    }

    @Override
    public double calculateAppraisalPrice(){
        this.setAppraisalPrice(97 * getSqFootage()
                + 10000 * getBedCount()
                + 12000 * getBathCount()
                + 460000 * getYardAcres());
        return this.getAppraisalPrice();
    }

    @Override
    public String toString(){
        return String.format("""
                -------------------------------------------------------------------------------
                Resident Type: House       Address: %-20s Zip Code: %-20s
                -------------------------------------------------------------------------------
                Sq Footage: %.0f
                Bedroom: %d
                Bathroom: %d
                Yard Size(Acres): %.2f
                -----------------------------------------
                Appraisal Price: %.2f
                List Price: %.2f
                -----------------------------------------
                """, getStreetAddress(), getZip(),
                getSqFootage(),
                getBedCount(),
                getBathCount(),
                getYardAcres(),
                calculateAppraisalPrice(),
                getListPrice());
    }
}
