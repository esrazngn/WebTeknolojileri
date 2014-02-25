

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class asalSay
 */
@WebServlet("/asalSay")
public class asalSay extends HttpServlet {
	int sayi;
	ArrayList<Integer> asal = new ArrayList<>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public asalSay() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        PrintWriter out = response.getWriter();
    	PrimeCount pr1 = new PrimeCount(0, 25000);
    	PrimeCount pr2 = new PrimeCount(250000, 50000);
    	PrimeCount pr3 = new PrimeCount(50000, 75000);
    	PrimeCount pr4 = new PrimeCount(75000, 100000);

    	pr1.start();
    	pr2.start();
    	pr3.start();
    	pr4.start();
    	out.println(asal);

	        }
    
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	public class PrimeCount extends Thread{
		public PrimeCount(int a,int b){
    	for(int i=a; i<=b; i++){ 
            sayi=0; 
            for(int j=2; j<=i/2; j++){ 
                if(i%j==0) sayi++; 
            } 
            if(sayi==0) asal.add(i); 
        }
    }
	}
}
