import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
//RSA NIN HAZIR FONKSÝYONLARLA GERÇEKLEMESÝ
 
public class hazir {
	private static BigInteger ZERO = BigInteger.ZERO;
	private static BigInteger ONE  = BigInteger.ONE;
	private static BigInteger TWO  = new BigInteger("2");
	Scanner scan=new Scanner(System.in);
	String metin;
	
	ArrayList<BigInteger> ilk_asciiler = new ArrayList<BigInteger>();
	ArrayList<BigInteger> sifreli_metnin_asciileri = new ArrayList<BigInteger>();
	ArrayList<BigInteger> cozulmus_metnin_asciileri = new ArrayList<BigInteger>();
	
	private BigInteger asal1, asal2, E, n, D, C, M, A;
	static int i1, i2, i3, i4, phi_n;
	
	public void metinAl(){
		
		System.out.println("Þifrelenecek metni giriniz:");
		metin=scan.next();
	}
	
	public void anahtarTanimla(){
		
		asal1 = new BigInteger("11");
		asal2 = new BigInteger("17");
		E = new BigInteger("23");
		n = asal1.multiply(asal2);
		
		i1 = asal1.intValue();
		i2 = asal2.intValue();
		phi_n = (i1-1)*(i2-1);
		i3 = E.intValue();
		i4 = n.intValue();
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
 
	public void metniSifrele(){
		
		int i;
		
		char charC;
		
		BigInteger a;
		
		String sifreli_mesaj="";
		
		for(i=0;i<ilk_asciiler.size();i++){
			
			a=ilk_asciiler.get(i);
			
			C=mod4Pow(a, E, n);
			
			sifreli_metnin_asciileri.add(C);
			
			charC=(char) C.intValue();
			
			sifreli_mesaj+=charC;
		}
		//System.out.println("sifreli_metnin_asciileri:"+sifreli_metnin_asciileri);
		
		System.out.println("sifreli_mesaj="+sifreli_mesaj);
	}
	public static BigInteger mod4Pow(BigInteger a, BigInteger e, BigInteger n) {
		BigInteger[] listem = new BigInteger[16];
		listem[0] = ONE;
		for(int i=1; i<16; i++) {
			listem [i] = listem[i-1].multiply(a);
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
			r = (r.multiply(listem[p])).mod(n);
			
			//catch 4 lower bits
			p = (int)(b[i] & LOW);
			if (p<0)	p+=256;
			r = (r.multiply(r)).mod(n);
			r = (r.multiply(r)).mod(n);
			r = (r.multiply(r)).mod(n);
			r = (r.multiply(r)).mod(n);
			r = (r.multiply(listem[p])).mod(n);
		}
		return r;
	}
	public void sifreliMetniCoz(){
		
		int i;
		
		char charM;
		
		BigInteger b,phi;
		
		phi=BigInteger.valueOf(phi_n);
		
		String cozulmus_mesaj="";
		
		for(i=0;i<sifreli_metnin_asciileri.size();i++){
			
			b=sifreli_metnin_asciileri.get(i);
			
			D=E.modInverse(phi);
			
			M=b.modPow(D,n);
			
			cozulmus_metnin_asciileri.add(M);
			
			charM=(char) M.intValue();
			
			cozulmus_mesaj+=charM;
		}
		//System.out.println("cozulmus_metnin_asciileri:"+cozulmus_metnin_asciileri);
		
		System.out.println("cozulmus_mesaj="+cozulmus_mesaj);
	}
	public static BigInteger modInverse(BigInteger a, BigInteger n) throws ArithmeticException {
		BigInteger n0 = n;
		BigInteger a0 = a;
		BigInteger t0 = ZERO;
		BigInteger t  = ONE;
		BigInteger q  = n0.divide(a0);
		BigInteger r  = n0.subtract(q.multiply(a0));
		BigInteger temp;
		
		while (r.compareTo(ZERO) == 1) {
			temp = (t0.subtract(q.multiply(t))).mod(n);
							
			t0 = t;
			t  = temp;
			n0 = a0;
			a0 = r;
			q  = n0.divide(a0);
			r  = n0.subtract(q.multiply(a0));
		}
		
		if (a0.compareTo(ONE) != 0)	throw new ArithmeticException();
		
		return t.mod(n);
	}
	public static void main(String args[]){
		
		hazir A=new hazir();
	 	
	 	A.metinAl();
	 	A.anahtarTanimla();
	 	A.metninSayisalKarsiligi();
	 	A.metniSifrele();
	 	A.sifreliMetniCoz();
	}
}