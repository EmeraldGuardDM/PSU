import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;


/**
 * Created by Nikich on 25.04.2016.
 */
public class task2 extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        double value = -1;
        int type = 0;
        int func = 0;
        int accuracy = 0;
        try {
            value = Double.parseDouble(request.getParameter("val"));
            type = Integer.parseInt(request.getParameter("type"));
            func = Integer.parseInt(request.getParameter("func"));
            accuracy = Integer.parseInt(request.getParameter("accuracy"));
        }
        catch (Exception e){
        }

        if(type == 1)
            value = Math.toRadians(value);

        double result = 0.0;

        switch (func){
            case 0:
                result = Math.cos(value);
                break;
            case 1:
                result = Math.sin(value);
                break;
            case 2:
                result = Math.tan(value);
                break;
            case 3:
                result = Math.acos(value);
                break;
            case 4:
                result = Math.asin(value);
                break;
            case 5:
                result = Math.atan(value);
                break;
        }

        PrintWriter out = response.getWriter();
        out.println("<form action=\"task2\" method=\"get\">" +
                "<input type=\"text\" name=\"val\" value=\"0\">"+
                "<span style=\"padding-left: 10px\">" +
                "<select name=\"type\">"+
                "<option value=\"0\">Радианы</option>" +
                "<option value=\"1\">Градусы</option>" +
                "</select>" +
                "</span>" +
                "<span style=\"padding-left: 10px\">" +
                "<select name=\"func\">"+
                "<option value=\"0\">sin</option>" +
                "<option value=\"1\">cos</option>" +
                "<option value=\"2\">tan</option>" +
                "<option value=\"3\">acos</option>" +
                "<option value=\"4\">asin</option>" +
                "<option value=\"5\">atan</option>" +
                "</select>" +
                "</span>" +
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
                "</form>" +
                "<br><br>"
        );
        if(value != -1)
            out.format("<h1>Результат: %."+accuracy+"f </h1>", result);
    }
}
