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
	String ad = request.getParameter("id");
	session.setAttribute("ad", ad);
	double fiyat = Double.parseDouble(request.getParameter("value")
			.toString());
	if (fiyat != 0.0) {
		int id = Integer.parseInt(ad);
		int i = DatabaseConnection.updateFiyat(id, "tb_icecek", fiyat);
		if(i>0)
			out.println("basarili");
		else
			out.print("basarisiz");

	} else
		response.sendRedirect("fiyatGuncelle.jsp");
%>


