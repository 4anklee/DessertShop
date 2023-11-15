package BlackJackBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

/**
 * Base interface used to manage a collection of cards.
 * 
 * @author Jared N. Plumb
 * @version 1.0
 * @since 2018-07-09
 * @Minor modifications by Jeff Light
 * @since 2019-11-16
 */
public final class PGame extends JPanel {

	/** Sets the background color for the window */
	public static void setBackgroundColor(Color color) {
		BACKGROUND_COLOR = color;
	}

	/** Sets the background color of the banners */
	public static void setBannerColor(Color color) {
		BANNER_COLOR = color;
	}

	/** Sets the color of the banner text */
	public static void setBannerTextColor(Color color) {
		BANNER_TEXT_COLOR = color;
	}

	/** Sets the color of the status text */
	public static void setStatusTextColor(Color color) {
		STATUS_TEXT_COLOR = color;
	}

	/** Sets the background color of the buttons */
	public static void setButtonColor(Color color) {
		BUTTON_COLOR = color;
	}

	/** Sets the selected color of the buttons */
	public static void setButtonHighlightColor(Color color) {
		BUTTON_HIGHLIGHT = color;
	}

	/** Sets the button text color */
	public static void setButtonTextColor(Color color) {
		BUTTON_TEXT_COLOR = color;
	}

	/** Sets the font used throughout the game */
	public static void setFont(String name) {
		GAME_FONT = name;
	}

	/**
	 * Run the game using a deck, a hand for the dealer, and a hand for the player
	 */
	public static void run(PDeck deck, PHand dealer, PHand player) {
		final PGame game = new PGame(deck, dealer, player);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setTitle("Game");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.setLocationByPlatform(true);
				frame.add(game);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

	// **********************************************************************
	// Private Data
	// (You do not need to know anything below this point!)
	// **********************************************************************
	private static final long serialVersionUID = -6901243923241700564L;
	private static final int GAME_WIDTH = 640;
	private static final int GAME_HEIGHT = 480;
	private static final int CARD_WIDTH = 100;
	private static final int CARD_HEIGHT = 150;
	private static final int CARD_SPACING = 8;
	private static Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
	private static Color BANNER_COLOR = Color.DARK_GRAY;
	private static Color BANNER_TEXT_COLOR = Color.GREEN;
	private static Color STATUS_TEXT_COLOR = Color.GREEN;
	private static Color BUTTON_COLOR = Color.BLUE;
	private static Color BUTTON_HIGHLIGHT = Color.CYAN;
	private static Color BUTTON_TEXT_COLOR = Color.GREEN;
	private static String GAME_FONT = "SansSerif";
	private PDeck deck;
	private PHand dealer;
	private PHand player;
	private Status status;
	private Button hitButton;
	private Button standButton;;
	private Button restartButton;

	private PGame(PDeck deck, PHand dealer, PHand player) {
		this.deck = deck;
		this.dealer = dealer;
		this.player = player;
		this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		this.setOpaque(true);
		this.setBackground(BACKGROUND_COLOR);
		this.add(new Banner("Dealer"));
		this.add(new PlayArea(dealer));
		this.add(new Banner("Player"));
		this.add(new PlayArea(player));
		this.status = new Status();
		this.hitButton = new HitButton();
		this.standButton = new StandButton();
		this.restartButton = new RestartButton();
		this.add(status);
		this.add(hitButton);
		this.add(standButton);
		this.add(restartButton);
		newGame();
	}

	private void newGame() {
		this.deck.shuffle();
		this.dealer.addCard(deck.dealHiddenCard());
		this.player.addCard(deck.dealCard());
		this.dealer.addCard(deck.dealCard());
		this.player.addCard(deck.dealCard());
		paintGame();
		checkGame();
	}

	private void checkGame() {
		if (dealer.getValue() >= 21 || player.getValue() >= 21)
			finishGame();
	}

	private void dealCard() {
		player.addCard(deck.dealCard());
		checkGame();
		paintGame();
	}

	private void finishGame() {

		if (dealer.getSize() > 0)
			dealer.getCard(0).showCard();

		while (dealer.getValue() <= 17)
			dealer.addCard(deck.dealCard());

		if (dealer.getSize() == 2 && dealer.getValue() == 21)
			status.setText("Dealer Blackjack!  You Lose!");
		else if (player.getSize() == 2 && player.getValue() == 21)
			status.setText("Player Blackjack!  You Win!");
		else if (dealer.getValue() > 21 && player.getValue() > 21)
			status.setText("Dealer Bust!  Player Bust!  You Lose!");
		else if (dealer.getValue() <= 21 && player.getValue() > 21)
			status.setText("Player Bust!  You Lose!");
		else if (dealer.getValue() > 21 && player.getValue() <= 21)
			status.setText("Dealer Bust!  You Win!");
		else if (dealer.getValue() < player.getValue())
			status.setText("You Win!");
		else if (dealer.getValue() > player.getValue())
			status.setText("You Lose!");
		else if (dealer.getValue() == player.getValue())
			status.setText("Tie!  You Lose!");
		else
			status.setText("ERROR: Unhandled Conclusion");

		hitButton.setVisible(false);
		standButton.setVisible(false);
		restartButton.setVisible(true);

		paintGame();
	}

	private void restartGame() {

		while (dealer.getSize() > 0)
			deck.addCard(dealer.removeCard(0));

		while (player.getSize() > 0)
			deck.addCard(player.removeCard(0));

		status.setText(null);
		hitButton.setVisible(true);
		standButton.setVisible(true);
		restartButton.setVisible(false);

		newGame();
	}

	private void paintGame() {
		this.repaint();
	}

	private class Banner extends JPanel {
		private static final long serialVersionUID = -8125170738840399404L;
		private final Font FONT = new Font(GAME_FONT, Font.BOLD, 16);
		private String text;

		private Banner(String text) {
			this.getFontMetrics(FONT); // This is a hack to fix a Java font bug
			this.text = text;
			this.setPreferredSize(new Dimension(600, 30));
			this.setOpaque(false);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(BANNER_COLOR);
			g2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 16, 16);
			g2.setFont(FONT);
			g2.setColor(BANNER_TEXT_COLOR);
			FontMetrics metrics = g2.getFontMetrics();
			g2.drawString(text, 10, this.getHeight() / 2 + metrics.getHeight() / 2 - metrics.getDescent());
		}
	}

