package Draw12a;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.Serial;

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

	public DrawPanel() {
		this.setPreferredSize(new Dimension(1600, 900));	//Sets the dimensions of the DrawPanel.  Change this if your screen doesn't support this size.
		this.setOpaque(true);
		this.setBackground(Color.WHITE);			//Sets the background of the DrawPanel LIGHT_GRAY.  You may change this if desired.
	}
	
	
	/**
	 * Overrides the JComponent.paintComponent method.
	 * EVERYTHING that gets drawn to the Component (which sits on the content frame of the JFrame) is drawn in this method.
	 * Draw12a
	 * Draw all your objects in the paintComponent method.
	 * Automatically called by the event handler whenever the screen needs to be redrawn.
	 * DO NOT CALL THIS METHOD MANUALLY
	 * 
	 * @param	g	//All drawing in Java must go through a Graphics object
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;			//Allows us to draw using both the Graphics class methods and the Graphics2D class methods

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	//Makes drawn shapes and fonts clearer

		//Heptagon
		g2.setColor(new Color(241, 205, 205));
		g2.setStroke(new BasicStroke(3));
		var emptyHeptagon = regPolygon(100, 100, 50, 7);
		g2.draw(emptyHeptagon);

		var heptagon = regPolygon(250, 100, 50, 7);
		g2.rotate(90, 250, 100);
		g2.fill(heptagon);
		g2.draw(heptagon);
		g2.rotate(-90, 250, 100);

		//Triangles
		g2.setColor(new Color(243, 193, 135));
		g2.setStroke(new BasicStroke(3));
		var EmptyTriangle = regPolygon(400, 100, 50, 3);
		g2.draw(EmptyTriangle);

		var Triangle = regPolygon(600, 100, 50, 3);
		g2.rotate(90, 600, 100);
		g2.fill(Triangle);
		g2.draw(Triangle);
		g2.rotate(-90, 600, 100);

		//Circles
		g2.setColor(new Color(255, 239, 140));
		g2.setStroke(new BasicStroke(2));
		var emptyCircle = new Ellipse2D.Double(800, 50, 100, 100);
		g2.draw(emptyCircle);

		var circle = new Ellipse2D.Double(1000, 50, 100, 100);
		g2.rotate(90, circle.getCenterX(), circle.getCenterY());
		g2.fill(circle);
		g2.draw(circle);
		g2.rotate(-90, circle.getCenterX(), circle.getCenterY());

		//Ovals
		g2.setColor(new Color(228, 248, 146));
		g2.setStroke(new BasicStroke(3));
		var emptyOval = new Ellipse2D.Double(100, 300, 50, 100);
		g2.draw(emptyOval);

		var oval = new Ellipse2D.Double(250, 300, 50, 100);
		g2.rotate(90, oval.getCenterX(), oval.getCenterY());
		g2.fill(oval);
		g2.draw(oval);
		g2.rotate(-90, oval.getCenterX(), oval.getCenterY());

		//Pentagons
		g2.setColor(new Color(167, 233, 245));
		g2.setStroke(new BasicStroke(3));
		var EmptyRegPentagon = regPolygon(500, 500, 100, 5);
		g2.draw(EmptyRegPentagon);

		var regPentagon = regPolygon(750, 500, 100, 5);
		g2.rotate(90, 750, 500);
		g2.fill(regPentagon);
		g2.draw(regPentagon);
		g2.rotate(-90, 750, 500);

		//Octagons
		g2.setColor(new Color(229, 173, 252));
		g2.setStroke(new BasicStroke(3));
		var EmptyRegOctagon = regPolygon(800, 300, 50, 8);
		g2.draw(EmptyRegOctagon);

		var RegOctagon = regPolygon(950, 300, 50, 8);
		g2.rotate(90, 950, 300);
		g2.fill(RegOctagon);
		g2.draw(RegOctagon);
		g2.rotate(-90, 950, 300);

		/*
		 * Use this section to write your code.
		 * DrawShapes
		 * Draw at least 6 shapes in BOTH draw and fill formats using methods found in the Graphics class and/or the Graphics2D class.
		 * In other words, if you draw an empty rectangle, you should also draw a filled rectangle.  That counts as one (1) shape.
		 * The empty and filled versions of the shape should be at different orientations.
		 * One of the shapes MUST be a triangle.
		 * Each shape should be a different color.  An empty and a filled rectangle may be the same color, but they must be a different color from an empty and filled triangle.
		 * At least one of the colors should NOT be a standard color from the COLOR palette.
		 * Each empty shape should have a different stroke size.
		 * Be sure all shapes are located such that they can all be seen.
		 */
	}//end of method paintComponent(Graphics)


	public Polygon regPolygon(int xCenter, int yCenter, int radius, int sides) {
		int[] xPoints = new int[sides];
		int[] yPoints = new int[sides];

		for (int i = 0; i < sides; i++) {
			xPoints[i] = (int) (xCenter + radius * Math.cos(2 * Math.PI * i / sides));
			yPoints[i] = (int) (yCenter + radius * Math.sin(2 * Math.PI * i / sides));
		}

        return new Polygon(xPoints, yPoints, sides);
	}
}//end of class DrawPanel