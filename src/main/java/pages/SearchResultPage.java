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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofSeconds(2));
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

    public void seeMap() {
        TestHelpers.clickOnElement(searchResultLocators.getSeeMap());
    }
    public void closeMap() {
        TestHelpers.clickOnElement(searchResultLocators.getCloseMap());
    }

    public void clickOnFirstCLuster() {
        wait.until(ExpectedConditions.visibilityOf(searchResultLocators.getListOfClusters().get(0)));
        TestHelpers.clickOnElement(searchResultLocators.getListOfClusters().get(0));
        TestHelpers.sleep(1);
    }
    public boolean isMapDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(searchResultLocators.getMap()));
       if (searchResultLocators.getMap().isDisplayed()) {return true;} else return false;
    }
    public boolean isMapClosed(){
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResultLocators.getListeningItems()));
        if (searchResultLocators.getListeningItems().size()!=0) {return true;} else return false;
    }

}
