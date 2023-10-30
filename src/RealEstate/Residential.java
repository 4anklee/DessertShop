/* Name: Frank Lee
 * Project: Lab6i
 * Instructor: Brother Alex May
 * Date: Oct 16, 2023
 * Description: Real Estate Office
 */
package RealEstate;

public abstract class Residential  extends Property{

    private int bedCount;
    private int bathCount;
    private double sqFootage;

    public Residential(){
        super();
        this.bedCount = 0;
        this.bathCount = 0;
        this.sqFootage = 0;
    }

    public Residential(String streetAddress, String zip, int bedCount, int bathCount, double sqFootage, double listPrice, double appraisalPrice){
        super(streetAddress, zip, listPrice, appraisalPrice);
        this.bedCount = bedCount;
        this.bathCount = bathCount;
        this.sqFootage = sqFootage;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public int getBathCount() {
        return bathCount;
    }

    public void setBathCount(int bathCount) {
        this.bathCount = bathCount;
    }

    public double getSqFootage() {
        return sqFootage;
    }

    public void setSqFootage(double sqFootage) {
        this.sqFootage = sqFootage;
    }

    public abstract double calculateAppraisalPrice();
}
