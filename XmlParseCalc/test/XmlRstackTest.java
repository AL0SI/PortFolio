import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.*;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import java.io.File;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by q on 17.07.2016.
 */
public class XmlRstackTest {
    static XmlRstack xmlRstack;
@Before public void bef(){
    xmlRstack = new XmlRstack();
}
@After public void af(){
    xmlRstack=null;
}





    @Test
    public void validtest() throws Exception {
        assertTrue(xmlRstack.valid());

    }

    @Test
    public void ini() throws Exception {

        xmlRstack.ini();
        assertTrue("документ создан ", xmlRstack.doc != null);


    }


    @Test
    public void setSiblingParent() throws Exception {
// test call method reznode() from method setSiblingParent()
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document mockdoc = builder.newDocument();
        Element root = mockdoc.createElement("root");
        Element root1 = mockdoc.createElement("root1");
        Element root2 = mockdoc.createElement("root2");
        Element root12 = mockdoc.createElement("root12");
        Element root22 = mockdoc.createElement("root22");

        mockdoc.appendChild(root);
        root.appendChild(root1);
        root.appendChild(root2);
        root1.appendChild(root12);
        root1.appendChild(root22);

        Tester tester=new Tester();
       assertFalse(tester.test(root)==root1);
       assertFalse(tester.setSiblingParent(root)==root1);


    }

    @Test
    public void sibling() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document mockdoc = builder.newDocument();

        Element root = mockdoc.createElement("root");
        Element root1 = mockdoc.createElement("root1");
        Element root2 = mockdoc.createElement("root2");

        mockdoc.appendChild(root);
        root.appendChild(root1);
        root.appendChild(root2);


        assertTrue(xmlRstack.sibling(root1) == root2);
        assertTrue(xmlRstack.sibling(root) != root2);
        assertTrue(xmlRstack.sibling(root) != root1);
        assertTrue(xmlRstack.sibling(root1) != root1);
        assertTrue(xmlRstack.sibling(root2) != root);
    }

    @Test(expected = NumberFormatException.class)
    public void convert() throws Exception {

        assertTrue(xmlRstack.convert("132") == 132.0);
        assertTrue(xmlRstack.convert("-132") == -132.0);
        assertTrue(xmlRstack.convert("0.132") == 0.132);

        xmlRstack.convert("qq");
    }

    @Test
    public void rez() throws Exception {

        assertFalse(xmlRstack.rez("2", "2", "SUM") == "4.0");
        assertFalse(xmlRstack.rez("2", "2", "SUB") == "0.0");
        assertFalse(xmlRstack.rez("3", "2", "MUL") == "6.0");
        assertFalse(xmlRstack.rez("6", "2", "DIV") == "3.0");


    }



}