<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="beans.DatabaseConnection"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="obj" class="beans.kullaniciBean" />
<jsp:setProperty property="*" name="obj" />

<%
	String ad = request.getParameter("id");
	session.setAttribute("ad", ad);
	String sifre = request.getParameter("value").toString();
	if (sifre != null) {
		System.out.println(ad+sifre);
		int i = DatabaseConnection.updateSifre(ad, sifre);
		response.sendRedirect("kullaniciGuncelle.jsp");


	} else
		response.sendRedirect("kullaniciGuncelleHata.jsp");
%>


