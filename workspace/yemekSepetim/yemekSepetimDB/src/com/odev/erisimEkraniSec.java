package com.odev;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class erisimEkrani
 */
@WebServlet("/erisimEkraniSec")
public class erisimEkraniSec extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public erisimEkraniSec() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if (request.getParameter("yiyecekEkle")!=null)
			response.sendRedirect("yiyecekEkle.jsp");
		if (request.getParameter("fiyat")!=null)
			response.sendRedirect("fiyatGuncelle.jsp");
		if (request.getParameter("kullaniciGuncelle")!=null)
			response.sendRedirect("kullaniciGuncelle.jsp");
		if (request.getParameter("kullaniciSil")!=null)
			response.sendRedirect("kullaniciSil.jsp");
		if (request.getParameter("siparis")!=null)
			response.sendRedirect("siparis.jsp");
		if (request.getParameter("listele")!=null)
			response.sendRedirect("siparisListele.jsp");
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
