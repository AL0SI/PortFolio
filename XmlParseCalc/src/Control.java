import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

/**
 * Created by q on 18.07.2016.
 */
public class Control {
  static   String wayxsd = "";
   static String wayxml = "";
   static String string=" ";
 void sheme(File file) {
        wayxsd = file.getAbsolutePath();
    }

    public void calc(File file) {
        wayxml = file.getAbsolutePath();
    }

    public String valid() throws IOException, SAXException {
        if (wayxml.equals("") || wayxsd.equals("")) return "1";
        else if (XmlValid.xmlvalid(wayxml, wayxsd)) return "3";
        return "2";
    }

    public void calculate() throws SAXException, TransformerException, ParserConfigurationException, IOException {

        XmlRstack.setname(wayxml, wayxsd);
        XmlRstack.start();
    }
    static void rezult(String str){
        string=string+str+"\r\n";


    }
    static void setrezult(){
        MainFrame.setrezult("Файл расположен : "+System.getProperty("user.dir")
                + File.separator+"\r\n"+"ResultsampleTest.xml"+"\r\n"+string);
    }
}
