package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public interface Listable {
    public HashMap<String, Residential> getListings();
    public Residential getListing(String listing);
    public Set<String> getStreetAddresses();
    public Collection<Residential> getResidences();
    public int getListingCount();
    public void addListing(String listing, Residential residential);
}
