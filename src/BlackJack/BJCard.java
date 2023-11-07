package BlackJack;

import BlackJackBase.PCard;

import java.awt.*;

public class BJCard extends PCard {
    int suit;
    int rank;
    boolean hidden;
    public static final int CLUB = 1;
    public static final int DIAMOND = 1;
    public static final int HEART = 1;
    public static final int SPADE = 1;
    public static final int ACE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int KNIGHT = 12;
    public static final int QUEEN = 13;
    public static final int KING  = 14;

    public BJCard(int suit, int rank){
        this.suit = suit;
        this.rank = rank;
        this.hidden = false;
    }
    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public void hideCard() {

    }

    @Override
    public void showCard() {

    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public Color getFontColor(){
        if(){

        }
    }
}
