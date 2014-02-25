

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.net.*;


@WebServlet("/search-engines")
public class SearchEngines extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    String searchString = request.getParameter("searchString");
    if ((searchString == null) ||
        (searchString.length() == 0)) {
      reportProblem(response, "Aranacak kelimeyi girmediniz");
      return;
    }
    searchString = URLEncoder.encode(searchString, "utf-8");
    String searchEngineName =
      request.getParameter("searchEngine");
    if ((searchEngineName == null) ||
        (searchEngineName.length() == 0)) {
      reportProblem(response, "Lütfen Arama motoru seçiniz");
      return;
    }
    String searchURL =
      SearchUtilities.makeURL(searchEngineName, searchString);
    if (searchURL != null) {
      response.sendRedirect(searchURL);
    } else {
      reportProblem(response, "Unrecognized search engine");
    } 
  }

  private void reportProblem(HttpServletResponse response,
                             String message)
      throws IOException {
    response.sendError(HttpServletResponse.SC_NOT_FOUND, message);
  }
}
