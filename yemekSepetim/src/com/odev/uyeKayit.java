package com.odev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/uyeKayit")
public class uyeKayit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
				+ "Transitional//EN\">\n";
		String title = "�ye Kay�t Ekran�";
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
				+ "<li><a href='uyeKayit'>Kay�t Ol</a></li>"
				+ "<li><a href='uyeGiris'>�ye Giri�i</a>"
				+ "</ul>"
				+ "<div id='combo-holder'></div>"
				+

				"</div>"
				+ "</header>"
				+

				"<div id='main'>"
				+ "<div class='wrapper cf'>"
				+

				"<div id='portfolio-content' class='cf'>  "
				+ "<form name='registration' ACTION='uyeBilgi'  method='post'>"
				+ "<h1>Hesap Bilgileri</h1></br>"
				+ "<table border=0  cellpadding=1 >"
				+ "<TR><TD>Kullanici adi :</TD>"
				+ "	<TD colspan=5><input type='text' name='user' value = ''> </TD>"
				+ "</TR>"
				+ "<TR><TD>Parola:</TD>"
				+ "	<TD colspan=5><input type='password'  name='password' value = ''>  </TD>"
				+ "</TR>"
				+ "<TR><TD>Parola Onayi:</TD>"
				+ "	<TD colspan=5><input type='password'  name='password2' value = ''>  </TD>"
				+ "</TR>"
				+ "<TR><TD>E-posta:</TD>"
				+ "	<TD colspan=5><input type='text'  name='email' value = '' >  </TD>"
				+ "</TR>"
				+ "</table>"
				+ "<p> Kisisel Bilgiler <p/>"
				+

				"<table>"
				+ "<TR><TD>Adiniz:</TD>"
				+ "<TD colspan=5><input typ'text'  name='isim' id  = 'ad' value = ''>  </TD>"
				+ "</TR>"
				+ "<TR><TD>Soyadiniz:</TD>"
				+ "	<TD colspan=5><input type='text'  name='soyisim' value = '' > </TD>"
				+ "</TR>"
				+ "<TR><TD>Telefon Numaraniz:</TD>"
				+ "	<TD colspan=5><input type='text'  name='tel' value = '' > </TD>"
				+ "</TR>"
				+ "<TR><TD>Cinsiyetiniz</TD>"
				+ "	<TD colspan=5><input type='radio'  name='erkek'> <span> Erkek </span>  "
				+ "				  <input type='radio'  name='bayan' ><span>Bayan</span></TD>"
				+ "</TR>"
				+ "<TR><TD>Sehriniz:</TD>"
				+ "	<TD><select name='city'>  "
				+ "		<option value='Default'>(L�tfen ya�ad���n�z �ehri se�iniz)</option>"
				+ "		<option value='Adana'>Adana</option>"
				+ "		<option value='Bursa'>Bursa</option>  "
				+ "		<option value='�stanbul'>�stanbul</option>"
				+ "		<option value='Samsun'>Samsun</option>  "
				+ "		<option value='Tokat'>Tokat</option>  "
				+ "		<option value='Zonguldak'>Zonguldak</option> </select><TD/>"
				+

				"</TR></table>" + "<INPUT TYPE='SUBMIT' VALUE='Kay�t Ol'>"
				+ "</fielset>     </div>           " + "</fielset> "
				+ "</form></header>" + "<div id='main'>"
				+ "<div class='home-featured'>" + "<ul id='filter-buttons'>"
				+ "<li><a href='hakkimizda' >Hakk�m�zda</a></li>"
				+ "	<li><a href='iletisim' >�leti�im Bilgilerimiz</a></li>"
				+ "</ul></div></div></div></div>"

				+ "</body> </html>");
	}
}
