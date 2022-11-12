package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultLocators {

    @FindBy(xpath = "//*[@data-cy='close-modal']")
    private WebElement closeModal;
    public WebElement getCloseModal() {
        return closeModal;
    }
    public void setCloseModal(WebElement closeModal) {
        this.closeModal = closeModal;
    }

    @FindBy(xpath = "//*[@data-cy='listing-item-link']")
    private List<WebElement> listingItems;

    public List<WebElement> getListingItems() {
        return listingItems;
    }
    public void setListingItems(List<WebElement> listingItems) {
        this.listingItems = listingItems;
    }

    @FindBy(xpath = "//*[@data-cy='search.listing-panel.go-to-map-button-listingPanel']")
    private WebElement seeMap;

    public WebElement getSeeMap() {
        return seeMap;
    }
    public void setSeeMap(WebElement seeMap) {
        this.seeMap = seeMap;
    }

    @FindBy(xpath = "//*[@data-cy='search.map.go-to-list-button-mapContainer']")
    private WebElement closeMap;

    public WebElement getCloseMap() {
        return closeMap;
    }
    public void setCloseMap(WebElement closeMap) {
        this.closeMap = closeMap;
    }

    @FindBy(xpath = "//*[@aria-label='Mapa']")
    private WebElement Map;

    public WebElement getMap() {
        return Map;
    }
    public void setMap(WebElement Map) {
        this.Map  = Map;
    }

    @FindBy(xpath = "//*[@aria-label='Mapa']/descendant::*[@role='button']")
    private List<WebElement> listOfClusters;

    public List<WebElement> getListOfClusters() {
        return listOfClusters;
    }
    public void setListOfClusters(List<WebElement> listOfClusters) {
        this.listOfClusters = listOfClusters;
    }

}

