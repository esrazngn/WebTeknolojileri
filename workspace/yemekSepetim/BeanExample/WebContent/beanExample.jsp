<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="stringBean" class="com.bean.StringBean" />
<OL>
	<LI>Initial value (from jsp:getProperty): <I><jsp:getProperty
				name="stringBean" property="message" /></I>
	<LI>Initial value (from JSP expression): <I><%=stringBean.getMessage()%></I>
	<LI><jsp:setProperty name="stringBean" property="message"
			value="Best string bean: Fortex" /> Value after setting property
		with jsp:setProperty: <I><jsp:getProperty name="stringBean"
				property="message" /></I>
	<LI>
		<%
			stringBean.setMessage("My favorite: Kentucky Wonder");
		%> Value after setting property with
		scriptlet: <I><%=stringBean.getMessage()%></I>
	
</OL>

stringBean deneme değişkenine değer atama :
<jsp:setProperty property="stringBean" name="deneme" value="Best string bean: Fortex"/>

<jsp:getProperty property="stringBean" name="deneme" />