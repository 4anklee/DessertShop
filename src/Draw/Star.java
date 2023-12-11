package Draw;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Star extends LandscapeObject{

    private final int point;
    private final Color starColor;
    private int starRadius = 4;
    private final Stroke stroke = new BasicStroke(1);

    public Star(Graphics2D g2, int x, int y, double scale, int point, Color starColor) {
        super(g2, x, y, scale);
        this.point = point;
        this.starColor = starColor;
    }

    @Override
    public void draw() {
        applyScale();
        drawStarlight();
        drawStar();
    }

    private void drawStarlight() {
        GeneralPath path = new GeneralPath();
        double angle = 2 * Math.PI / point;

        path.moveTo(getStartX() + starRadius * Math.cos(0),
                getStartY() + starRadius * Math.sin(0));
        for (int i = 1; i <= point; i++) {
            double x = getStartX() + starRadius * Math.cos(i * angle);
            double y = getStartY() + starRadius * Math.sin(i * angle);
            path.quadTo(getStartX(), getStartY(), x, y);
        }
        path.closePath();

        g2.setColor(starColor);
        g2.setStroke(stroke);
        g2.draw(path);
        g2.fill(path);
    }

    public void drawStar(){
        g2.setColor(new Color(248, 241, 197));
        g2.fillOval(getStartX() - starRadius / 2, getStartY() - starRadius / 2, starRadius, starRadius);
    }


    @Override
    public void applyScale() {
        this.starRadius *= (int) this.getScale();
    }
}
