package com.odev;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class yiyecekJson {
	public static void main(String[] args) {
		// Json String'ine d�n��t�r�lecek nesne;
		SampleClass jsonObject1 = new SampleClass(9716, new String[] { "item1",
				"item2", "item3" }, new String[] { "item1", "item2", "item3" },
				new String[] { "item1", "item2", "item3" });
		SampleClass jsonObject2 = new SampleClass(976, new String[] { "item1",
				"item2", "item3" }, new String[] { "item1", "item2", "item3" },
				new String[] { "item1", "item2", "item3" });
		List<SampleClass> list = new ArrayList<SampleClass>();
		list.add(jsonObject1);
		list.add(jsonObject2);

		// Serialization
		String json = Serialize(list);
		System.out.println(json);
		dosyayaYaz yaz = new dosyayaYaz();
		yaz.yaz(json, "D:\\Siparis.txt");

		// Deserialization - dizi i�in
		/*
		 * SampleClass[] array = Deserialize(json, new SampleClass[1]);
		 * 
		 * System.out.println(array[0].text); System.out.println(array[1].text);
		 * 
		 * //Deserialization - liste i�in List<SampleClass> list2 =
		 * Deserialize(json, new ArrayList<SampleClass>());
		 * 
		 * System.out.println(array[0].number);
		 * System.out.println(array[1].number);
		 */

	}

	public static String Serialize(Object object) {
		// Serialization i�lemi:
		// Nesne >>> String D�n���m�

		// Serializator
		Gson gson = new Gson();
		String jsonString = gson.toJson(object);

		return jsonString;
	}

	@SuppressWarnings("unchecked")
	public static <T> T Deserialize(String jsonString, T type) {
		// Deserialization i�lemi:
		// String >>> Nesne D�n���m�

		// Json nesnesi ve d�n��t�rme i�lemi
		Gson gson = new Gson();
		T jsonObject = (T) gson.fromJson(jsonString, type.getClass());

		return jsonObject;
	}

	public static class SampleClass {

		public int siparisID;
		public String[] yemekler;
		public String[] i�ecekler;
		public String[] salatalar;

		public SampleClass(int number, String[] yemekler, String[] icecekler,
				String[] salatalar) {
			this.siparisID = number;
			this.yemekler = yemekler;
			this.i�ecekler = icecekler;
			this.salatalar = salatalar;
		}
	}

}
