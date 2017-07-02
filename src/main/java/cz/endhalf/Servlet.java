package cz.endhalf;

/**
 * Created by Marek on 01/07/2017.
 */
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Must be named same as from web.xml; otherwise, its name is FQCN; 2 names mapped to one context is not allowed
@WebServlet(urlPatterns = {"/home"}, initParams=@WebInitParam(name="ProductName",value="DefaultValue"))
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
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/authenticate.jsp");

        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Person p = new Person();
        if(username != null && password!= null){
            p.setUsername(username);
            p.setPassword(password);
            Database.authenticate(p);
        }
        if(p.isAuth()){
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/app/auth.jsp");
            req.setAttribute("user",p);
            requestDispatcher.forward(req,resp);
        }
        else{
            resp.getWriter().print("Not authenticated!");
        }

    }
}
