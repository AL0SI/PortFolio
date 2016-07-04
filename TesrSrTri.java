/**
 * Created by q on 03.07.2016.
 */

import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//import static junit.framework.Assert.assertTrue;


public class TesrSrTri extends Assert   {
    SrTri sr;

    public static void main(String[] args) {
        JUnitCore runner=new JUnitCore();
        Result result=runner.run(SrTri.class);
        System.out.println("pusk"+result.getRunCount());
        System.out.println("heppi"+result.wasSuccessful());
        System.out.println("fail"+result.getFailures());
System.out.println("failcount"+result.getFailureCount());
System.out.println("f1"+result.getRunTime());

    }
    @Before
    public void testIni() {
        System.out.println("1");
        sr = new SrTri();
    }

    @After    public void testClose() {
        System.out.println("2");
        sr = null;
    }

    @Test    public void testSr() {
        System.out.println("3");
        assertFalse("1",sr.sr(1, 2) == 2);
        assertFalse(sr.sr(1, 3) == 3);
        assertFalse(sr.sr(1, 4) == 4);

    }
    @Test   public void testSrm(){
        System.out.println("4");
        assertTrue(sr.srm(1, 4) == 1);
        assertTrue(sr.srm(4, 4) == 4);
        assertTrue(sr.srm(4, 3) == 3);
        assertTrue(sr.srm(1, 0) == 1);
    }

}
