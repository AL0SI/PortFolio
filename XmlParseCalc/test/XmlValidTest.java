import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by q on 17.07.2016.
 */
public class XmlValidTest {
    String way = System.getProperty("user.dir") + "\\filetest" + File.separator;
    String tru = way + "Test.xml";
       String she = way + "Calculator.xsd";

    @Test
    public void xmlvalidTest() throws Exception {
        XmlValid xmlValid = new XmlValid();
        assertEquals(xmlValid.xmlvalid(tru, she), true);



    }

}