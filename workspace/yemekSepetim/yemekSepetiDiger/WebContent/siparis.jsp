<%@page import="com.odev.Test"%>
<%@page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
   
    <%@page import="java.util.ArrayList"%>
<%@page import="com.odev.Yiyecek"%>
<%@page import= "java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%List<Yiyecek> yiyecekListesi = new ArrayList<Yiyecek>();
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
icecekListesi.add( new Yiyecek( "Su 1.00 TL" ,1.00) );%>
<html class="no-js">

	<head>
	<script type="text/javascript">
	function yemekEkle() {	
		var adeti = parseInt(document.siparis.yemekkAdet.value);
	    document.getElementById('area1').value = document.getElementById('area1').value +document.getElementById('yiyecekler').value +" "+ adeti+" adet "+"\n";
	
	    //document.getElementById('area1').value = document.getElementById('area1').value +document.getElementById('yemekler').value+ value.replace('&nbsp', ' ').replace('&nbsp', ' ').replace('&nbsp', ' ').replace('&nbsp', ' ');
	}
	function icecekEkle() {
		var adeti = parseInt(document.siparis.icecekAdet.value);
	    document.getElementById('area2').value = document.getElementById('area2').value +document.getElementById('icecekler').value.replace('&nbsp', ' ').replace('&nbsp', ' ').replace('&nbsp', ' ').replace('&nbsp', ' ') +" "+ adeti+" adet "+"\n";
	}function salataEkle() {
		var adeti = parseInt(document.siparis.salataAdet.value);
	    document.getElementById('area3').value = document.getElementById('area3').value + document.getElementById('salatalar').value.replace('&nbsp', ' ').replace('&nbsp', ' ').replace('&nbsp', ' ').replace('&nbsp', ' ')+" "+ adeti+" adet "+"\n";
	}
	</script>
		<meta charset="utf-8"/>
		<title>Siparis Ekranı</title>
		<link rel="stylesheet" media="all" href="css/style.css"/>
		<meta name="viewport" content="width=device-width, initial-scale=1"/>
		<!-- Adding "maximum-scale=1" fixes the Mobile Safari auto-zoom bug: http://filamentgroup.com/examples/iosScaleBug/ -->		
				
		<!-- JS -->
		<script src="js/jquery-1.7.1.min.js"></script>
		<script src="js/custom.js"></script>
		<script src="js/tabs.js"></script>
		<script src="js/css3-mediaqueries.js"></script>
		<script src="js/jquery.columnizer.min.js"></script>
		
		<!-- Isotope -->
		<script src="js/jquery.isotope.min.js"></script>
		
		<!-- Lof slider -->
		<script src="js/jquery.easing.js"></script>
		<script src="js/lof-slider.js"></script>
		<link rel="stylesheet" href="css/lof-slider.css" media="all"  /> 
		<!-- ENDS slider -->
		
		<!-- Tweet -->
		<link rel="stylesheet" href="css/jquery.tweet.css" media="all"  /> 
		<script src="js/tweet/jquery.tweet.js" ></script> 
		<!-- ENDS Tweet -->
		
		<!-- superfish -->
		<link rel="stylesheet" media="screen" href="css/superfish.css" /> 
		<script  src="js/superfish-1.4.8/js/hoverIntent.js"></script>
		<script  src="js/superfish-1.4.8/js/superfish.js"></script>
		<script  src="js/superfish-1.4.8/js/supersubs.js"></script>
		<!-- ENDS superfish -->
		
		<!-- prettyPhoto -->
		<script  src="js/prettyPhoto/js/jquery.prettyPhoto.js"></script>
		<link rel="stylesheet" href="js/prettyPhoto/css/prettyPhoto.css"  media="screen" />
		<!-- ENDS prettyPhoto -->
		
		<!-- poshytip -->
		<link rel="stylesheet" href="js/poshytip-1.1/src/tip-twitter/tip-twitter.css"  />
		<link rel="stylesheet" href="js/poshytip-1.1/src/tip-yellowsimple/tip-yellowsimple.css"  />
		<script  src="js/poshytip-1.1/src/jquery.poshytip.min.js"></script>
		<!-- ENDS poshytip -->
		
		<!-- JCarousel -->
		<script type="text/javascript" src="js/jquery.jcarousel.min.js"></script>
		<link rel="stylesheet" media="screen" href="css/carousel.css" /> 
		<!-- ENDS JCarousel -->
		
		<!-- GOOGLE FONTS -->
		<link href='http://fonts.googleapis.com/css?family=Voltaire' rel='stylesheet' type='text/css'>

		<!-- modernizr -->
		<script src="js/modernizr.js"></script>
		
		<!-- SKIN -->
		<link rel="stylesheet" media="all" href="css/skin.css"/>
		
		<!-- Less framework -->
		<link rel="stylesheet" media="all" href="css/lessframework.css"/>
		
		<!-- jplayer -->
		<link href="player-skin/jplayer-black-and-yellow.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.jplayer.min.js"></script>
		
		<!-- flexslider -->
		<link rel="stylesheet" href="css/flexslider.css" >
		<script src="js/jquery.flexslider.js"></script>


	</head>
	
	
	<body>
	
		<!-- HEADER -->
		<header>
			<div class="wrapper cf">
				
				<div id="logo">
					<a href="anasayfa.jsp"><img  src="img/logo.png" alt="Simpler"></a>
				</div>
				
				<!-- nav -->
				<ul id="nav" class="sf-menu">
					<li class="current-menu-item"><a href="anasayfa.jsp">Anasayfa</a></li>
					<li><a href="uyeKayit.jsp">Kayıt Ol</a></li>
					<li><a href="uyeGiris.jsp">Üye Girişi</a>
					<li><a href="siparis.jsp">Sipariş Ver</a>
				</ul>
				<div id="combo-holder"></div>
				<!-- ends nav -->

			</div>
		</header>
		<!-- ENDS HEADER -->
		
		<!-- MAIN -->
		<div id="main">
			<div class="wrapper cf">
			
			
				
			<!-- portfolio content-->
        	<div id="portfolio-content" class="cf">        	

