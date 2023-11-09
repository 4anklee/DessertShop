package BlackJack;

import BlackJackBase.PCard;
import BlackJackBase.PDeck;

import java.util.ArrayList;
import java.util.Collections;

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
        Collections.shuffle(cards);
    }

    @Override
    public void addCard(PCard card) {
        cards.add((BJCard) card);
    }

    @Override
    public PCard dealCard() {
        return cards != null ? cards.remove(cards.size() - 1) : null;
    }

    @Override
    public PCard dealHiddenCard() {
        if (cards != null && !cards.isEmpty()) {
            cards.get(cards.size() - 1).hideCard();
            return cards.remove(cards.size() - 1);
        }
        return null;
    }

    @Override
    public int cardCount() {
        return cards.size();
    }
}
