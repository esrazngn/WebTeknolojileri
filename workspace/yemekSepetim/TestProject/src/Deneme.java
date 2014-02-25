import java.util.ArrayList;
import javax.swing.JOptionPane;
//import java.math.BigInteger;
import java.math.*;

public class Deneme {
	
	static ArrayList<Integer> ascii_liste = new ArrayList<Integer>();
	static ArrayList<Character> mesaj_liste = new ArrayList<>();
	static ArrayList<Integer> sifrelenmis_liste = new ArrayList<Integer>();
	static  ArrayList<Integer> liste = new ArrayList<Integer>();
	static ArrayList<Integer> sonuc_liste = new ArrayList<Integer>();
	
	static Integer p, q, e, n, phi_n,sonuc, taban, us,eleman ;
	static String mesaj, k ;
	static BigInteger uslu ;

	
	static void kullanicidan_Al(){
		
		String asal1, asal2, asal3;
		
		asal1 = JOptionPane.showInputDialog("p asal sayýnýzý girin");
		p=Integer.parseInt(asal1);
		
		asal2 = JOptionPane.showInputDialog("q asal sayýnýzý girin");
		q = Integer.parseInt(asal2);
		
		asal3 = JOptionPane.showInputDialog("e asal sayýnýzý girin");
		e = Integer.parseInt(asal3);
		
	}
	
	static int n_Hesapla(int x, int y){
		
		n = x*y ;
		return n;
	
	}
	
	static int phi_n_Hesapla(int x, int y){
		
		phi_n = (x-1)*(y-1) ;
		return phi_n ;
		
	}

	static String mesaj_Al(){
		
		mesaj = JOptionPane.showInputDialog("þifrelenecek mesajýnýzý yazýnýz");
		return mesaj;
		
		
	}
	
	static ArrayList ascii_liste(String k){
		
		char harf;
		int ascii ;
		//char mesaj_liste[] = k.toCharArray();
		for(int i=0 ; i < mesaj_liste.length ; i++){
			harf = mesaj_liste[i];
			ascii = (int)(harf);
			ascii_liste.add(ascii);
		}
		return ascii_liste ;
		
		//JOptionPane.showMessageDialog(null, ascii_liste);  void olursa 
	}
	
	static ArrayList us_Alma(){
		
		us = e;
		sonuc = 1;
		
		for(int m = 0 ; m <mesaj.length() ; m++ ){
			taban = mesaj.length() ;
			for(int i = us ; i > 0 ; i--){
				sonuc = taban*sonuc ;
			}	
			eleman = sonuc%(n);
			sonuc_liste.add(eleman);
		}
		
		return sonuc_liste ;
		//JOptionPane.showMessageDialog(null, sonuc);
		//JOptionPane.showMessageDialog(null, sonuc_liste);
		
	}
	
	
	public static void main(String[] args) {

		kullanicidan_Al();
		n_Hesapla(p,q);
		phi_n_Hesapla(p,q);
		k = mesaj_Al();
		liste = ascii_liste(k);
		//us_Alma()
	}
	
	
	
	

}
