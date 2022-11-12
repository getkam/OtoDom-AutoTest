import enums.NavBarPrimaryMarketItems;
import helpers.FileHelper;
import enums.NavBarAdsItems;
import helpers.ScreenShotHelper;
import helpers.TestHelpers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.FastSearchPage;
import pages.SearchResultPage;

import static org.assertj.core.api.Assertions.assertThat;


public class LandingPage {

    WebDriver driver;
    WebDriverWait wait;
    String TestName;

    @Before
    public void setUp(){
        FileHelper.createFile();
        FileHelper.writeToFile("Initializing ....");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.otodom.pl/");
        driver.manage().window().maximize();
        ScreenShotHelper screenShotHelper = new ScreenShotHelper(driver);
        BasePage basePage = new BasePage(driver); // closing cookies
        basePage.closeCookies(driver);

    }
    @Test
    public void SimpleSearch(){
        TestName = "SimpleSearch";
        FileHelper.writeToFile("Start test: "+ TestName);
        FastSearchPage fastSearchPage = new FastSearchPage(driver);
        BasePage basePage = new BasePage(driver);
        fastSearchPage.selectEstate("Domy");
        ScreenShotHelper.TakeScreenShot("TC0002");
        fastSearchPage.clickButton();
        TestHelpers.sleep(2);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.closeModal();
        ScreenShotHelper.TakeScreenShot("TC0002");
        assertThat(basePage.getPageTitle()).contains("Domy na sprzedaż - www.otodom.pl");
        FileHelper.writeToFile("Test TC0002 Passed");
    }

    @Test
    public void FastSearchNumberOfFoundItems(){
        TestName = "FastSearchNumberOfFoundItems";
        FileHelper.writeToFile("Start test: "+ TestName);
        FastSearchPage fastSearchPage = new FastSearchPage(driver);
        fastSearchPage.selectEstate("Domy");
        fastSearchPage.inputLocation("Rembertów");
        fastSearchPage.selectTransaction("Na sprzedaż");
        fastSearchPage.inputPriceMax("1400000");
        fastSearchPage.inputPriceMin("900000");
        fastSearchPage.inputAreaMax("300");
        fastSearchPage.inputAreaMin("120");
        ScreenShotHelper.TakeScreenShot(TestName);
        fastSearchPage.clickButton();
        TestHelpers.sleep(2);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.closeModal();
        ScreenShotHelper.TakeScreenShot(TestName);
        assertThat(searchResultPage.getNumberOfListingItems()).isEqualTo(fastSearchPage.getNumberOfSearchItems());
        FileHelper.writeToFile("Test "+ TestName +"Passed");
    }

    @Test
    public void NavigationBarApartForSale(){
        TestName = "NavigationBarApartForSale";
        FileHelper.writeToFile("Start test: "+ TestName);
        BasePage basePage = new BasePage(driver);
        basePage.selectItemFromNavBarAds(NavBarAdsItems.APARTAMENTS_FOR_RENT);
        assertThat(basePage.getPageTitle()).contains("Mieszkania na wynajem - www.otodom.pl");
        FileHelper.writeToFile("Test "+ TestName +"Passed");
    }

    @Test
    public void NavigationBarTopDevelopers(){
        TestName = "NavigationBarTopDevelopers";
        FileHelper.writeToFile("Start test: "+ TestName);
        BasePage basePage = new BasePage(driver);
        basePage.selectItemFromNavBarPrimaryMarkets(NavBarPrimaryMarketItems.TOP_DEVELOPERS);
        assertThat(basePage.getPageTitle()).contains("Rynek pierwotny nieruchomości w Polsce");
        FileHelper.writeToFile("Test "+ TestName +"Passed");
    }

    @After
   public void tearDown(){
       driver.quit();
       FileHelper.writeToFile("Closing....");
       FileHelper.closeWriter();
    }

}
