package com.odev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;

public class siparisJSON
{
	static Siparis[] array;
	
	public static void hesapla(double tutar, String[] yemek, String[] icecek, String[] salata) throws IOException
	{

		BufferedReader br = null;

		br = new BufferedReader(new FileReader("D:\\Siparis.txt"));
		StringBuilder jsonStringSB = new StringBuilder();
		String line;

		while ((line = br.readLine()) != null)
		{
			jsonStringSB.append(line);
		}
		String jsonString = jsonStringSB.toString();
		array = Deserialize(jsonString, new Siparis[1]);

		Siparis[] yeniDizi = new Siparis[array.length + 1];

		for (int i = 0; i < array.length; i++)
			yeniDizi[i] = array[i];
		
		
		yeniDizi[array.length] = new Siparis((array.length+1), tutar, yemek, icecek, salata);


		String json1 = Serialize(yeniDizi);
		dosyayaYaz(json1);
		
	}



public static void dosyayaYaz(String json) {
	try {
		File dosya = new File("D:\\Siparis.txt");
		FileWriter yazici = new FileWriter(dosya);
		BufferedWriter yaz = new BufferedWriter(yazici);
		yaz.write(json);
		yaz.close();
	} catch (Exception hata) {
		hata.printStackTrace();
	}

}

public static String Serialize(Object object) {

	Gson gson = new Gson();
	String jsonString = gson.toJson(object);

	return jsonString;
}

@SuppressWarnings("unchecked")
public static <T> T Deserialize(String jsonString, T type) {

	Gson gson = new Gson();
	T jsonObject = (T) gson.fromJson(jsonString, type.getClass());

	return jsonObject;
}

public static class Siparis
{
	public int SiparisID;
	public double Tutar;
	public String[] yemekler;
	public String[] icecekler;
	public String[] salatalar;


	public Siparis(int siparisID, double tutar, String[] yemekler, String[] icecekler, String[] salatalar)
	{
		this.SiparisID = siparisID;
		this.Tutar = tutar;
		this.yemekler = yemekler;
		this.icecekler = icecekler;
		this.salatalar = salatalar;
	}
}
}

