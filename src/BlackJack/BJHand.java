package BlackJack;

import BlackJackBase.PCard;
import BlackJackBase.PHand;
import static BlackJack.BJCard.*;

import java.util.ArrayList;

public class BJHand implements PHand {
    private final ArrayList<BJCard> cards;
    public BJHand() {
        this.cards = new ArrayList<>();
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
