<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Rastgele Sayılar- 2</title>
</head>
<body>
<UL>
<%
int numEntries = com.odev.RanUtilities.randomInt(10);
for(int i=0; i<numEntries; i++) {
out.println("<LI>"+(i+1) +" . Sayi: "+
com.odev.RanUtilities.randomInt(10));
}
%>

</body>
</html>