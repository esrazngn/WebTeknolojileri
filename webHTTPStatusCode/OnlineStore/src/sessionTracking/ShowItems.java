package sessionTracking;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

/** Servlet that displays a list of items being ordered.
 *  Accumulates them in an ArrayList and counts
 *  repeated items.
 */

@WebServlet("/show-items")
public class ShowItems extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    synchronized(session) {
      @SuppressWarnings("unchecked")
      List<SimpleItem> previousItems =
        (List<SimpleItem>)session.getAttribute("previousItems");
      if (previousItems == null) {
        previousItems = new ArrayList<SimpleItem>();
      }
      String itemName = request.getParameter("itemName");
      if ((itemName != null) &&
          (!itemName.trim().equals(""))) {
        SimpleItem item = findItem(itemName, previousItems);
        if (item != null) {
          item.incrementItemCount();
        } else {
          item = new SimpleItem(itemName);
          previousItems.add(item);
        }
      }
      session.setAttribute("previousItems", previousItems);
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Items Purchased";
      String docType =
        "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
        "Transitional//EN\">\n";
      out.println(docType +
                  "<HTML>\n" +
                  "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                  "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                  "<H1>" + title + "</H1>");
      if (previousItems.size() == 0) {
        out.println("<I>No items</I>");
      } else {
        out.println("<UL>");
        for(SimpleItem item: previousItems) {
          out.println("  <LI>" + item);
        }
        out.println("</UL>");
      }
      out.println("</BODY></HTML>");
    }
  }

  private SimpleItem findItem(String itemName,
                              List<SimpleItem> previousItems) {
    for(SimpleItem item: previousItems) {
      if (item.getItemName().equals(itemName)) {
        return(item);
      }
    }
    return(null);
  }
}
