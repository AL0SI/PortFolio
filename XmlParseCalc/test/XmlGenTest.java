import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by q on 17.07.2016.
 */
public class XmlGenTest {
    XmlGen xmlGen;

    @Before
    public void bef() {
        xmlGen = new XmlGen();

    }

    @After
    public void af() {
        xmlGen = null;
    }



    @Test
    public void expressionResult() throws Exception {

        assertNotNull(xmlGen.genXml());// test genXml()
        xmlGen.genXml();
        xmlGen.expressionResult("rezult");//test expressionResult();
        xmlGen.expressionResult("1111");
        assertTrue(xmlGen.doc.getFirstChild().getFirstChild().getFirstChild().getFirstChild().getFirstChild().getTextContent() == "rezult");
        assertTrue(xmlGen.doc.getFirstChild().getFirstChild().getFirstChild().getNextSibling().getFirstChild().getTextContent()=="1111");
        assertTrue(xmlGen.doc.getFirstChild().getFirstChild().getFirstChild().getNodeName()=="expressionResult");
        assertTrue(xmlGen.doc.getFirstChild().getFirstChild().getNodeName()=="expressionResults");
        assertTrue(xmlGen.doc.getFirstChild().getNodeName()=="simpleCalculator");
        xmlGen.FILENAME="test.xml";

        xmlGen.write();
        assertTrue(new File(xmlGen.way+xmlGen.FILENAME).exists());

    }



}