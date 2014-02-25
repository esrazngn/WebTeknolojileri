package beans;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
	private static Connection connection = null;
	private ResultSet rs = null;
	private Statement st = null;
	static String connectionURL = "jdbc:mysql://localhost:3306/yemeksepetim";
	static ArrayList<Integer> yiyecek;

	public void Baglanti() {
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

	public static int register(User u) {
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();
		int status = 1;

		try {
			if (u.getsifre().equals(u.getsifre2())) {
				System.out.println(u.getad() + u.getsifre() + u.getuserid());
				String sql = "insert into tb_kullanicilar(userid, sifre, yetki, ad, soyad, adres) values('"
						+ u.getuserid()
						+ "','"
						+ u.getsifre()
						+ "','"
						+ 0
						+ "','"
						+ u.getad()
						+ "','"
						+ u.getsoyad()
						+ "','"
						+ u.getadres() + "')";
				Statement s = connection.createStatement();
				s.executeUpdate(sql);
				s.close();
			} else
				status = 0;

		} catch (Exception e) {
			status = 0;
		}

		return status;
	}

	public static int updateFiyat(int id,String table, double fiyat )
	{
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();
		int status = 1;
		 try {

	            String sql        = "UPDATE "+table+" SET fiyat = ? "
	                     + " WHERE id = ?";

	            //String sql     = "UPDATE student SET firstName = ? "
	            //       + " Set lastName = ?, "
	            //       + " WHERE studentID = 456987";

	            PreparedStatement pst = connection.prepareStatement(sql);
	            pst.setDouble(1, fiyat);
	            pst.setInt(2, id);

	            pst.executeUpdate();
	            System.out.println("Updated Successfully!");

	            connection.close();

		} catch (Exception e) {
			status = 0;
		}

		return status;
	}

	
	
	
	public static int yiyecekEkle(Yiyecek y, String table) {
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();
		int status = 1;
		System.out.println(y.getId() + y.getKey() + y.getValue());
		try {
			String sql = "insert into " + table
					+ "(id, ad, fiyat ) values('"
					+ y.getId() + "','" + y.getKey() + "','" + y.getValue()
					+ "')";
			Statement s = connection.createStatement();
			s.executeUpdate(sql);
			s.close();
			System.out.println(y.getId() + y.getKey() + y.getValue());


		} catch (Exception e) {
			status = 0;
		}

		return status;
	}

	public static boolean sorgula(LoginBean bean) {
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();
		boolean status2 = false;

		try {
			System.out.println(bean.getuserid() + bean.getsifre());
			Statement st = connection.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM tb_kullanicilar");
			while (result.next()) {
				if (bean.getuserid().equals(result.getString("userid"))
						& bean.getsifre().equals(result.getString("sifre"))) {
					bean.setyetki(result.getInt("yetki"));
					status2 = true;
				}

			}
			connection.close();

		} catch (Exception e) {
			status2 = false;
		}

		return status2;
	}


	public static String sorgula(int id) {
		String ad = null ;
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();

		try {
			System.out.println(id);
			Statement st = connection.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM tb_yemek where id = "+id);
			while (result.next()) {
					ad = result.getString("ad");
				}

			
			connection.close();
			
		} catch (Exception e) {
			
		}
		return ad;

	
	}
}


