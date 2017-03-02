package yandex.pages;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by q on 28.02.2017.
 */
public class HomeYandex {
   static int count=0;
    private static Logger Log = Logger.getLogger(HomeYandex.class.getName());

    public HomeYandex() {
        DOMConfigurator.configure("log4j.xml");
    }

    WebDriver driver;
    By market = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[1]/div/a[2]");
    By homeArrowTabs = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[1]");

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    void market() {
        driver.findElement(market).click();

    }

    void selectMenuHomeArrowTabs(String select) {
        WebElement menuItem = driver.findElement(homeArrowTabs);
        List<WebElement> menuItems = menuItem.findElements(By.tagName("a"));
        for (WebElement q : menuItems) {
            if (q.getText().contains(select)) {
                Log.info("получили " + select + " кликнули " + q.getText());
                screenshot();
                q.click();
                break;
            }
        }
    }
    void screenshot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "c:\\tmp\\screenshot" + count + ".png";
        if (new File(path).exists()) {
            count++;
            path = "c:\\tmp\\screenshot" + count + ".png";
        }
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        count++;
        Log.info("скриншот " + path);
    }

}
