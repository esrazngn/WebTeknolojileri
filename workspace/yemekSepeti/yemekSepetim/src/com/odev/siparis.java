package com.odev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class siparis
 */
@WebServlet("/siparis")
public class siparis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public siparis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Yiyecek> yiyecekListesi = new ArrayList<Yiyecek>();
		yiyecekListesi.add( new Yiyecek( "Bolu Köfte 9.90 TL", 9.90 ) );
		yiyecekListesi.add( new Yiyecek( "Kasap Köfte 9.90 TL" , 9.90 ) );
		yiyecekListesi.add( new Yiyecek( "Tavuk Pirzola 9.50 TL",9.50 ) );
		yiyecekListesi.add( new Yiyecek( "Tavuk Şiş 9.50 TL" ,9.50) );
		yiyecekListesi.add( new Yiyecek( "Kuzu Pirzola 15.00 TL",15.00) );
		yiyecekListesi.add( new Yiyecek( "Kuzu Şiş 15.00 TL" ,15.00) );
		yiyecekListesi.add( new Yiyecek( "Dana Biftek 15.00 TL" ,15.00) );
		yiyecekListesi.add( new Yiyecek( "Dana Sadra 15.00 TL",15.00 ) );
		yiyecekListesi.add( new Yiyecek( "Et Şiş 15.00 TL" ,15.00) );
		yiyecekListesi.add( new Yiyecek( "Bolu Special Izgara 40.00 TL" ,40.00) );


		List<Yiyecek> salataListesi = new ArrayList<Yiyecek>();
		salataListesi.add( new Yiyecek( "Çoban Salata  4.00 TL", 4.00 ) );
		salataListesi.add( new Yiyecek( "Mevsim Salata  4.00 TL" , 4.00 ) );
		salataListesi.add( new Yiyecek( "Akdeniz Salata  8.00 TL",2.50 ) );
		salataListesi.add( new Yiyecek( "Special Ege Salata 8.50 TL" ,8.50) );
		salataListesi.add( new Yiyecek( "Tavuk Salata 10.50 TL",10.50) );
		salataListesi.add( new Yiyecek( "Piyaz 5.00 TL" ,5.00) );


		List<Yiyecek> icecekListesi = new ArrayList<Yiyecek>();
		icecekListesi.add( new Yiyecek( "Pepsi (33 cl.) 2.50 TL", 2.50 ) );
		icecekListesi.add( new Yiyecek( "Pepsi Light (33 cl.) 2.50 TL" , 2.50 ) );
		icecekListesi.add( new Yiyecek( "Yedigün (33 cl.)  2.50 TL",2.50 ) );
		icecekListesi.add( new Yiyecek( "Meyve Suyu (33 cl.) 2.50 TL" ,2.50) );
		icecekListesi.add( new Yiyecek( "Ayran (30 cl.) 1.50 TL",1.50) );
		icecekListesi.add( new Yiyecek( "Su 1.00 TL" ,1.00) );
		
		
		response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	    response.setContentType("text/html");
	    String docType =
	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	      "Transitional//EN\">\n";
	    String title = "Sipariş Ekranı";
	    out.println(docType +
	                "<<html class='no-js'>\n" +
	                "<HEAD><TITLE>" + title + "</TITLE><link rel='stylesheet' media='all' href='css/style.css'/>"+
		"<meta name='viewport' content='width=device-width, initial-scale=1'/>"+
		
		"<script src='js/jquery-1.7.1.min.js'></script>"+
		"<script src='js/custom.js'></script>"+
		"<script src='js/tabs.js'></script>"+
		"<script src='js/css3-mediaqueries.js'></script>"+
		"<script src='js/jquery.columnizer.min.js'></script>"+
		
		"<script src='js/jquery.isotope.min.js'></script>"+
		
		"<script src='js/jquery.easing.js'></script>"+
		"<script src='js/lof-slider.js'></script>"+
		"<link rel='stylesheet' href='css/lof-slider.css' media='all'  /> "+
		    
		"<link rel='stylesheet' href='css/jquery.tweet.css' media='all'  />"+ 
		"<script src='js/tweet/jquery.tweet.js' ></script> "+
		
		"<link rel='stylesheet' media='screen' href='css/superfish.css' />"+ 
		"<script  src='js/superfish-1.4.8/js/hoverIntent.js'></script>"+
		"<script  src='js/superfish-1.4.8/js/superfish.js'></script>"+
		"<script  src='js/superfish-1.4.8/js/supersubs.js'></script>"+
		"<script  src='js/prettyPhoto/js/jquery.prettyPhoto.js'></script>"+
		"<link rel='stylesheet' href='js/prettyPhoto/css/prettyPhoto.css'  media='screen' />"+
	
		"<link rel='stylesheet' href='js/poshytip-1.1/src/tip-twitter/tip-twitter.css'  />"+
		"<link rel='stylesheet' href='js/poshytip-1.1/src/tip-yellowsimple/tip-yellowsimple.css'  />"+
		"<script  src='js/poshytip-1.1/src/jquery.poshytip.min.js'></script>"+
		"<script type='text/javascript' src='js/jquery.jcarousel.min.js'></script>"+
		"<link rel='stylesheet' media='screen' href='css/carousel.css' /> "+
		"<link href='http://fonts.googleapis.com/css?family=Voltaire' rel='stylesheet' type='text/css'>"+
		"<script src='js/modernizr.js'></script>"+
		"<link rel='stylesheet' media='all' href='css/skin.css'/>"+
		"<link rel='stylesheet' media='all' href='css/lessframework.css'/>"+
		"<link rel='stylesheet' href='css/flexslider.css' >"+
		"<script src='js/jquery.flexslider.js'></script>"+

	"</head><body><header>"+
"<div class='wrapper cf'>"+
				
				"<div id='logo'>"+
					"<a href='anasayfa.jsp'><img  src='img/logo.png' alt='Simpler'></a>"+
				"</div>"+
				
				
				"<ul id='nav' class='sf-menu'>"+
					"<li class='current-menu-item'><a href='anasayfa.jsp'>Anasayfa</a></li>"+
					"<li><a href='uyeKayit'>Kayıt Ol</a></li>"+
					"<li><a href='uyeGiris'>Üye Girişi</a>"+
					"<li><a href='siparis'>Sipariş Ver</a>"+
				"</ul>"+
				"<div id='combo-holder'></div>"+
				

			"</div>"+
		"</header>"+
		
		"<div id='main'>"+
			"<div class='wrapper cf'>"+
			
			
        	"<div id='portfolio-content' class='cf'>  "+
        	"</header>"+
        	"<fieldset><legend><h1>Siparişinizi Seçiniz </h1> </br> </legend>"+ 
        	"<form name = 'yemek' action='yemekEkle' method='post'>"+
        	"<fieldset><legend><h4>Yemek Seçimi</h4></br> </legend>"+
        	"<table>"+
        	"<TR><TD><h5>Yemekler :</h5></br></TD>"+
				"<td><select name='yemekler' id='yemekler'>");
					 for(int i=0; i<yiyecekListesi.size(); i++) {
				out.print("<option value=" + yiyecekListesi.get(i).getKey() +">"+
				
				yiyecekListesi.get(i).getKey()+
				"</option>");
				} 
				out.print(	"</select></td>"+
					
			"</tr>"+
			"<<tr><td><h5>Adet</h5></td>"+
				"<TD><input type='text' name='yemekAdet' value = 0></TD>"+
				"<td><INPUT TYPE='submit' name = 'ok1' value='OK'></td>"+
				"<td><textarea id = 'area1' rows='3' cols='30'></textarea></td>"+
				"<td><input type='text' name='yemekAdetSec' value = ''></td></tr>"+
				"</table></form></fieldset>");
			   

        			