<fieldset><legend><h1>Siparişinizi Seçiniz </h1> </br> </legend> 
<form name = 'siparis' action="siparisVer" method="post">
<fieldset><legend><h4>Yemek Seçimi</h4></br> </legend>
<table>

<tr><td><h5>Yemekler</h5> </td>

	<td><select name = "yemekler" id="yemekler">
			<% for(int i=0; i<yiyecekListesi.size(); i++) {%>
			<option value=<%= i %>><%=yiyecekListesi.get(i).getKey()%></option>
			<%} %>
			
		</select></td>
		</tr>
		<tr><td><h5>Adet</h5></br> </br></td>
			<TD><input type='text' name='yemekAdet' value = 0></TD>
			<td><INPUT TYPE='button' name = 'ok1' value='OK' onclick="javascript:yemekEkle()" ></td>
			<td><textarea rows='3' id = 'area1' cols='30'></textarea></td>
			<td><input type='text' id = 'yemekAdetSec' value = ''></td></tr> 
			</table></fieldset>
	<fieldset><legend><h4>İcecek Secimi</h4></br></legend>
	<table>
	
		<TR><TD><h5>İçecekler : </h5> </br></TD>
			<td><select name='icecekler' ids="icecekler">
				<% for(int i=0; i<icecekListesi.size(); i++) {%>
			<option value=<%=i %>><%=icecekListesi.get(i).getKey()%></option>
			<%} %>
				</select></td>
		</tr>
		<tr><td><h5>Adet</h5> </br> </br></td>
			<TD><input type='text' name='icecekAdet' value = 0></TD>
			<td><INPUT TYPE='button' name = 'ok2' value='OK' onclick="javascript:icecekEkle()"></td>
			<td><textarea id = 'area2' rows='3' cols='30'></textarea></td>
			<td><input type='text' name='icecekAdetSec' value = ''></td></tr>
			</table></fieldset>
	<fieldset><legend><h4>Salata Secimi</h4></br></legend>
	<table>
		
		
		<TR><TD><h5>Salatalar :</h5></br></TD>
			<td><select name='salatalar' id="salatalar">
				<% for(int i=0; i<salataListesi.size(); i++) {%>
			<option value=<%=i %>><%=salataListesi.get(i).getKey()%></option>
			<%} %>
				</select></td>
				
		</tr>
		<<tr><td><h5>Adet</h5> </br> </br></td>
			<TD><input type='text' name='salataAdet' value = 0></TD>
			<td><INPUT TYPE='button' name = 'ok2' value='OK' onclick="javascript:salataEkle()"></td>
			<td><textarea id = 'area3' rows='3' cols='30'></textarea></td>
			<td><input type='text' name='salataAdetSec' value = ''></td></tr>
			</table></fieldset>
	</fieldset>
	<p align=right>SiparisID <input type='text' name='siparisID' value = ''> Toplam Tutar <input type='text' name='toplamTutar' value = ''>
		    		    	    			<br/><p align=right> <INPUT TYPE='button' value='Siparis Onayla' >
		    		    	    			
</form>
</header>
<!-- MAIN -->
		<div id="main">
			
			
			
			
				
			<!-- featured -->
			<div class="home-featured">
			
				<ul id="filter-buttons">
					<li><a href="http://localhost:8080/yemekSepetim/siparis.jsp" >Hakkımızda</a></li>
					<li><a href="#" >İletişim Bilgilerimiz</a></li>
				</ul>
				
				<!-- Filter container -->
				
				
			</div>
			<!-- ENDS featured -->
			
			
			
			
		</div>
		<!-- ENDS MAIN -->
</body>
</html>