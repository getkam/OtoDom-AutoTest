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

public class SearchPageTests {

    WebDriver driver;
    WebDriverWait wait;
    String TestName;

    @Before
    public void setUp(){
        FileHelper.createFile();
        FileHelper.writeToFile("Initializing ....");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.otodom.pl/pl/oferty/sprzedaz/dom/cala-polska");
        driver.manage().window().maximize();
        ScreenShotHelper screenShotHelper = new ScreenShotHelper(driver);
        BasePage basePage = new BasePage(driver); // closing cookies
        basePage.closeCookies(driver);
    }

    @Test
    public void ClickOnLogo(){
        TestName = "SearchPage_ClickOnLogo";
        FileHelper.writeToFile("Start test: "+ TestName);
        BasePage basePage = new BasePage(driver);
        basePage.clickOnLogo();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://www.otodom.pl/");
        ScreenShotHelper.TakeScreenShot(TestName);
        FileHelper.writeToFile("Test "+ TestName +"Passed");
    }

    @Test
    public void SeeOnTheMapCLickOnCLuster(){
        TestName = "SearchPage_SeeOnTheMapCLickOnCLuster";
        FileHelper.writeToFile("Start test: "+ TestName);
        FastSearchPage fastSearchPage = new FastSearchPage(driver);
        fastSearchPage.selectEstate("Mieszkania");
        fastSearchPage.inputLocation("Szczecin");
        fastSearchPage.selectTransaction("Na wynajem");
        ScreenShotHelper.TakeScreenShot(TestName);
        fastSearchPage.clickButton();
        TestHelpers.sleep(2);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.seeMap();
        TestHelpers.sleep(2);
        assertThat(searchResultPage.isMapDisplayed()).isTrue();
        ScreenShotHelper.TakeScreenShot(TestName);
        searchResultPage.clickOnFirstCLuster();
        searchResultPage.closeMap();
        assertThat(searchResultPage.isMapClosed()).isTrue();
        FileHelper.writeToFile("Test "+ TestName +"Passed");
    }

    @After
    public void tearDown(){
        FileHelper.writeToFile("Closing ....");
        FileHelper.closeWriter();
        driver.quit();
    }

}
