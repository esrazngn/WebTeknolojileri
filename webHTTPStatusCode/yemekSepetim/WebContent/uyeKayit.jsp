<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Kullanici Kayit Formu</title>
</head>
<body>
<form name='registration' ACTION="http://localhost:8080/yemekSepetim/uyeBilgileri"  method="post"> 
 Hesap Bilgileri
<table border=0  cellpadding=1 >
	<TR><TD>Kullanici adi :</TD>
		<TD colspan=5><input type="text"  name="userid" value = ""> </TD>
	</TR>
	<TR><TD>Parola:</TD>
		<TD colspan=5><input type="password"  name="password" value = "">  </TD>
	</TR>
	<TR><TD>Parola Onayi:</TD>
		<TD colspan=5><input type="password"  name="password2" value = "">  </TD>
	</TR>
	<TR><TD>E-posta:</TD>
		<TD colspan=5><input type="text"  name="email" value = "" >  </TD>
	</TR>
</table>
  <p> Kisisel Bilgiler <p/>

  <table>
	<TR><TD>Adiniz:</TD>
		<TD colspan=5><input type="text"  name="Adınız" value = "">  </TD>
	</TR>
	<TR><TD>Soyadiniz:</TD>
		<TD colspan=5><input type="text"  name="Soyadınız" value = "" > </TD>
	</TR>
	<TR><TD>Telefon Numaraniz:</TD>
		<TD colspan=5><input type="text"  name="Telefon numaranız" value = "" > </TD>
	</TR>
	<TR><TD>Cinsiyetiniz</TD>
		<TD colspan=5><input type="radio"  name="erkek"> <span> Erkek </span>  
					  <input type="radio"  name="bayan" ><span>Bayan</span></TD>
	</TR>
	<TR><TD>Sehriniz:</TD>
		<TD><select name="city">  
			<option value="Default">(Lütfen yasadiginiz sehri seçiniz)</option>  
			<option value="Adana">Adana</option>
			<option value="Bursa">Bursa</option>  
			<option value="IStanbul">Istanbul</option>  
			<option value="Samsun">Samsun</option>  
			<option value="Tokat">Tokat</option>  
			<option value="Zonguldak">Zonguldak</option> </select><TD/>
		
	</TR>
		
</table>
	<INPUT TYPE="SUBMIT" VALUE="Kayıt Ol">


</form>
</body>
</html>