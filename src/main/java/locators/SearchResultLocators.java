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

    ;


    @FindBy(xpath = "//*[@data-cy='listing-item-link']")
    private List<WebElement> listeningItems;

    public List<WebElement> getListeningItems() {
        return listeningItems;
    }
    public void setListeningItems(List<WebElement> listeningItems) {
        this.listeningItems = listeningItems;
    }
}