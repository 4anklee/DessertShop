package BlackJack;

import java.util.ArrayList;
import static BlackJack.BJCard.*;

public class BJDeck {
    ArrayList<BJCard> cards = new ArrayList<>();
    public static final int[] suits = {CLUB, DIAMOND, HEART, SPADE};
    public static final int[] ranks = {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, KNIGHT, QUEEN, KING};
    public BJDeck(){
        for(int suit : suits){
            for(int rank : ranks){
                cards.add(new BJCard(suit, rank));
            }
        }
    }
}
