package BlackJack;

import BlackJackBase.PCard;
import BlackJackBase.PDeck;

import java.util.ArrayList;
import java.util.Collections;

import static BlackJack.BJCard.*;

public class BJDeck implements PDeck {
    private final ArrayList<BJCard> cards;

    public BJDeck(){
        this.cards = new ArrayList<>();
        for(int suit : suits){
            for(int rank : ranks){
                cards.add(new BJCard(rank, suit));
            }
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public void addCard(PCard card) {
        if (card instanceof BJCard){
            cards.add((BJCard) card);
        }
    }

    @Override
    public PCard dealCard() {
        return !cards.isEmpty() ? cards.remove(cards.size() - 1) : null;
    }

    @Override
    public PCard dealHiddenCard() {
        BJCard card = (BJCard) dealCard();
        if (card != null) {
            card.hideCard();
        }
        return card;
    }

    @Override
    public int cardCount() {
        return cards.size();
    }
}
