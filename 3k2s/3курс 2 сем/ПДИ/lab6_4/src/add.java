import handl.handl;
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

@WebServlet("/add")
public class add extends HttpServlet {

    private final static String filename = "D:\\db.xml";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String tovar = request.getParameter("tovar");
            int col = Integer.parseInt(request.getParameter("col"));

            Document doc = handl.openXml();
            NodeList nList = doc.getElementsByTagName("tovar");
            boolean isFound = false;
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getAttribute("tovar").equals(tovar)) {
                        eElement.setAttribute("col", Integer.toString(Integer.parseInt(eElement.getAttribute("col")) + col));
                        isFound = true;
                    }
                }
            }

            if(!isFound){
                Node node = doc.getFirstChild();
                Element element = doc.createElement("tovar");
                element.setAttribute("tovar", tovar);
                element.setAttribute("col", Integer.toString(col));
                node.appendChild(element);
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
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
