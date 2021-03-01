import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class zad3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<form action=\"zad3\" method=\"get\">" +
                "Введите слово: " +
                "<span style=\"padding-left: 10px\">" +
                "<input type=\"text\" name=\"word\">" +
                "</span>" +
                "<input type=\"submit\" value=\"Отправить\">" +
                "</form>"
        );


        String word = request.getParameter("word");

        int counter = 0;
        String text = FileUtils.readFileToString(new File("D:\\bd.txt"), Charset.defaultCharset());

        String[] words = text.split(" ");
        for (String t : words
                ) {
            if (t.trim().equals(word.trim()))
                counter++;
        }

        if(counter > 0) {
            out.println("<br><br>" +
                    "Слово найдено! Встретилось: " +
                    counter +
                    " раз"
            );
        }else{
            out.println("<br><br>" +
                    "Слово не найдено!"
            );
        }
    }
}
