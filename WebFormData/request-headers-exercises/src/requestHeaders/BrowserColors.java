package requestHeaders;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/browser-colors")
public class BrowserColors extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String bgColor, fgColor;
    // Assume for simplicity that Firefox and IE are
    // the only two browsers
    String userAgent = request.getHeader("User-Agent");
    if ((userAgent != null) &&
        (userAgent.contains("MSIE"))) {
      bgColor = "RED";
      fgColor = "YELLOW";
    } else {
      bgColor = "YELLOW";
      fgColor = "RED";
    }
    String title = "Hello";
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println
      (docType +
       "<HTML>\n" +
       "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
       "<BODY BGCOLOR=\"" + bgColor + "\" TEXT=\"" + fgColor + "\">\n" +
       "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
       "</BODY></HTML>");
  }
}
