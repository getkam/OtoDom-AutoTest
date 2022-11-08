package pages;

import helpers.TestHelpers;
import locators.SearchResultLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage {
    WebDriver driver;
    WebDriverWait wait;
    SearchResultLocators searchResultLocators;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        searchResultLocators = new SearchResultLocators();
        PageFactory.initElements(driver,searchResultLocators);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofSeconds(1));
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void closePopUp(){
        wait.equals(ExpectedConditions.elementToBeClickable(searchResultLocators.getCloseModal()));
        TestHelpers.clickOnElement(searchResultLocators.getCloseModal());
    }

}