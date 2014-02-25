public class Main { 
        public static void main(String[] args) { 
         final int sayi;
        	Runnable r1 = new Runnable() {
        		@Override
        		public void run() {
            for(int i=2; i<=100; i++){ 
                sayi=0; 
                for(int j=2; j<=i/2; j++){ 
                    if(i%j==0) sayi++; 
                } 
                if(sayi==0) System.out.println(i); 
            }
			
			
				
				
			
			
        }
    }; }}