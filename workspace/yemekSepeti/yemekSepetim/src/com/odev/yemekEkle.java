package com.odev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class yemekEkle
 */
@WebServlet("/yemekEkle")
public class yemekEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public yemekEkle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		  request.setCharacterEncoding("utf-8");
		  // Allocate a output writer to write the response message into the network socket
		  PrintWriter out = response.getWriter();

		  // Write the response message, in an HTML page
		  
		     out.println("<!DOCTYPE html>");
		     out.println("<html><head>");
		     out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		     out.println("<title>Siparis Ver</title></head>");
		     out.println("<body><h2>Yemeðiniz</h2>");

		     
		     String yemek = request.getParameter("yemekler");
		     if (yemek == null
		           ) {
		        out.println("<p>Yemek: MISSING</p>");
		     } else {
		        out.println("<p>Yemek: " + yemek.replace("&nbsp", " ") + "</p>");
		     }
		     String yemekAdet = request.getParameter("yemekAdet");
		     if (yemekAdet == null) {
		        out.println("<p>yemek: MISSING</p>");
		     } else {
		        out.println("<p>YemekAdet: " + yemekAdet + "</p>");
		     }
	}

}
