import org.junit.After;
import org.junit.Before;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by q on 17.07.2016.
 */
@RunWith(Suite.class)
   @Suite.SuiteClasses( { XmlValidTest.class,XmlRstackTest.class,XmlGenTest.class,ControlTest.class})
   public class Suita {

}
