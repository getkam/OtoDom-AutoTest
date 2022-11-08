package pages;

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
        sleep();

    }

    public void selectTransaction(String transaction){
        TestHelpers.clickOnElement(fastSearchLocators.getTransactionType());
        wait.until(ExpectedConditions.visibilityOf(fastSearchLocators.getTransactionDropDownBox()));
        TestHelpers.selectByTextFromReactDropdown(driver, fastSearchLocators.getTransactionDropDownBox(), transaction);
    }

    public void inputLocation(String location){
        TestHelpers.clickOnElement(fastSearchLocators.getLocation());
        wait.until(ExpectedConditions.visibilityOf(fastSearchLocators.getLocationPicker()));
        TestHelpers.sendTextToElement(fastSearchLocators.getLocationPicker(), location);
        wait.until(ExpectedConditions.visibilityOf(fastSearchLocators.getLocationPickerFirstSuggestion()));
        TestHelpers.clickOnElement(fastSearchLocators.getLocationPickerFirstSuggestion());
    }

    public void selectDistanceRadius (String distanceRadius){
        TestHelpers.selectByTextFromReactDropdown(driver, fastSearchLocators.getDistanceRadius(), distanceRadius);
    }

    public void inputPriceMin(String priceMin){
        TestHelpers.sendTextToElementAndLooseFocus(fastSearchLocators.getPriceMin(), priceMin);
    }

    public void inputPriceMax(String priceMax){
        TestHelpers.sendTextToElementAndLooseFocus(fastSearchLocators.getPriceMax(), priceMax);
    }

    public void inputAreaMin(String areaMin){
        TestHelpers.sendTextToElementAndLooseFocus(fastSearchLocators.getAreaMin(), areaMin);
    }

    public void inputAreaMax(String areaMax){
        TestHelpers.sendTextToElementAndLooseFocus(fastSearchLocators.getAreaMax(), areaMax);
    }

    public void clickButton(){
        wait.until(ExpectedConditions.elementToBeClickable(fastSearchLocators.getSearchButton()));
        TestHelpers.clickOnElement(fastSearchLocators.getSearchButton());
    }

    private void sleep(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
