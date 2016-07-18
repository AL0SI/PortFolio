import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * Created by q on 15.07.2016.
 */
public class XmlGen {
    static Document doc;
    static Element expressionResults;
    public static  String FILENAME = "ResultsampleTest.xml";
    public static String way=System.getProperty("user.dir")
            + File.separator;

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        genXml();
        expressionResult("13131");
  expressionResult("135435131");
  expressionResult("1314rerr31");
  expressionResult("13rer131");
        write();
    }


    public static Document genXml() throws IOException, ParserConfigurationException, SAXException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
         doc = factory.newDocumentBuilder().newDocument();

        Element rootElement = doc.createElement("simpleCalculator");
        doc.appendChild(rootElement);

       expressionResults = doc.createElement("expressionResults");
        rootElement.appendChild(expressionResults);
        return doc;








    }
    public static void expressionResult(String string){

        Control.rezult(string);
        Element expressionResult = doc.createElement("expressionResult");
        expressionResults.appendChild(expressionResult);

        Element result = doc.createElement("result");
        result.appendChild(doc.createTextNode(string));
        expressionResult.appendChild(result);

    }
    public static void write() throws TransformerException, IOException {

        final File xmlFile = new File(way + FILENAME);
        xmlFile.createNewFile();
        doc.setXmlStandalone(true);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.CDATA_SECTION_ELEMENTS, "name");
        transformer.transform(new DOMSource(doc), new StreamResult(xmlFile));
        transformer.reset();
        Control.setrezult();
    }
}

