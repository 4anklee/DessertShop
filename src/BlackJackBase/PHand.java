package BlackJackBase;

/**
 * Base interface used to manage cards held by a player.
 * 
 * @author Jared N. Plumb
 * @version 1.0
 * @since 2018-05-25
// * @Minor modifications by Jeff Light
 * @since 2019-11-09
 */
public interface PHand {

	/** Returns the number of cards in the hand. */
	public int getSize();

	/** Adds a card to the end of the hand. */
	public void addCard(PCard card);

	/** Returns a card from the hand (but not removed). */
	public PCard getCard(int index);

	/** Removes and returns the card */
	public PCard removeCard(int index);

	/** Returns the point value of the current hand.
	 *  Basic BlackJack rules apply:
	 *  Ranks 2 - 10 are valued at their face value
	 *  Ranks Jack - King are valued at 10
	 *  Ace is valued at 11 if the total value of all cards in the hand is <= 21
	 *  Otherwise, Ace is valued as 1 
	 */
	public int getValue();
}