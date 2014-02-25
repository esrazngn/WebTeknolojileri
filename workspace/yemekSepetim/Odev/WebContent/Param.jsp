<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parametre Gönder</title>
</head>
<body>
<form action = 'threeParam.jsp'>
	<table border=0  cellpadding=1 >
	<TR><TD>parametre 1:</TD>
		<TD colspan=5><input type="text"  name="param1" value = "1. Parametre"> </TD>
	</TR>
	<TR><TD>parametre 2:</TD>
		<TD colspan=5><input type="text"  name="param2" value = "2. Parametre"> </TD>
	</TR><TR><TD>parametre 1:</TD>
		<TD colspan=5><input type="text"  name="param3" value = "3. Parametre"> </TD>
	</TR>
	<tr><td> <input type='submit'  value = 'Gönder' /></td></tr>
	</table>
</form>

</body>
</html>