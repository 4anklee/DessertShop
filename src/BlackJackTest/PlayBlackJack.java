package BlackJackTest;

import BlackJack.BJDeck;

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
        DeckTest.run(bjDeck);

    }
}
