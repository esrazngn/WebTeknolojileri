import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class asd {
	
		Scanner scan = new Scanner(System.in);
		String metin;
		private BigInteger asal1,asal2,E,n,b2;
		char a;
		static int i1,i2;
		ArrayList<Integer> veri = new ArrayList<Integer>();
	
		public void sayi_tanimla(){
	
			asal1 = new BigInteger("743298775634766987876567568709786");
			asal2 = new BigInteger("743298775634567897876567568709786");
			E = new BigInteger("65537");
			n = asal1.multiply(asal2);
			i1 = asal1.intValue();
			i2 = asal2.intValue();
	
		}
		public void kullanicidanAl(){
		
			System.out.println("metninizi giriniz:");
			metin=scan.next();
		}
		public void metinCevir(){
		 
			char[] ayir=metin.toCharArray();//metni char() halinde ayırıyor
			int i;
			
			for(i=0;i<ayir.length;i++){
				a = ayir[i];
				int b;
				b= (int)(a);
				veri.add(b); //herbir karakterin ascii karsiligini bulup veri listesine atiyor.
				b2=BigInteger.valueOf(b); //b yi bigint e ceviriyoruz �sl� say�larda mod alabilmek i�in.
			
			}
			System.out.println(veri);
		}
		public void Binary_cevir(int x){
			String s="";
			int k;
			while(x>0)
			{
			k=x%2;

			s=k+s;

			x=x/2;

			}
			System.out.println(s);
		
		}
		public static void main(String args[]){
		 	asd A=new asd();
		 	
		 	A.kullanicidanAl();
		 	A.sayi_tanimla();
		 	A.Binary_cevir(i1);
		 	A.Binary_cevir(i2);
		 	A.metinCevir();

		 	
	 } 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}