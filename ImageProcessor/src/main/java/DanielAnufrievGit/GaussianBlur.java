package DanielAnufrievGit;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class GaussianBlur {
    private BufferedImage sourceImage;
    public File applyGaussianBlur(File sourceImageFile, File destinationDirectory) throws IOException {

        try {
            this.sourceImage = ImageIO.read(sourceImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        int[] pixels = sourceImage.getRGB(0, 0, width, height, null, 0, width);

        int[][] matrix = {
                {1, 2, 1},
                {2, 4, 2},
                {1, 2, 1}
        };

        int sum = 16; // Сумма всех элементов матрицы

        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                int red = 0;
                int green = 0;
                int blue = 0;

                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        int rgb = pixels[(i + k) * width + j + l];
                        red += (rgb >> 16) & 0xFF;
                        green += (rgb >> 8) & 0xFF;
                        blue += (rgb & 0xFF);
                    }
                }

                red = red / sum;
                green = green / sum;
                blue = blue / sum;

                pixels[i * width + j] = (red << 16) | (green << 8) | blue;
            }
        }

        sourceImage.setRGB(0, 0, width, height, pixels, 0, width);

        try {
            File outputFile = new File(destinationDirectory, "Blur_" + sourceImageFile.getName());
            ImageIO.write(this.sourceImage, "png", outputFile);
            return outputFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
