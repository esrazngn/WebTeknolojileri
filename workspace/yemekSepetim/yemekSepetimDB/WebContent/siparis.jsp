<%@page import="com.odev.denemeclass"%>
<%@page import="beans.Yiyecek"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="beans.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page trimDirectiveWhitespaces="true"%>
<jsp:useBean id="obj" class="beans.LoginBean" />

<jsp:setProperty property="*" name="obj" />
<%obj.setadres(session.getAttribute("adres").toString());
session.setAttribute("adres", obj.getadres());
System.err.println("adres"+ obj.getadres()); %>

<%
	request.setCharacterEncoding("UTF-8");

%>

<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">
<jsp:useBean id="cart" scope="session" class="beans.ShoppingCart" />
<jsp:useBean id="yiyecek" scope="session" class="beans.Yiyecek" />

<html class='no-js'>
<HEAD>
<TITLE>Sipariş</TITLE>
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
					String id = request.getParameter("id");
					if (id != null) {
						String desc = request.getParameter("desc")
								;
						Float price = new Float(request.getParameter("price"));

						cart.addItem(id, desc, price.floatValue(), 1);
					}
				%>

				<a href="siparisGoster.jsp">Sepete Git: </a>
				<%=cart.getNumOfItems()%>
				<hr>
				<center>
					<h3>Sipariş Ekle</h3>
				</center>
				<table border="1" width="300" cellspacing="0" cellpadding="2"
					align="center">
					<h3>
						<tr>
							<th>Yemek Seçeneklerimiz</th>
							<th>Fiyat</th>
						</tr>
					</h3>
					<%
						ArrayList<Yiyecek> yemek = denemeclass.yiyecekDondur("tb_yemek");
						for (int i = 0; i < yemek.size(); i++) {
					%>

					<tr>
						<form action="siparis.jsp" method="post">
							<td><%=yemek.get(i).getKey()%></td>
							<td><%=yemek.get(i).getValue()%></td>
							<td><input type="submit" name="Submit" value="Ekle"></td>
							<input type="hidden" name="id" value=<%=yemek.get(i).getId()%>>
							<input type="hidden" name="desc"
								value="<%=yemek.get(i).getKey()%>"> <input type="hidden"
								name="price" value=<%=yemek.get(i).getValue()%>>
						</form>
					</tr>
					<%
						}
					%>
					<h3>
						<tr>
							<th>İçecek Seçeneklerimiz</th>
							<th>Fiyat</th>
						</tr>
					</h3>

					<%
						ArrayList<Yiyecek> icecek = denemeclass.yiyecekDondur("tb_icecek");
						for (int i = 0; i < icecek.size(); i++) {
					%>

					<tr>
						<form action="siparis.jsp" method="post">
							<td><%=icecek.get(i).getKey()%></td>
							<td><%=icecek.get(i).getValue()%></td>
							<td><input type="submit" name="Submit" value="Ekle"></td>
							<input type="hidden" name="id" value=<%=icecek.get(i).getId()%>>
							<input type="hidden" name="desc"
								value="<%=icecek.get(i).getKey()%>"> <input type="hidden"
								name="price" value=<%=icecek.get(i).getValue()%>>
						</form>
					</tr>
					<%
						}
					%>
					<h3>
						<tr>
							<br><th>Salata Seçeneklerimiz</th>
							<th>Fiyat</th>
						</tr>
					</h3>

					<%
						ArrayList<Yiyecek> salata = denemeclass.yiyecekDondur("tb_salata");
						for (int i = 0; i < salata.size(); i++) {
					%>

					<tr>
						<form action="siparis.jsp" method="post">
							<td><%=salata.get(i).getKey()%></td>
							<td><%=salata.get(i).getValue()%></td>
							<td><input type="submit" name="Submit" value="Ekle"></td>
							<input type="hidden" name="id" value=<%=salata.get(i).getId()%>>
							<input type="hidden" name="desc"
								value="<%=salata.get(i).getKey()%>"> <input type="hidden"
								name="price" value=<%=salata.get(i).getValue()%>>
						</form>
					</tr>
					<%
						}
					%>
				</table>
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