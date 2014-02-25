import java.util.ArrayList;

public class HelloThread extends Thread {
	final static ArrayList<Integer> asal=new ArrayList<Integer>();
    public void run() {
    	int sayi;
	    
	      for(int i=2; i<=100; i++){ 
	            sayi=0; 
	            for(int j=2; j<=i/2; j++){ 
	                if(i%j==0) sayi++; 
	            } 
	            if(sayi==0) asal.add(i);
	           
	        }
	      System.out.println(asal); 
	      }
    public void run2() {
    	int sayi;
	      
	      for(int i=100; i<=200; i++){ 
	            sayi=0; 
	            for(int j=2; j<=i/2; j++){ 
	                if(i%j==0) sayi++; 
	            } 
	            if(sayi==0) System.out.println(+i); 
	        }
    }
	      public static void main(String args[]) {
	          (new HelloThread()).start();
	          
			
	           
	          
	      }
    
}