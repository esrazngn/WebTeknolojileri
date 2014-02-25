package com.odev;

public class Kullanici
{
	public String KullaniciAdi;
	public int yetki;
	public String parola;
	public String[] bilgiler;

	public Kullanici(String kullaniciAdi, String parola, int yetki, String[] bilgiler)
	{
		this.KullaniciAdi = kullaniciAdi;
		this.yetki = yetki;
		this.parola = parola;
		this.bilgiler = bilgiler;
	}
}