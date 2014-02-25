package com.odev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/IceCream1")
public class IceCream1 extends HttpServlet {

	HttpSession session;
	String kind;
	Order ord;

	// the user gets to the page without submitting a form
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");

		// session is retrieved before getting the writer

		session = request.getSession(true);

		// see what has been ordered already
		Vector ordered = (Vector) session.getAttribute("order");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body bgcolor=\"white\">");
		out.println("<head>");

		out.println("<title> An ice cream shop </title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h1>Welcome to our ice cream shop!</h1>");

		// print out what has been ordered
		if (ordered == null && kind == null) {
			session.setAttribute("order", new Vector());
			out.println("You have not ordered anything yet.<BR>");
			out.println("Try our ice cream, it's delicious!<P>");
		} else if (ordered == null) {
			// add the current order to the new order list
			Vector v = new Vector();
			v.add(new Order(kind));
			session.setAttribute("order", v);
		} else if (kind != null) {
			ordered.add(new Order(kind));
			session.setAttribute("order", ordered);
		}

		kind = null;

		if (ordered != null) {
			out.println("You have ordered:<P>");
			// extract all orders
			Enumeration orders = ordered.elements();
			while (orders.hasMoreElements()) {
				out.println(((Order) orders.nextElement()).getName());
				out.println("<P>");
			}
		}

		out.println("Please click on ice cream you want to buy<BR>");
		out.println("to add it to your order<P>");

		// a button for vanilla ice cream
		out.println("<P>");
		out.print("<form action=\"");
		out.print(response.encodeURL("IceCream1"));
		out.print("\" ");
		out.println("method=POST>");
		out.println("<input type=hidden name=\"toBuy\" value=\"Vanilla\">");
		out.println("<br>");
		out.println("<input type=submit value=\"Vanilla\">");
		out.println("</form>");

		// a button for chocolate ice cream
		out.println("<P>");
		out.print("<form action=\"");
		out.print(response.encodeURL("IceCream1"));
		out.print("\" ");
		out.println("method=POST>");
		out.println("<input type=hidden name=\"toBuy\" value=\"Chocolate\">");
		out.println("<br>");
		out.println("<input type=submit value=\"Chocolate\">");
		out.println("</form>");

		// a button for strawberry ice cream
		out.println("<P>");
		out.print("<form action=\"");
		out.print(response.encodeURL("IceCream1"));
		out.print("\" ");
		out.println("method=POST>");
		out.println("<input type=hidden name=\"toBuy\" value=\"Strawberry\">");
		out.println("<br>");
		out.println("<input type=submit value=\"Strawberry\">");
		out.println("</form>");

		// a button to erase the session
		out.println("<P>");
		out.print("<form action=\"");
		out.print(response.encodeURL("KillSession"));
		out.print("\" ");
		out.println("method=POST>");
		out.println("<br>");
		out.println("<input type=submit value=\"Erase all!\">");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");

		out.close();

	}

	// the user submits one of the forms
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// session = request.getSession(true);

		kind = request.getParameter("toBuy");

		// the rest is the same for POST and GET,
		// so we let doGet() do the job
		doGet(request, response);
	}

}