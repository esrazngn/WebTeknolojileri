
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    //get the 'file' parameter
    String fileName = (String) request.getParameter("file");
    if (fileName == null || fileName.equals(""))
      throw new ServletException(
          "Invalid or non-existent file parameter in UrlServlet servlet.");

    if (fileName.indexOf(".pdf") == -1)
      fileName = fileName + ".pdf";

    URL pdfDir = null;
    URLConnection urlConn = null;
    ServletOutputStream stream = null;
    BufferedInputStream buf = null;
    try {

      pdfDir = new URL(getServletContext().getInitParameter(
          "remote-pdf-dir")
          + fileName);

    } catch (MalformedURLException mue) {

      throw new ServletException(mue.getMessage());
    }
    try {

      stream = response.getOutputStream();

      //set response headers
      response.setContentType("application/pdf");
      response.addHeader("Content-Disposition", "attachment; filename="
          + fileName);

      urlConn = pdfDir.openConnection();
      response.setContentLength((int) urlConn.getContentLength());

      buf = new BufferedInputStream(urlConn.getInputStream());
      int readBytes = 0;

      //read from the file; write to the ServletOutputStream
      while ((readBytes = buf.read()) != -1)
        stream.write(readBytes);
    } catch (IOException ioe) {
      throw new ServletException(ioe.getMessage());
    } finally {
      if (stream != null)
        stream.close();
      if (buf != null)
        buf.close();
    }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doGet(request, response);
  }
}

          