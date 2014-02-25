package com.odev;

import java.io.File;

import org.json.JSONWriter;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class JsonTest
{
	public static void main(String[] args)
	{
		SerializationTest();
		//DeserializationTest();
	}
	
	public static void SerializationTest()
	{
		// Serialization iþlemi:
		// Nesne >>> String Dönüþümü
		
		// Json String'ine dönüþtürülecek nesne;
		SampleClass jsonObject = new SampleClass("Test", 9716, new String[]{"item1", "item2", "item3"});
		
		// Serializator
		Gson gson = new Gson();
        String jsonString = gson.toJson(jsonObject);
        
        System.out.println(jsonString);
	}
	
	public static void DeserializationTest()
	{
		// Deserialization iþlemi:
		// String >>> Nesne Dönüþümü
		
		// Nesneye dönþtürülecek json stringi
		String jsonString = "{\"test\":\"Test\", \"number\":9716, \"array\":[\"item1\",\"item2\",\"item3\"]}";
		
		// Json nesnesi ve dönüþtürme iþlemi
		Gson gson = new Gson();
		SampleClass jsonObject = gson.fromJson(jsonString, SampleClass.class);
		
		// Sonucun kontrol edilmesi;
		System.out.println(jsonObject.text);
		System.out.println(jsonObject.number);
		System.out.println(jsonObject.array[0]);
		System.out.println(jsonObject.array[1]);
		System.out.println(jsonObject.array[2]);
	}
	
	public static class SampleClass
	{
		public String text;
		public int number;
		public String[] array;
		
		public SampleClass(String text, int number, String[] array)
		{
			this.text = text;
			this.number = number;
			this.array = array;
		}
	}
}
