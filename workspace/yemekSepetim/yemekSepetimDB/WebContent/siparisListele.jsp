<%@page import="com.odev.denemeclass"%>
<%@page import="beans.siparisBean"%>
<%@page import="beans.Yiyecek"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="beans.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class='no-js'>
<HEAD>
<TITLE>Sipariş Listeleme</TITLE>
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
			<a href='uyeGirisAnasayfa.html'><img src='img/logo.png'
				alt='Simpler'></a>
		</div>
		<!-- nav -->
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
			

			<form action="siparisListele.jsp">
				<table>
				<tr><h1>Sipariş Listele</h1>
			</br> </br> 
				</tr>
					<tr>
						<td>Siparis ID:</td>
						<td><select name="id">
								<%
									String secilenID = null;
									if (request.getParameter("id") != null)
										secilenID = request.getParameter("id").toString();
									Connection con = null;
									ResultSet rs = null;
									ArrayList<Integer> siparisID = new ArrayList();
									ArrayList<siparisBean> si = new ArrayList();

									try {
										Class.forName("com.mysql.jdbc.Driver");
										con = DriverManager.getConnection(
												"jdbc:mysql://localhost:3306/yemeksepetim", "root",
												"test");
										HttpSession ss = request.getSession();

										PreparedStatement pst = con
												.prepareStatement("select * from tb_siparis");

										rs = pst.executeQuery();

										while (rs.next()) {
											int id = rs.getInt("id");
											siparisID.add(id);
											System.err.println("sid:" + id);
										}
										for (int i = 0; i < siparisID.size(); i++) {
											if (siparisID.get(i) != siparisID.get(i + 1)
													& i - 1 < siparisID.size()) {
								%><option value="<%=siparisID.get(i)%>"><%=siparisID.get(i)%></option>
								<%
									}
											if (i + 2 == siparisID.size()) {
								%><option value="<%=siparisID.get(i + 1)%>"><%=siparisID.get(i + 1)%></option>
								<%
									}

										}
									} catch (Exception e) {
										out.print(e);
									}
									double toplamFiyat = 0.0;

									if (secilenID != null) {
										System.out.println("asdas");
										si = DatabaseConnection.SiparisListele(Integer
												.parseInt(secilenID));
										System.out.println("boy:" + si.size());
										%>					
									
												<tr><td></br><h2>Siparişler</h2></br></td></tr><%
																											for (int i = 0; i < si.size(); i++) {
																																			toplamFiyat += si.get(i).gettoplamFiyat();
																																			System.out.println("id" + si.get(i).getID());

																																			System.out.println("toplam" + si.get(i).gettoplamFiyat());
																																			System.out.println("saadet" + si.get(i).getsalataAdet());
																																			System.out.println("icadet" + si.get(i).geticecekAdet());
																																			System.out.println("yadet" + si.get(i).getyemekAdet());
																																
																																	for (int j = 0; j < si.get(i).getyemek().size(); j++) {
																																				System.out.println("yaf"
																																						+ si.get(i).getyemek().get(j).getValue());
																																				System.out.println("yad"
																																						+ si.get(i).getyemek().get(j).getKey());
																																				System.out.println("yid"
																																						+ si.get(i).getyemek().get(j).getId());
																										%>
											<tr><td><%=si.get(i).getyemek().get(j).getKey()%></td>
											
											<td><%=si.get(i).getyemekAdet()%> Adet</td>
											

									<%
																					}
																													for (int j = 0; j < si.get(i).geticecek().size(); j++) {
																														System.out.println("iaf"
																																+ si.get(i).geticecek().get(j).getValue());
																														System.out.println("iad"
																																+ si.get(i).geticecek().get(j).getKey());
																														System.out.println("iid"
																																+ si.get(i).geticecek().get(j).getId());
																				%>
												<tr><td><%=si.get(i).geticecek().get(j).getKey()%></td>
												
												<td><%=si.get(i).geticecekAdet()%> Adet</td>
												<%
												}
											for (int j = 0; j < si.get(i).getsalata().size(); j++) {
												System.out.println("saf"
														+ si.get(i).getsalata().get(j).getValue());
												System.out.println("sad"
														+ si.get(i).getsalata().get(j).getKey());
												System.out.println("sid"
														+ si.get(i).getsalata().get(j).getId());
												%>
												<tr><td><%=si.get(i).getsalata().get(j).getKey() %></td>
												
												<td><%=si.get(i).getsalataAdet()%> Adet</td>
												<%
			
									}
										}
									}
								%>
								<tr>
									<td><h4>Siparis Tutarı:</h4></td>
									<td><%=toplamFiyat%> TL</td>
								</tr>
					
					<td><INPUT TYPE='SUBMIT' VALUE='Seç'></td>
					<tr>
					</tr>
				</table>
			</form>
			</br>
			</li>



			<div id='portfolio-content' class='cf'>
				</header>
				</br> </br> </br>
				<div id='main'>
					<div class='home-featured'>
						<ul id='filter-buttons'>
							<li><a href='hakkimizda.html'>Hakkımızda</a></li>
							<li><a href='iletisim.html'>İletişim Bilgilerimiz</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
</body>
</html>