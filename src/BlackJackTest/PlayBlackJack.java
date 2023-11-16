package BlackJackTest;

import BlackJack.BJDeck;
import BlackJack.BJHand;

import static BlackJackTest.HandTest.run;

public class PlayBlackJack {
    public static void main(String[] args) {
        BJDeck bjDeck = new BJDeck();
        BJHand bjHand = new BJHand();
        run(bjDeck, bjHand);
    }
}
