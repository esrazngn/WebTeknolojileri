<%@ page language="java" contentType="text/html"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>Üç Parametre Uygulaması</TITLE> 
</HEAD>
<BODY>
<form action = 'threeParam.jsp'>
	<table border=0  cellpadding=1 >
	<TR><TD>parametre 1:</TD>
		<TD colspan=5><input type="text"  name="param1" > </TD>
	</TR>
	<TR><TD>parametre 2:</TD>
		<TD colspan=5><input type="text"  name="param2" > </TD>
	</TR><TR><TD>parametre 3:</TD>
		<TD colspan=5><input type="text"  name="param3" > </TD>
	</TR>
	<tr><td> <input type='submit'  value = 'Gönder' /></td></tr>
	</table>
</form>
<H1>3 Parametre</H1>
<UL>
 <LI><B>param1</B>: <%= request.getParameter("param1") %>
 <LI><B>param2</B>: <%= request.getParameter("param2") %>
 <LI><B>param3</B>: <%= request.getParameter("param3") %>
</UL>
</BODY></HTML>