package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestHelpers {

    public static void selectByTextFromReactDropdown(WebDriver driver, WebElement element, String expectedElement){
        Actions action = new Actions(driver);
        action.moveToElement(element.findElement(By.xpath("//*[text()=\'"+expectedElement+"\']"))).click().perform();
    }

    public static void clickOnElement(WebElement element) {element.click();}

    public static void sendTextToElementAndLooseFocus(WebElement element, String expectedText){
        element.sendKeys(expectedText);
        element.sendKeys(Keys.TAB);
        System.out.println("input: "+ expectedText);
    }

    public static void sendTextToElement(WebElement element, String expectedText){
        element.sendKeys(expectedText);
        System.out.println("input: " + expectedText);
    }

    public static void print(String line){
        System.out.println(line);
    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}