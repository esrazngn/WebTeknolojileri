<%@page import="beans.Yiyecek"%>
<%@page import="beans.siparisBean"%>
<%@page import="com.odev.SendMailSSL"%>
<%@page import="net.codejava.email.EmailSendingServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.odev.denemeclass"%>
<%@page import="beans.Yiyecek"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="java.text.DecimalFormat"%>
<jsp:useBean id="sip" class="beans.siparisBean" />
<jsp:setProperty property="*" name="sip" />

<%@page import="beans.DatabaseConnection"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="obj" class="beans.LoginBean" />

<jsp:setProperty property="*" name="obj" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="beans.DatabaseConnection"%>

<%
	sip = (siparisBean) session.getAttribute("sip");
	System.err.println("sip" + sip.getyemek().get(0).getId());
	System.err.println("sip" + sip.geticecek().get(0).getId());
	obj.setadres(session.getAttribute("adres").toString());
	session.setAttribute("adres", obj.getadres());
	System.err.println("adres" + obj.getadres());
%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="kk" class="beans.kredi" />
<jsp:setProperty property="*" name="kk" />



<%
	Boolean durum = true;
	String kod;
	int code;
%><!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">

<html class='no-js'>
<HEAD>
<TITLE>Fiyat Güncelleme Ekranı</TITLE>
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
			<a href='anasayfa.jsp'><img src='img/logo.png' alt='Simpler'></a>
		</div>
		<!-- nav -->
				<ul id="nav" class="sf-menu">
					<li class="current-menu-item"><a href="uyeGirisAnasayfa.jsp">Anasayfa</a></li>
					<li><a href="siparis.jsp">Sipariş Ver</a></li>
					<li><a href="cikis.jsp">Çıkış Yap</a>
					</li>
					
				</ul>
		<div id='combo-holder'></div>
	</div>
	</header>
	<div id='main'>
		<div class='wrapper cf'>
			<div id='portfolio-content' class='cf'>
				<%
					if (request.getParameter("Gcode") == null) {
						code = SendMailSSL.randomCode();
						session.setAttribute("code", code);
						System.err.println("kkbak:" + kk.getAd());

						durum = beans.DatabaseConnection.KKsorgula(kk);
						System.err.println("kkbak:" + kk.getBakiye());
						if (durum) {
							durum = SendMailSSL.mailgonder(code, obj.getadres());
							System.err.println("code:" + code);
							session.setAttribute("kk", kk);
						}
				%>
				Lütfen mail adresinize gelen Doğrulama Kodunu giriniz:

				<form action="odemeprocess.jsp" method="post">
					<input type='text' name='Gcode' VALUE=""> <input
						type="hidden" name="no" value=<%=kk.getNo()%>> <input
						type="hidden" name="ad" value=<%=kk.getAd()%>> <input
						type="hidden" name="bakiye" value=<%=kk.getBakiye()%>> <input
						type="hidden" name="csv" value=<%=kk.getcsv()%>> <input
						type="hidden" name="skt" value=<%=kk.getskt()%>> <input
						type="hidden" name="soyad" value=<%=kk.getSoyad()%>> <input
						type='submit' value='Giriş' />
				</form>
				<%
					} else {
						if (durum) {

							code = Integer.parseInt(session.getAttribute("code")
									.toString());
							System.err.println("durum1");
							System.err.println("durum" + request.getParameter("Gcode"));

							System.err.println("durum2");

							System.err.println("--code:"
									+ request.getParameter("Gcode") + "codeeee" + code);
							String gcode = request.getParameter("Gcode").toString();
							if (gcode.equals(code + "")) {
								double fiyat = Double.parseDouble(session.getAttribute(
										"fiyat").toString());
								System.err.println("--kk:" + kk.getAd());

								durum = DatabaseConnection.updateBakiye(kk, fiyat);
								System.err.println("--bakiye:" + kk.getBakiye());
								System.err.println("--fiyat:" + fiyat);

								if (durum) {
									sip = (siparisBean) session.getAttribute("sip");
									sip.settoplamFiyat(fiyat);
									DatabaseConnection.siparisEkle(sip);
				%>
				<h3>İşleminiz Başarılı...!</h3>

				<%
					} else {
				%>
				<h3>İşleminiz Sırasında hata oluştu!! Tekrar denemek için <a
					href="odeme.jsp">tıklayınız...</a></h3>

				<%
					}
							}
						}
					}
				%>

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
	</div>
</body>
</html>






