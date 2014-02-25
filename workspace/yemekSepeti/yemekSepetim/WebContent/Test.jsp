<%@page import="com.odev.Test"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="com.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>

<script type="text/javascript">

function Test()
{
	var text = "Ertugrul Ozcan";
	window.location.replace("Test.jsp?name=" + text);
	<%
	String name = request.getParameter("name");
	if(name != null)
		Test.Function(name);
	
		%>
}

</script>

</head>
<body>

<input type="button" value="Tamam" onclick="javascript:Test()">

</body>
</html>