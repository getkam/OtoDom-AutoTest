import helpers.FileHelper;
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
    public void TC0001(){
        FileHelper.writeToFile("Start TC0001");
        FastSearchPage fastSearchPage = new FastSearchPage(driver);
        fastSearchPage.selectEstate("Domy");
        fastSearchPage.inputLocation("Rembertów");
        fastSearchPage.selectTransaction("Na sprzedaż");
        //fastSearchPage.selectDistanceRadius("10 km");
        fastSearchPage.inputPriceMax("1400000");
        fastSearchPage.inputPriceMin("900000");
        fastSearchPage.inputAreaMax("300");
        fastSearchPage.inputAreaMin("120");
        ScreenShotHelper.TakeScreenShot("TC0001");
        fastSearchPage.clickButton();
        TestHelpers.sleep(2);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.closeModal();
        ScreenShotHelper.TakeScreenShot("TC0001");
        assertThat(searchResultPage.getNumberOfListeningItems()).isEqualTo(fastSearchPage.getNumberOfSearchItems());
        FileHelper.writeToFile("Test TC0001 Passed");
    }

    @Test
    public void TC0002(){
        FileHelper.writeToFile("Start TC0002");
        FastSearchPage fastSearchPage = new FastSearchPage(driver);
        fastSearchPage.selectEstate("Domy");
        ScreenShotHelper.TakeScreenShot("TC0002");
        fastSearchPage.clickButton();
        TestHelpers.sleep(2);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.closeModal();
        ScreenShotHelper.TakeScreenShot("TC0002");
        assertThat(searchResultPage.getPageTitle()).contains("Domy na sprzedaż - www.otodom.pl");
        FileHelper.writeToFile("Test TC0002 Passed");
    }

    @After
   public void tearDown(){
       driver.quit();
       FileHelper.writeToFile("Closing....");
       FileHelper.closeWriter();
    }

}
