package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePageLocators {

    @FindBy(id="onetrust-accept-btn-handler")
    private WebElement closeCookiesBtn;

    public WebElement getCloseCookiesBtn(){return closeCookiesBtn;}

    public void setCloseCookiesBtn(WebElement closeCookiesBtn){this.closeCookiesBtn = closeCookiesBtn;};

}
