package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FastSearchLocators {

    @FindBy(xpath="//*[@data-cy='search-form--field--estate']")
    private WebElement estateType;

    public WebElement getEstateType(){return estateType;}

    public void setEstateType(WebElement estateType){this.estateType = estateType;};

    @FindBy(xpath="//*[@id='react-select-estate-listbox']")
    private WebElement estateDropDownBox;

    public WebElement getEstateDropDownBox(){return estateDropDownBox;}

    public void setEstateDropDownBox(WebElement estateDropDownBox){this.estateDropDownBox = estateDropDownBox;};

    @FindBy(xpath="//*[@id='react-select-transaction-listbox']")
    private WebElement transactionDropDownBox;

    public WebElement getTransactionDropDownBox(){return transactionDropDownBox;}

    public void setTransactionDropDownBox(WebElement transactionDropDownBox){this.transactionDropDownBox = transactionDropDownBox;};


    @FindBy(xpath="//*[@data-cy='search-form--field--transaction']")
    private WebElement transactionType;

    public WebElement getTransactionType(){return transactionType;}

    public void setTransactionType(WebElement transactionType){this.transactionType = transactionType;};


    @FindBy(xpath="//*[@id='location']")
    private WebElement location;

    public WebElement getLocation(){return location;}

    public void setLocation(WebElement location){this.location = location;};


    @FindBy(xpath="//*[@data-cy='location-picker-input']")
    private WebElement locationPicker;

    public WebElement getLocationPicker(){return locationPicker;}

    public void setLocationPicker(WebElement location){this.locationPicker = locationPicker;};


    @FindBy(xpath="//*[@data-testid='suggestions-item'][1]")
    private WebElement locationPickerFirstSuggestion;

    public WebElement getLocationPickerFirstSuggestion(){return locationPickerFirstSuggestion;}

    public void setLocationPickerFirstSuggestion(WebElement locationPickerFirstSuggestion){this.locationPickerFirstSuggestion = locationPickerFirstSuggestion;};


    @FindBy(xpath="//*[@data-cy='search-form--field--distanceRadius']")
    private WebElement distanceRadius;

    public WebElement getDistanceRadius(){return distanceRadius;}

    public void setDistanceRadius(WebElement distanceRadius){this.distanceRadius = distanceRadius;};


    @FindBy(xpath="//*[@id='priceMin']")
    private WebElement priceMin;

    public WebElement getPriceMin(){return priceMin;}

    public void setPriceMin(WebElement priceMin){this.priceMin = priceMin;};


    @FindBy(xpath="//*[@id='priceMax']")
    private WebElement priceMax;

    public WebElement getPriceMax(){return priceMax;}

    public void setPriceMax(WebElement priceMax){this.priceMax = priceMax;};


    @FindBy(xpath="//*[@id='areaMin']")
    private WebElement areaMin;

    public WebElement getAreaMin(){return areaMin;}

    public void setAreaMin(WebElement areaMin){this.areaMin = areaMin;};


    @FindBy(xpath="//*[@id='areaMax']")
    private WebElement areaMax;

    public WebElement getAreaMax(){return areaMax;}

    public void setAreaMax(WebElement areaMax){this.areaMax = areaMax;};


    @FindBy(xpath="//*[@id='search-form-submit']")
    private WebElement searchButton;

    public WebElement getSearchButton(){return searchButton;}

    public void setSearchButton(WebElement searchButton){this.searchButton = searchButton;};

}
