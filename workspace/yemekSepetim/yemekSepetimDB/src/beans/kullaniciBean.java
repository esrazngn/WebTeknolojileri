package beans;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import com.mysql.jdbc.exceptions.MySQLDataException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class kullaniciBean {
	private boolean durum = true;
	private String userid;
	private String sifre;
	private int yetki = 0;
	private String ad;
	private String soyad;
	private String adres;
	private Connection connection = null;
	private ResultSet rs = null;
	private Statement st = null;
	String connectionURL = "jdbc:mysql://localhost:3306/yemeksepetim";

	public kullaniciBean() {
		try {
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a Connection to the database
			connection = DriverManager.getConnection(connectionURL, "root",
					"test");
		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
		}

	}

	public void setdurum(boolean durum) {
		this.durum = durum;
	}

	public Boolean getdurum() {
		return (this.durum);
	}

	
	public void setuserid(String userid) {
		this.userid = userid;
	}

	public String getuserid() {
		return (this.userid);
	}

	public void setsifre(String sifre) {
		this.sifre = sifre;
	}

	public String getsifre() {
		return (this.sifre);
	}

	public void setad(String ad) {
		this.ad = ad;
	}

	public String getad() {
		return (this.ad);
	}

	public void setsoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getsoyad() {
		return (this.soyad);
	}

	public void setadres(String adres) {
		this.adres = adres;
	}

	public String getadres() {
		return (this.adres);
	}
	public void insert() throws SQLException {

		try {

			System.out.println(userid + sifre + yetki + ad + soyad + adres);
			String sql = "insert into tb_kullanicilar(userid, sifre, yetki, ad, soyad, adres) values('"
					+ userid
					+ "','"
					+ sifre
					+ "','"
					+ yetki
					+ "','"
					+ ad
					+ "','" + soyad + "','" + adres + "')";
			Statement s = connection.createStatement();
			s.executeUpdate(sql);
			s.close();
			
		} catch (MySQLIntegrityConstraintViolationException e) {
		} catch (Exception e) {
			setdurum(false);
		}
		
	}

}