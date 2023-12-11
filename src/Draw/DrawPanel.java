package Draw;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.*;
import java.util.List;

/**
 * Class used to create a DrawPanel where shapes will be drawn by the programmer (via code).
 * 
 * @author Jared N. Plumb
 * @version 1.0
 * @since 2019-11-26
 * @Minor modifications by Jeff Light
 * @since 2019-12-01
 */
public class DrawPanel extends JPanel {
	//Attributes
	@Serial
	private static final long serialVersionUID = 6311020027600344213L;
	
	//Landscape Colors
	private static final String LIGHT_SKY_BLUE = "87CEFA";
	private static final String MIDNIGHT_BLUE = "191970";
	private static final String SNOW3 = "CDC9C8";
	private static final String WHITE = "FFFFFF";
	private static final String MY_WHITE_SMOKE = "F5F5F5";
	private static final String LAWN_GREEN = "7CFC00";
	private static final String MEDIUM_SPRING_GREEN = "00FA9A";
	private static final String SPRING_GREEN = "00FF7F";

	//Tree Colors
	private final static String BROWN = "A52A2A";
	private final static String DARK_GREEN = "006400";
	private final static String FOREST_GREEN = "228B22";
	private final static String GRAY = "808080";
	private final static String GREEN = "008000";
	
	//House Colors
	private final static String DARK_SLATE_GRAY = "2F4F4F";
	private final static String FIREBRICK = "B22222";
	private final static String INDIAN_RED = "CD5C5C";
	private final static String MAROON = "800000";
	private final static String MOCCASIN = "FFE4B5";
	private final static String RED = "FF0000";
	private final static String SADDLE_BROWN = "8B4513";
	private final static String SIENNA = "A0522D";
	private final static String SLATE_GRAY = "708090";
	private final static String PERU = "CD853F";
	private final static String WHITE_SMOKE = "F5F5F5";
	private final static String BURLYWOOD = "DEB887";

	// Flower Colors

	private static final Color LIGHT_YELLOW = new Color(246, 219, 70);

	private static final Color LIGHT_PINK = new Color(246, 158, 202);

	private static final Color LIGHT_GREEN = new Color(191, 229, 40);

