import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Created by Nikich on 25.04.2016.
 */
public class task14 extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String value = request.getParameter("values");
        String results = "";
        try {
            String[] values = value.split(",");

            ArrayList<Integer> intList = new ArrayList<>();
            for (String x : values
                    ) {
                intList.add(Integer.parseInt(x.trim()));
            }
            Collections.sort(intList);
            results = "";
            for (int x : intList
                    ) {
                results += Integer.toString(x);
                results += " ";
            }
        }catch (Exception e){

        }
        PrintWriter out = response.getWriter();
        out.println("<form action=\"task14\" method=\"get\">" +
                "<span style=\"padding-left: 10px\">" +
                "Введите массив: " +
                "<input type=\"text\" name=\"values\" value=\"0\">" +
                "</span>" +
                "<input type=\"submit\" value=\"Отправить\">"+
                "</form>"+
                "<br><br>" +
                "<h1>Результат: </h1>"+
                results
        );

    }
}
