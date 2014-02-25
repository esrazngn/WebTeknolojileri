<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<TITLE>Rastgele Sayılar</TITLE>
<LINK REL=STYLESHEET
HREF="JSP-Styles.css"
TYPE="text/css">
</HEAD>
<BODY>
<H1>Rastgele Sayılar</H1>
<UL>
<LI>1. Sayi: <%= com.odev.RanUtilities.randomInt(10) %>
<LI>2. Sayi: <%= com.odev.RanUtilities.randomInt(10) %>
<LI>3. Sayi: <%= com.odev.RanUtilities.randomInt(10) %>
<LI>4. Sayi: <%= com.odev.RanUtilities.randomInt(10) %>
<LI>5. Sayi: <%= com.odev.RanUtilities.randomInt(10) %>
</UL>
</BODY></HTML>