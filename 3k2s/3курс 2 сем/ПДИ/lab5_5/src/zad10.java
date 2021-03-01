import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class zad10 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        int step = 0;
        try{
            step = Integer.parseInt(request.getParameter("step"));
            String vote = request.getParameter("vote");
            if(step >3){
                out.println("<div style=\"width: 100px; float: left;padding: 5px\">" +
                        "Вы ответили на все вопросы!" +
                        "</div>"
                );
            } else {
                if (vote.equals("0")) {
                    out.println("<div style=\"width: 100px; float: left;padding: 5px\">" +
                            "<form action=\"zad10\" method=\"get\">\n" +
                            "<input type=\"radio\" name=\"vote\" value=\"0\">да"+Integer.toString(step)+"\n" +
                            "    <br>\n" +
                            "    <input type=\"radio\" name=\"vote\" value=\"1\">нет"+Integer.toString(step)+"\n" +
                            "<input type=\"hidden\" name=\"step\" value=\"" + Integer.toString(step + 1) + "\">" +
                            "<input type=\"submit\" value=\"Проголосовать\">"+
                            "  </form>" +
                            "</div>"
                    );
                } else {
                    out.println("<div style=\"width: 100px; float: left;padding: 5px\">" +
                            "<form action=\"zad10\" method=\"get\">\n" +
                            "<input type=\"radio\" name=\"vote\" value=\"0\">да"+Integer.toString(step)+"\n" +
                            "    <br>\n" +
                            "    <input type=\"radio\" name=\"vote\" value=\"1\">нет"+Integer.toString(step)+"\n" +
                            "<input type=\"hidden\" name=\"step\" value=\"" + Integer.toString(step + 2) + "\">" +
                            "<input type=\"submit\" value=\"Проголосовать\">"+
                            "  </form>" +
                            "</div>"
                    );
                }
            }
        }catch (Exception e){
            out.println("<div style=\"width: 100px; float: left;padding: 5px\">" +
                    "<form action=\"zad10\" method=\"get\">\n" +
                    "<input type=\"radio\" name=\"vote\" value=\"0\">да0\n" +
                    "    <br>\n" +
                    "    <input type=\"radio\" name=\"vote\" value=\"1\">нет0\n" +
                    "<input type=\"hidden\" name=\"step\" value=\"1\">"+
                    "<input type=\"submit\" value=\"Проголосовать\">"+

                    "  </form>" +
                    "</div>"
            );
        }
    }
}
