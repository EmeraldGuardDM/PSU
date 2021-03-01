import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.awt.geom.Arc2D;
import java.io.*;
import java.math.MathContext;


/**
 * Created by Nikich on 25.04.2016.
 */
public class task4figureResult extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        int figure = -1;

        try{
            figure = Integer.parseInt(request.getParameter("figure"));
        }catch (Exception e){}

        double result = 0.0;

        if(figure == 0){
            double dl = Double.parseDouble(request.getParameter("dl"));
            result = Math.pow(dl, 3);
        }

        if(figure == 1){
            double rd = Double.parseDouble(request.getParameter("rd"));
            result = 4.0/3.0*Math.PI*Math.pow(rd, 3);
        }

        int accuracy = 0;
        try {
            accuracy = Integer.parseInt(request.getParameter("accuracy"));
        }
        catch (Exception e){
        }

        PrintWriter out = response.getWriter();
        if(figure != -1)
            out.format("<h1>Результат: %."+accuracy+"f </h1>", result);
    }
}
