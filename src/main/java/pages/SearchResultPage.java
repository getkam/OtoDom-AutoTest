package pages;

import helpers.FileHelper;
import helpers.TestHelpers;
import locators.SearchResultLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private SearchResultLocators searchResultLocators;
    private List<WebElement> listeningItems;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        searchResultLocators = new SearchResultLocators();
        PageFactory.initElements(driver,searchResultLocators);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofSeconds(1));
    }



    public void closeModal(){
        wait.equals(ExpectedConditions.elementToBeClickable(searchResultLocators.getCloseModal()));
        try {
            TestHelpers.clickOnElement(searchResultLocators.getCloseModal());
            FileHelper.writeToFile("Modal window closed");
        }catch(Exception e){
            FileHelper.writeToFile("No modal window displayed");
        }
    }

    public int getNumberOfListeningItems(){
        return searchResultLocators.getListeningItems().size();
    }

}
