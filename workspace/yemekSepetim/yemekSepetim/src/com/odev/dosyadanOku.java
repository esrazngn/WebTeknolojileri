package com.odev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class dosyadanOku {
	public static void main(String args[]) throws IOException {
		dosyadanOku d = new dosyadanOku();
		boolean tur = d.kullaniciAdiOku("esra", 1);
		System.out.println(tur);
	}

	static int satir = 0;
	static SampleClass[] array;
	int yetki = 0;

	@SuppressWarnings("resource")
	public boolean kullaniciAdiOku(String user, int pass) throws IOException {

		BufferedReader br = null;

		br = new BufferedReader(new FileReader("D:\\Kullanici.txt"));
		StringBuilder jsonStringSB = new StringBuilder();
		String line;

		while ((line = br.readLine()) != null) {
			jsonStringSB.append(line);

		}
		String jsonString = jsonStringSB.toString();
		array = Deserialize(jsonString, new SampleClass[100]);
		satir = array.length;
		boolean durum = true;

		while (satir > 0 & durum) {
			String kullanici = (array[satir - 1].KullaniciAdi);
			int parola = array[satir - 1].parola;
			if (user.equals(kullanici)) {
				if (pass == parola) {
					yetki = array[satir - 1].yetki;
					durum = false;
				} else {
					break;
				}
			} else {
				satir -= 1;
			}
		}
		setYetki(yetki);
		durum = !durum;
		return durum;

	}

	public void setYetki(int yetki) {
		this.yetki = yetki;
	}

	public int getYetki() {
		return yetki;
	}

	@SuppressWarnings("unchecked")
	public static <T> T Deserialize(String jsonString, T type) {
		// Deserialization iþlemi:
		// String >>> Nesne Dönüþümü

		// Json nesnesi ve dönüþtürme iþlemi
		Gson gson = new Gson();
		T jsonObject = (T) gson.fromJson(jsonString, type.getClass());

		return jsonObject;
	}

	public static class SampleClass {
		public String KullaniciAdi;
		public int yetki;
		public int parola;
		public String[] bilgiler;

		public SampleClass(String kullaniciAdi, int parola, int yetki,
				String[] bilgiler) {
			this.KullaniciAdi = kullaniciAdi;
			this.yetki = yetki;
			this.parola = parola;
			this.bilgiler = bilgiler;
		}
	}

}