	public DrawPanel() {
		this.setPreferredSize(new Dimension(1280, 700));	//Sets the dimensions of the DrawPanel.  Change this if your screen doesn't support this size.
		this.setOpaque(true);
		this.setBackground(Color.WHITE);			//Sets the background of the DrawPanel LIGHT_GRAY.  You may change this if desired.
	}
	/**
	 * Overrides the JComponent.paintComponent method.
	 * EVERYTHING that gets drawn to the Component (which sits on the content frame of the JFrame) is drawn in this method.
	 * Draw12b
	 * Draw all your objects here.
	 * Automatically called by the event handler whenever the screen needs to be redrawn.
	 * DO NOT CALL THIS METHOD MANUALLY
	 * 
	 * @param	g	//All drawing in Java must go through a Graphics object
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;			//Allows us to draw using both the Graphics class methods and the Graphics2D class methods
		Random r = new Random();


		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	//Makes drawn shapes and fonts clearer

		//DrawTree landscape
		g2.setColor(Color.decode("#" + MIDNIGHT_BLUE));
		g2.fillRect(0,0,this.getWidth(),this.getHeight());
		
		g2.setColor(Color.decode("#" + LAWN_GREEN));
		g2.fillOval((-600), 350, this.getWidth() + 1200, 700);

		List<LandscapeObject> landscapeObjects = new ArrayList<>();

		//DrawTree Trees
		Tree t1 = new Tree(g2, 50, 400, 1, 3, BROWN , DARK_GREEN);
		t1.draw();
		
		Tree t2 = new Tree(g2, 200, 375, 1, 5, BROWN , GRAY);
		t2.draw();

		Tree t3 = new Tree(g2, 300, 450, 1, 4, BROWN , FOREST_GREEN);
		t3.draw();

		Collections.addAll(landscapeObjects, t1, t2, t3);


		int yBase = 370;
		for(int i = 20; i >= 0; i--){
			int xCorTree = r.nextInt(700) + 400;
			int yCorTree = r.nextInt(20) + yBase;
			int xCorFlower = r.nextInt(1300) + 10;
			int yCorFlower = r.nextInt(20) + yBase + 20;
			int xCorStar = r.nextInt(1300) + 10;
			int yCorStar = r.nextInt(310) + 30;
			int xCorDogeCoin = r.nextInt(1300) + 10;
			int yCorDogeCoin = r.nextInt(20) + yBase;
			int treeScale = r.nextInt(3) + 1;
			int flowerScale = r.nextInt(4) + 1;
			int starScale = r.nextInt(3) + 1;
			int dogeCoinScale = r.nextInt(3) + 1;
			int level = r.nextInt(4) + 3;
			int petal = r.nextInt(13) + 4;
			int point = r.nextInt(3) + 4;
			int trunkColorIndex = r.nextInt(4);
			int branchColorIndex = r.nextInt(13);
			int petalColorIndex = r.nextInt(4);
			int leafColorIndex = r.nextInt(4);
			int pedicelColorIndex = r.nextInt(4);
			int starColorIndex = r.nextInt(4);
			int denominationIndex = r.nextInt(4);
			boolean isBill = r.nextBoolean();

			String BranchColor = switch (branchColorIndex) {
				case 0 -> DARK_SLATE_GRAY;
				case 1 -> FIREBRICK;
				case 2 -> INDIAN_RED;
				case 3 -> MAROON;
				case 4 -> MOCCASIN;
				case 5 -> RED;
				case 6 -> SADDLE_BROWN;
				case 7 -> SIENNA;
				case 8 -> SLATE_GRAY;
				case 9 -> PERU;
				case 10 -> WHITE_SMOKE;
				case 11 -> BURLYWOOD;
				default -> GREEN;
			};

			String trunkColor = switch (trunkColorIndex) {
				case 0 -> SADDLE_BROWN;
				case 1 -> SIENNA;
				case 2 -> BURLYWOOD;
				default -> BROWN;
			};

			Color petalColor = switch (petalColorIndex){
				case 0 -> LIGHT_GREEN;
				case 1 -> LIGHT_PINK;
				case 2 -> LIGHT_YELLOW;
				default -> Color.PINK;
			};

			Color leafColor = switch (leafColorIndex) {
				case 0 -> new Color(96, 124, 54);
				case 1 -> new Color(150, 213, 55);
				case 2 -> new Color(96, 107, 80);
				default -> new Color(60, 98, 2);
			};

			Color pedicelColor = switch (pedicelColorIndex) {
				case 0 -> new Color(246, 176, 106);
				case 1 -> new Color(252, 212, 185);
				case 2 -> new Color(243, 193, 135);
				default -> new Color(246, 167, 134);
			};

			Color starColor = switch (starColorIndex) {
				case 0 -> new Color(248, 228, 9);
				case 1 -> new Color(255, 251, 230);
				case 2 -> new Color(228, 248, 250);
				default -> new Color(255, 239, 39);
			};

			String denomination = switch (denominationIndex){
				case 0 -> "100";
				case 1 -> "200";
				case 2 -> "500";
				default -> "1000";
			};

			landscapeObjects.add(new Tree(g2, xCorTree, yCorTree, treeScale, level, trunkColor, BranchColor));

			landscapeObjects.add(new Flower(g2, xCorFlower, yCorFlower, flowerScale, petal, petalColor, leafColor, pedicelColor));

			landscapeObjects.add(new Star(g2, xCorStar, yCorStar, starScale, point, starColor));

			landscapeObjects.add(new DogeCoin(g2, xCorDogeCoin, yCorDogeCoin, dogeCoinScale, isBill, denomination));

			yBase += 13;
		}

		landscapeObjects.add(new CyberTruck(g2, 50, 370, 1));

		landscapeObjects.sort(Comparator.comparingInt(landscapeObject -> landscapeObject.currentY));

		for(LandscapeObject landscapeObject : landscapeObjects) {
			landscapeObject.draw();
		}




	}//end of method paintComponent(Graphics)

}//end of class DrawPanel