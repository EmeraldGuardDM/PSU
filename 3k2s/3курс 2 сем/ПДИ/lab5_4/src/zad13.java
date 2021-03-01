import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.*;

public class zad13 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<form action=\"zad13\" method=\"get\">" +
                "Введите слово: " +
                "<span style=\"padding-left: 10px\">" +
                "<input type=\"number\" name=\"A\">" + "x+" +"<input type=\"number\" name=\"B\">" + "y+" + "<input type=\"number\" name=\"C\"> = 0"+
                "</span>" +
                "<br>" +
                "Максимальное расстояние: " +
                "<span style=\"padding-left: 10px\">"+
                "<input type=\"number\" name=\"distance\">"+
                "</span>"+
                "<input type=\"submit\" value=\"Отправить\">" +
                "</form>"
        );

        try {
            int a = Integer.parseInt(request.getParameter("A"));
            int b = Integer.parseInt(request.getParameter("B"));
            int c = Integer.parseInt(request.getParameter("C"));
            double maxdistance = Double.parseDouble(request.getParameter("distance"));

            String text = FileUtils.readFileToString(new File("D:\\dots.txt"), Charset.defaultCharset());
            String[] words = text.split("\n");
            out.print("Подходящие точки:");
            for (String t : words
                    ) {
                Scanner scanner = new Scanner(t);
                int mx = scanner.nextInt();
                int my = scanner.nextInt();
                double distance = Math.abs(a*mx + b*my + c) / Math.sqrt(a*a + b*b);
                if(distance < maxdistance){
                    out.print("<br>"+
                    "("+mx+","+my+")");
                }
            }

        }catch (Exception e) {

        }
    }
}
