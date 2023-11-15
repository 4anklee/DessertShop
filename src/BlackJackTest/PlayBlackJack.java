package BlackJackTest;

import BlackJack.BJDeck;
import BlackJack.BJHand;

import java.awt.*;

import static BlackJackBase.PGame.*;

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
        setBackgroundColor(new Color(248, 225, 237));
        setBannerColor(Color.DARK_GRAY);
        setBannerTextColor(Color.WHITE);
        setStatusTextColor(new Color(120, 150, 162));
        setButtonColor(new Color(245, 189, 119));
        setButtonHighlightColor(new Color(229, 173, 252));
        setButtonTextColor(Color.WHITE);
        setFont("Times New Roman");
        BJDeck bjDeck = new BJDeck();
//        run(bjDeck);
//
        BJHand bjHand = new BJHand();
//        run(bjDeck, bjHand);
        BJHand bjDealer =new BJHand();
        run(bjDeck, bjDealer, bjHand);

    }
}
