<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Rastgele Sayılar - 3</title>
</head>
<body>
<%! private int randomNum = com.odev.RanUtilities.randomInt(20);
%>
<H1>Rastgele Sayi : <%= randomNum %></H1>

</body>
</html>