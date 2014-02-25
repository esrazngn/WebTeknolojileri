package com.odev;

import com.google.gson.Gson;
import com.odev.KullaniciBilgileri;
import com.odev.KullaniciBilgileri.SampleClasses;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.odev.JsonTest.SampleClass;

/**
 * Servlet implementation class uyeBilgi
 */
@WebServlet("/uyeBilgi")
public class uyeBilgi extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	boolean wrong=true;
	 boolean parolaEslesme = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uyeBilgi() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	    response.setContentType("text/html");
	    
        String username,passwd, email, isim, soyisim, passwd2;
        username =request.getParameter("user");
        passwd = request.getParameter("password");
        passwd2 = request.getParameter("password2");
        email = request.getParameter("email");
        isim = request.getParameter("isim");
        soyisim = request.getParameter("soyisim");
        out.println("<html><head></head><body>"+username+passwd+passwd2+email+"</body></html>");
        	  if ( !passwd.equals(passwd2) )
        	  {
        		  response.sendRedirect("uyeHataliKayit");
        	  }
        	  else
        	  {
        
        int password = Integer.parseInt(passwd);
        
        String[] bilgiler = {isim, soyisim, email };
  
        SampleClasses sc = new SampleClasses(username, password, bilgiler);        	  
        SerializationTest(sc);
        }
		}
	public static void SerializationTest(SampleClasses sc)
	{
		Gson gson = new Gson();
		String jsonString = gson.toJson(sc);
        
        System.out.println(jsonString);
        dosyayaYaz yaz = new dosyayaYaz();
        yaz.yaz(jsonString, "D:\\Kullanici.txt");
	}
	
		
       
	
}


