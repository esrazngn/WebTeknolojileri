package sessionTracking;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

/** Servlet that displays a list of all previous referring pages
 *  from that client. This differs from "ShowItems" from notes
 *  in three ways:
 *  1) The item comes from the Referer request header instead of a
 *     request parameter, and
 *  2) Repeated entries are avoided by calling "contains" on the
 *     list of previous URLs before insertion. Another idea would
 *     be to use HashSet (or, better, LinkedHashSet).
 *  3) It uses doGet instead of doPost so you can use hypertext
 *     links instead of form submissions to access it.
 */

@WebServlet("/show-referers")
public class ShowReferers extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    synchronized(session) {
      @SuppressWarnings("unchecked")
      List<String> previousURLs =
        (List<String>)session.getAttribute("previousURLs");
      if (previousURLs == null) {
        previousURLs = new ArrayList<String>();
      }
      String referer = request.getHeader("Referer");
      if ((referer != null) &&
          (!previousURLs.contains(referer))) {
        previousURLs.add(referer);
      }
      session.setAttribute("previousURLs", previousURLs);
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Pages Linked From";
      String docType =
        "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
        "Transitional//EN\">\n";
      out.println(docType +
                  "<HTML>\n" +
                  "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                  "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                  "<H1>" + title + "</H1>");
      if (previousURLs.size() == 0) {
        out.println("<I>No items</I>");
      } else {
        out.println("<UL>");
        for(String url: previousURLs) {
          out.println("  <LI>" + url);
        }
        out.println("</UL>");
      }
      out.println("</BODY></HTML>");
    }
  }
}
