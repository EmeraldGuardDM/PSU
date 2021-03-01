package handl;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class handl {
    private final static String filename = "D:\\db.xml";

    public static Document openXml() throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(filename);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        return doc;
    }

    public static String getTovar() throws IOException, SAXException, ParserConfigurationException {
        Document doc = openXml();
        NodeList nList = doc.getElementsByTagName("tovar");
        String result = "";
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                result += "<tr>" +
                        "<td>" + eElement.getAttribute("tovar") + "</td>" +
                        "<td>" + eElement.getAttribute("col") + "</td>" +
                        "</tr>";
            }
        }
        return result;
    }
}
