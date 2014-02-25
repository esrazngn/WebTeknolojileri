package beans;

public class LoginBean {  
private String userid,sifre; 
private int yetki;
private String adres;

public String getadres() {  
    return adres;
}  
  
public void setadres(String adres) {  
    this.adres = adres;
}  
  
public String getuserid() {  
    return userid;  
}  
  
public void setuserid(String userid) {  
    this.userid= userid;  
}  


public int getyetki() {  
    return yetki;  
}  
  
public void setyetki(int yetki) {  
    this.yetki = yetki;  
}  


  
public String getsifre() {  
    return sifre;  
}  
  
public void setsifre(String sifre) {  
    this.sifre= sifre;  
}  
}