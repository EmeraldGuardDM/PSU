import library.LibraryHandl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
    private final static String filename = "D:\\Uni\\ПДИ\\lab6_6\\web\\db.xml";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Document doc = null;
        try {
            String id = request.getParameter("id");
            doc = LibraryHandl.openXml();
            NodeList nList = doc.getElementsByTagName("book");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getAttribute("id").equals(id)) {
                        eElement.setAttribute("free", Integer.toString(0));
                        eElement.setAttribute("date", Long.toString(new Date(System.currentTimeMillis()).getTime() + 604800*1000));
                    }
                }
            }

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
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
