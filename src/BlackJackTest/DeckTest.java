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

/**
 * A simple playing card deck test. This test will create a window and display
 * the full contents of the playing card deck.
 * 
 * @author Jared N. Plumb
 * @version 1.2
 * @since 2018-06-12
 * @Minor modifications by Jeff Light
 * @since 2019-11-09
 */
public class DeckTest extends JPanel {

	/**
	 * Display a deck of cards in a window.
	 * 
	 * @param deck
	 *            The deck of cards to display.
	 */
	public static void run(PDeck deck) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setTitle("Deck Test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.setLocationByPlatform(true);
				frame.setContentPane(new DeckTest(deck));
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

	// **********************************************************************
	// Private Data
	// (You do not need to know anything below this point!)
	// **********************************************************************
	private DeckTest(PDeck deck) {
		this.getFontMetrics(CARD_FONT); // This is a hack to fix a Java font bug
		this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.cards = new PCard[deck.cardCount()];
		while (deck.cardCount() > 0)
			this.cards[deck.cardCount() - 1] = deck.dealCard();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int row = this.cards.length / 4;
		for (int i = 0; i < this.cards.length; i++) {
			PCard card = this.cards[i];
			int x = CARD_WIDTH * (i % row);
			int y = CARD_HEIGHT * (i / row);
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
	}

	private static final long serialVersionUID = 447779152059287596L;
	private static final int CARD_WIDTH = 100;
	private static final int CARD_HEIGHT = 150;
	private static final int GAME_WIDTH = CARD_WIDTH * 14;
	private static final int GAME_HEIGHT = CARD_HEIGHT * 4;
	private static final Font CARD_FONT = new Font("SansSerif", Font.BOLD, 40);
	private PCard[] cards;
}
