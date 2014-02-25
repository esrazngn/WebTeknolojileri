package com.odev;

public class Yiyecek {
	String key;
	double value;
	public Yiyecek(String key, Double value)
	{
	this.key = key;
	this.value = value;
	}
	public  void  setKey(String key){
		this.key = key;

	}
	public String getKey(){
		return key.replace(" ", "&nbsp");
	}
	public  void  setValue(Double value){
		this.value = value;
	
	}
	public Double getValue(){
		return value;
	}
	
	
	

	}


