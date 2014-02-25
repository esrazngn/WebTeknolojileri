package coreservlets;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
@WebServlet("/welcome")

public class WelcomeServlet extends HttpServlet {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

// process "get" requests from clients
protected void doGet( HttpServletRequest request,
HttpServletResponse response )
throws ServletException, IOException
{
response.setContentType( "text/html" );
PrintWriter out = response.getWriter();

// send XHTML page to client

// start XHTML document
out.println( "<?xml version = \"1.0\"?>" );

out.println( "<!DOCTYPE html PUBLIC \"-//W3C//DTD " +
"XHTML 1.0 Strict//EN\" \"http://www.w3.org" +
"/TR/xhtml1/DTD/xhtml1-strict.dtd\">" );

out.println(
"<html xmlns = \"http://www.w3.org/1999/xhtml\">" );

// head section of document
out.println( "<head><JavaScript version='1.3'>" );
out.println( "<title>A Simple Servlet Example</title>" );
out.println( "</head></javascript>" );

// body section of document
out.println( "<body onLoad=alert('I am FLYING HIGH with this Servlet')>");
out.println( "<h1>Welcome to Servlets!</h1>" );
out.println( "</body>" );

// end XHTML document
out.println( "</html>" );
out.close(); // close stream to complete the page
}
}