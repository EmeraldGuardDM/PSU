import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import voter.VoterHandling;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Nikich on 25.04.2016.
 */
@WebServlet("/statistic")
public class StatisticServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Document doc = VoterHandling.openXml();
            NodeList nList = doc.getElementsByTagName("answer");
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            for (int i=0; i<nList.getLength();i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    out.print("id: " + eElement.getAttribute("id") +
                    " answer: " + eElement.getAttribute("answer")+
                    " time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Long.parseLong(eElement.getAttribute("time")))+
                    "<br>");
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
