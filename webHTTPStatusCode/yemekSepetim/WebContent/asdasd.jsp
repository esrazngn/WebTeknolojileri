<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function yemekEkle() {
	var adeti = document.siparis.yemekAdet.value;
    document.getElementById('area1').value = document.getElementById('area1').value + adeti+" adet "+document.getElementById('yemekler').value+"\n";
}
function icecekEkle() {
	var adeti = document.siparis.icecekAdet.value;
    document.getElementById('area2').value = document.getElementById('area2').value + adeti+" adet "+document.getElementById('icecekler').value+"\n";
}function salataEkle() {
	var adeti = document.siparis.salataAdet.value;
    document.getElementById('area3').value = document.getElementById('area3').value + adeti+" adet "+document.getElementById('salatalar').value+"\n";
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Siparis Ekrani</title>
</head>
<body>
<fieldset><legend><h1>Siparişiniz Seçiniz </h1> </legend> 
<form name = 'siparis' action="siparisVer" method="post">
<fieldset><legend>Yemek Seçimi </legend>
<table>
<tr><td>Yemekler </td>
	<td><select name = "yemekler" id="yemekler">
			<option tag value="Default">(Yemek Seçiniz...)</option>  
			<option value="Bolu Köfte 9.90 TL">Bolu Köfte 9.90 TL</option>
			<option value="Kasap Köfte 9.90 TL">Kasap Köfte 9.90 TL</option>
			<option value="Tavuk Pirzola 9.50 TL">Tavuk Pirzola 9.50 TL</option>
			<option value="Tavuk Şiş 9.50 TL">Tavuk Şiş 9.50 TL</option>
			<option value="Kuzu Pirzola 15.00 TL">Kuzu Pirzola 15.00 TL</option>
			<option value="Kuzu Şiş 15.00 TL">Kuzu Şiş 15.00 TL</option>
			<option value="Dana Biftek 15.00 TL">Dana Biftek 15.00 TL</option>
			<option value="Dana Sadra 15.00 TL">Dana Sadra 15.00 TL</option>
			<option value="Et Şiş 15.00 TL">Et Şiş 15.00 TL</option>
			<option value="Bolu Special Izgara 40.00 TL">Bolu Special Izgara 40.00 TL</option>		
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
		<TR><TD>İçecekler :</TD>
			<td><select name='icecekler' id="icecekler">
				<option value='Default'>(Seçiniz...)</option>
				<option value='Pepsi (33 cl.) 2.50 TL'>Pepsi (33 cl.) 2.50 TL</option>
				<option value='Pepsi Light (33 cl.) 2.50 TL'>Pepsi Light (33 cl.) 2.50 TL</option>
				<option value='Yedigün (33 cl.)  2.50 TL'>Yedigün (33 cl.)  2.50 TL</option>
				<option value='Meyve Suyu (33 cl.) 2.50 TL'>Meyve Suyu (33 cl.) 2.50 TL</option>
				<option value='Ayran (30 cl.) 1.50 TL'>Ayran (30 cl.) 1.50 TL</option>
				<option value='Su 1.00 TL'>Su 1.00 TL</option>
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
				<option value='Default'>(Seçiniz...)</option>
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