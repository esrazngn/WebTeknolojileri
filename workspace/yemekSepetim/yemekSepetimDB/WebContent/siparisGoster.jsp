<%@page import="beans.siparisBean"%>
<%@page import="beans.denemeSiparis"%>
<%@page import="com.odev.denemeclass"%>
<%@page import="beans.Yiyecek"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="java.text.DecimalFormat"%>
<jsp:useBean id="sip" class="beans.siparisBean" />

<%@page import="beans.DatabaseConnection"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="obj" class="beans.LoginBean" />

<jsp:setProperty property="*" name="obj" />
<%					denemeSiparis d = new denemeSiparis();

	obj.setadres(session.getAttribute("adres").toString());
	session.setAttribute("adres", obj.getadres());
	System.err.println("adres" + obj.getadres());
%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">
<jsp:useBean id="cart" scope="session" class="beans.ShoppingCart" />
<jsp:useBean id="yiyecek" scope="session" class="beans.Yiyecek" />

<html class='no-js'>
<HEAD>
<title>Sepetiniz</title>
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
				session.setAttribute("sip", sip);
				System.out.println("siparis1a:"+sip.getyemek().size());
					if (request.getParameter("del") != null)
						cart.delete();
				%>

				<%
					if (cart.getCost() > 0.0f) {
				%><form action="siparisGoster.jsp">
					<td><input type="submit" name="del" position="relative"
						value="Sepeti Temizle"></td>

				</form>
				<%
					}
				%>
				<center>
					<table width="300" border="1" cellspacing="0" cellpadding="2"
						border="0">
						<caption>



							<%
								String id = request.getParameter("id");
								if (id != null) {
									cart.removeItem(id);
								}
							%>
							<h1>Sepetiniz</h1>
						</caption>
						<br>
						<tr>
							<th><h4>Yiyecek Adı</h4></th>
							<th><h4>Fiyat</h4></th>
							<th><h4>Adet</h4></th>
						</tr>
						<%
							Enumeration e = cart.getEnumeration();
							String[] tmpItem;
							// Iterate over the cart
							while (e.hasMoreElements()) {
								tmpItem = (String[]) e.nextElement();
								 int sipid = Integer.parseInt(tmpItem[0]);
								 int sipadet = Integer.parseInt(tmpItem[3]);
								if (sipid>110&sipid<1110){
									Yiyecek s = new Yiyecek();
								s.setId(sipid);
								s.setAdet(sipadet);

								sip.setsalata(s);
								sip.setsalataAdet(sipadet);
								System.out.println("salata:"+sipid);
								}
								else if (sipid>1110) {
									Yiyecek i = new Yiyecek();
									i.setAdet(sipadet);

									i.setId(sipid);
									sip.seticecek(i);
									sip.seticecekAdet(sipadet);
									System.out.println("icecek:"+sipid);
								}
								else{
									Yiyecek y = new Yiyecek();
									y.setId(sipid);
									y.setAdet(sipadet);
									sip.setyemek(y);
									sip.seticecekAdet(sipadet);
									System.out.println("yemek:"+sipid);
								}
								System.out.println("siparis1b:"+sip.getyemek().size());
								System.out.println("siparis3:"+sip.getsalata().size());
								System.out.println("siparis4:"+sip.geticecek().size());
								session.setAttribute("sip", sip);

									%>
								
						
						<tr>
							<td><%=tmpItem[1]%></td>
							
							<td align="center"><%=tmpItem[2]%> TL</td>
							<td align="center"><%=tmpItem[3]%></td>


							<form action="siparisGoster.jsp" method="post">
											<%session.setAttribute("sip", sip); %>
							
								<td><input type="submit" name="Submit" value="Sil"></td>
								<input type="hidden" name="id" value=<%=tmpItem[0]%>>

							</form>
						</tr>
						<%
							}
							System.out.println("siparis1c:"+sip.getyemek().size());

						%>
					</table>
					<h3>
					
						Fiyat:<%=new DecimalFormat("##.##").format(cart.getCost())%>
						<%
							String fiyat = cart.getCost() + "";

							session.setAttribute("fiyat", fiyat);
						%>
						TL Adet :<%=cart.getNumOfItems()%></h3>
				</center>
				<a href="siparis.jsp">Siparis Ekle</a>
				<%
					if (cart.getCost() > 0.0f) {
				%>
				<center>
				<form action="odeme.jsp" method="post">
				<%
				
				
				 %>
				<td><input type="submit" name="tamam" value="Sipariş Onayla"></td>
					
								
								

							</form>
					
					
				</center>
				
				
					<% ;	}
					
				%>

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