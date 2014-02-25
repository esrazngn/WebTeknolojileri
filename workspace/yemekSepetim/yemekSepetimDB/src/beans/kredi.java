package beans;

import java.util.Date;

public class kredi {
	private int no,csv;
	private String ad, soyad;
	private double bakiye;
	private String skt;
	
	public int getNo(){
		return this.no;
	}
	public void setNo(int no){
		this.no = no;
	}
	
	public int getcsv(){
		return this.csv;
	}
	public void setcsv(int csv){
		this.csv = csv;
	}
	
	public double getBakiye(){
		return this.bakiye;
	}
	public void setBakiye(double bakiye){
		this.bakiye = bakiye;
	}
	
	public String getskt(){
		return this.skt;
	}
	public void setskt(String skt){
		this.skt = skt;
	}
	
	public String getAd(){
		return this.ad;
	}
	public void setAd(String ad){
		this.ad = ad;
	}
	public String getSoyad(){
		return this.soyad;
	}
	public void setSoyad(String soyad){
		this.soyad = soyad;
	}
	
}
