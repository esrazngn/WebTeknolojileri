package com.odev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class icecekEkle
 */
@WebServlet("/icecekEkle")
public class icecekEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public icecekEkle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		// Allocate a output writer to write the response message into the
		// network socket
		PrintWriter out = response.getWriter();

		// Write the response message, in an HTML page

		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		out.println("<title>Siparis Ver</title></head>");
		out.println("<body><h2>içeceðiniz</h2>");

		String icecek = request.getParameter("icecekler");
		if (icecek == null) {
			out.println("<p>Icecek: MISSING</p>");
		} else {
			out.println("<p>Icecek: " + icecek.replace("&nbsp", " ") + "</p>");
		}
		String icecekAdet = request.getParameter("icecekAdet");
		if (icecekAdet == null) {
			out.println("<p>Ýcecek: MISSING</p>");
		} else {
			out.println("<p>Ýçecek Adet: " + icecekAdet + "</p>");
		}
	}

}
