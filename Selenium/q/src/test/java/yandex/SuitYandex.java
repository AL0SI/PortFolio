package yandex;

/**
 * Created by q on 01.03.2017.
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import yandex.pages.HeadPhoneTest;
import yandex.pages.TvTest;

/**
 * Created by q on 20.02.2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TvTest.class, HeadPhoneTest.class})
public class SuitYandex {
    public static void main(String[] args) {

    }
}
