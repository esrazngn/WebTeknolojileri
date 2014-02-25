<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="beans.DatabaseConnection"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="obj" class="beans.Yiyecek" />
<jsp:setProperty property="*" name="obj" />

<%
	String ad3 = request.getParameter("id3");
	session.setAttribute("ad3", ad3);
	double fiyat = Double.parseDouble(request.getParameter("value")
			.toString());
	if (fiyat != 0.0) {
		int id = Integer.parseInt(ad3);
		int i = DatabaseConnection.updateFiyat(id, "tb_salata", fiyat);
		response.sendRedirect("fiyatGuncelle.jsp");


	} else
		response.sendRedirect("fiyatGuncelle.jsp");
%>


