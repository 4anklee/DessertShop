package Draw;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CyberTruck extends LandscapeObject {
    private int height;
    private BufferedImage image;
    private int width;


    public CyberTruck(Graphics2D g2, int x, int y, double scale) {
        super(g2, x, y, scale);

        try {
            image = ImageIO.read(new File("/Users/Frank/Documents/GitHub/fall2023/out/production/fall2023/Draw/img/cyberTruck.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        width = image.getWidth();
        height = image.getHeight();
        this.currentY = (int) (this.getStartY() + (height / 8 * getScale()));
    }

    public void draw() {
        applyScale();
        if (image != null) {
            g2.drawImage(image, this.currentX, this.getStartY(), width, height, null);
        }
    }

    @Override
    public void applyScale() {
        this.width = (int) (width * getScale() / 7);
        this.height = (int) (height * getScale() / 7);
    }
}
