package RealEstate;

import java.util.HashMap;
import java.util.Set;

public interface Biddable {
    HashMap<String, Double> getBids();

    Double getBid(String key);

    Set<String> getBidders();

    int getBidCount();

    void newBid(String key, Double value);
}
