package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Listings implements Listable{
    HashMap<String, Residential> listings;

    public Listings(){
        this.listings = new HashMap<>();
    }

    @Override
    public HashMap<String, Residential> getListings() {
        return listings;
    }

    @Override
    public Residential getListing(String listing){
        return listings.get(listing);
    }

    @Override
    public Set<String> getStreetAddresses(){
        return listings.keySet();
    }

    @Override
    public Collection<Residential> getResidences(){
        return listings.values();
    }

    @Override
    public int getListingCount(){
        return listings.values().size();
    }

    @Override
    public void addListing(String listing, Residential residential){
        listings.put(listing, residential);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        int listingNo = 1;
        for(Residential listing : listings.values()){
            result.append(String.format("Listing No: %d\n", listingNo));
            result.append(listing);
            result.append("\n");
            listingNo++;
        }
        return result.toString();
    }
}
