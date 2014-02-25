import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
 
/*Max ve Min: Ýki tane big integer deðerinin küçüðünü veya büyük olanýný verir.
***GreatestCommonDivisor: Ýki big integerin ortak bölenlerinin en büyüðünü verir.
***Divide: Ýki big integeri böler sonucunu verir.
***Add: Ýki big integeri toplar.
***Abs: Mutlak Deðerini bulur.
***Multiply: Ýki big integeri çarpar ve sonucu verir.
***Subtract: Ýki big integeri birbirinden çýkarýr.
***Negate: Negatif halini verir.
***Remainder: Bölümünden kalýnýný gösterir.*/
 
public class deneme_18 {
 
	Scanner scan=new Scanner(System.in);
	String metin;
	private static BigInteger ZERO = BigInteger.ZERO;
	private static BigInteger ONE  = BigInteger.ONE;
	private static BigInteger TWO  = new BigInteger("2");
	
	ArrayList<BigInteger> ilk_asciiler = new ArrayList<BigInteger>();
	ArrayList<BigInteger> sifreli_metnin_asciileri = new ArrayList<BigInteger>();
	ArrayList<BigInteger> cozulmus_metnin_asciileri = new ArrayList<BigInteger>();
	
	private BigInteger asal1, asal2;
	private BigInteger D, C, M, A;
	private static BigInteger E;
	private BigInteger n;
	static int i1, i2;
	private static BigInteger x1 , x2 , x3, y1 , y2, y3, q , t1 , t2 , t3, phi_n ;
	
	public void metinAl(){
		
		System.out.println("Þifrelenecek metni giriniz:");
		metin=scan.next();
	}
	
	public void anahtarTanimla(){
 
	
		asal1 = new BigInteger("11");
		asal2 = new BigInteger("17");
		E = new BigInteger("23");
		n = asal1.multiply(asal2);
		phi_n = (asal1.subtract(BigInteger.valueOf(1))).multiply(asal2.subtract(BigInteger.valueOf(1)));
		
	}
	
	public void metninSayisalKarsiligi(){
		
		char[] asciiList=metin.toCharArray();
		int i,asciiA;
		char CharA;	
		
		for(i=0;i<asciiList.length;i++){
			
			CharA = asciiList[i];
			asciiA=(int) CharA;
			A=BigInteger.valueOf(asciiA);
			ilk_asciiler.add(A); 
		}
		//System.out.println("ilk_asciiler:"+ilk_asciiler);
	}
	public static BigInteger mod4Pow(BigInteger a, BigInteger e, BigInteger n) {
		BigInteger[] val = new BigInteger[16];
		val[0] = ONE;
		for(int i=1; i<16; i++) {
			val[i] = val[i-1].multiply(a);
		}
		
		BigInteger r = ONE;
		byte[] b = e.toByteArray();
		
		byte LOW = (byte)15;
		byte HIGH = (byte)240;
		byte bits;
		int p;
		for(int i=0; i<b.length; i++) {

			//catch 4 bits of higher value			
			p = (int)(b[i] & HIGH);
			if (p<0)	p+=256;
			p=p/16;
			r = (r.multiply(r)).mod(n);
			r = (r.multiply(r)).mod(n);
			r = (r.multiply(r)).mod(n);
			r = (r.multiply(r)).mod(n);
			r = (r.multiply(val[p])).mod(n);
			
			//catch 4 lower bits
			p = (int)(b[i] & LOW);
			if (p<0)	p+=256;
			r = (r.multiply(r)).mod(n);
			r = (r.multiply(r)).mod(n);
			r = (r.multiply(r)).mod(n);
			r = (r.multiply(r)).mod(n);
			r = (r.multiply(val[p])).mod(n);
		}
		return r;
	}
	
	public void metniSifrele(){
		
		int i;
		char charC;
		BigInteger a, a_nin_E_kuvveti, bolum, tamdeger;
		
		String sifreli_mesaj="";
		
		
		
		C = mod4Pow(a, E, n)
		//System.out.println("sifreli_metnin_asciileri:"+sifreli_metnin_asciileri);
		System.out.println("sifreli_mesaj="+sifreli_mesaj);
	}
	
	public void sifreliMetniCoz(){
		
		int i;
		char charM;
		BigInteger b, b_nin_D_kuvveti, bolum, tamdeger;
		
		String cozulmus_mesaj="";
		
		for(i=0;i<sifreli_metnin_asciileri.size();i++){				//M=b.modPow(D,n);  yerine
			
			b=sifreli_metnin_asciileri.get(i);
			
			D=genisletilmis_euclid(E, phi_n );
			
			b_nin_D_kuvveti=UsHesapla(b,D);
			
			bolum=n.divide(b_nin_D_kuvveti);
			
			tamdeger=bolum.multiply(b_nin_D_kuvveti);
			
			M=n.subtract(tamdeger);		
			
			charM=(char) M.intValue();
			
			cozulmus_metnin_asciileri.add(M);
			
			cozulmus_mesaj+=charM;
		}
		//System.out.println("cozulmus_metnin_asciileri:"+cozulmus_metnin_asciileri);
		System.out.println("cozulmus_mesaj="+cozulmus_mesaj);
	}
	
	public static void main(String args[]){
 
		
		deneme_18 A=new deneme_18();
	 	
	 	A.metinAl();
	 	A.anahtarTanimla();
	 	A.metninSayisalKarsiligi();
	 	A.metniSifrele();
	 	A.sifreliMetniCoz();
	}
	
	public BigInteger genisletilmis_euclid(BigInteger f, BigInteger d){
		
		x1 = new BigInteger("1");
		x2 = new BigInteger("0");
		y1 = new BigInteger("0");
		y2 = new BigInteger("1");
		q = new BigInteger("0");
		t1 = new BigInteger("1");
		t2 = new BigInteger("1");
		t3 = new BigInteger("3");
 
		int i=1;
		x3=f;
		y3=d;
		
		do{
			if(i==1){
				q=x3.divide(y3);
				
				t1=x1.subtract(q.multiply(y1));
				
				t2=x2.subtract(q).multiply(y2);
				
				t3=x3.subtract(q.multiply(y3));
				
			}
			else{
				x1 = y1; x2 = y2; x3 = y3;
                y1 = t1; y2 = t2; y3 = t3;
                
                q=x3.divide(y3);
                t1 = x1.subtract(q.multiply(y1));
                t2 = x2 .subtract(q.multiply(y2));
                t3 = x3 .subtract(q.multiply(y3));
			}
			i++;
			if(y3.signum() ==0){
				break;
			}
		}
		while(y3.intValue() !=1);
			if (y3.signum()==0){
				System.out.println("tersi yok");
			}
		
			else{
				
			}
			if(y1.signum() < 0){
				
				y1=f.add(y1);
			}
			return y1;	
		}
 
	BigInteger UsHesapla(BigInteger taban, BigInteger us)
	{
		BigInteger sonuc ;
		sonuc = new BigInteger("1");
		BigInteger katli_us = taban;
 
	    while (us.signum()>0){   //döngü adedi = ( log(us)/log(2) ) + 1; 
		  
	    	if ( (us.and(BigInteger.valueOf(1)).intValue()==1 ))  //en saðdaki bit 1 ise.
	    	
	    		sonuc = sonuc .multiply(katli_us);
	    		us = us.divide(BigInteger.valueOf(2));  // ikiye bölünce 1 bit saða kayar.  (us=us>>1)
	    
	    	if (us.signum()==0) break;
	    
	    	katli_us=katli_us.multiply(katli_us);
	  }
	  return sonuc;
	}
	
 
}