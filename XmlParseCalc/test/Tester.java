import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by q on 17.07.2016.
 */
public class Tester extends XmlRstack{
    static Node nod;

    public static void main(String[] args) throws ParserConfigurationException {
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


        System.out.println(test(root).getNodeName());
    }

   public static Node test(Node node){

        setSiblingParent(node);
        return nod;

    }



    public static void reznode(Node node) {


       nod= node;

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


}
