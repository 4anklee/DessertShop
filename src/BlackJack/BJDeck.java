package BlackJack;

import java.util.ArrayList;
import static BlackJack.BJCard.*;

public class BJDeck {
    ArrayList<BJCard> cards = new ArrayList<>();

    public BJDeck(){
        for(int suit : suits){
            for(int rank : ranks){
                cards.add(new BJCard(suit, rank));
            }
        }
    }
}
