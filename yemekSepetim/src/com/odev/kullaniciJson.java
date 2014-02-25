package com.odev;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class kullaniciJson {
	public static void main(String[] args) {
		// Json String'ine dönüþtürülecek nesne;
		SampleClass jsonObject1 = new SampleClass("User1", 1, 9716,
				new String[] { "item1", "item2", "item3" });
		SampleClass jsonObject2 = new SampleClass("User2", 0, 9716,
				new String[] { "item1", "item2", "item3" });
		List<SampleClass> list = new ArrayList<SampleClass>();
		list.add(jsonObject1);
		list.add(jsonObject2);

		// Serialization
		String json = Serialize(list);
		dosyayaYaz yaz = new dosyayaYaz();
		yaz.yaz(json, "D:\\Kullanici.txt");
		System.out.println(json);

		// Deserialization - dizi için
		/*
		 * SampleClass[] array = Deserialize(json, new SampleClass[1]);
		 * 
		 * System.out.println(array[0].text); System.out.println(array[1].text);
		 * 
		 * //Deserialization - liste için List<SampleClass> list2 =
		 * Deserialize(json, new ArrayList<SampleClass>());
		 * 
		 * System.out.println(array[0].number);
		 * System.out.println(array[1].number);
		 */

	}

	public static String Serialize(Object object) {
		// Serialization iþlemi:
		// Nesne >>> String Dönüþümü

		// Serializator
		Gson gson = new Gson();
		String jsonString = gson.toJson(object);

		return jsonString;
	}

	@SuppressWarnings("unchecked")
	public static <T> T Deserialize(String jsonString, T type) {
		// Deserialization iþlemi:
		// String >>> Nesne Dönüþümü

		// Json nesnesi ve dönüþtürme iþlemi
		Gson gson = new Gson();
		T jsonObject = (T) gson.fromJson(jsonString, type.getClass());

		return jsonObject;
	}

	public static class SampleClass {
		public String KullaniciAdi;
		public int yetki;
		public int parola;
		public String[] bilgiler;

		public SampleClass(String kullaniciAdi, int parola, int yetki,
				String[] bilgiler) {
			this.KullaniciAdi = kullaniciAdi;
			this.yetki = yetki;
			this.parola = parola;
			this.bilgiler = bilgiler;
		}
	}

}
