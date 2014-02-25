<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kayit ol</title>
</head>
<body>
<%if(request.getServletPath().endsWith(".jsp")){response.sendRedirect("index");} %>

	

<form action="index/kayit" method = "post">
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
		<td><input type="submit" value = "Kayıt" /> &nbsp; <input type = "button" value= "Geri" onClick = "javascript:history.back()"></td>
	</tr>
	
	
</table>
</form>


</body>
</html>