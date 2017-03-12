/**
 * Created by q on 03.03.2017.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.security.Key;
import java.util.List;

public class SimlpeElementsConverter {
    WebElement fromform;
    WebElement inform;
    WebElement coinsform;
    By pathName;
    private WebDriver driver;

   
    public void setPachName(By pachName) {
        this.pathName = pachName;
    }
   
    public boolean clickByName(String name) {
        Boolean responce = false;
        List<WebElement> q = driver.findElement(pathName).findElements(By.cssSelector("div label"));
        for (WebElement w : q) {
            if (w.getText().equals(name)) {
                w.click();
            }
            if (w.isEnabled() || w.isSelected())
                responce = true;
        }
        return responce;
    }
   
    public boolean show() {
        Boolean responce = false;

        driver.findElement(pathName).click();
        By q = By.cssSelector("div[data-reactid='.0.$1.$1']");
                responce = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(q)).isDisplayed();
        responce = driver.findElement(q).isDisplayed();
        return responce;
    }
   
    public String showGetText() {


        String responce = driver.findElement(pathName).getText();

        return responce;
    }
   
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
   
    public boolean setParametersConverter(String from, String in, String coins) {

        List<WebElement> select = driver.findElement(pathName).findElements(By.cssSelector("div[class='select']"));
        boolean response = true;
        fromform = select.get(0);
        clic(fromform, from);
        if (!fromform.getText().contains(from)) {

            response = false;
        }

        inform = select.get(1);
        clic(inform, in);
        if (!inform.getText().contains(in)) {
            response = false;

            coinsform = driver.findElement(pathName).findElement(By.cssSelector("input[data-reactid='.0.$1.$0.0.1.0.0.0']"));
            coinsform.sendKeys(Keys.BACK_SPACE);
            coinsform.sendKeys(Keys.BACK_SPACE);
            coinsform.sendKeys(Keys.BACK_SPACE);
            coinsform.sendKeys(coins);
            if (!coinsform.getAttribute("value").replace(" ", "").replace(".", "").replace(",", "").contains(coins)) {

                response = false;
            }


        } return response;

    }

    void clic(WebElement frominform, String resp) {
        List<WebElement> e = frominform.findElements(By.tagName("span"));
        for (WebElement q : e) {
            if (q.getText().equals(resp)) {
                Actions builder = new Actions(driver);
                builder.moveToElement(frominform)
                        .click(q);
                Action mouseoverAndClick = builder.build();
                mouseoverAndClick.perform();


                break;
            }
        }
    }
}


