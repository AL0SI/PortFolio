import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by q on 18.07.2016.
 */
public class ControlTest {
    Control control;
    @Before public void bef(){
        control=new Control();
    }
    @After public void af(){
        control=null;
    }
    @Test
    public void sheme() throws Exception {


        String way =System.getProperty("user.dir") + File.separator+ "C.xsd";
        File file = new File(way ); file.createNewFile();

        control.sheme(file);


        assertEquals(way,control.wayxsd);
    }

    @Test
    public void calc() throws Exception {

        String way =System.getProperty("user.dir") + File.separator+"filetest"+ File.separator+"C.xsd";
        File file = new File(way ); file.createNewFile();

        control.calc(file);


        assertEquals(way,control.wayxml);
        if(!file.delete())
            System.out.println("Delete failed");
    }

    @Test
    public void valid() throws Exception {
       control.wayxsd = "";
        control.wayxml = "";
assertEquals("1",control.valid());
    }

    @Test
    public void calculate() throws Exception {
        XmlRstack xmlRstack=new XmlRstack();
        control.wayxml="q\\1";
        control.wayxsd="w\\2";
       xmlRstack.setname(control.wayxml,control.wayxsd);
        assertEquals("1",XmlRstack.FILENAME);
        assertEquals("q\\",XmlRstack.way);
        assertEquals("2",XmlRstack.SHEMA);
        assertEquals("w\\",XmlRstack.wayxsd);
        xmlRstack=null;

    }

    @Test
    public void rezult() throws Exception {
        control.string="";
        assertEquals("",control.string);
        control.rezult("1");
         control.rezult("2");
        assertEquals("1\r\n2\r\n",control.string);
    }



}