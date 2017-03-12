import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by q on 10.03.2017.
 */@Title("class A")
public class A {
     @Step
    String  metod(String argument){
        return  argument;
    }
}
