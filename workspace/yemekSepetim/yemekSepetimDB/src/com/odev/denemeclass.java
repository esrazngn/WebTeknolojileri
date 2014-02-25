package com.odev;

import java.util.ArrayList;
import java.util.Enumeration;

import beans.DatabaseConnection;
import beans.ShoppingCart;
import beans.Yiyecek;
import beans.denemeSiparis;
import beans.kredi;
import beans.siparisBean;

public class denemeclass {

	/**
	 * @param args
	 */
	public static ArrayList<siparisBean> siparisDondur() {
		// String esra = beans.DatabaseConnection.kullaniciSorgula("userid",
		// "tb_kullanicilar", "ad");
		// System.out.println("sorulan "+esra);
		// System.out.println("sonuc:"+
		// beans.DatabaseConnection.deleteKullanici("user1"));

		ArrayList<siparisBean> y = beans.DatabaseConnection
				.yiyecekListele("tb_siparisim");
		System.out.println("-------" + y.get(0).getID() + y.get(1).getID());
		System.out.println("boyuuutiiiiiiiiiiiiiii:" + y.size());
		for (int i = 0; i < y.size(); i++)
			System.out.println("---" + y.get(i).getID());
		return y;
	}

	public static ArrayList<Yiyecek> yiyecekDondur(String table) {
		// String esra = beans.DatabaseConnection.kullaniciSorgula("userid",
		// "tb_kullanicilar", "ad");
		// System.out.println("sorulan "+esra);
		// System.out.println("sonuc:"+
		// beans.DatabaseConnection.deleteKullanici("user1"));

		ArrayList<Yiyecek> y = beans.DatabaseConnection.yiyecek(table);
		System.out.println("miktar:" + y.size());
		for (int i = 0; i < y.size(); i++)
			System.out.println("idler" + y.get(i).getId());
		return y;
	}

	public static void main(String args[]) {
		/*
		 * //yiyecekDondur("tb_salata"); beans.ShoppingCart cart = new
		 * ShoppingCart(); float f = 12.5f; cart.addItem("5465", "sear sasd", f,
		 * 1); cart.addItem("5465", "sear sasd", f, 1); cart.addItem("5465",
		 * "sear sasd", f, 1);
		 * 
		 * System.out.println("numofitems: "+cart.getNumOfItems());
		 * cart.delete(); System.out.println("caarrttt: "+cart.getCost());
		 * System.out.println("numofitems: "+cart.getNumOfItems());
		 * 
		 * /* Enumeration e = cart.getEnumeration(); String[] tmpItem; //
		 * Iterate over the cart while (e.hasMoreElements()) { tmpItem =
		 * (String[]) e.nextElement(); System.out.println(tmpItem[0]); }
		 * 
		 * //siparisDondur(); 
		 * */siparisBean sa = new siparisBean();
		 Yiyecek y = new Yiyecek();
		 y.setId(5);
		 sa.setyemek(y);
		 beans.denemeSiparis d = new denemeSiparis();
		 d.siparisim = sa;
		 System.out.println(d.siparisim.getyemek().size());
	

		 
		 /*
		 * //s.settoplamFiyat(55.55);
		 * //System.out.println("fiyat : "+s.gettoplamFiyat()); kredi k = new
		 * kredi(); k.setAd("Esra"); k.setBakiye(299); k.setcsv(22);
		 * k.setNo(4455); k.setskt("01.17"); k.setSoyad("Zengin");
		 * System.out.println(beans.DatabaseConnection.KKsorgula(k));
		 * System.out.println(beans.DatabaseConnection.updateBakiye(k, 50.0));
		 * s.setID(5); s.setyemekID(2); s.setyemekAdet(5); s.seticecekID(1111);
		 * s.seticecekAdet(5); s.setsalataID(111); s.setsalataAdet(5);
		 * s.settoplamFiyat(100.0);
		 * //System.out.println(beans.DatabaseConnection.siparisEkle(s));
		 * Yiyecek y = new Yiyecek(); Yiyecek i = new Yiyecek(); Yiyecek s = new
		 * Yiyecek();
		 * 
		 * y.setId(5); y.setKey("Yemek"); y.setValue(10.5);
		 * 
		 * i.setId(55); i.setKey("icecek"); i.setValue(10.5);
		 * 
		 * s.setId(52); s.setKey("salata"); s.setValue(10.5);
		 * 
		 * sa.setyemek(y); sa.seticecek(i); sa.setsalata(s); sa.setyemek(y);
		 * sa.seticecek(i); sa.setsalata(s); sa.setyemek(y); sa.seticecek(i);
		 * sa.setsalata(s);
		 * 
		 * System.out.println(sa.getyemek().get(0).getKey());
		 * System.out.println(sa.geticecek().get(0).getKey());
		 * System.out.println(sa.getsalata().get(0).getKey());
		 * System.out.println(sa.getyemek().get(1).getKey());
		 * System.out.println(sa.geticecek().get(1).getKey());
		 * System.out.println(sa.getsalata().get(1).getKey());
		 * System.out.println(sa.getyemek().get(2).getKey());
		 * System.out.println(sa.geticecek().get(2).getKey());
		 * System.out.println(sa.getsalata().get(2).getKey());
		 * 
		 * ArrayList<siparisBean> si = new ArrayList<>(); si.add(sa);
		 * si.add(sa); si.add(sa); double fiyat =0; for(int i1=0; i1<si.size();
		 * i1++){ fiyat+= si.get(i1).getyemek().get(i1).getValue(); }
		 * System.err.println(fiyat);
		 

		ArrayList<siparisBean> si = new ArrayList<>();
		si = DatabaseConnection.SiparisListele(5);
		System.err.println("iiiiiiiii");
		for (int i = 0; i < si.size(); i++) {
			System.out.println("id" + si.get(i).getID());

			System.out.println("toplam" + si.get(i).gettoplamFiyat());
			System.out.println("saadet" + si.get(i).getsalataAdet());
			System.out.println("icadet" + si.get(i).geticecelAdet());
			System.out.println("yadet" + si.get(i).getyemekAdet());


			for (int j = 0; j < si.get(i).getyemek().size(); j++) {
				System.out.println("yaf"
						+ si.get(i).getyemek().get(j).getValue());
				System.out.println("yad"
						+ si.get(i).getyemek().get(j).getKey());
				System.out.println("yid"
						+ si.get(i).getyemek().get(j).getId());
			}
			for (int j = 0; j < si.get(i).geticecek().size(); j++) {
				System.out.println("iaf"
						+ si.get(i).geticecek().get(j).getValue());
				System.out.println("iad"
						+ si.get(i).geticecek().get(j).getKey());
				System.out.println("iid"
						+ si.get(i).geticecek().get(j).getId());
			}for (int j = 0; j < si.get(i).getsalata().size(); j++) {
				System.out.println("saf"
						+ si.get(i).getsalata().get(j).getValue());
				System.out.println("sad"
						+ si.get(i).getsalata().get(j).getKey());
				System.out.println("sid"
						+ si.get(i).getsalata().get(j).getId());-
			}
		}*/
	}

}
