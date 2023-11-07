package BlackJaveTest;

import BlackJack.BJCard;
import BlackJack.BJDeck;

import static BlackJaveTest.CardTest.*;

public class PlayBlackJack {
    public static void main(String[] args) {
        BJCard bjCard = new BJCard(1, 1);
        BJDeck bjDeck = new BJDeck();
        run(bjCard);

    }
}
