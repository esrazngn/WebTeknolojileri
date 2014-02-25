package requestHeaders;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/second-page")
public class SecondPage extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    String firstPage = "first-page.html";
    String referer = request.getHeader("Referer");
    if ((referer == null) ||
        (!referer.contains(firstPage))) {
      response.sendRedirect(firstPage);
    } else {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String docType =
        "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
        "Transitional//EN\">\n";
      out.println(docType +
                  "<HTML>\n" +
                  "<HEAD><TITLE>Second Page</TITLE></HEAD>\n" +
                  "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                  "<H1>Welcome to the Second Page</H1>\n" +
                  "</BODY></HTML>");
    }
  }
}
