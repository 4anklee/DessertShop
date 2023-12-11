package Draw;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class Flower extends LandscapeObject{
    private final int petals;
    private final Color petalColor;
    private final Color leafColor;
    private final Color pedicelColor;
    private  int pedicelDiameter = 2;
    private  double pistilHeight = 4;
    private  double petalLength = 2.2;
    private  double leafLength = 2.5;
    private final BasicStroke stroke = new BasicStroke(1);


    public Flower(Graphics2D g2, int x, int y, double scale, int petals, Color petalColor, Color leafColor, Color pedicelColor){
        super(g2, x, y, scale);
        this.petals = petals;
        this.petalColor = petalColor;
        this.leafColor = leafColor;
        this.pedicelColor = pedicelColor;
    }
    @Override
    public void draw() {
        applyScale();
        drawPistil();
        drawFlower();
        drawLeaf();
    }

    private void drawLeaf() {
        var path = new GeneralPath();
        g2.setColor(leafColor);
        path.moveTo(getStartX(), getStartY());
        path.quadTo(getStartX() - leafLength, getStartY(), getStartX() - leafLength, getStartY() - leafLength);
        path.quadTo(getStartX(), getStartY() - leafLength, getStartX(), getStartY());
        path.quadTo(getStartX() + leafLength, getStartY(), getStartX() + leafLength, getStartY() - leafLength);
        path.quadTo(getStartX(), getStartY() -leafLength, getStartX(), getStartY());
        g2.fill(path);
        g2.setColor(Color.BLACK);
        g2.draw(path);
    }

    private void drawFlower() {
        int flowerCenterX = getStartX();
        int flowerCenterY = (int) (getStartY() - pistilHeight);
        var path = new GeneralPath();


        for (int i = 0; i < petals; i++) {
            double StartRadian =  2 * Math.PI * i / petals - 2 * Math.PI / (petals * 2);
            double finalRadian = 2 * Math.PI * i / petals + 2 * Math.PI / (petals * 2);
            double Radian = 2 * Math.PI * i / petals;

            g2.setColor(petalColor);

            path.moveTo(flowerCenterX, flowerCenterY);
            path.lineTo((int) (Math.round(flowerCenterX + petalLength * Math.cos(StartRadian))),
                    (int) (Math.round(flowerCenterY - petalLength * Math.sin(StartRadian))));
            path.quadTo((int) Math.round(flowerCenterX + 2 * petalLength * Math.cos(Radian)),
                    (int) Math.round(flowerCenterY - 2 * petalLength * Math.sin(Radian)),
                    (int) (Math.round(flowerCenterX + petalLength * Math.cos(finalRadian))),
                    (int) (Math.round(flowerCenterY - petalLength * Math.sin(finalRadian))));
            path.closePath();

            g2.fill(path);
            g2.setColor(Color.BLACK);
            g2.draw(path);
        }

        g2.setColor(pedicelColor);
        var pedicel = new Ellipse2D.Double(flowerCenterX - (double) (pedicelDiameter / 2), flowerCenterY - (double) (pedicelDiameter / 2), pedicelDiameter, pedicelDiameter);
        g2.fill(pedicel);
        g2.draw(pedicel);
        g2.setColor(Color.BLACK);
        g2.draw(pedicel);
    }

    private void drawPistil() {
        g2.setColor(Color.BLACK);
        g2.setStroke(stroke);
        g2.drawLine(this.getStartX(), this.getStartY(), this.getStartX(), (int) (this.getStartY() - pistilHeight));
    }

    @Override
    public void applyScale() {
        pedicelDiameter *= (int) (this.getScale() * pedicelDiameter);
        pistilHeight *= (int) (this.getScale() * pistilHeight);
        petalLength *= (int) (this.getScale() * petalLength);
        leafLength *= (int) (this.getScale() * leafLength);
    }
}
