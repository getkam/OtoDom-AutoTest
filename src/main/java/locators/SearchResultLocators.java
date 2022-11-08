package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultLocators {


    @FindBy(xpath="//*[@data-cy='close-modal']")
    private WebElement closeModal;

    public WebElement getCloseModal(){return closeModal;}

    public void setCloseModal(WebElement closeModal){this.closeModal = closeModal;};


}