	private class Status extends JPanel {
		private static final long serialVersionUID = 8869322120214666782L;
		private final Font FONT = new Font(GAME_FONT, Font.BOLD, 20);
		private String text;

		private Status() {
			this.setPreferredSize(new Dimension(600, 34));
			this.setOpaque(false);
		}

		private void setText(String text) {
			this.text = text;
			paintGame();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (text != null) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setFont(FONT);
				g2.setColor(STATUS_TEXT_COLOR);
				FontMetrics metrics = g2.getFontMetrics();
				Rectangle2D rect = metrics.getStringBounds(text, g2);
				g2.drawString(text, this.getWidth() / 2 - (int) rect.getWidth() / 2,
						this.getHeight() / 2 + metrics.getHeight() / 2 - metrics.getDescent());
			}
		}
	}

	private class PlayArea extends JPanel {
		private static final long serialVersionUID = -2576568959049193937L;
		private final Font FONT = new Font(GAME_FONT, Font.BOLD, 40);
		private PHand hand;

		private PlayArea(PHand hand) {
			this.hand = hand;
			this.setPreferredSize(new Dimension(600, 155));
			this.setOpaque(false);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			int spacing = CARD_SPACING;
			if (hand.getSize() > 5)
				spacing = 600 / hand.getSize() - CARD_WIDTH - (hand.getSize() - 5);

			for (int i = 0; i < hand.getSize(); i++) {

				PCard card = hand.getCard(i);
				if (card == null)
					continue;

				g2.setColor(card.getBorderColor());
				g2.fillRoundRect(i * (CARD_WIDTH + spacing), 0, CARD_WIDTH, CARD_HEIGHT, 16, 16);

				g2.setColor(card.getFaceColor());
				g2.fillRoundRect(i * (CARD_WIDTH + spacing) + 4, 4, CARD_WIDTH - 8, CARD_HEIGHT - 8, 12, 12);

				int x = i * (CARD_WIDTH + spacing);

				if (card.isHidden()) {
					for (int s = 0; s < 11; s++) {
						g2.setColor(s % 2 == 0 ? card.getStripeColor() : card.getBackColor());
						g2.fillRect(x + 8 + 4 * s, 8 + 4 * s, CARD_WIDTH - 16 - 8 * s, CARD_HEIGHT - 16 - 8 * s);
					}
				} else {
					g2.setFont(FONT);
					g2.setColor(card.getFontColor());
					FontMetrics metrics = g2.getFontMetrics();
					String text = card.getText();
					Rectangle2D rect = metrics.getStringBounds(text, g2);
					g2.drawString(text, x + CARD_WIDTH / 2 - (int) rect.getWidth() / 2,
							CARD_HEIGHT / 2 + metrics.getHeight() / 2 - metrics.getDescent());
				}

			}
		}
	}

	private class Button extends JPanel implements MouseListener {
		private static final long serialVersionUID = 2562514311212476569L;
		private final Font FONT = new Font(GAME_FONT, Font.BOLD, 16);
		private String text;
		private boolean down;

		public Button(String text) {
			this.text = text;
			this.down = false;
			this.setPreferredSize(new Dimension(100, 30));
			this.setOpaque(false);
			this.addMouseListener(this);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(down ? BUTTON_HIGHLIGHT : BUTTON_COLOR);
			g2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 16, 16);

			g2.setFont(FONT);
			g2.setColor(BUTTON_TEXT_COLOR);

			FontMetrics metrics = g2.getFontMetrics();
			Rectangle2D rect = metrics.getStringBounds(text, g2);
			g2.drawString(text, this.getWidth() / 2 - (int) rect.getWidth() / 2,
					this.getHeight() / 2 + metrics.getHeight() / 2 - metrics.getDescent());
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			down = true;
			this.repaint();

		}

		public void mouseReleased(MouseEvent e) {
			down = false;
			this.repaint();
		}
	}

	private class HitButton extends Button {
		private static final long serialVersionUID = 8142888208655021092L;

		public HitButton() {
			super("Hit");

		}

		public void mouseClicked(MouseEvent e) {
			dealCard();
		}
	}

	private class StandButton extends Button {
		private static final long serialVersionUID = 4290860168347972255L;

		public StandButton() {
			super("Stand");
		}

		public void mouseClicked(MouseEvent e) {
			finishGame();
		}
	}

	private class RestartButton extends Button {
		private static final long serialVersionUID = 6468817203841566611L;

		public RestartButton() {
			super("Restart");
			this.setVisible(false);
		}

		public void mouseClicked(MouseEvent e) {
			restartGame();
		}
	}

}
