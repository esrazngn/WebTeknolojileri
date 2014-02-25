

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletTest
 */
@WebServlet("/servletTest")
public class servletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			performTask(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
				IOException {
			performTask(request, response);
		}

		private void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,
				IOException {

			String pdfFileName = "Android-Overview.pdf";
			String contextPath = getServletContext().getRealPath(File.separator);
			File pdfFile = new File(contextPath + pdfFileName);

			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename=" + pdfFileName);
			response.setContentLength((int) pdfFile.length());

			FileInputStream fileInputStream = new FileInputStream(pdfFile);
			OutputStream responseOutputStream = response.getOutputStream();
			int bytes;
			while ((bytes = fileInputStream.read()) != -1) {
				responseOutputStream.write(bytes);
			}

		}

	}
