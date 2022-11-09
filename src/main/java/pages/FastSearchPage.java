package pages;

import helpers.FileHelper;
import helpers.ScreenShotHelper;
import helpers.TestHelpers;
import locators.FastSearchLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FastSearchPage {
    WebDriver driver;
    WebDriverWait wait;
    FastSearchLocators fastSearchLocators;

    public FastSearchPage(WebDriver driver){
        this.driver = driver;
        fastSearchLocators = new FastSearchLocators();
        PageFactory.initElements(driver, fastSearchLocators);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
    }

    public void selectEstate(String estate){
        TestHelpers.clickOnElement(fastSearchLocators.getEstateType());
        wait.until(ExpectedConditions.visibilityOf(fastSearchLocators.getEstateDropDownBox()));
        TestHelpers.selectByTextFromReactDropdown(driver, fastSearchLocators.getEstateDropDownBox(), estate);
        FileHelper.writeToFile("Selected estate: "+ estate);

    }

    public void selectTransaction(String transaction){
        TestHelpers.clickOnElement(fastSearchLocators.getTransactionType());
        wait.until(ExpectedConditions.visibilityOf(fastSearchLocators.getTransactionDropDownBox()));
        TestHelpers.selectByTextFromReactDropdown(driver, fastSearchLocators.getTransactionDropDownBox(), transaction);
        FileHelper.writeToFile("Selected transaction type: "+ transaction);
    }

    public void inputLocation(String location){
        TestHelpers.clickOnElement(fastSearchLocators.getLocation());
        wait.until(ExpectedConditions.visibilityOf(fastSearchLocators.getLocationPicker()));
        TestHelpers.sendTextToElement(fastSearchLocators.getLocationPicker(), location);
        wait.until(ExpectedConditions.visibilityOf(fastSearchLocators.getLocationPickerFirstSuggestion()));
        TestHelpers.clickOnElement(fastSearchLocators.getLocationPickerFirstSuggestion());
        FileHelper.writeToFile("Selected location: " + location);
    }

    public void selectDistanceRadius (String distanceRadius){
        TestHelpers.selectByTextFromReactDropdown(driver, fastSearchLocators.getDistanceRadius(), distanceRadius);
        FileHelper.writeToFile("Selected distance Radius: "+ distanceRadius);
    }

    public void inputPriceMin(String priceMin){
        TestHelpers.sendTextToElementAndLooseFocus(fastSearchLocators.getPriceMin(), priceMin);
        FileHelper.writeToFile("Entered minimum price: " + priceMin);
    }

    public void inputPriceMax(String priceMax){
        TestHelpers.sendTextToElementAndLooseFocus(fastSearchLocators.getPriceMax(), priceMax);
        FileHelper.writeToFile("Entered maximum price: " + priceMax);
    }

    public void inputAreaMin(String areaMin){
        TestHelpers.sendTextToElementAndLooseFocus(fastSearchLocators.getAreaMin(), areaMin);
        FileHelper.writeToFile("Entered minimum area: " + areaMin);
    }

    public void inputAreaMax(String areaMax){
        TestHelpers.sendTextToElementAndLooseFocus(fastSearchLocators.getAreaMax(), areaMax);
        FileHelper.writeToFile("Entered maximum area: " + areaMax);
    }

    public void clickButton(){
        wait.until(ExpectedConditions.elementToBeClickable(fastSearchLocators.getSearchButton()));
        TestHelpers.clickOnElement(fastSearchLocators.getSearchButton());
        FileHelper.writeToFile("Search button clicked");
    }

    private void sleep(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
