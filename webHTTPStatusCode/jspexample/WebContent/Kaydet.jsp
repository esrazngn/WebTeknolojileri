<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<%@page import="java.sql.Connection, java.sql.PreparedStatement" %>
 
<%@page import="java.sql.SQLException,java.sql.DriverManager" %>
 
&nbsp;
 
<html>
 
<head>
 
<title>JSP Page</title>
 
</head>
 
<body>
 
<%!
 
Connection baglanti=null;
 
PreparedStatement ifade=null;
 
String tcNo,ad,soyad,il,ilce,adres;
 
%>
 
<%
 
try{
 
tcNo=request.getParameter("tcno");
 
ad=request.getParameter("ad");
 
soyad=request.getParameter("soyad");
 
adres=request.getParameter("adres");
 
il=request.getParameter("il");
 
ilce=request.getParameter("ilce");
 
try{
 
Class.forName("com.mysql.jdbc.Driver");
 
}catch(ClassNotFoundException e){
 
out.println("Jdbc Yüklenemedi");
 
}
 
baglanti=DriverManager.getConnection("jdbc:mysql://localhost/uyeliksistemi?useUnicode=true&characterEncoding=UTF-8", "root", "root");
 
ifade=baglanti.prepareStatement("insert into uyekayit(uyetc,uyead,uyesoyad,uyeadres,uyeil,uyeilce) values(?,?,?,?,?,?) ");
 
ifade.setString(1, tcNo);
 
ifade.setString(2, ad);
 
ifade.setString(3, soyad);
 
ifade.setString(4, adres);
 
ifade.setString(5, il);
 
ifade.setString(6, ilce);
 
ifade.executeUpdate();
 
}catch(SQLException e){
 
out.println("Hata");
 
}finally{
 
ifade.close();
 
baglanti.close();
 
out.println("Kayıt Yapıldı");
 
}
 
%>
 
</body>
 
</html>