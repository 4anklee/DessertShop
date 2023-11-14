package BlackJackTest;

import BlackJack.BJCard;
import BlackJack.BJDeck;
import BlackJack.BJHand;

import static BlackJack.BJCard.*;

import static BlackJackTest.DeckTest.run;
import static BlackJackTest.HandTest.run;


public class PlayBlackJack {
    public static void main(String[] args) {
//        BJCard spadeAce = new BJCard(SPADE, ACE);
//        BJCard heartSix = new BJCard(HEART, SIX);
//        BJCard spadeJack = new BJCard(SPADE, JACK);
//        BJCard heartKnight = new BJCard(HEART, KNIGHT);
//        BJCard diamondQueen = new BJCard(DIAMOND, QUEEN);
//        BJCard clubKing = new BJCard(CLUB, KING);
//        ArrayList<BJCard> cards = new ArrayList<>();
//        Collections.addAll(cards, spadeAce, heartSix, spadeJack, heartKnight, diamondQueen, clubKing);
//        for(BJCard card : cards){
//            run(card);
//        }
        BJDeck bjDeck = new BJDeck();
//        run(bjDeck);

        BJHand bjHand = new BJHand();
        bjHand.addCard(new BJCard(ACE, SPADE));
        bjHand.addCard(new BJCard(ACE, DIAMOND));
        bjHand.addCard(new BJCard(ACE, HEART));
        bjHand.addCard(new BJCard(ACE, CLUB));
        bjHand.addCard(new BJCard(TWO, CLUB));
        bjHand.addCard(new BJCard(TWO, DIAMOND));
        bjHand.addCard(new BJCard(THREE, SPADE));
        System.out.println(bjHand.getValue());
        run(bjDeck, bjHand);
//        run(bjDeck);
    }
}
