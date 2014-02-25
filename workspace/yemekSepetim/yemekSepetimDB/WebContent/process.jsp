
<%@page import="beans.DatabaseConnection"%>
<jsp:useBean id="obj" class="beans.User"/>

<jsp:setProperty property="*" name="obj"/>

<%
	int status=DatabaseConnection.register(obj);
if(status>0)
	response.sendRedirect("anasayfa.jsp");
else
	response.sendRedirect("uyeHataliKayit.jsp");
%>