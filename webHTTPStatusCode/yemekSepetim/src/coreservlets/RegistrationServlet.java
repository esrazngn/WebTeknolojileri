package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/** Servlet that processes a registration form containing
 *  a user's first name, last name, and email address.
 *  If all the values are present, the servlet displays the
 *  values. If any of the values are missing, the input
 *  form is redisplayed. Either way, the values are put
 *  into cookies so that the input form can use the
 *  previous values.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    boolean isMissingValue = false;
    String userid = request.getParameter("userid");
    if (isMissing(userid)) {
      userid = "";
      isMissingValue = true;
    }
    String password = request.getParameter("password");
    if (isMissing(password)) {
 
      isMissingValue = true;
    }
    
    Cookie c1 = new LongLivedCookie("userid", userid);
    response.addCookie(c1);
    Cookie c2 = new LongLivedCookie("password", password);
    response.addCookie(c2);
  
    if (isMissingValue) {
      response.sendRedirect("uyeGirisEkrani");
    } else {
      PrintWriter out = response.getWriter();
      String docType =
        "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
        "Transitional//EN\">\n";
      String title = "Thanks for Registering";
      out.println
        (docType +
         "<HTML>\n" +
         "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
         "<BODY BGCOLOR=\"#FDF5E6\">\n" +
         "<CENTER>\n" +
         "<H1 ALIGN>" + title + "</H1>\n" +
         "<UL>\n" +
         "  <LI><B>userid</B>: " +
                userid+ "\n" +
         "  <LI><B>password</B>: " +
                password+ "\n" +
         
         "</UL>\n" +
         "</CENTER></BODY></HTML>");
    }
  }

  /** Determines if value is null or empty. */
  
  private boolean isMissing(String param) {
    return((param == null) ||
           (param.trim().equals("")));
  }
}
