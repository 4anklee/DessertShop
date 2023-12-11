package Draw;

import java.awt.*;

/**
 * Tree Class.  Extends LandscapeObject Class.
 * Note this class inherits 3 protected attributes from LandscapeObject for convenience in coding methods.
 * protected int currentX
 * protected int currentY
 * protected Graphics2D
 * <p>
 * When creating a Tree object in the DrawPanel.paintComponent(Graphics) method, usually the following syntax is used.
 * <p>
 * Tree t1 = new Tree(args);
 * t1.draw();
 * 
 * @author Jeffrey L Light
 * @version 1.0
 * @since 2019-11-26
 */
public class Tree extends LandscapeObject{
	//Attributes
	private final int levels;						//The number of levels (branch triangles) the tree will have.
	private final String trunkColor; 				// The Hex color of the trunk, including the preceding '#'. Set in the constructor.
	private final String branchColor; 			// The Hex color of the branches, including the preceding '#'. Set in the constructor.
	private int trunkWidth = 10;			//The trunk width in pixels.  Default of 10 for a scale of 1.  Modified by applyScale method().
	private int trunkHeight = 15;			//The trunk height in pixels.  Default of 15 for a scale of 1.  Modified by applyScale method().
	private int branchWidth = 30;			//The branch width in pixels.  Default of 30 for a scale of 1.  Modified by applyScale method().
	private int branchHeight = 30;			//The branch height in pixels.  Default of 30 for a scale of 1.  Modified by applyScale method().
	private double branchOverlap = 0.45;		//Indicates how much of each triangle is overlapped by the one above it.
	private final BasicStroke treeStroke = new BasicStroke(1);	//Stroke of 1 pixel use to outline each shape of the tree.

	/**
	 * Primary Constructor.
	 * Sets all class attributes.
	 * 
	 * @param	g2				The Graphics2D interface.
	 * @param	x				int.  The startX coordinate.  currentX is also set to x upon object creation.
	 * @param	y				int.  The startY coordinate.  currentX is also set to y upon object creation.
	 * @param	levels			int indicating how many levels (branch triangles) the tree will have.
	 * @param	scale			double.  Scale multiplier for the object.
	 * @param	s_trunkColor	A String representing the Hex code for the color used for the trunk of the tree.
	 * @param	s_branchColor	A String representing the Hex code for the color used for the branches of the tree.
	 *
     */
	public Tree(Graphics2D g2, int x, int y, double scale, int levels,  String s_trunkColor, String s_branchColor) {
		super(g2, x, y, scale);
		this.levels = levels;
		this.trunkColor = "#" + s_trunkColor;
		this.branchColor = "#" + s_branchColor;
		this.currentY = (int) (y + trunkHeight * scale);
	}//end of Constructor Tree
	
	
	//Methods
	/**
	 * draw()
	 * Calls applyScale to apply the scale multiplier to all shape dimensions for the object.
	 * Calls drawTrunk to draw the trunk of the tree.
	 * Calls drawBranches to draw the branches of the tree.
	 *
     */
	public void draw() {
		applyScale();
		drawTrunk();
		drawBranches();
	}//end of method draw()
	
	/**
	 * applyScale
	 * Applies the scale multiplier to all shape dimensions for the object.
	 * Called by draw()
	 *
     */
	public void applyScale() {
		this.trunkHeight = (int) (this.getScale() * this.trunkHeight);
		this.trunkWidth = (int) (this.getScale() * this.trunkWidth);
        this.branchHeight = (int) (this.getScale() * this.branchHeight);
		this.branchWidth = (int) (this.getScale() * this.branchWidth);
		this.branchOverlap = this.getScale() * this.branchOverlap;
	}//end of method applyScale()
	/**
	 * drawTrunk()
	 * Draws a rectangle for the trunk of the tree.
	 * Called by draw()
	 *
     */
	private void drawTrunk() {
		g2.setColor(Color.decode(trunkColor));
		g2.setStroke(treeStroke);
		var truck = new Rectangle(this.getStartX() - this.trunkWidth / 2, this.getStartY(), this.trunkWidth, this.trunkHeight);
		g2.fill(truck);
		g2.draw(truck);
		g2.setColor(Color.BLACK);
		g2.draw(truck);
	}//end of method drawTrunk()
	/**
	 * drawBranches()
	 * Draws 'level' number of triangles above the trunk overlapped by 'branchOverlap'.
	 * Called by draw()
	 *
     */
	private void drawBranches() {
		int baseY = this.getStartY();
		int halfBranchWidth = this.branchWidth / 2;

		for (int i = 0; i < levels; i++) {
			int topY = baseY - branchHeight;
			var branch = new Polygon(
					new int[]{this.getStartX() - halfBranchWidth, this.getStartX() + halfBranchWidth, this.getStartX()},
					new int[]{(int) (baseY + branchOverlap), (int) (baseY + branchOverlap), topY},
					3
			);

			g2.setColor(Color.decode(branchColor));
			g2.fill(branch);
			g2.setStroke(treeStroke);
			g2.draw(branch);

			g2.setColor(Color.BLACK);
			g2.draw(branch);

			baseY -= (int) (branchHeight - branchOverlap * 35);
		}
	}
}//end of class Tree
