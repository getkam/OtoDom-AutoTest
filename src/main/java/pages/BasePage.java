package pages;

import helpers.TestHelpers;
import locators.BasePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    BasePageLocators basePageLocators;

    public BasePage(WebDriver driver){
        this.driver = driver;
        basePageLocators = new BasePageLocators();
        PageFactory.initElements(driver,basePageLocators);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
    }

    public void closeCookies(WebDriver driver){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("onetrust-accept-btn-handler"))));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        System.out.println("Cookies closed");
    }
}
