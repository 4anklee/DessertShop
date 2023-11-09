package BlackJack;

import BlackJackBase.PCard;
import BlackJackBase.PDeck;

import java.util.ArrayList;
import static BlackJack.BJCard.*;

public class BJDeck implements PDeck {
    ArrayList<BJCard> cards = new ArrayList<>();

    public BJDeck(){
        for(int suit : suits){
            for(int rank : ranks){
                cards.add(new BJCard(suit, rank));
            }
        }
    }

    public ArrayList<BJCard> getBJDeck(){
        return cards;
    }

    @Override
    public void shuffle() {

    }

    @Override
    public void addCard(PCard card) {

    }

    @Override
    public PCard dealCard() {
        return null;
    }

    @Override
    public PCard dealHiddenCard() {
        return null;
    }

    @Override
    public int cardCount() {
        return 0;
    }
}
