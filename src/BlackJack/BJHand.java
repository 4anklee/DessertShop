package BlackJack;

import BlackJackBase.PCard;
import BlackJackBase.PHand;
import static BlackJack.BJCard.*;

import java.util.ArrayList;

public class BJHand implements PHand {
    ArrayList<BJCard> cards;
    public BJHand() {
        cards = new ArrayList<>();
    }


    @Override
    public int getSize() {
        return cards.size();
    }

    @Override
    public void addCard(PCard card) {
        cards.add((BJCard) card);
    }

    @Override
    public PCard getCard(int index) {
        return cards.get(index);
    }

    @Override
    public PCard removeCard(int index) {
        return cards.remove(index);
    }

    /** Returns the point value of the current hand.
     *  Basic BlackJack rules apply:
     *  Ranks 2 - 10 are valued at their face value
     *  Ranks Jack - King are valued at 10
     *  Ace is valued at 11 if the total value of all cards in the hand is <= 21
     *  Otherwise, Ace is valued as 1
     */
    @Override
    public int getValue() {
        int result = 0;
        int numbersOfAce = 0;
        for(BJCard card : cards){
            if (card.getRank() >= TEN) {
                result += TEN;
            }else if(card.getRank() == ACE){
                result += ACE;
                numbersOfAce += 1;
            }else {
                result += card.getRank();
            }
        }
        while(result < 21 && numbersOfAce > 0){
            numbersOfAce -= 1;
            result += 10;
        }
        return result;
    }
}
