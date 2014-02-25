public class HelloThread2 extends Thread {

        public void run() {
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
	          //(new HelloThread()).start();
	          (new HelloThread2()).start();
	      }
  
   

}