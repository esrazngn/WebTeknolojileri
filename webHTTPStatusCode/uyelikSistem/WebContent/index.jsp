<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-9">
<title>üyelik sistemi</title>
<script type="text/javascript">
function kayitol(){
	window.location.href="index/kayitol";
}


</script>
</head>
<body>
<%if(request.getServletPath().endsWith(".jsp")){response.sendRedirect("index");} %>
	<% if(session.getAttribute("oturum")==null){
		request.setCharacterEncoding("ISO-8859-9");
		response.setCharacterEncoding("ISO-8859-9");
		request.getRequestDispatcher("/giris.jsp").include(request, response);}
		%>
	

</body>
</html>
