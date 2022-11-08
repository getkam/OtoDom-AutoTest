import helpers.FileHelper;
import helpers.TestHelpers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.FastSearchPage;
import pages.SearchResultPage;

import java.time.Duration;


public class Testy {

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

        fastSearchPage.clickButton();
        TestHelpers.sleep(2);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.closeModal();
        Assert.assertEquals("","Domy nasprzedaż w Warszawa, Rembertow - www.otodom.pl",searchResultPage.getPageTitle());
        FileHelper.writeToFile("Test TC0001 Passed");
    }

    @After
   public void tearDown(){
       FileHelper.writeToFile("Closing ....");
       FileHelper.closeWriter();
       driver.quit();
    }


}
