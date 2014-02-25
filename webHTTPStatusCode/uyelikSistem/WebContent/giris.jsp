<%if(request.getServletPath().endsWith(".jsp")){response.sendRedirect("index");} %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
	

<form action="index/giris" method = "post">
<table>
	<tr>
		<td> kullanici adı </td>
		<td> :</td>
		<td><input type="text" name = "kadi" /></td>
	</tr>
	<tr>
		<td> Şifre </td>
		<td> :</td>
		<td><input type="password" name = "sifre" /></td>
	</tr>
	<tr>
		<td> </td>
		<td> :</td>
		<td><input type="submit" value = "Giris" /> &nbsp; <input type = "button" value= "Kayıt" onClick = "javascript:kayitol()"></td>
	</tr>
	
	
</table>
</form>

