/* Name: Frank Lee
 * Project: Lab6i
 * Instructor: Brother Alex May
 * Date: Oct 16, 2023
 * Description: Real Estate Office
 */
package RealEstate;

import java.util.HashMap;
import java.util.Set;

public abstract class Residential extends Property implements Biddable{

    private final HashMap<String, Double> bidDB;
    private int bedCount;
    private int bathCount;
    private double sqFootage;

    public Residential(){
        super();
        this.bedCount = 0;
        this.bathCount = 0;
        this.sqFootage = 0;
        this.bidDB = new HashMap<>();
    }

    public Residential(String streetAddress, String zip, int bedCount, int bathCount, double sqFootage, double listPrice, double appraisalPrice){
        super(streetAddress, zip, listPrice, appraisalPrice);
        this.bedCount = bedCount;
        this.bathCount = bathCount;
        this.sqFootage = sqFootage;
        this.bidDB = new HashMap<>();
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

    @Override
    public HashMap<String, Double> getBids(){
        return this.bidDB;
    }

    @Override
    public Double getBid(String key){
        return this.bidDB.get(key);
    }

    @Override
    public Set<String> getBidders(){
        return this.bidDB.keySet();
    }

    @Override
    public int getBidCount(){
        return this.bidDB.size();
    }

    @Override
    public void newBid(String key, Double value){
        this.bidDB.put(key, value);
    }
}
