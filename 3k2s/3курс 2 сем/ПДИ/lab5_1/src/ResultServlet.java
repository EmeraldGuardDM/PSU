import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Nikich on 22.04.2016.
 */
@MultipartConfig(fileSizeThreshold = 1024*1024*2,
                    maxFileSize = 1024*1024*10,
                    maxRequestSize = 1024*1024*50)
public class ResultServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        Part part = request.getPart("file");
        InputStream stream = part.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String text = reader.lines().collect(Collectors.joining("\n"));

        String[] texts = text.split("\n");
        ArrayList<String> listStr = new ArrayList<>();
        for (int i=0; i< texts.length; i++) {
            String buf = texts[i];
            buf = buf.trim();
            int usedSymbols = 0;
            String newBuf = "   ";
            String[] words = buf.split(" ");
            for (int j = 0; j < words.length; j++) {
                if(newBuf.length() + words[j].length() >= 80){
                    listStr.add(newBuf);
                    usedSymbols = 0;
                    newBuf = "";
                }
                newBuf+= words[j]+" ";
                usedSymbols += words[j].length() + 1;
            }
        }
        String result = String.join("\n", listStr);

        request.setAttribute("message", result);
        getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
