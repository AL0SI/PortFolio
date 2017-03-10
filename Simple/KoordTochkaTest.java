import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static org.junit.Assert.*;

/**
 * Created by q on 04.07.2016.
 */
public class KoordTochkaTest {
    KoordTochka k;
    public static void main(String[] args) throws Exception {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(KoordTochka.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }
    @Before public void b(){
        k=new KoordTochka();
    }
    @After
    public void a(){
        k=null;
    }
    @Test
    public void srv() throws Exception {
assertTrue(k.srv(1,1)==1);
 assertTrue(k.srv(-1,1)==2);
 assertTrue(k.srv(-1,-1)==3);
 assertTrue(k.srv(1,-1)==4);
    }

}