package Draw;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Flower extends LandscapeObject{
    private final int petals;
    private final Color pistilColor;
    private final Color flowerColor;
    private final Color leafColor;
    private static int pistilsHeight = 20;
    private static int petalLength = 7;
    private static int leafLength = 10;
    private final BasicStroke stroke = new BasicStroke(1);


    public Flower(Graphics2D g2, int x, int y, double scale, int petals, Color pistilColor, Color flowerColor, Color leafColor){
        super(g2, x, y, scale);
        this.petals = petals;
        this.pistilColor = pistilColor;
        this.flowerColor = flowerColor;
        this.leafColor = leafColor;
    }
    @Override
    public void draw() {
        applyScale();
        drawPedicel();
        drawLeaf();
        drawFlower();
    }

    private void drawLeaf() {
        var path = new GeneralPath();
        g2.setColor(Color.PINK);
        path.moveTo(getStartX(), getStartY());
        path.quadTo(getStartX() - leafLength, getStartY(), getStartX() - leafLength, getStartY() - leafLength);
        path.quadTo(getStartX(), getStartY() - leafLength, getStartX(), getStartY());
        path.quadTo(getStartX() + leafLength, getStartY(), getStartX() + leafLength, getStartY() - leafLength);
        path.quadTo(getStartX(), getStartY() -leafLength, getStartX(), getStartY());
        g2.fill(path);
    }

    private void drawFlower() {
        int flowerCenterX = getStartX();
        int flowerCenterY = getStartY() - pistilsHeight;
        var path = new GeneralPath();
        for (int i = 0; i < petals; i++) {
            double StartAngle =  2 * Math.PI * i / petals - 2 * Math.PI / (petals * 2);
            double finalAngle = 2 * Math.PI * i / petals + 2 * Math.PI / (petals * 2);
            double angle = 2 * Math.PI * i / petals;

            g2.setColor(new Color(26, 218, 183));

            path.moveTo(flowerCenterX, flowerCenterY);
            path.lineTo((int) (Math.round(flowerCenterX + petalLength * Math.cos(StartAngle))),
                    (int) (Math.round(flowerCenterY + petalLength * Math.sin(StartAngle))));
            path.quadTo((int) Math.round(flowerCenterX + 2 * petalLength * Math.cos(angle)),
                    (int) Math.round(flowerCenterY + 2 * petalLength * Math.sin(angle)),
                    (int) (Math.round(flowerCenterX + petalLength * Math.cos(finalAngle))),
                    (int) (Math.round(flowerCenterY + petalLength * Math.sin(finalAngle))));
            path.closePath();

            g2.draw(path);
        }

    }

    private void drawPedicel() {
        g2.setColor(Color.BLACK);
        g2.setStroke(stroke);
        g2.drawLine(this.getStartX(), this.getStartY(), this.getStartX(), this.getStartX() - pistilsHeight);
    }

    @Override
    public void applyScale() {
        pistilsHeight *= (int) getScale();
        petalLength *= (int) getScale();
        leafLength *= (int) getScale();
    }
}
