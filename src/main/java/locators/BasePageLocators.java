package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasePageLocators {

    ////////////////////////////////////////////////////////////////////////////////  Close cookies
    @FindBy(id="onetrust-accept-btn-handler")
    private WebElement closeCookiesBtn;

    public WebElement getCloseCookiesBtn(){return closeCookiesBtn;}

    public void setCloseCookiesBtn(WebElement closeCookiesBtn){this.closeCookiesBtn = closeCookiesBtn;};

    ////////////////////////////////////////////////////////////////////////////////  LOGO
    @FindBy(xpath="//a[@href='/']")
    private WebElement logoIcon;

    public WebElement getLogoIcon(){return logoIcon;}

    public void setLogoIcon(WebElement logoIcon){this.logoIcon = logoIcon;};
    ////////////////////////////////////////////////////////////////////////////////  Ogloszenia
    @FindBy(xpath="//*[@data-cy='navbar.menu.ads']")
    private WebElement navBarAds;
    public WebElement getNavBarAds(){return navBarAds;}
    public void setNavBarAds(WebElement navBarAds){this.navBarAds = navBarAds;};

    @FindBy(xpath="//*[@id='li-frontend.navbar.menu.ads']/ul/li")
    private List<WebElement> navBarAdsList;
    public List<WebElement>getNavBarAdsList(){return navBarAdsList;}
    public void setNavBarAdsList(List<WebElement> navBarAdsList){this.navBarAdsList = navBarAdsList;};

    ////////////////////////////////////////////////////////////////////////////////  Rynek pierwotny
    @FindBy(xpath="//*[@data-cy='navbar.menu.primary-market']")
    private WebElement navBarPrimaryMarket;

    public WebElement getNavBarPrimaryMarket(){return navBarPrimaryMarket;}

    public void setNavBarPrimaryMarket(WebElement navBarPrimaryMarket){this.navBarPrimaryMarket = navBarPrimaryMarket;};

    @FindBy(xpath="//*[@id='li-frontend.navbar.menu.primary-market']/ul/li")
    private List<WebElement> navBarPrimaryMarketList;

    public List<WebElement> getNavBarPrimaryMarketList(){return navBarPrimaryMarketList;}

    public void setNavBarPrimaryMarketList(List<WebElement> navBarPrimaryMarketList){this.navBarPrimaryMarketList = navBarPrimaryMarketList;};

    ////////////////////////////////////////////////////////////////////////////////  Firmy
    @FindBy(xpath="//*[@data-cy='navbar.menu.companies']")
    private WebElement navBarCompanies;

    public WebElement getNavBarCompanies(){return navBarCompanies;}

    public void setNavBarCompanies(WebElement navBarCompanies){this.navBarCompanies = navBarCompanies;};


    @FindBy(xpath="//*[@id='li-frontend.navbar.menu.companies']/ul/li']")
    private List<WebElement> navBarCompaniesList;

    public List<WebElement> getNavBarCompaniesList(){return navBarCompaniesList;}

    public void setNavBarCompaniesList(List<WebElement> navBarCompaniesList){this.navBarCompaniesList = navBarCompaniesList;};

    ////////////////////////////////////////////////////////////////////////////////  Porady
    @FindBy(xpath="//*[@data-cy='navbar.menu.articles']")
    private WebElement navBarArticles;

    public WebElement getNavBarArticles(){return navBarArticles;}

    public void setNavBarArticles(WebElement navBarArticles){this.navBarArticles = navBarArticles;};

    @FindBy(xpath="//*[@id='li-frontend.navbar.menu.articles']/ul/li")
    private List<WebElement>  navBarArticlesList;

    public List<WebElement>  getNavBarArticlesList(){return navBarArticlesList;}

    public void setNavBarArticlesList(List<WebElement> navBarArticlesList){this.navBarArticlesList = navBarArticlesList;};

    ////////////////////////////////////////////////////////////////////////////////  Kredyty
    @FindBy(xpath="//*[@data-cy='navbar.menu.credits']")
    private WebElement navBarCredits;

    public WebElement getNavBarCredits(){return navBarCredits;}

    public void setNavBarCredits(WebElement navBarCredits){this.navBarCredits = navBarCredits;};

}
