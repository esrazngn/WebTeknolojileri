package snippet;

public class Snippet {
	<%@page import="beans.DatabaseConnection"%>  
	<jsp:useBean id="obj" class="beans.LoginBean"/>  
	  
	<jsp:setProperty property="*" name="obj"/>  
	  
	<%
	    	boolean status=DatabaseConnection.sorgula(obj);  
	    if(status & obj.getyetki()== 0 ){  
	    response.sendRedirect("uyeGirisAnasayfa.jsp");  
	    }  
	    else if( status & obj.getyetki()== 1 )
	    	response.sendRedirect("erisimEkrani.jsp");  
	
	    else  
	    {  
	    	response.sendRedirect("uyeGirisBasarisiz.jsp");  
	     
	      
	    }
	    %>  
}

