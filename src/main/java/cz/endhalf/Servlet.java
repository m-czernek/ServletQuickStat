package cz.endhalf;

/**
 * Created by Marek on 01/07/2017.
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Must be named same as from web.xml; otherwise, its name is FQCN; 2 names mapped to one context is not allowed
@WebServlet(urlPatterns = {"/home","/someOtherValue"}, name = "Main", initParams=@WebInitParam(name="ProductName",value="DefaultValue"))
public class Servlet extends HttpServlet {
    String appName;

    @Override
    public void init() throws ServletException {
        // Uncomment to get init parameter from web.xml OR to get the default value defined in initParams
        //appName=getInitParameter("ProductName");
        //Uncomment to get
        appName = getServletContext().getInitParameter("ProductName");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Change the response

        String name = req.getParameter("name");

        if(name != null && name!="") {
            resp.setContentType("text/xml");
            resp.getWriter().printf("<myServlet>" +
                    "<name>Hello, %s</name>" +
                    "<product>%s</product>" +
                    "</myServlet>", name, appName);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.setContentType("text/xml");

        //jsp form triggers [POST]
        if(name != "" && name != null){
            resp.getWriter().printf("<message>Hello, %s</message>",name);
        }
        else{
            resp.sendRedirect("index.jsp");
        }
    }
}
