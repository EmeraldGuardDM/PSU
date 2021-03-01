import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class zad12 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<form action=\"zad12\" method=\"get\">\n" +
                "Размер шрифта: <input type=\"number\" name=\"sz\" >"+
                "Кол-воо строк: <input type=\"number\" name=\"cl\" >"+
                "<br><input type=\"submit\" value=\"отправить\">"+
                "  </form>"
        );
        try {
            ArrayList<String> text = new ArrayList<String>();
            int sz = Integer.parseInt(request.getParameter("sz"));
            int cl = Integer.parseInt(request.getParameter("cl"));
            for (int i = 0; i < cl; i++)
                text.add("saddsfsadfasfas" + Integer.toString(i));

            String result = "<br><br>";
            for (String x : text
                    ) {
                result += "<span style=\"font-size:" + Integer.toString(sz) + "pt;\">" + x + "</span><br>";
            }
            out.println(result);
        }catch (Exception e){}
    }
}
