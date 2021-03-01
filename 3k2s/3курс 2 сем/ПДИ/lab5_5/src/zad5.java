import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class zad5 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<form action=\"zad5\" method=\"get\">" +
                "Ищем: " +
                "<span style=\"padding-left: 10px\">" +
                "<input type=\"text\" name=\"word\">" +
                "</span>" +
                "<br>"+
                "Заменяем: " +
                "<span style=\"padding-left: 10px\">" +
                "<input type=\"text\" name=\"word2\">" +
                "</span>" +
                "<br>"+
                "Поиск по: "+
                "<span style=\"padding-left: 10px\">" +
                "<select name=\"field\">"+
                "<option selected value=\"key\">Ключ</option>"+
                "<option value=\"value\">Значение</option>"+
                "</select>"+
                "</span>"+
                "<br>"+
                "Замена: "+
                "<span style=\"padding-left: 10px\">" +
                "<select name=\"replace\">"+
                "<option selected value=\"key\">Ключ</option>"+
                "<option value=\"value\">Значение</option>"+
                "</select>"+
                "</span>"+
                "<br>"+
                "<input type=\"submit\" value=\"Отправить\">" +
                "</form>"
        );

        collection.init();
        try{
            String result = "<br>";
            String word = request.getParameter("word");
            String word2 = request.getParameter("word2");
            String field = request.getParameter("field");
            String replace = request.getParameter("replace");
            if(field.equals("key")){
                if(collection.map.containsKey(word)){
                    result += "Ключ найден и";
                    if(replace.equals("value")){
                        collection.map.replace(word, word2);
                        result += "значение изменено<br>";
                    }
                    else{
                        collection.map.put(word2, collection.map.get(word));
                        collection.map.remove(word);
                        result += "ключ изменен<br>";
                    }
                }
            }
            out.print(result);
        }catch (Exception e){}

        out.println("<br>"+
                "<table width=\"300px\" border=\"1\" cellspacing=\"2\">" +
                "<tr>" +
                "<td width=\"50%\">Ключ</td>" +
                "<td>Значение</td>" +
                "</tr>"+
                collection.getMapHtml()+
                "</table>");
    }
}
