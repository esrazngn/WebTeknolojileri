

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class aramaMotoruSecimi
 */
@WebServlet("/aramaMotoruSecimi")
public class aramaMotoruSecimi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aramaMotoruSecimi() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Arama motorunu seçiniz ve aranacak kelimeyi giriniz !";
	    String actionURL = "search-engines";
	    String docType =
	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	      "Transitional//EN\">\n";
	    out.println
	      (docType +
	       "<HTML>\n" +
	       "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	       "<BODY BGCOLOR='red'>" +
	       
	       "<H1>" + title + "</H1>\n" +
	       "<FORM ACTION=\"" + actionURL + "\">\n" +
	       "  Search keywords: \n" +
	       "  <INPUT TYPE=\"TEXT\" NAME=\"searchString\"><P>\n");
	    SearchSpec[] specs = SearchUtilities.getCommonSpecs();
	    for(int i=0; i<specs.length; i++) {
	      String searchEngineName = specs[i].getName();
	      out.println("<INPUT TYPE=\"RADIO\" " +
	                  "NAME=\"searchEngine\" " +
	                  "VALUE=\"" + searchEngineName + "\">\n");
	      out.println(searchEngineName + "<BR>\n");
	    }
	    out.println
	      ("<BR>  <INPUT TYPE=\"SUBMIT\">\n" +
	       "</FORM>\n" +
	       "</BODY></HTML>");
	    
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
