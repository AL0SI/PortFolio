/**
 * Created by q on 16.07.2016.
 */

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class XmlRstack {
    static String reult;
    static Stack<Node> stack;
    public static Document doc = null;
    public static String FILENAME = "sampleTest.xml";
    public static String SHEMA = "Calculator.xsd";
    static String way = System.getProperty("user.dir") + File.separator;
    static String wayxsd = System.getProperty("user.dir") + File.separator;


    public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException {

        MainFrame app = new MainFrame();
        app.setVisible(false);

start();

    }
   static void start() throws IOException, SAXException, TransformerException, ParserConfigurationException {
        if (valid()) {

            XmlGen.genXml();
            ini();
            printNod(doc);
        } else {
            System.out.println(" bad file");
        }
    }

    static void ini() {
        try {
            stack = new Stack<>();

            final File xmlFile = new File(way + FILENAME);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(xmlFile);

            doc.getDocumentElement().normalize();


        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static boolean valid() throws IOException, SAXException {
        return XmlValid.xmlvalid(way + FILENAME, wayxsd + SHEMA);

    }


    public static void printNod(Document doc) throws IOException, TransformerException {
        NodeList nodeList = doc.getElementsByTagName("expression");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            printNodes(node);

            printlist(stack);
            XmlGen.write();


        }

    }

    private static void printlist(Stack<Node> stack) {
        stack.pop();
        Collections.reverse(stack);
        for (int i = 0; i < stack.size() - 1; i++)
            reznode(stack.get(i));
        XmlGen.expressionResult(reult);

        stack.clear();

    }


    private static void printNodes(Node node) {
        stack.push(node);

        NodeList nodeList = node.getChildNodes();

        b:
        for (int i = 0; i < nodeList.getLength(); i++) {
            node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {

                if (node.hasChildNodes()) {
                    printNodes(node);
                    break;


                }


            }
            continue b;
        }


    }


    public static void reznode(Node node) {


        Node[] child = child(node);


        String atr = artrib(node);


        node.setTextContent(rez(child[0].getTextContent(), child[1].getTextContent(), atr));

        reult = node.getTextContent();
        node = sibling(node);

        setSiblingParent(node);


    }


    static Node setSiblingParent(Node node) {


        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                if (node.hasChildNodes()) {
                    setSiblingParent(node);

                    reznode(node.getParentNode());

                }
            }


        }
        return node;
    }

    public static String artrib(Node node) {
        if (node.hasAttributes()) {

            NamedNodeMap attributes = node.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                Node attribute = attributes.item(j);

                return attribute.getNodeValue();
            }
        }

        return null;
    }

    public static Node sibling(Node node) {


        NodeList nodeList = node.getParentNode().getChildNodes();

        for (int i = nodeList.getLength() - 1; i > -1; i--) {
            node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {

                return node;


            }
        }


        return node;
    }

    public static Node[] child(Node node) {
        Node[] n = new Node[2];

        NodeList nodeList = node.getChildNodes();

        w:
        for (int i = 0; i < nodeList.getLength(); i++) {
            node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                n[0] = node;

                n[1] = sibling(node);
                if (n[0] == n[1]) break w;


                return n;
            }
        }
        return n;
    }


    public static double convert(String str) {
        return Double.parseDouble(str);
    }

    public static String rez(String re1, String re2, String op) {

        double rez1 = convert(re1);
        double rez2 = convert(re2);

        double rezultat = 0;


        switch (op) {
            case "SUB":
                rezultat = rez1 - rez2;
                break;
            case "SUM":
                rezultat = rez1 + rez2;
                break;
            case "MUL":
                rezultat = rez1 * rez2;
                break;
            case "DIV":
                rezultat = rez1 / rez2;
                break;

        }

        String r = String.valueOf(rezultat);
        return r;

    }

    public static void setname(String calc, String sheme) {

        FILENAME = calc.substring(calc.lastIndexOf(File.separator) + 1);
        way = calc.substring(0,calc.lastIndexOf(File.separator)+1 );
        SHEMA = sheme.substring(sheme.lastIndexOf(File.separator) + 1);
        wayxsd = sheme.substring(0,sheme.lastIndexOf(File.separator) +1);

    }
}
