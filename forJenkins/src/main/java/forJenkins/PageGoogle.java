package forJenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by q on 26.03.2017.
 */
public class PageGoogle {
    WebDriver driver;


    public PageGoogle() {
        System.setProperty("webdriver.gecko.driver", "webDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    void getHome() {
        driver.get(ADR.home);
        driver.navigate();

    }

    void quit() {
        driver.quit();
    }
    String getTitle(){
        return driver.getTitle();
    }


}
