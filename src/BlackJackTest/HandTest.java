package BlackJackTest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BlackJackBase.PCard;
import BlackJackBase.PDeck;
import BlackJackBase.PHand;

/**
 * A simple playing card hand test. This test will attempt a number of hand
 * arrangements to validate they add up to the correct points. A final hand that
 * equals 21 points will be displayed.
 * 
 * @author Jared N. Plumb
 * @version 1.1
 * @since 2018-06-12
 * @Minor modifications by Jeff Light
 * @since 2019-11-09
 */
public class HandTest extends JPanel {

	/**
	 * Display a deck of cards in a window.
	 * 
	 * @param card
	 *            The deck of cards to display.
	 */
	public static void run(PDeck deck, PHand hand) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setTitle("Hand Test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.setLocationByPlatform(true);
				frame.setContentPane(new HandTest(deck, hand));
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

	// **********************************************************************
	// Private Data
	// (You do not need to know anything below this point!)
	// **********************************************************************
	private HandTest(PDeck deck, PHand hand) {
		this.getFontMetrics(CARD_FONT); // This is a hack to fix a Java font bug
		this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.deck = deck;
		this.hand = hand;
		for (int i = 0; i < 4; i++)
			do {
				if (this.hand.getSize() > i)
					this.deck.addCard(this.hand.removeCard(i));
				deck.shuffle();
				this.hand.addCard(this.deck.dealCard());
			} while (this.hand.getValue() != 11 + i);
		for (int i = 4; i < 6; i++)
			do {
				if (this.hand.getSize() > i)
					this.deck.addCard(this.hand.removeCard(i));
				deck.shuffle();
				this.hand.addCard(this.deck.dealCard());
			} while (this.hand.getValue() != 14 + (i - 3) * 2);
		do {
			if (this.hand.getSize() > 6)
				this.deck.addCard(this.hand.removeCard(6));
			deck.shuffle();
			this.hand.addCard(this.deck.dealCard());
		} while (this.hand.getValue() != 21);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < hand.getSize(); i++) {
			PCard card = hand.getCard(i);
			int x = CARD_WIDTH / 2 + CARD_WIDTH * i;
			int y = CARD_HEIGHT / 2;
			g2.setColor(card.getBorderColor());
			g2.fillRoundRect(x, y, CARD_WIDTH, CARD_HEIGHT, 16, 16);
			g2.setColor(card.getFaceColor());
			g2.fillRoundRect(x + 4, y + 4, CARD_WIDTH - 8, CARD_HEIGHT - 8, 12, 12);
			g2.setFont(CARD_FONT);
			g2.setColor(card.getFontColor());
			FontMetrics metrics = g2.getFontMetrics();
			String text = card.getText();
			Rectangle2D rect = metrics.getStringBounds(text, g2);
			g2.drawString(text, x + CARD_WIDTH / 2 - (int) rect.getWidth() / 2,
					y + CARD_HEIGHT / 2 + metrics.getHeight() / 2 - metrics.getDescent());
		}
		g2.setFont(CARD_FONT);
		g2.setColor(Color.GRAY);
		FontMetrics metrics = g2.getFontMetrics();
		g2.drawString(String.format("= %d", hand.getValue()), CARD_WIDTH / 2 + CARD_WIDTH * hand.getSize() + 12,
				CARD_HEIGHT + metrics.getHeight() / 2 - metrics.getDescent());
	}

	private static final long serialVersionUID = 3514525153815595242L;
	private static final int CARD_WIDTH = 100;
	private static final int CARD_HEIGHT = 150;
	private static final int GAME_WIDTH = CARD_WIDTH * 9;
	private static final int GAME_HEIGHT = CARD_HEIGHT * 2;
	private static final Font CARD_FONT = new Font("SansSerif", Font.BOLD, 40);
	private final PDeck deck;
	private final PHand hand;
}
