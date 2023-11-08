package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public interface Listable {
    HashMap<String, Residential> getListings();
    Residential getListing(String listing);
    Set<String> getStreetAddresses();
    Collection<Residential> getResidences();
    int getListingCount();
    void addListing(String listing, Residential residential);
}
