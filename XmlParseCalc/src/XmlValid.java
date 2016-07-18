import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.File;
import org.xml.sax.SAXException;

/**
 * Created by q on 14.07.2016.
 */
public class XmlValid {

    public static boolean xmlvalid(String xmL, String xsD) throws SAXException, IOException {
        File xml = new File(xmL);
       File xsd = new File(xsD);
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator()
                    .validate(new StreamSource(xml));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
