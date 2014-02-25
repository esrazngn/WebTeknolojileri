package com.odev;

import com.google.gson.Gson;
import com.odev.KullaniciBilgileri;
import com.odev.KullaniciBilgileri.SampleClass;

public class control {
	 /*public boolean epostaControl(String email){
		  if(email.matches( "(([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4}))(((;|,|; | ;| ; | , | ,){1}"
			        +"([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4}))*)")) {
			  return true;
			}
			else{
				return false;
			}
	 }*/
	public static void main(String args[]){
		String isim = "esra", soyisim = "zengin", email = "es@w.cn", username = "esraa";
		int password = 123;
		
		String[] bilgiler = {isim, soyisim, email };
		  
  	  SampleClass sc = new SampleClass(username, password, bilgiler);        	  
  	 KullaniciBilgileri.SerializationTest(sc);
  	  }


	
	}
	
