<%@page import="com.odev.CookieUtilities"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<%String username = CookieUtilities.getCookieValue(request, "userid", ""); %>
<div id='portfolio-content' class='cf'>
<fieldset><legend><h2>Üye Girişi </h2></br></legend>
<form name='giris' action='loginprocess.jsp'>
<table border=0  cellpadding=1 >
	<TR><td><h5>Kullanıcı Adı :</h5> </td>
<TD colspan=5> <input type='text' name='userid' VALUE = username> </TD> 	</TR>
<TR> <td> <h5>Şifre : </h5> </td>
<TD colspan=5> <input type='password'  name='sifre' value = '' ></TD></TR>
</table><input type='checkbox' name='hatirla' value='check' checked />Beni Hatırla<br/>
<input type='submit'value ='Giriş' />
</fielset></form>     </div>
</fielset></br> </br> </br></br> </br>  </br></br> </br>
</form></header><div id='main'><div class='home-featured'><ul id='filter-buttons'>
<li><a href='hakkimizda.jsp' >Hakkımızda</a></li>
<li><a href='iletisim.jsp' >İletişim Bilgilerimiz</a></li></ul></div></div>
</body> </html>