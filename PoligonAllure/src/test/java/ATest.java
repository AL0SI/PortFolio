import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import static org.junit.Assert.*;

/**
 * Created by q on 10.03.2017.
 */
@Title("test clas A")
@Description("testim class")
public class ATest {
    A a;

    @Before
    public void setUp() throws Exception {
        a = new A();
    }

    @After
    public void tearDown() throws Exception {
        a = null;
    }

    @Title("test metod")
    @Description("testim metod")
    @Test
    public void metod() throws Exception {
        assertTrue(a.metod("q") == "q");
        testString();
    }

    @Title("test step")

    @Step
    public void testString() {
        assertEquals(a.metod("test"), "test");
    }

}