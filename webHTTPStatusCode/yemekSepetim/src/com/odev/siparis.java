package com.odev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class siparis
 */
@WebServlet("/siparis")
public class siparis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public siparis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		final HashMap<String, Double> yemek = new HashMap<String, Double>();			
	     yemek.put("Bolu Köfte 9.90 TL",9.90);
	     yemek.put("Kasap Köfte 9.90 TL",9.90);
	     yemek.put("Tavuk Pirzola 9.50 TL",9.50);
	     yemek.put("Tavuk Şiş 9.50 TL",9.50);
	     yemek.put("Kuzu Pirzola 15.00 TL",15.0);
	     yemek.put("Kuzu Şiş 15.00 TL",15.0);
	     yemek.put("Dana Biftek 15.00 TL",15.0);
	     yemek.put("Dana Sadra 15.00 TL",15.0);
	     yemek.put("Et Şiş 15.00 TL",15.0);
	     yemek.put("Bolu Special Izgara 40.00 TL" ,40.0);
	     
	     final HashMap<String, Double> icecek = new HashMap<String, Double>();
		 
		 icecek.put("Pepsi (33 cl.) 2.50 TL",2.50);
		 icecek.put("Pepsi Light (33 cl.) 2.50 TL",2.50);
		 icecek.put("Yedigün (33 cl.)  2.50 TL",2.50);
		 icecek.put("Meyve Suyu (33 cl.) 2.50 TL",2.50);
		 icecek.put("Ayran (30 cl.) 1.50 TL",1.50);
		 icecek.put( "Su 1.00 TL",1.0);
	     
final HashMap<String,Double> salata = new HashMap<String, Double>();
		 
		 salata.put("Çoban Salata  4.00 TL",4.00);
		 salata.put("Mevsim Salata  4.00 TL",4.00);
		 salata.put("Akdeniz Salata  8.00 TL",8.00);
		 salata.put("Ege Salata 8.50 TL",8.50);
		 salata.put("Tavuk Salata 10.50 TL",10.50);
		 salata.put("Piyaz 5.00 TL",5.0);
		 
	 	final List<String> yem = new ArrayList<String>(yemek.keySet());
	 	final List<String> ice = new ArrayList<String>(icecek.keySet());
		final List<String> sal = new ArrayList<String>(salata.keySet());
		
	    PrintWriter out = response.getWriter();
	    String docType =
	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	      "Transitional//EN\">\n";
	    String title = "Sipariş Ekranı";
	    out.println("<link rel='stylesheet' href='/yemekSepetim/style.css' type='text/css' media='all'/>");
	   
	    	out.println(docType +
	    		"<html><head>"+
	    		"  <title>"+title+
	    		"</title>  "+
	    	    "</head>  <body >  "+
	    	   " <fieldset><legend><h1>Siparişiniz Seçiniz </h1> </legend> "+
	    	   " <form action = 'siparis'> "+
	    	   "<div style='position:relative; left:350px; top:8px;'>"+
	    	   "<p>Seçilenler &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Toplam Tutar </div>"+
	    	  
	    	   "<fieldset><legend>Yemek Seçimi </legend>"+
	    	    "<table border=0  cellpadding=1 >"+
	    	   "<form name='yemek' action='yemekEkle'"+
	    	    "<TR><TD>Yiyecekler :</TD>"+
	    	    	"<td colspan=2><select name='yiyecekSec'> " +
	    	    			"<option selected='' value='Default'>(Seçiniz...)</option>"); 
	    	    		for (int  i = 0; i<yem.size(); i++){
	    	    			out.println("<option VALUE=\"" + yem.get(i) + "\">" +yem.get(i) + "</option>");	    	    			
	    	    		}
	    	    		out.println("</select></TD>" +
	    	    	"<tr><td>Adet</td>" +
	    	    		"<TD><input type='text' name='yemekAdet' value = ''></TD>	" +
	    	    		"<td><INPUT TYPE='submit' ></td>"+
    	    			"<td><textarea rows='3' cols='30'></textarea></td>"+
	    	    			"<td><input type='text' name='yemekAdetSec' value = ''></td></tr>"+
	    	    			"</form></table></fieldset>"+
	    	    	"<fieldset><legend>İçecek Seçimi</legend>"+
	    	    	"<table border=0  cellpadding=1 >"+
	    	    			"<TR><TD>Yiyecekler :</TD>"+
		    	    		"<td colspan=2><select name='icecekler'> " +
		    	    			"<option selected='' value='Default'>(Seçiniz...)</option>"); 
		    	    			for (int  i = 0; i<ice.size(); i++){
			    	    			out.println("<option VALUE=\"" + ice.get(i) + "\">" +ice.get(i) + "</option>");	    	    			
			    	    		}
		    	    			
		    	    			out.println("</select></TD>" +
		    	    	"<tr><td>Adet</td>" +
		    	    		"<TD><input type='text' name='icecekAdet' value = ''></TD>	" +
		    	    		"<td><INPUT TYPE='button' name = 'ok2' value='OK' onClick ='siparisEkle()' ></td>"+
		    	    			"<td><textarea rows='3' cols='30'></textarea></td>"+
		    	    			"<td><input type='text' name='icecekAdetSec' value = ''></td></tr>"+
		    	    			"</table></fieldset>"+
		    	    			"<fieldset><legend>Salata Seçimi</legend>"+
		    	    	    	"<table border=0  cellpadding=1 >"+
		    	    	    			"<TR><TD>Yiyecekler :</TD>"+
		    		    	    		"<td colspan=2><select name='yiyecekler'> " +
		    		    	    			"<option selected='' value='Default'>(Seçiniz...)</option>");  
		    		    	    			for (int  i = 0; i<sal.size(); i++){
		    			    	    			out.println("<option VALUE=\"" + sal.get(i) + "\">" +sal.get(i) + "</option>");	    	    			
		    			    	    		}
		    		    	    			
		    		    	    			out.println(
		    		    	    			
		    		    	    			"</select></TD>" +
		    		    	    	"<tr><td>Adet</td>" +
		    		    	    		"<TD><input type='text' name='yemekAdet' value = ''></TD>	" +
		    		    	    		"<td><INPUT TYPE='button' name = 'ok3' value='OK' ></td>"+
		    		    	    			"<td><textarea rows='3' cols='30'></textarea></td>"+
		    		    	    			"<td><input type='text' name='yemekAdetSec' value = ''></td></tr>"+
		    		    	    			"</table></fieldset>"+
		    		    	 	    	   "<div style='position:relative; right:590px; top:8px;'>"+
		    		    	    			"<p align=right>SiparisID <input type='text' name='siparisID' value = ''> Toplam Tutar <input type='text' name='toplamTutar' value = ''>"+
		    		    	    			"<br/><palign=right> <INPUT TYPE='button' value='Siparis Onayla' >"+
		    		    	    			"</form>   </body>	    </html>"
	    			    	       );
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
