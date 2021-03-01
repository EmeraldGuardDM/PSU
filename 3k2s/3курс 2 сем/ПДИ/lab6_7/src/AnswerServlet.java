import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import voter.VoterHandling;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Date;

/**
 * Created by Nikich on 25.04.2016.
 */
@WebServlet("/answer")
public class AnswerServlet extends HttpServlet {

    private final static String filename = "D:\\Uni\\ПДИ\\lab6\\web\\db.xml";
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        String answer = request.getParameter("vote");
        String votenumbet = request.getParameter("votenumber");

        Document doc = null;
        try {
            doc = VoterHandling.openXml();
            Node node = doc.getFirstChild();
            Element element = doc.createElement("answer");
            element.setAttribute("id", votenumbet);
            element.setAttribute("answer", answer);
            element.setAttribute("time", Long.toString(System.currentTimeMillis()));
            node.appendChild(element);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new StringWriter());
            transformer.transform(source, result);
            PrintWriter outputStream = new PrintWriter(filename);
            outputStream.print(result.getWriter().toString());
            outputStream.close();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
