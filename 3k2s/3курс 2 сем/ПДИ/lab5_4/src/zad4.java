import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

public class zad4 extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<form action=\"zad4figure\" method=\"get\">" +
                "<span style=\"padding-left: 10px\">" +
                "Выберите фигуру: " +
                "<select name=\"figure\">"+
                "<option value=\"0\">куб</option>" +
                "<option value=\"1\">сфера</option>" +
                "</select>" +
                "</span>" +
                "<input type=\"submit\" name=\"submit\" value=\"Отправить\">"+
                "</form>"
        );
    }
}
