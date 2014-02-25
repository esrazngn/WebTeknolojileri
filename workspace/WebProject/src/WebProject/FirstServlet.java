package WebProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE HTML PUBLIC \"//-W3C//DTD HTML4.0" ;
		out.println( docType +
		"Transitional//EN\"\n"+
				"<HTML>\n"+ 
				"<HEAD><TITLE> WELCOME  </TITLE></HEAD>\n"+
		"<BODY BGCOLOR=\"#FDF5E6\">\n"+ 
				"<H1> WELCOME TO TO MY FIRST SERVLET </H1>\n"+ 
				"</BODY></HTML>");
				
	}
}

	