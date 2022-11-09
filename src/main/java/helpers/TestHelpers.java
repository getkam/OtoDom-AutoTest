package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestHelpers {

    public static void selectByTextFromReactDropdown(WebDriver driver, WebElement element, String expectedElement){
        Actions action = new Actions(driver);
        action.moveToElement(element.findElement(By.xpath("//*[text()=\'"+expectedElement+"\']"))).click().perform();
    }

    public static void clickOnElement(WebElement element) {
        element.click();
    }

    public static void sendTextToElementAndLooseFocus(WebElement element, String expectedText){
        element.sendKeys(expectedText);
        element.sendKeys(Keys.TAB);
    }

    public static void sendTextToElement(WebElement element, String expectedText){
        element.sendKeys(expectedText);
    }

    public static void addToLog(String line){
        FileHelper.writeToFile(line);
    }

    public static String getcurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        return dateFormat.format(date);

    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
