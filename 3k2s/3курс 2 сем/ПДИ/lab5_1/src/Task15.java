import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import static javax.xml.bind.DatatypeConverter.parseInt;

/**
 * Created by Nikich on 20.04.2016.
 */
public class Task15 extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        int number = 0;

        try {
            number = parseInt(request.getParameter("field"));
        } catch (Exception e) {
            number = 0;
        }

        if (number != 0) {
            Game.gamerMove(number-1);
            Game.compMove();
        }

        String strings[] = new String[9];
        for(int i =0; i<9; i++) {
            int state = Game.checkField(i);
            if (state == 1) {
                strings[i] = "<p style=\"text-align:center; font-size: 36\">X</p>";
            }
            if (state == 2) {
                strings[i] = "<p style=\"text-align:center; font-size: 36\">0</p>";
            }
            if (state == 3) {
                strings[i] = "<form action=\"Task15\" method=\"get\"><input type=\"hidden\" name=\"field\" value=\""+(i+1)+"\"> <button style=\"width: 50; height: 50\"></button></form>";
            }
        }
        out.println(
                "<table width=\"150\" height=\"150\">" +
                        "<tr>" +
                        "<td width=\"50\" height=\"50\">" + strings[0] + "</td>" +
                        "<td width=\"50\" height=\"50\">" + strings[1] + "</td>" +
                        "<td width=\"50\" height=\"50\">" + strings[2] + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td width=\"50\" height=\"50\">" + strings[3] + "</td>" +
                        "<td width=\"50\" height=\"50\">" + strings[4] + "</td>" +
                        "<td width=\"50\" height=\"50\">" + strings[5] + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td width=\"50\" height=\"50\">" + strings[6] + "</td>" +
                        "<td width=\"50\" height=\"50\">" + strings[7] + "</td>" +
                        "<td width=\"50\" height=\"50\">" + strings[8] + "</td>" +
                        "</tr>" +
                        "</table>");

        switch (Game.checkEndGame()){
            case 1: out.println("<p style=\"text-align: center; font-size:36pt\"> Поздравляем! Вы победили!</p>");
                //out.println("<button style=\"width: 150; height: 50\" onClick=\"window.location =\"localhost:8080\\Task15\"\">Попробовать еще раз </button>");
                Game.restart();
                break;
            case 2: out.println("<p style=\"text-align: center; font-size:36pt\"> Вы проиграли!</p>");
                Game.restart();
                break;
            case 3: out.println("<p style=\"text-align: center; font-size:36pt\"> Ничья!</p>");
                Game.restart();
                break;
        }
    }

}
