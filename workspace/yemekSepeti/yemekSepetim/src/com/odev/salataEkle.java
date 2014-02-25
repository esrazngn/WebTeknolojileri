package com.odev;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

@WebServlet("/salataEkle")
public class salataEkle extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	ArrayList<String> salata = new ArrayList<>();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{

		// Allocate a output writer to write the response message into the
		// network socket

		session = request.getSession(true);

		// see what has been ordered already
		Vector ordered = (Vector) session.getAttribute("order");
		// Write the response message, in an HTML page

		if (ordered == null) 
		{
			// add the current order to the new order list
			Vector v = new Vector();
			v.add(new Order(kind2 + " Adet "));
			v.add(new Order(kind));
			//int a = Integer.parseInt(kind2);
			//v.add(a*5+" TL ");

			session.setAttribute("order", v);
		} 
		else if (kind != null) 
		{
			ordered.add(new Order(kind2 + " Adet "));
			ordered.add(new Order(kind));

			
			//ordered.add(a*5+" TL ");
			//session.setAttribute("order", ordered);
		}

		kind = null;

		if (ordered != null) 
		{
			// extract all orders
			Enumeration orders = ordered.elements();
			while (orders.hasMoreElements()) 
			{
				salata.add(((Order) orders.nextElement()).getName());

			}
			System.err.println(salata);
		}

		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	HttpSession session;
	String kind;
	Order ord;
	String kind2;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		kind = request.getParameter("salatalar");
		kind2 = request.getParameter("salataAdet");
		doGet(request, response);

	}

}