out.print("<form name = 'icecek' method = 'post' action ='icecekEkle'><table>"+
"<TR><TD><h5>İçecekler :</h5></br></TD>"+
	"<td><select name='icecekler' id='yemekler'>");
		 for(int i=0; i<icecekListesi.size(); i++) {
	out.print("<option value=" + icecekListesi.get(i).getKey() +">"+icecekListesi.get(i).getKey()+
	"</option>");
	} 
	out.print(	"</select></td>"+
		
"</tr>"+
"<<tr><td><h5>Adet</h5></td>"+
	"<TD><input type='text' name='icecekAdet' value = 0></TD>"+
	"<td><INPUT TYPE='submit' name = 'ok2' value='OK' onclick='javascript:salataEkle()'></td>"+
	"<td><textarea id = 'area2' rows='3' cols='30'></textarea></td>"+
	"<td><input type='text' name='icecekAdetSec' value = ''></td></tr>"+
	"</table></fieldset></form>"+
	"<form  name = 'salata' method = 'post'action = 'salataEkle'><table>"+
"<TR><TD><h5>Salatalar :</h5></br></TD>"+
	"<td><select name='salatalar' id='salatalar'>");
		 for(int i=0; i<salataListesi.size(); i++) {
	out.print("<option value=" + salataListesi.get(i).getKey() + ">" +	salataListesi.get(i).getKey()+
	"</option>");
	}
		 String esra ="???????????";
	out.print(	"</select></td>"+
		
"</tr>"+
"<<tr><td><h5>Adet</h5></td>"+
	"<TD><input type='text' name='salataAdet' value = 0></TD>"+
	"<td><INPUT TYPE='submit' name = 'toBuy' value = 'ekle' ></td>"+
	"<td><textarea id = 'area3' rows='3' value = 'ekle' cols='30'></textarea></td>"+
	"<td><input type='text' name='salataAdetSec' value = '"+esra+"'></td></tr>"+
	"</table></fieldset></form>"+ 			
       
        		"</fieldset><form action ='siparisOnayla'>"+
        		"<p align=right>SiparisID <input type='text' name='siparisID' value = ''> Toplam Tutar <input type='text' name='toplamTutar' value = ''>"+
        		"<br/><p align=right> <INPUT TYPE='submit' value='Siparis Onayla' >"+
        			    		    	    			
        	"</form>" + "<div id='main'>"
            + "<div class='home-featured'>"
            + "<ul id='filter-buttons'>"
            + "<li><a href='hakkimizda' >Hakkımızda</a></li>"
            + "	<li><a href='iletisim' >İletişim Bilgilerimiz</a></li>"
            + "</ul></div></div></div></div>"

            + "</body> </html>");
        	

	
	
	}

}
