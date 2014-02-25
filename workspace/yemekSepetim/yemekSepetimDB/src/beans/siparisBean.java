package beans;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class siparisBean {
	private int adet, yemekAdet, icecekAdet, salataAdet, yemekID, icecekID,
			salataID, id;
	private double toplamFiyat = 0.0, yemekFiyat, icecekFiyat, salataFiyat,
			fiyat;
	protected ArrayList<Yiyecek> yemek = new ArrayList<>();
	protected ArrayList<Yiyecek> icecek = new ArrayList<>();
	protected ArrayList<Yiyecek> salata = new ArrayList<>();

		
	public int getyemekAdet() {
		return yemekAdet;
	}

	public void setyemekAdet(int yemekAdet) {
		this.yemekAdet = yemekAdet;
	}

	public int geticecekAdet() {
		return icecekAdet;
	}

	public void seticecekAdet(int icecekAdet) {
		this.icecekAdet = icecekAdet;
	}

	public int getsalataAdet() {
		return salataAdet;
	}

	public void setsalataAdet(int salataAdet) {
		this.salataAdet = salataAdet;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public ArrayList<Yiyecek> geticecek() {
		return this.icecek;
	}

	public void seticecek(Yiyecek y) {
		icecek.add(y);
	}

	public ArrayList<Yiyecek> getsalata() {
		return this.salata;
	}

	public void setsalata(Yiyecek y) {
		salata.add(y);
	}

	public ArrayList<Yiyecek> getyemek() {
		return this.yemek;
	}

	public void setyemek(Yiyecek y) {
		yemek.add(y);
	}

	public double gettoplamFiyat() {
		return toplamFiyat;
	}

	public void settoplamFiyat(double toplamFiyat) {
		this.toplamFiyat = toplamFiyat;

	}
	
	public int getyemekID() {
		return yemekID;
	}

	public void setyemekID(int yemekID) {
		this.yemekID = id;
	}
	
	public int geticecekID() {
		return icecekID;
	}

	public void seticecekID(int icecekid) {
		this.icecekID = icecekid;
	}
	
	public int getsalataID() {
		return salataID;
	}

	public void setsalataID(int salataid) {
		this.salataID = salataid;
	}
	

}
