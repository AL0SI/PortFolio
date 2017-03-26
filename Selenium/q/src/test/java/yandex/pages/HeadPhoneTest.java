package yandex.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by q on 28.02.2017.
 */
public class HeadPhoneTest {
    private static Logger Log = Logger.getLogger(HeadPhoneTest.class.getName());
    WebDriver driver;
    WebElement element;


    @Before
    public void bef() {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\q\\.m2\\repository\\selenium\\chromedriver.exe");
        DOMConfigurator.configure("log4j.xml");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
        driver.manage().window().maximize();

    }

    @After
    public void after() {
        driver.close();
        driver = null;
        element = null;
    }

    @Test
    public void testHome() {

        HomeYandex homeYandex = new HomeYandex();
        homeYandex.setDriver(driver);
        homeYandex.selectMenuHomeArrowTabs("Маркет");
        MarketYandex marketYandex = new MarketYandex();
        marketYandex.setDriver(driver);
        marketYandex.clikcTopMenuItem("Электроника");
        marketYandex.clikcCatalogMenuItem("Наушники");
        marketYandex.priceBefore(5000, false);
        marketYandex.ceckProdact("Beats");
        marketYandex.clickPerfomButton();
        (new WebDriverWait(driver, 10)).withTimeout(10,TimeUnit.SECONDS);


        marketYandex.screenshot();
        if(marketYandex.getCountItemSearchPanel()!=10){
            Log.warn("нашли  "+marketYandex.getCountItemSearchPanel()+"  нужно  "+10);
        }
        String itemName = marketYandex.getItemSearchPanel(0)
                .findElement(By.className("snippet-card__header-text")).getText();
        marketYandex.searchFild(itemName);
        marketYandex.screenshot();
        marketYandex.titleItem();

    }
}