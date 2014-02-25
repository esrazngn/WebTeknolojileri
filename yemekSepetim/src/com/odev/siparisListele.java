package com.odev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.odev.siparisJSON.Siparis;

/**
 * Servlet implementation class siparisListele
 */
@WebServlet("/siparisListele")
public class siparisListele extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public siparisListele() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
				+ "Transitional//EN\">\n";
		String title = "Üye Kayýt Ekraný";
		

		
		out.println(docType
				+ "<<html class='no-js'>\n"
				+ "<HEAD><TITLE>"
				+ title
				+ "</TITLE><link rel='stylesheet' media='all' href='css/style.css'/>"
				+ "<meta name='viewport' content='width=device-width, initial-scale=1'/>"
				+

				"<script src='js/jquery-1.7.1.min.js'></script>"
				+ "<script src='js/custom.js'></script>"
				+ "<script src='js/tabs.js'></script>"
				+ "<script src='js/css3-mediaqueries.js'></script>"
				+ "<script src='js/jquery.columnizer.min.js'></script>"
				+

				"<script src='js/jquery.isotope.min.js'></script>"
				+

				"<script src='js/jquery.easing.js'></script>"
				+ "<script src='js/lof-slider.js'></script>"
				+ "<link rel='stylesheet' href='css/lof-slider.css' media='all'  /> "
				+

				"<link rel='stylesheet' href='css/jquery.tweet.css' media='all'  />"
				+ "<script src='js/tweet/jquery.tweet.js' ></script> "
				+

				"<link rel='stylesheet' media='screen' href='css/superfish.css' />"
				+ "<script  src='js/superfish-1.4.8/js/hoverIntent.js'></script>"
				+ "<script  src='js/superfish-1.4.8/js/superfish.js'></script>"
				+ "<script  src='js/superfish-1.4.8/js/supersubs.js'></script>"
				+ "<script  src='js/prettyPhoto/js/jquery.prettyPhoto.js'></script>"
				+ "<link rel='stylesheet' href='js/prettyPhoto/css/prettyPhoto.css'  media='screen' />"
				+

				"<link rel='stylesheet' href='js/poshytip-1.1/src/tip-twitter/tip-twitter.css'  />"
				+ "<link rel='stylesheet' href='js/poshytip-1.1/src/tip-yellowsimple/tip-yellowsimple.css'  />"
				+ "<script  src='js/poshytip-1.1/src/jquery.poshytip.min.js'></script>"
				+ "<script type='text/javascript' src='js/jquery.jcarousel.min.js'></script>"
				+ "<link rel='stylesheet' media='screen' href='css/carousel.css' /> "
				+ "<link href='http://fonts.googleapis.com/css?family=Voltaire' rel='stylesheet' type='text/css'>"
				+ "<script src='js/modernizr.js'></script>"
				+ "<link rel='stylesheet' media='all' href='css/skin.css'/>"
				+ "<link rel='stylesheet' media='all' href='css/lessframework.css'/>"
				+ "<link rel='stylesheet' href='css/flexslider.css' >"
				+ "<script src='js/jquery.flexslider.js'></script>"
				+

				"</head><body><header>"
				+ "<div class='wrapper cf'>"
				+

				"<div id='logo'>"
				+ "<a href='anasayfa.jsp'><img  src='img/logo.png' alt='Simpler'></a>"
				+ "</div>"
				+

				"<ul id='nav' class='sf-menu'>"
				+ "<li class='current-menu-item'><a href='anasayfa.jsp'>Anasayfa</a></li>"
				+ "<li><a href='siparis'>Sipariþ Ver</a>" 
				+ "<li><a href='cikisYap'>Çýkýþ Yap</a>"

				+"</ul>"
				
				+ "<div id='combo-holder'></div>" +

				"</div>" + "</header>" +

				"<div id='main'>" + "<div class='wrapper cf'><h1>Sipariþler</h1></br></br>");
				Siparis[] array;
				BufferedReader br = null;
				
				br = new BufferedReader(new FileReader("D:\\Siparis.txt"));
				StringBuilder jsonStringSB = new StringBuilder();
				String line;

				while ((line = br.readLine()) != null)
				{
					jsonStringSB.append(line);
				}
				String jsonString = jsonStringSB.toString();
				array = Deserialize(jsonString, new Siparis[1]);

				for(int i = 0; i<array.length; i++)
				{
					out.print("<li><h5>Sipariþ ID: "+array[i].SiparisID+"</h5></li>");
					
					out.print("</br><li>Yemekler</li>");
					for(int j = 0; j<array[i].yemekler.length; j++)
					{
						out.print(array[i].yemekler[j]+" ");
						
					}
					out.print("</br><li>Ýçecekler</li>");
					for(int k = 0; k<array[i].icecekler.length; k++)
					{
						out.print( array[i].icecekler[k]+" ");
					}
					out.print("</br><li>Salatalar</li>");
					for(int m = 0; m<array[i].salatalar.length; m++)
					{
						out.print(array[i].salatalar[m]+" ");
								
					}
					out.print("</br></br><li>Tutar:  "+array[i].Tutar+"</li>");
					out.print("</br>--------------------------------------------------------");

				}
	
				out.print("<div id='portfolio-content' class='cf'>  " + "</header>"
				+ " </br></br></br>" + "<div id='main'>"
				+ "<div class='home-featured'>" + "<ul id='filter-buttons'>"
				+ "<li><a href='hakkimizda' >Hakkýmýzda</a></li>"
				+ "	<li><a href='iletisim' >Ýletiþim Bilgilerimiz</a></li>"
				+ "</ul></div></div></div></div>"

				+ "</body> </html>");
	}
@SuppressWarnings("unchecked")
public static <T> T Deserialize(String jsonString, T type) {
	// Deserialization iþlemi:
	// String >>> Nesne Dönüþümü

	// Json nesnesi ve dönüþtürme iþlemi
	Gson gson = new Gson();
	T jsonObject = (T) gson.fromJson(jsonString, type.getClass());

	return jsonObject;
}


}
