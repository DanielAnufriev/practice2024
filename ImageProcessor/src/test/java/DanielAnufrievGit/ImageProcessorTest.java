package DanielAnufrievGit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImageProcessorTest {
    @Test
    public void testPerformSobel() throws IOException {
        // Preparing input data for the test
        String imagesPath = System.getProperty("user.home") + "/Pictures";
        File sourceImageFile = new File(imagesPath +"/test_image_folder/test_image.jpg");
        File destinationDirectory = new File(imagesPath + "/Results");

        // Creating an ImageProcessor instance
        ImageProcessor imageProcessor = new ImageProcessor();

        // Calling the performSobel method
        File resultFile = imageProcessor.performSobel(sourceImageFile, destinationDirectory);

        // Checking that the file has been created
        assertTrue(resultFile.exists());


    }

    @Test
    public void testApplyGaussianBlur() throws IOException {
        // Preparing input data for the test
        String imagesPath = System.getProperty("user.home") + "/Pictures";
        File sourceImageFile = new File(imagesPath +"/test_image_folder/test_image.jpg");
        File destinationDirectory = new File(imagesPath + "/Results");

        // Creating an GaussianBlur
        GaussianBlur gaussianBlur = new GaussianBlur();

        // Calling the applyGaussianBlur method
        File resultFile = gaussianBlur.applyGaussianBlur(sourceImageFile, destinationDirectory);

        // Checking that the file has been created
        assertTrue(resultFile.exists());


    }

}