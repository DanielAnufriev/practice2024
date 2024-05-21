package DanielAnufrievGit;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MainTest {

    @InjectMocks
    Main main = new Main();
   @Test
   public void testFileChoice() {
       // Preparing the input data for the test
       String imagesPath = "../testImagesPath";
       String[] fileNames = {"../testImagesPath/test1.jpg", "../testImagesPath/test2.jpg", "../testImagesPath/test3.jpg"};
       File[] files = new File[fileNames.length];
       for (int i = 0; i < fileNames.length; i++) {
           files[i] = new File(fileNames[i]);
       }


       String input = "2";  // Selecting the second file
       InputStream in = new ByteArrayInputStream(input.getBytes());
       System.setIn(in);

       // Method call
       File result = Main.FileChoice(imagesPath);

       // Checking the output to the console
       for (int i = 0; i < files.length; i++) {
           System.out.println((i + 1) + ". " + files[i].getName());
       }

       // Checking the returned file
       assertEquals(files[1], result);
   }

    @Test
    public void testSobelreturnFile() {
        String imagesPath = System.getProperty("user.home") + "/Pictures";
        File sourceImageFile = new File(imagesPath +"/test_image_folder/test_image.jpg");
        File destinationDirectory = new File(imagesPath + "/Results");
        File result = main.MakeSobel(sourceImageFile,destinationDirectory);
        assertTrue(result instanceof File);
    }


    @Test
    void testGaussianBlurreturnFile() {
        String imagesPath = System.getProperty("user.home") + "/Pictures";
        File sourceImageFile = new File(imagesPath +"/test_image_folder/test_image.jpg");
        File destinationDirectory = new File(imagesPath + "/Results");
        File result = main.MakeGaussianBlur(sourceImageFile,destinationDirectory);
        assertTrue(result instanceof File);
    }

}