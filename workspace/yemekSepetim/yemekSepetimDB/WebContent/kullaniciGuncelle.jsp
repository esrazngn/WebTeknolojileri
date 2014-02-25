<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="beans.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">

<html class='no-js'>
<HEAD>
<TITLE>Kullanıcı Güncelleme Ekranı</TITLE>
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
				<jsp:useBean id="obj" class="beans.Yiyecek" />

				<form name='form1' method='post' action="kullaniciguncelleprocess.jsp">
					<h1>Şifre Güncelle</h1>
					</br>
					<%
						String  idim = "admin";
						String kullaniciAd, kullaniciSifre = "****";
						if (session.getAttribute("ad") != null) {
							idim = session.getAttribute("ad").toString();
							kullaniciAd = DatabaseConnection.kullaniciSorgula(idim, "tb_kullanicilar", "ad");
							kullaniciSifre = DatabaseConnection.kullaniciSorgula(idim, "tb_kullanicilar", "sifre");
						} else
							kullaniciAd = "Seçiniz...";
					%>
					<table border=0 cellpadding=1>
						<TR>
							<TD>Kullanıcı ID:</TD>
							<td><select name="id">
									<option value=<%=idim%>><%=idim%></option>"
									<%
										Connection con = null;
										ResultSet rs = null;

										try {
											Class.forName("com.mysql.jdbc.Driver");
											con = DriverManager.getConnection(
													"jdbc:mysql://localhost:3306/yemeksepetim", "root",
													"test");
											HttpSession ss = request.getSession();

											PreparedStatement pst = con
													.prepareStatement("select * from tb_kullanicilar");

											rs = pst.executeQuery();
											while (rs.next()) {
												String id = rs.getString("userid");
									%>
									<option value="<%=id%>"><%=id%></option>

									<%
										}
										} catch (Exception e) {
											out.print(e);
										}
									%>

							</select></td>
						</tr>
						<tr>
							<TD>Kullanıcı Adı:</TD>
							<TD colspan=5>
								<%
									out.println(kullaniciAd);
								%>
							</TD>
						</TR>
						<TD>Kullanıcı Şifre:</TD>
						<TD colspan=5>
							<%
								out.println(kullaniciSifre);
							%>
						</TD>
						</TR>
						<TR>
							<TD>Kullanıcı Yeni Şifre :</TD>
							<TD colspan=5><input type='text' name='value' value=0000></TD>
						</TR>


					</table>
					<INPUT TYPE='SUBMIT' VALUE='Tamam'>

				</form>


				</br>
				



			</header>
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