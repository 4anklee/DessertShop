package BlackJack;

import BlackJackBase.PCard;

import java.awt.*;

public class BJCard extends PCard {
    private int suit;
    private int rank;
    private boolean hidden;
    public static final int CLUB = 1;
    public static final int DIAMOND = 2;
    public static final int HEART = 3;
    public static final int SPADE = 4;
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
    public static final int[] suits = {CLUB, DIAMOND, HEART, SPADE};
    public static final int[] ranks = {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, KNIGHT, QUEEN, KING};

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

    @Override
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public void hideCard() {
        this.hidden = true;
    }

    @Override
    public void showCard() {
        this.hidden = false;
    }

    @Override
    public String getText() {
        String suitText = "";
        switch(this.suit){
            case CLUB -> suitText = "♣";
            case DIAMOND -> suitText = "♦";
            case HEART -> suitText = "♥";
            case SPADE -> suitText = "♠";
        }
        String rankText = "";
        switch (this.rank){
            case ACE -> rankText = "A";
            case JACK -> rankText = "J";
            case KNIGHT -> rankText = "Kn";
            case QUEEN -> rankText = "Q";
            case KING -> rankText = "K";
            default -> {
                if(this.rank >= 1 && this.rank <= 10){
                    rankText = String.valueOf(this.rank);
                }
            }
        }
        return suitText + rankText;
    }

    @Override
    public Color getFontColor(){
        return getSuit() == CLUB || getSuit() == SPADE ? Color.BLACK : Color.RED;
    }
}
