package com.odev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

@WebServlet("/siparisEkle")
public class siparisEkle extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	private List<Yiyecek> yiyecekListesi;
	private List<Yiyecek> icecekListesi;
	private List<Yiyecek> salataListesi;
	double salataToplam = 0.0, yemekToplam = 0.0, icecekToplam = 0.0;
	ArrayList<String> salata = new ArrayList<>();
	ArrayList<String> yemek = new ArrayList<>();
	ArrayList<String> icecek = new ArrayList<>();
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
			doPost(request, response);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		session.getMaxInactiveInterval();
		double toplamFiyat = 0.0;
		yiyecekListesi = Yiyecek.yemek();
		icecekListesi = Yiyecek.icecek();
		salataListesi = Yiyecek.salata();
		if(yiyecekListesi == null)
			yiyecekListesi = new ArrayList<Yiyecek>();
		if(icecekListesi == null)
			icecekListesi = new ArrayList<Yiyecek>();
		if(salataListesi == null)
			salataListesi = new ArrayList<Yiyecek>();
		double salataFiyat = 0;
		double yemekFiyat = 0;
		double icecekFiyat = 0;
		ArrayList<String> salataSiparis = new ArrayList<>();
		ArrayList<String> yemekSiparis = new ArrayList<>();
		ArrayList<String> icecekSiparis = new ArrayList<>();

		
		

		
		if (session.isNew()) {
			session.setAttribute("salatalar", new ArrayList<String>());
			session.setAttribute("yemekler", new ArrayList<String>());
			session.setAttribute("icecekler", new ArrayList<String>());

		}
		else
		{
			session = req.getSession(true);
			session.getMaxInactiveInterval();
		}
		

		ArrayList<String> salata = (ArrayList<String>) session
				.getAttribute("salatalar");
		ArrayList<String> yemek = (ArrayList<String>) session
				.getAttribute("yemekler");
		ArrayList<String> icecek = (ArrayList<String>) session
				.getAttribute("icecekler");


		if (req.getParameter("salatalar") != null) 
		{
			
			salata.add(req.getParameter("salatalar"));
			String salataAdet = req.getParameter("salataAdet");

			if(salataAdet.equals("0"))
			{
				salataAdet = "1";
			}
			
				salata.add(salataAdet);
			int Sadet = Integer.parseInt(salataAdet);
			for (int i = 0; i < salataListesi.size(); i++)
			{
				String salatam = req.getParameter("salatalar");
				int salatasi = salataListesi.get(i).getId();
				if (Integer.parseInt(salatam) == salatasi) 
				{
					Double salataAdetTutar = salataListesi.get(i).getValue();
					
					salataFiyat += Sadet*salataAdetTutar;
					String salataF = Double.toString(salataFiyat);
					salata.add(salataF);
					break;
				} 
			}
			res.sendRedirect("siparis");
		}
		
		else if (req.getParameter("yemekler") != null) {			
			yemek.add(req.getParameter("yemekler"));
			String yemekAdet = req.getParameter("yemekAdet");

			if(yemekAdet.equals("0"))
			{
				yemekAdet = "1";
			}
			
				yemek.add(yemekAdet);
			int Yadet = Integer.parseInt(yemekAdet);
			for (int i = 0; i < yiyecekListesi.size(); i++)
			{
				String yemegim = req.getParameter("yemekler");
				int yemekID = yiyecekListesi.get(i).getId();
				if (Integer.parseInt(yemegim) == yemekID) {
					Double yemekAdetTutar = yiyecekListesi.get(i).getValue();
					yemekFiyat += Yadet*yemekAdetTutar;
					String yemekF =Double.toString(yemekFiyat);
					yemek.add(yemekF);
					break;
				} 
			}
			res.sendRedirect("siparis");
		}

		else if (req.getParameter("icecekler") != null) {
			icecek.add(req.getParameter("icecekler"));
			String icecekAdet = (req.getParameter("icecekAdet"));
			if ( icecekAdet.equals("0"))
			{
				icecekAdet = "1";
			}
			icecek.add(icecekAdet);
			int Iadet = Integer.parseInt(icecekAdet);
			for (int i = 0; i < icecekListesi.size(); i++)
			{
				String icecegim = req.getParameter("icecekler");
				int icecekID = icecekListesi.get(i).getId();
				if (Integer.parseInt(icecegim) == icecekID) {
					Double icecekAdetTutar = icecekListesi.get(i).getValue();
					icecekFiyat += Iadet*icecekAdetTutar;
					String icecekF =Double.toString(icecekFiyat);
					icecek.add(icecekF);
					break;
				} 
			}
			res.sendRedirect("siparis");

		
		}
		else if (req.getParameter("onayla") != null) {
			session.invalidate();
			for(int j = 0; j < yemek.size(); j++ )
			{
				int siparisYemek = 0;
				try 
				{
					siparisYemek = Integer.parseInt(yemek.get(j));
				}
				catch (Exception e) {
					e.printStackTrace();
						
				}
				finally
				{

				for (int i = 0; i < yiyecekListesi.size(); i++)
				{
					if(yiyecekListesi.get(i).getId()==siparisYemek)
					{
						yemekSiparis.add(yiyecekListesi.get(i).getKey().replace("&nbsp", " "));
						yemekSiparis.add(yemek.get(j+1)+" Adet");
						toplamFiyat+=Double.parseDouble(yemek.get(j+2));
						j+=2;
						break;
					}
					
				}
				}
			}
			
			for(int j = 0; j < icecek.size(); j++ )
			{
				int siparisIcecek = 0;
				try 
				{
					siparisIcecek = Integer.parseInt(icecek.get(j));
				}
				catch (Exception e) {
					e.printStackTrace();
						
				}
				finally
				{

				for (int i = 0; i < icecekListesi.size(); i++)
				{
					if(icecekListesi.get(i).getId()==siparisIcecek)
					{
						icecekSiparis.add(icecekListesi.get(i).getKey().replace("&nbsp", " "));
						icecekSiparis.add(icecek.get(j+1)+" Adet");
						toplamFiyat+=Double.parseDouble(icecek.get(j+2));
						j+=2;
						break;
					}
					
				}
				}
			}
			
			for(int j = 0; j < salata.size(); j++ )
			{
				int siparisSalata = 0;
				try 
				{
					siparisSalata = Integer.parseInt(salata.get(j));
				}
				catch (Exception e) {
					e.printStackTrace();
						
				}
				finally
				{

				for (int i = 0; i < salataListesi.size(); i++)
				{
					if(salataListesi.get(i).getId()==siparisSalata)
					{
						salataSiparis.add(salataListesi.get(i).getKey().replace("&nbsp", " "));
						salataSiparis.add(salata.get(j+1)+" Adet");
						toplamFiyat+=Double.parseDouble(salata.get(j+2));
						j+=2;
						break;
					}
					
				}
				}
			}
			
			
			
			System.out.println(yemekSiparis);
			System.out.println(icecekSiparis);
			System.out.println(salataSiparis);
			System.out.println(toplamFiyat);
			String[] yemekSiparisd = new String [yemekSiparis.size()];
			for( int i = 0; i < yemekSiparis.size(); i++)
			{
				yemekSiparisd[i] = yemekSiparis.get(i);
			}
			String[] icecekSiparisd = new String [icecekSiparis.size()];
			for( int i = 0; i < icecekSiparis.size(); i++)
			{
				icecekSiparisd[i] = icecekSiparis.get(i);
			}
			String[] salataSiparisd = new String [salataSiparis.size()];
			for( int i = 0; i < salataSiparis.size(); i++)
			{
				salataSiparisd[i] = salataSiparis.get(i);				
			}
			siparisJSON.hesapla(toplamFiyat, yemekSiparisd, icecekSiparisd, salataSiparisd);

		}
		res.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
				+ "Transitional//EN\">\n";
		String title = "Sipariþ Ekle";
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
				+ "<li class='current-menu-item'><a href='anasayfaGiris.jsp'>Anasayfa</a></li>"
				+ "<li><a href='siparis'>Sipariþ Ver</a>" 
				+ "<li><a href='cikisYap'>Çýkýþ Yap</a></li></ul>"
				+ "<div id='combo-holder'></div>" +

				"</div>" + "</header>" +

				"<div id='main'>" + "<div class='wrapper cf'>" +

				"<div id='portfolio-content' class='cf'>  " + "</header><h1>Sipariþiniz</h1></br></br>");
		if(!(yemekSiparis.size()==0))
		{
			out.println("<h4>Yemek Sipariþiniz</h4></br><table>");
			int i = 0, j = 2;
			while(i<yemekSiparis.size())
			{
				out.print("<li>"+yemekSiparis.get(i)+" "+ yemekSiparis.get(i+1)+" Tutar: "+yemek.get(j)+" TL</br>");
				i+=2;
				j+=3;
			}
		}
		if(!(icecekSiparis.size()==0))
		{
		out.print("</br><h4>Ýçecek Sipariþiniz</h4></br>");
		int k = 0, l = 2;
		while(k<icecekSiparis.size())
		{
			out.print("<li>"+icecekSiparis.get(k)+" "+ icecekSiparis.get(k+1)+" Tutar: "+icecek.get(l)+" TL </br>");
			k+=2;
			l+=3;
		}
		}
		if(!(salataSiparis.size()==0))
		{
		out.print("</br><h4>Salata Sipariþiniz</h4></br>");

		int m = 0, n = 2;
		while(m<salataSiparis.size())
		{
			out.print("<li>"+salataSiparis.get(m)+" "+ salataSiparis.get(m+1)+" Tutar: "+salata.get(n)+" TL </br>");
			m+=2;
			n+=3;
		}}
			
		out.print("</br><h3>Toplam Tutar: "+toplamFiyat+" TL <h3></table></br><div id='main'>"
				+ "<div class='home-featured'>" + "<ul id='filter-buttons'>"
				+ "<li><a href='hakkimizda' >Hakkýmýzda</a></li>"
				+ "	<li><a href='iletisim' >Ýletiþim Bilgilerimiz</a></li>"
				+ "</ul></div></div></div></div>"

				+ "</body> </html>");

	

	}

}
