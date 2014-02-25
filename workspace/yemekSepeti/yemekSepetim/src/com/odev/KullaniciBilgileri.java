package com.odev;

import com.google.gson.Gson;
import com.odev.JsonTest.SampleClass;


public class KullaniciBilgileri 
{	
	public static void SerializationTest(SampleClasses sc)
	{
		Gson gson = new Gson();
       String jsonString = gson.toJson(sc);
        
        System.out.println(jsonString);
	}
	public static class SampleClasses
	{
		public String[] kullaniciBilgileri;
		public String kullaniciAdi;
		public String parola;
		public String[] bilgiler;
		
		public SampleClasses(String kullaniciadi, String parola, String bilgiler [])
		{
			this.kullaniciAdi = kullaniciadi;
			this.parola = parola;
			this.bilgiler = bilgiler;
		}
		
	}
	
	
}
