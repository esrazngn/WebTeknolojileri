package com.odev;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class uyeBilgi
 */
@WebServlet("/uyeBilgi")
public class uyeBilgi extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	boolean wrong = true;
	boolean parolaEslesme = false;
	static int satir=0;
	static Kullanici[] array;
	
	String[] kulList = null;
	Integer[] parList = null;
	Integer[] yetList = null;
	List<String[]> bilList = null;

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
			{
	
	}

	
	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException  {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		String username, passwd, email, isim, soyisim, passwd2,cinsiyetB="Bayan", sehir, telefon,cinsiyetE = "Erkek",cinsiyet;
		boolean durum=false;
		try{
		cinsiyetE = request.getParameter("erkek");
		}
		catch(NullPointerException e){
		}
		try{
			cinsiyetB = request.getParameter("bayan");
		}catch(NullPointerException n){
				
			}
		if(!(cinsiyetE==null))
			cinsiyet = "Erkek";
		else {
			cinsiyet = "Bayan";
		}
		
		sehir = request.getParameter("city");
		telefon = request.getParameter("tel");
		username = request.getParameter("user");
		passwd = request.getParameter("password");
		passwd2 = request.getParameter("password2");
		email = request.getParameter("email");
		isim = request.getParameter("isim");
		soyisim = request.getParameter("soyisim");
		System.out.println("1:"+cinsiyet+"2 : "+sehir+"3 : "+telefon);
		control c = new control();
		boolean eKontrol = c.epostaControl(email);
		Kullanici[] array;
		uyeDosyaIslemleri u = new uyeDosyaIslemleri();
		array = u.dosyaOku();
		boolean kayitliuser = false;
		for(int i = 0; i<array.length; i++)
		{
			if(username.equals(array[i].KullaniciAdi))
			{
				kayitliuser=true;
				break;
			}			
		}
		if (!passwd.equals(passwd2) | !eKontrol | kayitliuser ) 
		{
			response.sendRedirect("uyeHataliKayit");
		} 
		else 
		{
			
			String[] bilgiler = { isim, soyisim, email,cinsiyet,telefon,sehir };
			u.dosyayaYaz(username, passwd, bilgiler, array);
			
			/*int password = Integer.parseInt(passwd);
			String[] bilgiler = { isim, soyisim, email };

			BufferedReader br = null;
				
			br = new BufferedReader (new FileReader ("D:\\Kullanici.txt"));
			StringBuilder jsonStringSB = new StringBuilder();
			String line;
			
			
			while( (line = br.readLine()) != null)
			{
			       jsonStringSB.append(line); 
			}
			String jsonString = jsonStringSB.toString();
			array = Deserialize(jsonString, new Kullanici[1]);
			
			Kullanici[] yeniDizi = new Kullanici[array.length+1];
			
			for(int i = 0; i < array.length; i++)
				yeniDizi[i] = array[i];
			yeniDizi[array.length] = new Kullanici(username, password, 0, bilgiler);
			
			String json1 = Serialize(yeniDizi);
			dosyayaYaz(json1);*/
PrintWriter out = response.getWriter();
out.print( "Kayýt Baþarýlý Lütfen Giriþ Yapýnýz...'Giriþ Sayfasýna Yönlendiriliyorsunuz..");
response.sendRedirect("uyeGiris");


		}
		
	}
	
	public void dosyayaYaz(String json)
	{
		try {
			File dosya = new File("D:\\Kullanici.txt");
			FileWriter yazici = new FileWriter(dosya);
			BufferedWriter yaz = new BufferedWriter(yazici);
			yaz.write(json);
			yaz.close();
		} catch (Exception hata) 
		{
			hata.printStackTrace();
		}
		
		
	}

	public String Serialize(Object object) 
	{

		Gson gson = new Gson();
		String jsonString = gson.toJson(object);

		return jsonString;
	}

	@SuppressWarnings("unchecked")
	public <T> T Deserialize(String jsonString, T type)
	{
		// Deserialization iþlemi:
		// String >>> Nesne Dönüþümü

		// Json nesnesi ve dönüþtürme iþlemi
		Gson gson = new Gson();
		T jsonObject = (T) gson.fromJson(jsonString, type.getClass());

		return jsonObject;
	}


}

