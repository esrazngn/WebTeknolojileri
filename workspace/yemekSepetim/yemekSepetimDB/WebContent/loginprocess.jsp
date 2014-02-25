<%@page import="org.apache.catalina.util.SessionIdGenerator"%>
<%@page import="beans.DatabaseConnection"%>
<jsp:useBean id="obj" class="beans.LoginBean" />

<jsp:setProperty property="*" name="obj" />

<%
	boolean status = DatabaseConnection.sorgula(obj);
	if (status) {
		String userid = request.getParameter("userid");
		obj.setuserid(userid);
		session.setAttribute("userid", userid);
		if (obj.getyetki() == 0)
			
			response.sendRedirect("uyeGirisAnasayfa.jsp");

		else if (status & obj.getyetki() == 1)
			response.sendRedirect("erisimEkrani.jsp");
		session.setAttribute("adres", obj.getadres());
		System.err.println("adres"+ obj.getadres());
	} else {
		response.sendRedirect("uyeGirisBasarisiz.jsp");

	}
%>
