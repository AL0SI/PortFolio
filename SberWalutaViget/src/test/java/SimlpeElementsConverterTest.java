import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by q on 07.03.2017.
 */
@Title("тестируем конвертер валют")
@RunWith(value = Parameterized.class)
public class SimlpeElementsConverterTest {
    String pathWebdriver = "c:\\Users\\q\\.m2\\repository\\selenium\\chromedriver.exe";
    String typeWebdriver = "webdriver.chrome.driver";
    static By sourceCalc = By.cssSelector("div[data-reactid='.0.$1.$0.1']");
    static By converter = By.cssSelector("div[data-reactid='.0.$1.$0.0']");
    static By receivingCalc = By.cssSelector("div[data-reactid='.0.$1.$0.2']");
    static By exchangeMethodCalc = By.cssSelector("div[data-reactid='.0.$1.$0.3']");
    static By packageOfServicesCalc = By.cssSelector("div[data-reactid='.0.$1.$0.4']");
    static By show = By.cssSelector("button[data-reactid='.0.$1.$0.6.0']");
    static By showResponce = By.cssSelector("span[data-reactid='.0.$1.$1.1.0']");
    static String fileName = "C:\\Users\\q\\IdeaProjects\\SberTeh\\src\\test\\java\\resources\\ground.csv";
    String currencyFrom;
    String currencyIn;
    String source;
    String receiving;
    String methodOfExchange;
    String packageOfServices;
    String data;
    WebDriver driver;
    private String site = "http://www.sberbank.ru/ru/quotes/converter";
    SimlpeElementsConverter simlpeElementsConverter;

    public SimlpeElementsConverterTest(String currencyFrom, String currencyIn, String source, String receiving, String methodOfExchange, String packageOfServices, String data) {
        this.currencyFrom = currencyFrom;
        this.currencyIn = currencyIn;
        this.source = source;
        this.receiving = receiving;
        this.methodOfExchange = methodOfExchange;
        this.packageOfServices = packageOfServices;
        this.data = data;

    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        Collection<String[]> getTestData = getTestData(fileName);

        return getTestData;
    }

    public static Collection<String[]> getTestData(String fileName)
            throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String record;
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        while ((record = file.readLine()) != null) {
            String fields[] = record.split(",");

            records.add(fields);
        }
        file.close();
        return records;
    }


    @Before
    public void before() {
        simlpeElementsConverter = new SimlpeElementsConverter();
        System.setProperty(typeWebdriver, pathWebdriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(site);
        simlpeElementsConverter.setDriver(driver);
    }

    @After
    public void after() {
        driver.close();
        driver = null;
    }
    @Description("тест конвертера")
    @Title("тест конвертера")
    @Test
    public void test() {
//        testConverter(currencyFrom, currencyIn, data);
//        testSource(source);
//        testReceiving(receiving);
//        testExchangeMethod(methodOfExchange);
//        testPakage(packageOfServices);
//
//        testResponce();

    }

    @Description("устанавливаем пару валю и сумму конвертации и проверяем это")
    @Step("устанавливаем пару валют {0} {1} и сумму {2} конвертации и проверяем это")
    public void testConverter(String currencyFrom,String currencyIn,String data) {

        simlpeElementsConverter.setPachName(converter);
        assertTrue(simlpeElementsConverter.setParametersConverter(currencyFrom, currencyIn, data));}

   @Description("устанавливаем источник и проверяем это")
    @Step("устанавливаем источник {0} и проверяем это")
   public void testSource(String source) {
        simlpeElementsConverter.setPachName(sourceCalc);
        assertTrue(simlpeElementsConverter.clickByName(source));
    }

   @Description("устанавливаем метод получения  и проверяем это")
    @Step("устанавливаем метод получения {0}  и проверяем это")
   public void testReceiving(String receiving) {
        simlpeElementsConverter.setPachName(receivingCalc);
        assertTrue(simlpeElementsConverter.clickByName(receiving));
    }

   @Description("устанавливаем способ обмена и проверяем это")
    @Step("устанавливаем способ обмена и проверяем это")
   public void testExchangeMethod(String methodOfExchange) {
        simlpeElementsConverter.setPachName(exchangeMethodCalc);
        assertTrue(simlpeElementsConverter.clickByName(methodOfExchange));
    }

   @Description("устанавливаем пакет услуг и проверяем это")
    @Step("устанавливаем пакет услуг {0} и проверяем это")
   public void testPakage(String packageOfServices) {
        simlpeElementsConverter.setPachName(packageOfServicesCalc);
        assertTrue(simlpeElementsConverter.clickByName(packageOfServices));
    }



   @Description("проверяем полученный результат")
    @Step("проверяем полученный результат")
   public void testResponce() {
       simlpeElementsConverter.setPachName(show);
       simlpeElementsConverter.show();
       new WebDriverWait(driver,10);
       simlpeElementsConverter.setPachName(showResponce);
       String a = simlpeElementsConverter.showGetText().replaceAll(" ", "");

       System.out.println(driver.findElement(showResponce).getText()+"   testResponce()");


            assertTrue(a.contains(data));
   }


}