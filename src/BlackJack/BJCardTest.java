package BlackJack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static BlackJack.BJCard.*;

import static org.junit.jupiter.api.Assertions.*;

class BJCardTest {

    private BJCard bjCard;

    @BeforeEach
    void setUp() {
        bjCard = new BJCard(CLUB, ACE);
    }

    @Test
    void getSuit() {
        assertEquals(CLUB, bjCard.getSuit());
    }

    @Test
    void setSuit() {
        bjCard.setSuit(SPADE);
        assertEquals(SPADE, bjCard.getSuit());
    }

    @Test
    void getRank() {
        assertEquals(ACE, bjCard.getRank());
    }

    @Test
    void setRank() {
        bjCard.setRank(TEN);
        assertEquals(TEN, bjCard.getRank());
    }

    @Test
    void isHidden() {
        assertFalse(bjCard.isHidden());
    }

    @Test
    void hideCard() {
        bjCard.hideCard();
        assertTrue(bjCard.isHidden());
    }

    @Test
    void showCard() {
        bjCard.showCard();
        assertFalse(bjCard.isHidden());
    }

    @Test
    void getText() {
        assertEquals("A♣", bjCard.getText());
    }

    @Test
    void getFontColor() {
        assertEquals(Color.BLACK, bjCard.getFontColor());
    }
}