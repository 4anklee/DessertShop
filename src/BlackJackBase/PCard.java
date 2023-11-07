package BlackJackBase;

import java.awt.Color;

/**
 * Base class used to create a playing card. This class is extended by another
 * class that overrides the necessary methods to create usability and visual
 * appeal.
 * 
 * @author Jared N. Plumb
 * @version 1.0
 * @since 2018-05-25
 * @Minor modifications by Jeff Light
 * @since 2019-11-01
 */
public abstract class PCard {

	/** Sets the card to the face down state. */
	public abstract void hideCard();

	/** Sets the card to the face up state. */
	public abstract void showCard();

	/**
	 * Finds if the card is face-down or face-up
	 * 
	 * @return <b>true</b> if the card is face down.
	 */
	public abstract boolean isHidden();

	/**
	 * Returns a string containing both the rank and suit of the card. This text will
	 * be placed in the middle of the card to identify the card rank and suit. It may
	 * include a standard character for the rank and a Unicode character for the suit.
	 */
	public abstract String getText(); // Returns a value such as "K\u2605"

	/** Returns the color of the font used for the card text. */
	public Color getFontColor() {
		return Color.LIGHT_GRAY;
	}

	/** Returns the color of the cards face. */
	public Color getFaceColor() {
		return Color.WHITE;
	}

	/** Returns the color of the cards background. */
	public Color getBackColor() {
		return Color.WHITE;
	}

	/** Returns the color of an 8 pixel border around the edge of the card. */
	public Color getBorderColor() {
		return Color.LIGHT_GRAY;
	}

	/** Returns the alternative color used on the cards background. */
	public Color getStripeColor() {
		return Color.LIGHT_GRAY;
	}
}
