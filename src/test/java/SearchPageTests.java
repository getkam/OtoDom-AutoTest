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
    public void TC0101(){
        FileHelper.writeToFile("Start TC0101");
        BasePage basePage = new BasePage(driver);
        basePage.clickOnLogo();
        assertThat(basePage.getPageTitle()).contains("Otodom: Ogłoszenia Nieruchomości, Mieszkania, Domy, Działki");
        ScreenShotHelper.TakeScreenShot("TC0101");
        FileHelper.writeToFile("Test TC0101 Passed");
    }

    @After
    public void tearDown(){
        FileHelper.writeToFile("Closing ....");
        FileHelper.closeWriter();
        driver.quit();
    }



}
