package beans;

public class User {
private String userid,sifre,ad,soyad,adres,sifre2;

public String getuserid() {
	return userid;
}

public void setuserid(String userid) {
	this.userid = userid;
}

public String getsifre() {
	return sifre;
}

public void setsifre(String sifre) {
	this.sifre = sifre;
}

public String getsifre2() {
	return sifre2;
}

public void setsifre2(String sifre2) {
	this.sifre2 = sifre2;
}

public String getad() {
	return ad;
}

public void setad(String ad) {
	this.ad = ad;
}

public void setsoyad(String soyad) {
	this.soyad = soyad;
}

public String getsoyad() {
	return (this.soyad);
}

public void setadres(String adres) {
	this.adres = adres;
}

public String getadres() {
	return (this.adres);
}

}
