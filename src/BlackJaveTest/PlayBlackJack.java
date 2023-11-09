package BlackJaveTest;

import BlackJack.BJCard;

import java.util.ArrayList;
import java.util.Collections;

import static BlackJack.BJCard.*;
import static BlackJaveTest.CardTest.run;

public class PlayBlackJack {
    public static void main(String[] args) {
        BJCard spadeAce = new BJCard(SPADE, ACE);
        BJCard heartSix = new BJCard(HEART, SIX);
        BJCard spadeJack = new BJCard(SPADE, JACK);
        BJCard heartKnight = new BJCard(HEART, KNIGHT);
        BJCard diamondQueen = new BJCard(DIAMOND, QUEEN);
        BJCard clubKing = new BJCard(CLUB, KING);
        ArrayList<BJCard> cards = new ArrayList<>();
        Collections.addAll(cards, spadeAce, heartSix, spadeJack, heartKnight, diamondQueen, clubKing);
        for(BJCard card : cards){
            run(card);
        }
//        BJDeck bjDeck = new BJDeck();
//        run(bjDeck);


//        for(BJCard bjCard : bjDeck.getBJDeck()){
//            run(bjCard);
//        }
    }
}
