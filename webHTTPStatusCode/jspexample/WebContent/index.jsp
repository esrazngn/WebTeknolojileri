<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
 
<html>
 
<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<title>JSP Page</title>
 
</head>
 
<body>
 
<br>
 
<br>
 
<h3><b style="color:black;background-color:#a0ffff">Üye</b> Kayıt <b style="color:black;background-color:#ff9999">Formu</b></h3>
 
<form action="Kaydet.jsp" method="POST">
 
<table>
 
<tr>
 
<td>TC No:</td>
 
<td><input type="text" name="tcno" /></td>
 
</tr>
 
<tr>
 
<td>Ad:</td>
 
<td><input type="text" name="ad"/></td>
 
</tr>
 
<tr>
 
<td>Soyad:</td>
 
<td><input type="text" name="soyad"/></td>
 
</tr>
 
<tr>
 
<td>Adres:</td>
 
<td><textarea name="adres" rows="3" cols="16"></textarea></td>
 
</tr>
 
<tr>
 
<td>İli:</td>
 
<td><input type="text" name="il"/></td>
 
</tr>
 
<tr>
 
<td>İlçe:</td>
 
<td><input type="text" name="ilce"/></td>
 
</tr>
 
<tr>
 
<td><input type="submit" value="Kaydet" /></td>
 
</tr>
 
</table> 
 
</form></center>
 
</body>
 
</html>