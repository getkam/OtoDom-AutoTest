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
        System.out.println("Initializing ....");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.otodom.pl/");
        driver.manage().window().maximize();
        BasePage basePage = new BasePage(driver); // closing cookies
        basePage.closeCookies(driver);


    }

    @Test
    public void TC0001(){
        System.out.println("Start TC0001");
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
        System.out.println("Search button clicked");
        TestHelpers.sleep(2);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        System.out.println("Search Result page title: "+ searchResultPage.getPageTitle());
        searchResultPage.closePopUp();
        Assert.assertEquals("","Domy na sprzedaż - www.otodom.pl",driver.getTitle());
    }

    @After
   public void tearDown(){
   //     driver.quit();
    }


}
