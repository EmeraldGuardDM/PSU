package voter;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.print.attribute.IntegerSyntax;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nikich on 22.04.2016.
 */
public class VoterHandling {
    private static int voteNumber;
    private final static String filename = "D:\\Uni\\ПДИ\\lab6\\web\\db.xml";
    public static String setMaxVotes() throws IOException, SAXException, ParserConfigurationException {
        Document doc = openXml();
        int maxVotes = doc.getElementsByTagName("vote").getLength();

        Random random = new Random();
        voteNumber = random.nextInt(maxVotes);
        return "";
    }

    public static Document openXml() throws ParserConfigurationException, IOException, SAXException {
        File inputFile = new File(filename);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        return doc;
    }

    public static String getOptionString(int option) throws IOException, SAXException, ParserConfigurationException {
        Document doc = openXml();
        NodeList nList = doc.getElementsByTagName("vote");
        Node nNode = nList.item(voteNumber);
        Element element = (Element) nNode;
        return element.getAttribute("question"+option);
    }

    public static String getVoteNumber(){
        return Integer.toString(voteNumber);
    }
    public static int getVotedUsers(int mode) throws IOException, SAXException, ParserConfigurationException {
        Document doc = openXml();
        NodeList nList = doc.getElementsByTagName("answer");
        int count = 0;
        for (int i=0; i<nList.getLength();i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                if (eElement.getAttribute("id").equals(Integer.toString(voteNumber))) {
                    if (mode == 4) {
                        count++;
                    } else if (eElement.getAttribute("answer").equals(Integer.toString(mode))) count++;
                }
            }
        }

        return count;
    }
}
