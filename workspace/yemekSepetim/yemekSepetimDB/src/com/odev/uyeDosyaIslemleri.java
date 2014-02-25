package com.odev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class uyeDosyaIslemleri {
	boolean okuma = false, yazma = true;

	public Kullanici[] dosyaOku() throws IOException{
		BufferedReader br = null;
		Kullanici[] array;

		br = new BufferedReader (new FileReader ("D:\\Kullanici.txt"));
		StringBuilder jsonStringSB = new StringBuilder();
		String line;
		
		
		while( (line = br.readLine()) != null)
		{
		       jsonStringSB.append(line); 
		}
		String jsonString = jsonStringSB.toString();
		array = Deserialize(jsonString, new Kullanici[1]);
		
		return array;
	}

		public void dosyayaYaz(String username , String  password , String [] bilgiler, Kullanici[] array ){
			Kullanici[] yeniDizi = new Kullanici[array.length+1];
			
			for(int i = 0; i < array.length; i++)
				yeniDizi[i] = array[i];
			Kullanici k = new Kullanici(username, password, 0, bilgiler);
			yeniDizi[array.length] = k;
			
			String json1 = Serialize(yeniDizi);
			
			dosyayaYaz(json1);
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

