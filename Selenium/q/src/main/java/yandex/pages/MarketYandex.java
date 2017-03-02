package yandex.pages;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by q on 28.02.2017.
 */
public class MarketYandex {
    private static Logger Log = Logger.getLogger(MarketYandex.class.getName());

    public MarketYandex() {
        Log.setLevel(Level.INFO);
        DOMConfigurator.configure("log4j.xml");
    }

    static int count = 0;
    WebDriver driver;
    //    electronic
    By topMenu = By.xpath("/html/body/div/div[2]");
    //    catalog
    By catalogMenu = By.xpath("/html/body/div/div[4]/div[1]");
    //    filtr
    By filtrPanel = By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[1]/div");
    //    manufacturers
    By prodactPanel = By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[1]/div/div[4]");
    By performButton = By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[1]/div/div[23]/div[1]/button");
    By searchPanel = By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]");
    By searchFild = By.id("header-search");
    //    searched product
    By titleItem = By.className("n-title__text");


    public void setDriver(WebDriver driver) {
        this.driver = driver;
        Log.info("драйвер получен");
    }

    void clikcTopMenuItem(String item) {

        WebElement menuItem = driver.findElement(topMenu);
        List<WebElement> menuItems = menuItem.findElements(By.tagName("li"));
        for (WebElement q : menuItems) {
            if (q.getText().contains(item)) {
                Log.info("получили " + item + " кликнули " + q.getText());
                screenshot();
                q.click();
                break;
            }
        }


    }

    void clikcCatalogMenuItem(String item) {
        WebElement menuItem = driver.findElement(catalogMenu);
        List<WebElement> menuItems = menuItem.findElements(By.tagName("a"));
        for (WebElement q : menuItems) {
            if (q.getText().contains(item)) {
                Log.info("получили " + item + " кликнули " + q.getText());
                screenshot();
                q.click();
                break;
            }
        }
    }

    void priceBefore(Integer price, boolean clikc) {
        WebElement menuItem = driver.findElement(filtrPanel);
        List<WebElement> menuItems = menuItem.findElements(By.id("glf-pricefrom-var"));
        menuItems.get(0).sendKeys(price.toString());
        Log.info("установили цену от " + price);
        screenshot();
        if (clikc) {
            menuItems.get(0).sendKeys(Keys.ENTER);
        }


    }

    void ceckProdact(String... prodact) {

        Actions builder = new Actions(driver);

        WebElement menuItem = driver.findElement(prodactPanel);
        List<WebElement> menuItems = menuItem.findElements(By.tagName("label"));
        for (WebElement q : menuItems) {
            for (String w : prodact) {

                if (q.getText().equals(w)) {
                    screenshot();
                    builder.moveToElement(q).click(q);
                    Action mouseoverAndClick = builder.build();
                    mouseoverAndClick.perform();
                    Log.info("поизводитель " + q.getText() + "   " + w);
                }
            }
        }

    }

    void clickPerfomButton() {
        WebElement button = driver.findElement(performButton);

        Actions builder = new Actions(driver);
        builder.moveToElement(button);
        screenshot();
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();

    }

    WebElement getItemSearchPanel(int index) {
        WebElement panel = driver.findElement(searchPanel);
        List<WebElement> items = panel.findElements(By.className("snippet-card__content"));
        Log.info("номер в результатах поиска " + index);
        return items.get(index);
    }

    int getCountItemSearchPanel() {
        WebElement panel = driver.findElement(searchPanel);
        List<WebElement> items = panel.findElements(By.className("snippet-card__content"));
        Log.info("число найденых моделей " + items.size());
        return items.size();
    }

    void searchFild(String reqwest) {
        WebElement fild = driver.findElement(searchFild);
        fild.sendKeys(reqwest);
        screenshot();
        fild.sendKeys(Keys.ENTER);
        Log.info("ищем модель " + reqwest);
    }

    String titleItem() {
        WebElement title = driver.findElement(titleItem);
        Log.info("нашли модель " + title.getText());
        return title.getText();
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
