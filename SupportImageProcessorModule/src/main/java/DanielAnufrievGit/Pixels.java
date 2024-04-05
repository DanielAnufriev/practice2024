package DanielAnufrievGit;

import java.awt.image.BufferedImage;

public class Pixels {
    public final int[][] pixR;

    public Pixels(BufferedImage img) {
        this.pixR = new int[img.getWidth()][img.getHeight()];

        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int rgb = img.getRGB(i, j);
                this.pixR[i][j] = (rgb >> 16) & 0xFF;
            }
        }
    }
}
