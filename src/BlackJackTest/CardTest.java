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

/**
 * A simple playing card test. This test displays the given card in a window
 * using Swing. The only method that needs to be called is <b>run</b>. The
 * remaining methods and variables can be ignored.
 * 
 * @author Jared N. Plumb
 * @version 1.2
 * @since 2018-06-12
 * @Minor modifications by Jeff Light
 * @since 2019-11-01
 */
public final class CardTest extends JPanel {

	/**
	 * Display a playing card in a window.
	 * 
	 * @param card
	 *            The card to display.
	 */
	public static void run(PCard card) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setTitle("Card Test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.setLocationByPlatform(true);
				frame.setContentPane(new CardTest(card));
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

	// **********************************************************************
	// Private Data
	// (You do not need to know anything below this point!)
	// **********************************************************************
	private CardTest(PCard card) {
		this.getFontMetrics(CARD_FONT); // This is a hack to fix a Java font bug
		this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.card = card;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(card.getBorderColor());
		g2.fillRoundRect(CARD_X, CARD_Y, CARD_WIDTH, CARD_HEIGHT, 16, 16);
		g2.setColor(card.getFaceColor());
		g2.fillRoundRect(CARD_X + 4, CARD_Y + 4, CARD_WIDTH - 8, CARD_HEIGHT - 8, 12, 12);
		g2.setFont(CARD_FONT);
		g2.setColor(card.getFontColor());
		FontMetrics metrics = g2.getFontMetrics();
		String text = card.getText();
		Rectangle2D rect = metrics.getStringBounds(text, g2);
		g2.drawString(text, CARD_X + CARD_WIDTH / 2 - (int) rect.getWidth() / 2,
				CARD_Y + CARD_HEIGHT / 2 + metrics.getHeight() / 2 - metrics.getDescent());
	}

	private static final long serialVersionUID = 447779152059287596L;
	private static final int GAME_WIDTH = 150;
	private static final int GAME_HEIGHT = 200;
	private static final int CARD_WIDTH = 100;
	private static final int CARD_HEIGHT = 150;
	private static final int CARD_X = (GAME_WIDTH - CARD_WIDTH) / 2;
	private static final int CARD_Y = (GAME_HEIGHT - CARD_HEIGHT) / 2;
	private static final Font CARD_FONT = new Font("SansSerif", Font.BOLD, 40);
	private final PCard card;
}
