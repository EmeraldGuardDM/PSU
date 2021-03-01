import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

public class zad4figure extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        int figure = -1;

        try{
            figure = Integer.parseInt(request.getParameter("figure"));
        }catch (Exception e){}


        String str = "";

        switch (figure){
            case 0:
                str = "<span>Длина стороны: <input type=\"text\" name=\"dl\" value=\"0\">"+
                        "<input type=\"hidden\" name=\"figure\" value=\"0\">"+
                        "</span>";
                break;
            case 1:
                str = "<span>Радиус шара: <input type=\"text\" name=\"rd\" value=\"0\">"+
                        "<input type=\"hidden\" name=\"figure\" value=\"1\">"+
                        "</span>";
                break;
        }

        PrintWriter out = response.getWriter();
        out.println("<form action=\"zad4figureResult\" method=\"get\">" +
                str +
                "<span style=\"padding: 10px\">" +
                "Точность: " +
                "<select name=\"accuracy\">"+
                "<option value=\"0\">0</option>" +
                "<option value=\"1\">1</option>" +
                "<option value=\"2\">2</option>" +
                "<option value=\"3\">3</option>" +
                "<option value=\"4\">4</option>" +
                "<option value=\"5\">5</option>" +
                "</select>" +
                "</span>" +
                "<input type=\"submit\" name=\"submit\" value=\"Отправить\">"+
                "</form>"
        );
    }
}
