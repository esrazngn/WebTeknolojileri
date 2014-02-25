package com.odev;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class deneme_7 {

	Scanner scan = new Scanner(System.in);
	String metin;

	private BigInteger asal1, asal2, E, n;

	static int f, d, x1 = 1, x2 = 0, x3, y1 = 0, y2 = 1, y3, q = 0, i = 1,
			t1 = 1, t2 = 2, t3 = 3, b;

	char a;

	static int i1, i2, i3, i4, D, x, y, sonuc = y, C, C2, M, b2;

	ArrayList<Integer> veri = new ArrayList<Integer>();
	ArrayList<Integer> veri2 = new ArrayList<Integer>();
	ArrayList<String> veri3 = new ArrayList<String>();
	ArrayList<String> veri5 = new ArrayList<String>();
	ArrayList<Integer> veri4 = new ArrayList<Integer>();

	public void sayi_tanimla() {

		asal1 = new BigInteger("553699199426609");
		asal2 = new BigInteger("743298775634567897876567568709786");
		E = new BigInteger("65537");
		n = asal1.multiply(asal2);
		i1 = asal1.intValue();
		i2 = asal2.intValue();
		i3 = E.intValue();
		i4 = n.intValue();
		System.out.println("i1" + i1);
		System.out.println("i2" + i2);
		System.out.println("i3" + i3);
		System.out.println("i4" + i4);
		System.out.println("n" + n);

	}

	public void kullanicidanAl() {

		System.out.println("metninizi giriniz:");
		metin = scan.next();

	}

	public void metinCevir() {

		char[] ayir = metin.toCharArray();
		int i;

		for (i = 0; i < ayir.length; i++) {
			a = ayir[i];
			b = (int) (a);
			veri.add(b);
			metniSifrele();
		}
		System.out.println("veri?????????" + veri);
		System.out.println("veri2" + veri2);
		System.out.println("veri3" + veri3);
	}

	public int gcd(int x, int y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);

	}

	public int genisletilmis_euclid(int f, int d) {
		x3 = f;
		y3 = d;

		do {
			if (i == 1) {
				q = x3 / y3;
				t1 = x1 - (q * y1);
				t2 = x2 - (q * y2);
				t3 = x3 - (q * y3);

			} else {
				x1 = y1;
				x2 = y2;
				x3 = y3;
				y1 = t1;
				y2 = t2;
				y3 = t3;
				q = x3 / y3;
				t1 = x1 - (q * y1);
				t2 = x2 - (q * y2);
				t3 = x3 - (q * y3);

			}
			i++;
			if (y3 == 0) {
				break;
			}

		} while (y3 != 1);
		if (y3 == 0) {
			System.out.println("tersi yok");
		}

		else {
			System.out.println("tersi:" + y2);
			D = y2;
		}
		return D;

	}

	public int us_al(int x, int y) {

		while (x != 0) {
			sonuc = sonuc * y;
			x--;

		}
		System.out.println("sonuc" + sonuc);
		return sonuc;
	}

	public void metniSifrele() {

		int i, w;

		for (i = 0; i < veri.size(); i++) {

			b2 = veri.get(i);
			w = us_al(b2, i3);
			System.out.println("w" + w);

			C = gcd(w, i4);
			System.out.println("c" + C);

			veri2.add(C);
			char charC = (char) C;

			String A = String.valueOf(charC);
			veri3.add(A);
		}
		System.out.println("veri3" + veri3);
	}

	public void metniCoz() {

		int i, a;

		for (i = 0; i < veri2.size(); i++) {

			C2 = veri2.get(i);
			a = us_al(C2, D);
			System.out.println("a" + a);

			M = gcd(a, i3);
			System.out.println("m" + M);

			veri4.add(M);
			char charM = (char) M;

			String B = String.valueOf(charM);
			veri5.add(B);
		}
		System.out.println("veri5" + veri5);
	}

	public static void main(String args[]) {

		deneme_7 A = new deneme_7();

		A.kullanicidanAl();
		A.sayi_tanimla();
		A.metinCevir();
		A.metniCoz();
		A.us_al(i3, i4);
		A.genisletilmis_euclid(i3, i4);

	}

}