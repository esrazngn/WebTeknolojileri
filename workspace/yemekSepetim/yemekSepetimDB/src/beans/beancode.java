package beans;

import java.sql.*;

public class beancode {

private String userid;
private String sifre;
private Connection con = null;
private ResultSet rs = null;
private PreparedStatement st = null;
String url = "jdbc:mysql://localhost:3306/";;
String db = "yemeksepetim";

public beancode(){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection(url+db,"root","test");
}
catch(Exception e){
System.out.println(e.getMessage());
}
}
public void setuserid(String userId){
userid = userId;
}

public String getuserid(){
return (userid);
}

public void setsifre(String pass){
sifre = pass;
}

public String getsifre(){
return (sifre);
}

public void insert(){ 
try{
String s1="insert into tb_kullanicilar values('"+userid+"','"+sifre+"')";
st = con.prepareStatement(s1);
st.executeUpdate();
st.clearParameters();
st.close(); 
}
catch(Exception m){
}
}
}