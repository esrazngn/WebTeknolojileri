package com.odev;

import java.util.ArrayList;
import java.util.List;

public class Yiyecek {
	String key;
	double value;
	int id;

	public Yiyecek(String key, Double value, int id) {
		this.key = key;
		this.value = value;
		this.id = id;
	}

	public void setKey(String key) {
		this.key = key;

	}

	public String getKey() {
		return key.replace(" ", "&nbsp");
	}

	public void setValue(Double value) {
		this.value = value;

	}

	public Double getValue() {
		return value;
	}

	public int getId() {
		return id;
	}

	public static ArrayList<Yiyecek> yemek() {
		List<Yiyecek> yiyecekListesi = new ArrayList<Yiyecek>();
		yiyecekListesi.add(new Yiyecek("Bolu Köfte ", 9.90, 1001));
		yiyecekListesi.add(new Yiyecek("Kasap Köfte ", 9.90, 1002));
		yiyecekListesi.add(new Yiyecek("Tavuk Pirzola ", 9.50, 1003));
		yiyecekListesi.add(new Yiyecek("Tavuk Þiþ ", 9.50, 1004));
		yiyecekListesi.add(new Yiyecek("Kuzu Pirzola ", 15.00, 1005));
		yiyecekListesi.add(new Yiyecek("Kuzu Þiþ ", 15.00, 1006));
		yiyecekListesi.add(new Yiyecek("Dana Biftek ", 15.00, 1007));
		yiyecekListesi.add(new Yiyecek("Dana Sadra ", 15.00, 1008));
		yiyecekListesi.add(new Yiyecek("Et Þiþ ", 15.00, 1009));
		yiyecekListesi.add(new Yiyecek("Bolu Special Izgara ", 40.00,
				1010));
		return (ArrayList<Yiyecek>) yiyecekListesi;

	}

	public static ArrayList<Yiyecek> salata() {
		List<Yiyecek> salataListesi = new ArrayList<Yiyecek>();
		salataListesi.add(new Yiyecek("Çoban Salata ", 4.00, 2001));
		salataListesi.add(new Yiyecek("Mevsim Salata ", 4.00, 2002));
		salataListesi.add(new Yiyecek("Akdeniz Salata ", 2.50, 2003));
		salataListesi
				.add(new Yiyecek("Special Ege Salata ", 8.50, 2004));
		salataListesi.add(new Yiyecek("Tavuk Salata ", 10.50, 2005));
		salataListesi.add(new Yiyecek("Piyaz ", 5.00, 2006));
		return (ArrayList<Yiyecek>) salataListesi;

	}

	public static ArrayList<Yiyecek> icecek() {
		List<Yiyecek> icecekListesi = new ArrayList<Yiyecek>();
		icecekListesi.add(new Yiyecek("Pepsi (33 cl.) ", 2.50, 3001));
		icecekListesi.add(new Yiyecek("Pepsi Light (33 cl.) ", 2.50,
				3002));
		icecekListesi.add(new Yiyecek("Yedigün (33 cl.)  ", 2.50, 3003));
		icecekListesi
				.add(new Yiyecek("Meyve Suyu (33 cl.) ", 2.50, 3004));
		icecekListesi.add(new Yiyecek("Ayran (30 cl.) ", 1.50, 3005));
		icecekListesi.add(new Yiyecek("Su ", 1.00, 3006));
		return (ArrayList<Yiyecek>) icecekListesi;
	}

}
