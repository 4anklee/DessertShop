package Draw12a;

import javax.swing.*;
import java.awt.*;

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

}//end of class DrawPanel