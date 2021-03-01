import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nikich on 22.04.2016.
 */
public class Task16 extends HttpServlet {

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, java.io.IOException {

        getServletContext().getRequestDispatcher("/Task16.jsp").forward(request, response);
    }
}
