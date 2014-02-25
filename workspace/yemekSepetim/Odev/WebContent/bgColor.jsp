<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Arka Plan Rengi</title>
</HEAD>
<%
String bgColor = request.getParameter("bgColor");
if ((bgColor == "black")){
bgColor = "Siyah";
}
else if ((bgColor == "yellow")){
bgColor = "Sarı";
}
else if ((bgColor == "blue")){
bgColor = "Mavi";
}
%>
<BODY BGCOLOR="<%= bgColor %>">
<H2 ALIGN="CENTER">Arka Plan Rengi:
"<%= bgColor %>"</H2>


</body>
</html>