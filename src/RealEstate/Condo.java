/* Name: Frank Lee
 * Project: Lab6i
 * Instructor: Brother Alex May
 * Date: Oct 16, 2023
 * Description: Real Estate Office
 */
package RealEstate;

public class Condo extends Residential {

    private int floorLvl;

    public Condo(){
        super();
        this.floorLvl = 0;
    }

    public Condo(String streetAddress, String zip, int bedCount, int bathCount, double sqFootage, int floorLvl, double listPrice, double appraisalPrice){
        super(streetAddress, zip, bedCount, bathCount, sqFootage, listPrice, appraisalPrice);
        this.floorLvl = floorLvl;
    }

    public int getFloorLvl() {
        return floorLvl;
    }

    public void setFloorLvl(int floorLvl) {
        this.floorLvl = floorLvl;
    }

    @Override
    public double calculateAppraisalPrice(){
        return 88 * getSqFootage() + 8000 * getBedCount() + 10000 * getBathCount() + 5000 * (getFloorLvl() - 1);
    }

    @Override
    public String toString(){
        return String.format("""
                -------------------------------------------------------------------------------
                Resident Type: Condo       Address: %-20s Zip Code: %-20s
                -------------------------------------------------------------------------------
                Sq Footage: %.2f
                Bedroom: %d
                Bathroom: %d
                Floor: %d
                -----------------------------------------
                Appraisal Price: %.2f
                List Price: %.2f
                -----------------------------------------
                """, getStreetAddress(), getZip(),
                getSqFootage(),
                getBedCount(),
                getBathCount(),
                getFloorLvl(),
                calculateAppraisalPrice(),
                getListPrice());
    }
}
