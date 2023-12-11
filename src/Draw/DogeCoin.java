package Draw;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DogeCoin extends LandscapeObject {
    private int height;
    private BufferedImage image;
    private int width;
    private int billWidth = 40;
    private int billHeight = 23;
    private int coinDiameter =15;
    private final boolean isBill;
    private double strokeWidth = 1.4;
    private final BasicStroke stroke = new BasicStroke((int) strokeWidth);
    private double fontSize = 2;
    private final String denomination;


    public DogeCoin(Graphics2D g2, int x, int y, double scale, boolean isBill, String denomination) {
        super(g2, x, y, scale);

        try{
            image = ImageIO.read(new File("/Users/Frank/Documents/GitHub/fall2023/out/production/fall2023/Draw/img/doge2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

        width = image.getWidth();
        height = image.getHeight();
        this.currentY = (int) (this.getStartY() + (billHeight / 2 * getScale()));
        this.isBill = isBill;
        this.denomination = denomination;
    }

    public void draw(){
        applyScale();
        if(isBill){
            drawDogeBill();
        }else{
            drawDogeCoin();
        }
    }

    private void drawDogeBill(){
        g2.setColor(new Color(188,159,55,255));

        int centerX = this.getStartX() + width / 2;
        int centerY = this.getStartY() + height / 2;

        g2.setFont(new Font("", Font.PLAIN, (int) fontSize));
        g2.setStroke(stroke);
        g2.setColor(new Color(228, 248, 146));
        g2.fillRect(centerX - billWidth / 2, centerY - billHeight / 2, billWidth, billHeight);
        g2.setColor(new Color(90, 140, 61));
        g2.drawRect(centerX - billWidth / 2, centerY - billHeight / 2, billWidth, billHeight);


        g2.fillOval(centerX - coinDiameter / 2, centerY - coinDiameter / 2, coinDiameter, coinDiameter);

        if (image != null) {
            g2.drawImage(image, this.currentX, this.getStartY(), width, height, null);
        }

        g2.drawOval(centerX - coinDiameter / 2, centerY - coinDiameter / 2, coinDiameter, coinDiameter);

        g2.setColor(new Color(114, 217, 6));
        g2.drawString("WOW", centerX, centerY);

        g2.drawString(" TO THE MOON", centerX - coinDiameter / 2, (int) (centerY - coinDiameter / 1.9));
        g2.drawString("    ONE DOGE", centerX - coinDiameter / 2, (int) (centerY + coinDiameter / 1.5));
        g2.drawString(denomination, (int) (centerX - coinDiameter / 0.9), (int) (centerY - coinDiameter / 1.9));
        g2.drawString(denomination, (int) (centerX + coinDiameter / 1.1), (int) (centerY - coinDiameter / 1.9));
        g2.drawString(denomination, (int) (centerX - coinDiameter / 0.9), (int) (centerY + coinDiameter / 1.5));
        g2.drawString(denomination, (int) (centerX + coinDiameter / 1.1), (int) (centerY + coinDiameter / 1.5));


    }

    private void drawDogeCoin() {
        g2.setColor(new Color(188,159,55,255));

        int centerX = this.getStartX() + width / 2;
        int centerY = this.getStartY() + height / 2;

        g2.fillOval(centerX - coinDiameter / 2, centerY - coinDiameter / 2, coinDiameter, coinDiameter);

        if (image != null) {
            g2.drawImage(image, this.currentX, this.getStartY(), width, height, null);
        }

        g2.setColor(new Color(149,133,59,255));
        g2.setStroke(stroke);
        g2.drawOval(centerX - coinDiameter / 2, centerY - coinDiameter / 2, coinDiameter, coinDiameter);

        g2.setColor(new Color(239, 203, 79));
        g2.setFont(new Font("", Font.PLAIN, (int) fontSize));
        g2.drawString("WOW", centerX, centerY);
    }


    @Override
    public void applyScale() {
        this.width = (int) (width * getScale() / 160);
        this.height = (int) (height * getScale() / 160);
        this.coinDiameter = (int) (coinDiameter * getScale());
        this.fontSize = fontSize * getScale();
        this.strokeWidth = strokeWidth * getScale();
        this.billWidth = (int) (billWidth * getScale());
        this.billHeight = (int) (billHeight * getScale());
    }
}
