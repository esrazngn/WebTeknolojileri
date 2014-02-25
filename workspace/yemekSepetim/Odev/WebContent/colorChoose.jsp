<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Renk Seçimi</title>
</head>
<body>
<form action="bgColor.jsp">
<table>
<TR><TD>Renk Seçiniz:</TD>
		<TD><select name="bgColor">  
			<option value="yellow">Sarı</option>
			<option value="blue">Mavi</option>  
			<option value="black">Siyah</option>  
			
			</select><TD/>
	</TR>
	<tr><td> <input type='submit'  value = 'Gönder' /></td></tr>
	
</table>
</form>
</body>
</html>