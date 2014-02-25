<%@page import="com.odev.CookieUtilities"%>
<%@page import="com.odev.SendMailSSL"%>
<%@page import="net.codejava.email.EmailSendingServlet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="beans.DatabaseConnection"%>
<jsp:useBean id="kk" class="beans.kredi" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class='no-js'>
				<HEAD><TITLE>Üye Giriş
				</TITLE><link rel='stylesheet' media='all' href='css/style.css'/>
<meta name='viewport' content='width=device-width, initial-scale=1'/>
<script src='js/jquery-1.7.1.min.js'></script>
<script src='js/custom.js'></script>
<script src='js/tabs.js'></script>
<script src='js/css3-mediaqueries.js'></script>
<script src='js/jquery.columnizer.min.js'></script>
<script src='js/jquery.isotope.min.js'></script>
<script src='js/jquery.easing.js'></script>
<script src='js/lof-slider.js'></script>
<link rel='stylesheet' href='css/lof-slider.css' media='all'  />
<link rel='stylesheet' href='css/jquery.tweet.css' media='all'  />
<script src='js/tweet/jquery.tweet.js' ></script> 
<link rel='stylesheet' media='screen' href='css/superfish.css' />
<script  src='js/superfish-1.4.8/js/hoverIntent.js'></script>
<script  src='js/superfish-1.4.8/js/superfish.js'></script>
<script  src='js/superfish-1.4.8/js/supersubs.js'></script>
<link rel='stylesheet' href='js/prettyPhoto/css/prettyPhoto.css'  media='screen' />
<link rel='stylesheet' href='js/poshytip-1.1/src/tip-twitter/tip-twitter.css'  />
<link rel='stylesheet' href='js/poshytip-1.1/src/tip-yellowsimple/tip-yellowsimple.css'  />
<script  src='js/poshytip-1.1/src/jquery.poshytip.min.js'></script>
<script type='text/javascript' src='js/jquery.jcarousel.min.js'></script>
<link rel='stylesheet' media='screen' href='css/carousel.css' /> 
<link href='http://fonts.googleapis.com/css?family=Voltaire' rel='stylesheet' type='text/css'>
<script src='js/modernizr.js'></script>
<link rel='stylesheet' media='all' href='css/skin.css'/>
<link rel='stylesheet' media='all' href='css/lessframework.css'/>
<link rel='stylesheet' href='css/flexslider.css' >
<script src='js/jquery.flexslider.js'></script>
</head><body><header>
<div class='wrapper cf'>
<div id='logo'>
<a href='anasayfa.jsp'><img  src='img/logo.png' alt='Simpler'></a>
</div><ul id='nav' class='sf-menu'>
<li class='current-menu-item'><a href='anasayfa.jsp'>Anasayfa</a></li>
<li><a href='uyeKayit.jsp'>Kayıt Ol</a></li>
<li><a href='uyeGiris.jsp'>Üye Girişi</a></ul>
<div id='combo-holder'></div>
</div></header><div id='main'><div class='wrapper cf'>
<div id='portfolio-content' class='cf'>
	<% String Dcode = "22"; 
	boolean durum;
	if(request.getParameter("Gcode")!= null){
		if(request.getParameter("Gcode").toString().equals(Dcode)){
			double fiyat = Double.parseDouble(session.getAttribute("fiyat").toString());
			durum = DatabaseConnection.updateBakiye(kk, fiyat);
			System.err.println("bakiye:"+kk.getBakiye());

			System.err.println("fiyat:"+fiyat);
			System.err.println("bakiye:"+kk.getBakiye());

			
			if(durum){
				%>
				İşleminiz Başarılı
				<%}
				else
					response.sendRedirect("siparis.jsp");
			
		}
	}
		else{
	
	%>
   Lütfen mail adresinize gelen Doğrulama Kodunu giriniz:
   
   <form action="dogrulama.jsp">
   <input type='text' name='Gcode' VALUE = ""> 
   <input type='submit'value ='Giriş' />
   
   </form>
   
   <%} %>
     </div>
</fielset></br> </br> </br></br> </br>  </br></br> </br>
</form></header><div id='main'><div class='home-featured'><ul id='filter-buttons'>
<li><a href='hakkimizda.jsp' >Hakkımızda</a></li>
<li><a href='iletisim.jsp' >İletişim Bilgilerimiz</a></li></ul></div></div>
</body> </html>