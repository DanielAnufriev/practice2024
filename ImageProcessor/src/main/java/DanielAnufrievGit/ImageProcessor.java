package DanielAnufrievGit;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageProcessor {

    private final Mask mask;


    public ImageProcessor() {
        this.mask = new Mask();
    }

    public File performSobel(File sourceImageFile, File destinationDirectory) throws IOException {
        BufferedImage sourceImage = ImageIO.read(sourceImageFile);
        BufferedImage resultImage = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        Pixels pixelColor = new Pixels(sourceImage);

        for (int i = 1; i < sourceImage.getWidth() - 1; i++) {
            for (int j = 1; j < sourceImage.getHeight() - 1; j++) {
                int pixelValue = calculateSobelValue(i, j, pixelColor);
                resultImage.setRGB(i, j, pixelValue);
            }
        }

        File outputFile = new File(destinationDirectory, "bordered_" + sourceImageFile.getName());
        ImageIO.write(resultImage, "png", outputFile);
        return outputFile;
    }

    private int calculateSobelValue(int x, int y, Pixels pixelColor) {
        int[][] gx = mask.gx;
        int[][] gy = mask.gy;

        int sumX = 0;
        int sumY = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                sumX += (pixelColor.pixR[x + i][y + j] * gx[i + 1][j + 1]);
                sumY += (pixelColor.pixR[x + i][y + j] * gy[i + 1][j + 1]);
            }
        }

        int magnitude = Math.abs(sumX) + Math.abs(sumY);
        return magnitude;
    }
}







