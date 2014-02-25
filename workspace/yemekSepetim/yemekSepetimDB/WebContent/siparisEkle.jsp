<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="beans.DatabaseConnection"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="obj" class="beans.Yiyecek" />

<%
	String ad = request.getParameter("id");
	
	
		response.sendRedirect("siparis.jsp");
%>


