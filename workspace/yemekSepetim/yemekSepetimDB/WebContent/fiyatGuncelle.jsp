<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="beans.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">

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
				<ul id="nav" class="sf-menu">
					<li class="current-menu-item"><a href="uyeGirisAnasayfa.jsp">Anasayfa</a></li>
					<li><a href="erisimEkrani.jsp">Erişim Ekranı</a></li>
					<li><a href="cikis.jsp">Çıkış Yap</a>
					</li>
					
				</ul>
		<div id='combo-holder'></div>
	</div>
	</header>
	<div id='main'>
		<div class='wrapper cf'>
			<div id='portfolio-content' class='cf'>
				<jsp:useBean id="obj" class="beans.Yiyecek" />

				<form name='form1' method='post' action="yemekfiyatprocess.jsp">
					<h1>Yemek Fiyat Güncelle</h1>
					</br>
					<%
						int idim = 1;
						String yemekAd, yemekFiyat = "0.0";
						if (session.getAttribute("ad1") != null) {
							idim = Integer.parseInt(session.getAttribute("ad1").toString());
							yemekAd = DatabaseConnection.sorgula(idim, "tb_yemek", "ad");
							yemekFiyat = DatabaseConnection.sorgula(idim, "tb_yemek",
									"fiyat");
						} else
							yemekAd = "Seçiniz...";
					%>
					<table border=0 cellpadding=1>
						<TR>
							<TD>Yemek ID:</TD>
							<%-- Yemeğin adını da seçtirebilirdik ama burda id seçtirme nedenim id il databaseden adını çekmektir. --%>
							<td><select name="id1">
									<option value=<%=idim%>><%=idim%></option>"
									<%
										ArrayList<String> yemek = new ArrayList();
										Connection con = null;
										ResultSet rs = null;

										try {
											Class.forName("com.mysql.jdbc.Driver");
											con = DriverManager.getConnection(
													"jdbc:mysql://localhost:3306/yemeksepetim", "root",
													"test");
											HttpSession ss = request.getSession();

											PreparedStatement pst = con
													.prepareStatement("select * from tb_yemek");

											rs = pst.executeQuery();
											while (rs.next()) {
												int id1 = rs.getInt("id");
									%>
									<option value="<%=id1%>"><%=id1%></option>

									<%
										}
										} catch (Exception e) {
											out.print(e);
										}
									%>

							</select></td>
						</tr>
						<tr>
							<TD>Yemek Adı:</TD>
							<TD colspan=5>
								<%
									out.println(yemekAd);
								%>
							</TD>
						</TR>
						<TD>Yemek Fiyatı:</TD>
						<TD colspan=5>
							<%
								out.println(yemekFiyat);
							%>
						</TD>
						</TR>
						<TR>
							<TD>Yemek Yeni Fiyatı :</TD>
							<TD colspan=5><input type='text' name='value' value=0.0
								onchange="if (!validate(this.value)) { alert('incorrect value'); this.value = ''; }">

								<script>
									​
								</script>
						</TR>


					</table>
					<INPUT TYPE='SUBMIT' VALUE='Tamam'>

				</form>


				</br>
				<form name='form1' method='post' action="icecekfiyatprocess.jsp">
					<h1>İçecek Fiyat Güncelle</h1>
					</br>
					<%
						int idim2 = 1111;
						String icecekAd, icecekFiyat = "0.0 ";
						if (session.getAttribute("ad2") != null) {
							idim2 = Integer
									.parseInt(session.getAttribute("ad2").toString());
							icecekAd = DatabaseConnection.sorgula(idim2, "tb_icecek", "ad");
							icecekFiyat = DatabaseConnection.sorgula(idim2, "tb_icecek",
									"fiyat");
						} else
							icecekAd = "Seçiniz...";
					%>
					<table border=0 cellpadding=1>
						<TR>
							<TD>İçecek ID:</TD>
							<td><select name="id2">
									<option value=<%=idim2%>><%=idim2%></option>"
									<%
										try {
											Class.forName("com.mysql.jdbc.Driver");
											con = DriverManager.getConnection(
													"jdbc:mysql://localhost:3306/yemeksepetim", "root",
													"test");
											HttpSession ss = request.getSession();

											PreparedStatement pst = con
													.prepareStatement("select * from tb_icecek");

											rs = pst.executeQuery();
											while (rs.next()) {
												int id2 = rs.getInt("id");
									%>
									<option value="<%=id2%>"><%=id2%></option>

									<%
										}
										} catch (Exception e) {
											out.print(e);
										}
									%>

							</select></td>
						</tr>
						<TR>
							<TD>İçecek Adı:</TD>
							<TD colspan=5>
								<%
									out.println(icecekAd);
								%>
							</TD>
						</TR>
						<TR>
							<TD>İçecek Fiyatı:</TD>
							<TD colspan=5>
								<%
									out.println(icecekFiyat);
								%>
							</TD>
						</TR>
						<TR>
							<TD>İçecek Yeni Fiyatı :</TD>
							<TD colspan=5><input type='text' name='value' value=0.0></TD>
						</TR>

					</table>
					<INPUT TYPE='SUBMIT' VALUE='Tamam'>


				</form>
				</br>
				<form name='form3' method='post' action="salatafiyatprocess.jsp">
					<h1>Salata Ekle</h1>
					</br>
					<%
						int idim3 = 11111;
						String salataAd, salataFiyat = "0.0 ";
						if (session.getAttribute("ad3") != null) {
							idim3 = Integer
									.parseInt(session.getAttribute("ad3").toString());
							salataAd = DatabaseConnection.sorgula(idim3, "tb_salata", "ad");
							salataFiyat = DatabaseConnection.sorgula(idim3, "tb_salata",
									"fiyat");
						} else
							salataAd = "Seçiniz...";
					%>
					<table border=0 cellpadding=1>
						<TR>
							<TD>Salata ID:</TD>
							<td><select name="id3">
									<option value=<%=idim3%>><%=idim3%></option>"
									<%
										try {
											Class.forName("com.mysql.jdbc.Driver");
											con = DriverManager.getConnection(
													"jdbc:mysql://localhost:3306/yemeksepetim", "root",
													"test");
											HttpSession ss = request.getSession();

											PreparedStatement pst = con
													.prepareStatement("select * from tb_salata");

											rs = pst.executeQuery();
											while (rs.next()) {
												int id3 = rs.getInt("id");
									%>
									<option value="<%=id3%>"><%=id3%></option>

									<%
										}
										} catch (Exception e) {
											out.print(e);
										}
									%>

							</select></td>
						</tr>
						<TR>
							<TD>Salata Adı:</TD>
							<TD colspan=5>
								<%
									out.println(salataAd);
								%>
							</TD>
						</TR>
						<TR>
							<TD>Salata Fiyatı:</TD>
							<TD colspan=5>
								<%
									out.println(salataFiyat);
								%>
							</TD>
						</TR>
						<TR>
							<TD>Salata Yeni Fiyatı :</TD>
							<TD colspan=5><input type='text' name='value' value=0.0></TD>
						</TR>

					</table>
					<INPUT TYPE='SUBMIT' VALUE='Tamam'>
			</div>
			</fielset>

			</form>



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