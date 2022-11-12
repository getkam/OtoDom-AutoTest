package pages;

import enums.NavBarPrimaryMarketItems;
import helpers.FileHelper;
import enums.NavBarAdsItems;
import helpers.TestHelpers;
import locators.BasePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    static WebDriver driver;
    WebDriverWait wait;
    BasePageLocators basePageLocators;

    public enum NavBarPrimaryCompaniesItems{ AGENCIES, DEVELOPERS }
    public enum NavBarPrimaryArticlesItems{ARTICLES, DATA}

    public BasePage(WebDriver driver){
        this.driver = driver;
        basePageLocators = new BasePageLocators();
        PageFactory.initElements(driver,basePageLocators);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
    }
    public String getPageTitle(){
        FileHelper.writeToFile("Current page title: " + driver.getTitle());
        return driver.getTitle();

    }

    public void closeCookies(WebDriver driver){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("onetrust-accept-btn-handler"))));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        FileHelper.writeToFile("Cookies closed");
    }

    public void selectItemFromNavBarAds(NavBarAdsItems selectedOption){
        TestHelpers.clickOnElement(basePageLocators.getNavBarAds());
        wait.until(ExpectedConditions.elementToBeClickable(basePageLocators.getNavBarAdsList().get(selectedOption.getIndex())));
        TestHelpers.clickOnElement(basePageLocators.getNavBarAdsList().get(selectedOption.getIndex()));
    }

    public void selectItemFromNavBarPrimaryMarkets(NavBarPrimaryMarketItems selectedOption){
        TestHelpers.clickOnElement(basePageLocators.getNavBarPrimaryMarket());
        wait.until(ExpectedConditions.elementToBeClickable(basePageLocators.getNavBarPrimaryMarketList().get(selectedOption.getIndex())));
        TestHelpers.clickOnElement(basePageLocators.getNavBarPrimaryMarketList().get(selectedOption.getIndex()));
    }

    public void clickOnLogo (){
        TestHelpers.clickOnElement(basePageLocators.getLogoIcon());
    }

}
