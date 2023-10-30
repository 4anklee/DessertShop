/* Name: Frank Lee
 * Project: Lab6i
 * Instructor: Brother Alex May
 * Date: Oct 16, 2023
 * Description: Real Estate Office
 */
package RealEstate;

public abstract class Property {
    private String streetAddress;
    private String zip;
    private double listPrice;
    private double appraisalPrice;

    public Property() {
        this.streetAddress = "";
        this.zip = "";
        this.listPrice = 0;
        this.appraisalPrice = 0;
    }

    public Property(String streetAddress, String zip, double listPrice, double appraisalPrice){
        this.streetAddress = streetAddress;
        this.zip = zip;
        this.listPrice = listPrice;
        this.appraisalPrice = appraisalPrice;
    }

    public String getStreetAddress(){
        return this.streetAddress;
    }

    public void setStreetAddress(String streetAddress){
        this.streetAddress = streetAddress;
    }

    public String getZip(){
        return this.zip;
    }

    public void setZip(String zip){
        this.zip = zip;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getAppraisalPrice() {
        return appraisalPrice;
    }

    protected void setAppraisalPrice(double appraisalPrice) {
        this.appraisalPrice = appraisalPrice;
    }

    public abstract double calculateAppraisalPrice();
}
