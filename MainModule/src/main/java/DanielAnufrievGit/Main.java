package DanielAnufrievGit;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


/*Реализовать алгоритм растровой компьютерной графики: выделение контуров изображения методом Собеля*/
public class Main {


    public static File FileChoice(String imagesPath){

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
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class);
        BasicConfigurator.configure();
        ImageProcessor processor = new ImageProcessor();
        String imagesPath = System.getProperty("user.home") + "/Pictures";
        File sourceImageFile = FileChoice(imagesPath);
        File destinationDirectory = new File(imagesPath + "/Results");
        // Проверка наличия папки "Results" и создание, если она отсутствует
        if (!destinationDirectory.exists()) {
            if (destinationDirectory.mkdir()) {
                System.out.println("Папка 'Results' создана в директории.");
            } else {
                System.out.println("Не удалось создать папку 'Results'.");
            }
        }
        try {
            processor.performSobel(sourceImageFile, destinationDirectory);
            System.out.println("Обработка изображения завершена");
            logger.info("Successful image processing");
        } catch (IOException e) {
            logger.info("Unsuccessful image processing");
            e.printStackTrace();
        }
    }
}
