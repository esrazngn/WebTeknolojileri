<%@page import="org.apache.catalina.Session"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<jsp:useBean id="obj" class="beans.LoginBean" />

<jsp:setProperty property="*" name="obj" />
<%obj.setadres(session.getAttribute("adres").toString());
session.setAttribute("adres", obj.getadres());
System.err.println("adres"+ obj.getadres()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<
<html class='no-js'>
<HEAD>
<TITLE>Erişim Ekranı</TITLE>
<link rel='stylesheet' media='all' href='css/style.css' />
<meta name='viewport' content='width=device-width, initial-scale=1' />
<script src='js/jquery-1.7.1.min.js'></script>
<script src='js/custom.js'></script>
<script src='js/tabs.js'></script>
<script src='js/css3-mediaqueries.js'></script>
<script src='js/jquery.columnizer.min.js'></script>
<script src='js/jquery.isotope.min.js'></script>
<script src='js/jquery.easing.js'></script>
<script src='js/lof-slider.js'></script>
<link rel='stylesheet' href='css/lof-slider.css' media='all' />
<link rel='stylesheet' href='css/jquery.tweet.css' media='all' />
<script src='js/tweet/jquery.tweet.js'></script>
<link rel='stylesheet' media='screen' href='css/superfish.css' />
<script src='js/superfish-1.4.8/js/hoverIntent.js'></script>
<script src='js/superfish-1.4.8/js/superfish.js'></script>
<script src='js/superfish-1.4.8/js/supersubs.js'></script>
<script src='js/prettyPhoto/js/jquery.prettyPhoto.js'></script>
<link rel='stylesheet' href='js/prettyPhoto/css/prettyPhoto.css'
	media='screen' />
<link rel='stylesheet'
	href='js/poshytip-1.1/src/tip-twitter/tip-twitter.css' />
<link rel='stylesheet'
	href='js/poshytip-1.1/src/tip-yellowsimple/tip-yellowsimple.css' />
<script src='js/poshytip-1.1/src/jquery.poshytip.min.js'></script>
<script type='text/javascript' src='js/jquery.jcarousel.min.js'></script>
<link rel='stylesheet' media='screen' href='css/carousel.css' />
<link href='http://fonts.googleapis.com/css?family=Voltaire'
	rel='stylesheet' type='text/css'>
<script src='js/modernizr.js'></script>
<link rel='stylesheet' media='all' href='css/skin.css' />
<link rel='stylesheet' media='all' href='css/lessframework.css' />
<link rel='stylesheet' href='css/flexslider.css'>
<script src='js/jquery.flexslider.js'></script>


</head>
<body>
	<header>
	<div class='wrapper cf'>
		<div id='logo'>
			" <a href='uyeGirisAnasayfa.jsp'><img src='img/logo.png'
				alt='Simpler'></a>
		</div>
		<ul id='nav' class='sf-menu'>
			<li class='current-menu-item'><a href='uyeGirisAnasayfa.jsp'>Anasayfa</a></li>
			<li><a href='erisimEkrani.jsp'>Erişim Ekranı</a>
			<li><a href='cikis.jsp'>Çıkış Yap</a></li>
		</ul>
		<div id='combo-holder'></div>
	</div>
	</header>

	<div id='main'>
		<div class='wrapper cf'>
			

			<div id='portfolio-content' class='cf'>
				<p align=center>
				<h5>Admin Girişi Lütfen İşlem Seçiniz</h5>
				</p>
				<form action='erisimEkraniSec'>
					<table border=0 cellpadding=1 align=center>
						
						<TR>
							<TD><input type='submit' name='listele'
								value='Sipariş Listele' /></TD>
						</tr>
						<TR>
							<TD><input type='submit' name='yiyecekEkle' value='Yiyecek Ekle'
								 /></TD>
						</tr>
						<TR>
							<TD><input type='submit' name='fiyat' value='Fiyat Güncelle'
								 /></TD>
						</tr>
						<TR>
							<TD><input type='submit' name='kullaniciGuncelle' value='Kullanıcı Güncelle'
								 /></TD>
						</tr>
						<TR>
							<TD><input type='submit' name='kullaniciSil' value='Kullanıcı Sil'
								 /></TD>
						</tr>
						

					</table>
				</form>
				</header>
				</br>
				</br>

				<div id='main'>
					<div class='home-featured'>
						<ul id='filter-buttons'>
							<li><a href='hakkimizda.jsp'>Hakkımızda</a></li>
							<li><a href='iletisim.jsp'>İletişim Bilgilerimiz</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
</body>
</html>