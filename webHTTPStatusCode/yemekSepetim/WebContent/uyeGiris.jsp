<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Giriş Ekranı</title>
</head>
<body>
<fieldset><legend><h1>Üye Girişi </h1> </legend> 
	    	  <form name='giris' action="uyeGirisEkrani"> 
	    	    <table border=0  cellpadding=1 >
	    	    	<TR>
	    	    		<TD colspan=5> Kullanıcı Adı : <input type='text' name='userid' value = ''> </TD> 	</TR>
	    	    	<TR>
	    	    		<TD colspan=5> Şifre : <input type='password'  name='password' value = '' ></TD></TR>
	    	    </table>	
	    	     <input type='checkbox' name='hatirla' value='check' checked /><span>Beni Hatırla.<br/><br/></span>
	    	    <input type='submit'  />


	    	    </fielset></form>   

</body>
</html>