<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.DatabaseConnection"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="obj" class="beans.Yiyecek"/>


<jsp:setProperty property="*" name="obj"/>

<%
	int status = DatabaseConnection.yiyecekEkle(obj, "tb_salata");
if(status>0)
	response.sendRedirect("yiyecekEkle.jsp");
else
	response.sendRedirect("yiyecekEkleHata.jsp");
%>