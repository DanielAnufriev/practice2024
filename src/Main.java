import java.io.File;
import java.io.IOException;
/*Реализовать алгоритм растровой компьютерной графики: выделение контуров изображения методом Собеля*/
public class Main {
    public static void main(String[] args) {
        ImageProcessor processor = new ImageProcessor();
        File sourceImageFile = new File("images/input2.jpg");
        File destinationDirectory = new File("images/");
        try {
            processor.performSobel(sourceImageFile, destinationDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
