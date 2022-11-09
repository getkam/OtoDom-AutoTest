package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotHelper {

    private static File scrFile;
    private static WebDriver driver;

    public ScreenShotHelper(WebDriver driver){
        this.driver = driver;
    }

    public static void TakeScreenShot(String testName){
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src/main/screenshots/screenshot_"+ testName+ "_"+TestHelpers.getcurrentDate() + ".png"));
            FileHelper.writeToFile("ScreenShot taken: screenshot_"+ testName+ "_"+TestHelpers.getcurrentDate() + ".png");
        } catch (IOException e) {
            e.printStackTrace();
            FileHelper.writeToFile("Problem to create screenShot file");
        }
    }

}
