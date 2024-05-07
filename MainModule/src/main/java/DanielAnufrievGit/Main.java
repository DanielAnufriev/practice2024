package DanielAnufrievGit;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


/*Реализовать алгоритм растровой компьютерной графики: выделение контуров изображения методом Собеля*/
/* Дополнение проекта: добавлен метод размытия (Blur) изображения по методу Гаусса*/
public class Main {


    public static File FileChoice(String imagesPath) {

        File[] files = new File(imagesPath).listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpeg"));

        // Display the list of files in the directory
        System.out.println("Available files in the directory:");
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ". " + files[i].getName());
        }

        // Choose the file to process
        Scanner in = new Scanner(System.in);
        System.out.println("Input the nomber of image");
        int choice = in.nextInt(); // Change this to the desired file number
        File ImageFile = files[choice - 1];
        return ImageFile;
    }

    public static File MakeSobel(File sourceImageFile, File destinationDirectory) {
        ImageProcessor processor = new ImageProcessor();
        try {

            File resultSobel_file = processor.performSobel(sourceImageFile, destinationDirectory);
            System.out.println("The selection of the contours of the image by the Sobel method is completed");
            return resultSobel_file;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static File MakeGaussianBlur(File sourceImageFile, File destinationDirectory) {

        GaussianBlur gaussianBlur = new GaussianBlur();
        try {
            File resultgaussianBlur = gaussianBlur.applyGaussianBlur(sourceImageFile, destinationDirectory);
            System.out.println("Image blurring by the Gauss method is completed.");
            return  resultgaussianBlur;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static File CreateDirectory() {
        File destinationDirectory = new File(System.getProperty("user.home") + "/Pictures" + "/Results");
        if (!destinationDirectory.exists()) {
            if (destinationDirectory.mkdir()) {
                System.out.println("The 'Results' folder was created in the directory.");
            } else {
                System.out.println("The 'Results' folder created.");
            }
        }
        return destinationDirectory;
    }

    public static void ChooseAction(File sourceImageFile, File destinationDirectory) {
        Logger logger = Logger.getLogger(Main.class);
        BasicConfigurator.configure();
        Scanner inAction = new Scanner(System.in);
        System.out.println("Input 1 - to apply the Sobel boundary selection method " + "\n" +
                "Input 2 - to apply the Gaussian Blur method");
        int ActionChoice = inAction.nextInt(); // Change this to the desired file number
        switch (ActionChoice) {
            case (1):
                if (MakeSobel(sourceImageFile, destinationDirectory) != null) {
                    logger.info("Successful image processing");
                }
                else {
                    logger.info("Unsuccessful image processing");
                }

                break;
            case (2):

                if (MakeGaussianBlur(sourceImageFile, destinationDirectory) != null) {
                    logger.info("Successful image processing");
                } else {
                    logger.info("Unsuccessful image processing");
                }
                break;
        }
    }



    public static void main(String[] args) {

        String imagesPath = System.getProperty("user.home") + "/Pictures";
        File sourceImageFile = FileChoice(imagesPath);
        File destinationDirectory = CreateDirectory();
        ChooseAction(sourceImageFile,destinationDirectory);



    }
}
