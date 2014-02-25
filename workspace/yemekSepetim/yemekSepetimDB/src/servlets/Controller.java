package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegistrationDAO;

public class Controller extends HttpServlet
{
	static final long serialVersionUID = -8138593725520607100L;
	
    public void doGet ( HttpServletRequest request
                       , HttpServletResponse response )
        throws ServletException, IOException
    {
 
    	List registrations = null;
        try
        {
        	// create the DAO and retrieve all
        	// registrations
        	RegistrationDAO dao = new RegistrationDAO();
        	registrations = dao.getAllRegistrations();
        }
        catch ( Exception e )
        {
        	e.printStackTrace();

          // store the exception object in the request
        	HttpSession session = request.getSession();
            session.setAttribute (
                    "errMsg", e.getMessage() );

          // redirect to an error JSP
            response.sendRedirect("error.jsp");
            return;
        }

      // store the list reference in the session
        HttpSession session = request.getSession();
        session.setAttribute("registrations", registrations);

      // redirect the request to the JSP
        response.sendRedirect ( "showall.jsp" );
    }
}
