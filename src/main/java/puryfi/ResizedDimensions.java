package puryfi;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ResizedDimensions {
    private double scale;
    private int offsetX;
    private int offsetY;

    public ResizedDimensions(int offsetX, int offsetY, double scale) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.scale = scale;
    }

    public static ResizedDimensions calculate(JLabel originalImageLabel, BufferedImage org) {
        Rectangle viewportSize = originalImageLabel.getBounds();
        double scalex = ((double) originalImageLabel.getWidth()) / org.getWidth();
        double scaley = ((double) originalImageLabel.getHeight()) / org.getHeight();
        double scale = Math.min(scalex, scaley);
        int r_h = (int) (org.getHeight() * scale);
        int r_w = (int) (org.getWidth() * scale);

        int image_offset_y = (viewportSize.height - r_h) / 2;
        int image_offset_x = (viewportSize.width - r_w) / 2;
        return new ResizedDimensions(image_offset_x, image_offset_y, scale);
    }

    public double getScale() {
        return scale;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }
}
