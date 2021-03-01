package library;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by Nikich on 28.04.2016.
 */
public class LibraryHandl {
    private final static String filename = "D:\\Uni\\ПДИ\\lab6_6\\web\\db.xml";

    public static Document openXml() throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(filename);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        return doc;
    }

    public static String getBooks() throws IOException, SAXException, ParserConfigurationException {
        Document doc = openXml();
        NodeList nList = doc.getElementsByTagName("book");
        String result = "";
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                if (eElement.getAttribute("free").equals(Integer.toString(1))) {
                    result += "<tr>" +
                            "<td>" + eElement.getAttribute("name") + "</td>" +
                            "<form action=\"orderServlet\" method=\"get\">" +
                            "<input type=\"hidden\" name=\"id\" value=\""+eElement.getAttribute("id")+"\">" +
                            "<td align=\"center\"><input type=\"submit\" value=\"Заказать\"></td>" +
                            "</form>" +
                            "</td>"+
                            "</tr>";

                } else {
                    result += "<tr>" +
                            "<td>" + eElement.getAttribute("name") + "</td>" +
                            "<td align=\"center\">" +
                            new SimpleDateFormat("yyyy-MM-dd").format(Long.parseLong(eElement.getAttribute("date"))) +
                            "</td>"+
                            "</tr>";
                }
            }
        }
        return result;
    }
}
