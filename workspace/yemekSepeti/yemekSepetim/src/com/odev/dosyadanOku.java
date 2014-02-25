package com.odev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

public class dosyadanOku 
{
	public static void main(String[] args) 
	{  
		DeserializationTest();
	}
		public static void DeserializationTest()
		{
			 BufferedReader br = null;
			try 
			{
				br = new BufferedReader (new FileReader ("D:\\Kullanici.txt"));
				StringBuilder jsonStringSB = new StringBuilder();
				String line;
				while( (line = br.readLine()) != null)
				{
				       jsonStringSB.append(line);
				}
				String jsonString = jsonStringSB.toString();

			 
			Gson gson = new Gson();

			List<SampleClass> kullaniciListesi= gson.fromJson(jsonString, List<SampleClass>.class);
			SampleClass jsonObject = gson.fromJson(jsonString, SampleClass.class);
			
			// Sonucun kontrol edilmesi;
			System.out.println(jsonObject.kullaniciAdi);
			System.out.println(jsonObject.parola);
			System.out.println(jsonObject.bilgiler[0]);
			System.out.println(jsonObject.bilgiler[1]);
			System.out.println(jsonObject.bilgiler[2]);
		}
			catch (IOException e)
			{
				
			}
		
}
		public static class SampleClass
		{
			public String kullaniciAdi;
			public int parola;
			public String[] bilgiler;
			
			public SampleClass(String text, int number, String[] array)
			{
				this.kullaniciAdi = text;
				this.parola = number;
				this.bilgiler = array;
			}
		}


}
