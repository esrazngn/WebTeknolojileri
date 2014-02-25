<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="com.odev.Yiyecek"%>
<%@page import= "java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function yemekEkle() {
	var adeti = document.siparis.yemekAdet.value;
    document.getElementById('area1').value = document.getElementById('area1').value + adeti+" adet "+document.getElementById('yemekler').value.replace('&nbsp', ' ').replace('&nbsp', ' ').replace('&nbsp', ' ').replace('&nbsp', ' ')+"\n";

}
function icecekEkle() {
	var adeti = document.siparis.icecekAdet.value;
    document.getElementById('area2').value = document.getElementById('area2').value + adeti+" adet "+document.getElementById('icecekler').value.replace('&nbsp', ' ').replace('&nbsp', ' ').replace('&nbsp', ' ').replace('&nbsp', ' ')+"\n";
}function salataEkle() {
	var adeti = document.siparis.salataAdet.value;
    document.getElementById('area3').value = document.getElementById('area3').value + adeti+" adet "+document.getElementById('salatalar').value.replace('&nbsp', ' ').replace('&nbsp', ' ').replace('&nbsp', ' ').replace('&nbsp', ' ')+"\n";
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Siparis Ekrani</title>
</head>
<body>
<fieldset><legend><h1>Siparişiniz Seçiniz </h1> </legend> 
<form name = 'siparis' action="siparisVer" method="post">
<fieldset><legend>Yemek Seçimi </legend>
<table>
<tr><td>Yemekler </td>
<%List<Yiyecek> yiyecekListesi = new ArrayList<Yiyecek>();
yiyecekListesi.add( new Yiyecek( "Bolu Köfte 9.90 TL", 9.90 ) );
yiyecekListesi.add( new Yiyecek( "Kasap Köfte 9.90 TL" , 9.90 ) );
yiyecekListesi.add( new Yiyecek( "Tavuk Pirzola 9.50 TL",9.50 ) );
yiyecekListesi.add( new Yiyecek( "Tavuk Şiş 9.50 TL" ,9.50) );
yiyecekListesi.add( new Yiyecek( "Kuzu Pirzola 15.00 TL",15.00) );
yiyecekListesi.add( new Yiyecek( "Kuzu Şiş 15.00 TL" ,15.00) );
yiyecekListesi.add( new Yiyecek( "Dana Biftek 15.00 TL" ,15.00) );
yiyecekListesi.add( new Yiyecek( "Dana Sadra 15.00 TL",15.00 ) );
yiyecekListesi.add( new Yiyecek( "Et Şiş 15.00 TL" ,15.00) );
yiyecekListesi.add( new Yiyecek( "Bolu Special Izgara 40.00 TL" ,40.00) );%>

	<td><select name = "yemekler" id="yemekler">
			<option tag value="Default">(Yemek Seçiniz...)</option>  
			<option value=<%=yiyecekListesi.get(0)%>><%=yiyecekListesi.get(0).getKey()%></option>
			<option value=<%=yiyecekListesi.get(1).getKey()%>><%=yiyecekListesi.get(1).getKey()%></option>
			<option value=<%=yiyecekListesi.get(2).getKey()%>><%=yiyecekListesi.get(2).getKey()%></option>
			<option value=<%=yiyecekListesi.get(3).getKey()%>><%=yiyecekListesi.get(3).getKey()%></option>
			<option value=<%=yiyecekListesi.get(4).getKey()%>><%=yiyecekListesi.get(4).getKey()%></option>
			<option value=<%=yiyecekListesi.get(5).getKey()%>><%=yiyecekListesi.get(5).getKey()%></option>
			<option value=<%=yiyecekListesi.get(6).getKey()%>><%=yiyecekListesi.get(6).getKey()%></option>
			<option value=<%=yiyecekListesi.get(7).getKey()%>><%=yiyecekListesi.get(7).getKey()%></option>
			<option value=<%=yiyecekListesi.get(8).getKey()%>><%=yiyecekListesi.get(8).getKey()%></option>
			<option value=<%=yiyecekListesi.get(9).getKey()%>><%=yiyecekListesi.get(9).getKey()%></option>		
		</select></td>
		</tr>
		<tr><td>Adet</td>
			<TD><input type='text' name='yemekAdet' value = 0></TD>
			<td><INPUT TYPE='button' name = 'ok1' value='OK' onclick="javascript:yemekEkle()" ></td>
			<td><textarea rows='3' id = 'area1' cols='30'></textarea></td>
			<td><input type='text' id = 'yemekAdetSec' value = ''></td></tr> 
			</table></fieldset>
	<fieldset><legend>İcecek Secimi</legend>
	<table>
	<%List<Yiyecek> icecekListesi = new ArrayList<Yiyecek>();
icecekListesi.add( new Yiyecek( "Pepsi (33 cl.) 2.50 TL", 2.50 ) );
icecekListesi.add( new Yiyecek( "Pepsi Light (33 cl.) 2.50 TL" , 2.50 ) );
icecekListesi.add( new Yiyecek( "Yedigün (33 cl.)  2.50 TL",2.50 ) );
icecekListesi.add( new Yiyecek( "Meyve Suyu (33 cl.) 2.50 TL" ,2.50) );
icecekListesi.add( new Yiyecek( "Ayran (30 cl.) 1.50 TL",1.50) );
icecekListesi.add( new Yiyecek( "Su 1.00 TL" ,1.00) );%>
		<TR><TD>İçecekler :</TD>
			<td><select name='icecekler' id="icecekler">
				<option value='Default'>(İçecek Seçiniz...)</option>
				<option value=<%=icecekListesi.get(0).getKey()%>><%=icecekListesi.get(0).getKey()%></option>
				<option value=<%=icecekListesi.get(1).getKey()%>><%=icecekListesi.get(1).getKey()%></option>
				<option value=<%=icecekListesi.get(2).getKey()%>><%=icecekListesi.get(2).getKey()%></option>
				<option value=<%=icecekListesi.get(3).getKey()%>><%=icecekListesi.get(3).getKey()%></option>
				<option value=<%=icecekListesi.get(4).getKey()%>><%=icecekListesi.get(4).getKey()%></option>
				<option value=<%=icecekListesi.get(5).getKey()%>><%=icecekListesi.get(5).getKey()%></option>
				</select></td>
		</tr>
		<tr><td>Adet</td>
			<TD><input type='text' name='icecekAdet' value = 0></TD>
			<td><INPUT TYPE='button' name = 'ok2' value='OK' onclick="javascript:icecekEkle()"></td>
			<td><textarea id = 'area2' rows='3' cols='30'></textarea></td>
			<td><input type='text' name='icecekAdetSec' value = ''></td></tr>
			</table></fieldset>
	<fieldset><legend>Salata Secimi</legend>
	<table>
		<TR><TD>Salatalar :</TD>
			<td><select name='salatalar' id="salatalar">
				<option value='Default'>(Salata Seçiniz...)</option>
				<option value='Çoban Salata  4.00 TL'>Çoban Salata  4.00 TL</option>
				<option value='Special Mevsim Salata  4.00 TL'>Special Mevsim Salata   4 TL</option>
				<option value='Akdeniz Salata  8.00 TL'>Akdeniz Salata  8.00 TL</option>
				<option value='Ege Salata 8.50 TL'>Ege Salata 8.50 TL</option>
				<option value='Tavuk Salata 10.50 TL'>Tavuk Salata 10.50 TL</option>
				<option value='Piyaz 5.00 TL'>Piyaz 5.00 TL</option>
				</select></td>
		</tr>
		<tr><td>Adet</td>
			<TD><input type='text' name='salataAdet' value = 0 ></TD>
			<td><INPUT TYPE='button' id = 'ok3' value='OK' onclick="javascript:salataEkle()" ></td>
			<td><textarea rows='3' id = 'area3' cols='30'></textarea></td>
			<td><input type='text' name='salataAdetSec' value = ''></td></tr>
			</table></fieldset>
	</fieldset>
	<p align=right>SiparisID <input type='text' name='siparisID' value = ''> Toplam Tutar <input type='text' name='toplamTutar' value = ''>
		    		    	    			<br/><p align=right> <INPUT TYPE='button' value='Siparis Onayla' >
</form>
</body>
</html>