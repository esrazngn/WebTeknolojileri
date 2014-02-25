package com.odev;


import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/KillSession")

public class KillSession extends HttpServlet {
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	// get the session, 
	HttpSession session = request.getSession(true); 

	// invalidate it
	session.invalidate();

	response.setContentType("text/html");

	// session is retrieved before getting the writer

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body bgcolor=\"white\">");
        out.println("<head>");

	out.println("<title> Ice cream </title>");

        out.println("</head>");
        out.println("<body>");

	out.println("<h1>Thanks for trying our ice cream!</h1>");

	out.println("Click");
	out.println("<A HREF = \"IceCream1\">here</A>");
	out.println("to buy more ice cream");

	out.println("</body>");
	out.println("</html>");

	out.close();

    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	doGet(request,response);
    }
}