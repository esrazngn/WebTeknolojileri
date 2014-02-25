package com.odev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/siparisVer")
public class siparisVer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public siparisVer() {
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
		     out.println("<body><h2>Siparisiniz</h2>");
		     
		     
		     String yemek = request.getParameter("yemekler");
		     // Get null if the parameter is missing from query string.
		     // Get empty string or string of white spaces if user did not fill in
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
		     // Retrieve the value of the query parameter "password" (from password field)
		   /*  
		     String icecek = request.getParameter("icecekler");
		     if (icecek == null) {
		          out.println("<p>Salata: MISSING</p>");
		       } else {
		          out.println("<p>icecek: " + icecek + "</p>");
		       }

		     String icecekAdet = request.getParameter("icecekAdet");
		     if (icecekAdet == null) {
		          out.println("<p>ÝcecekAdt: MISSING</p>");
		       } else {
		          out.println("<p>icecekadet: " + icecekAdet + "</p>");
		       }

		     
		     
		     String salata = request.getParameter("salatalar");
		     if (salata == null) {
		        out.println("<p>Salata: MISSING</p>");
		     } else {
		        out.println("<p>Salata: " + salata + "</p>");
		     }
		     
		     String salataAdet = request.getParameter("salataAdet");
		     if (salataAdet == null) {
		          out.println("<p>Salata: MISSING</p>");
		       } else {
		          out.println("<p>SalataAdet: " + salataAdet + "</p>");
		       }*/


		     // Retrieve the value of the query parameter "gender" (from radio button)
		    // System.err.printf(salata.replace("&nbsp", " "));
		     out.println("</body></html>");  
	}
	}
