package com.statuscode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class status
 */
@WebServlet("/status")
public class status extends HttpServlet {
	

		public void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		String userAgent = request.getHeader("User-Agent");
		if ((userAgent != null) &&
		(userAgent.contains("MSIE")))
		{
		response.sendRedirect("http://home.mozilla.com");
		} else {
		response.sendRedirect("http://www.microsoft.com");
		}
		}
		}
		