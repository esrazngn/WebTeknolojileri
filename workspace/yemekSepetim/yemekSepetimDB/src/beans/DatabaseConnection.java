package beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

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

	public static int updateFiyat(int id, String table, double fiyat) {
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();
		int status = 1;
		try {

			String sql = "UPDATE " + table + " SET fiyat = ? "
					+ " WHERE id = ?";

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

	public static int updateSifre(String id, String sifre) {
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();
		int status = 1;
		try {

			String sql = "UPDATE tb_kullanicilar SET sifre = ? "
					+ " WHERE userid = ?";

			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, sifre);
			pst.setString(2, id);

			pst.executeUpdate();
			System.out.println("Updated Successfully!");

			connection.close();

		} catch (Exception e) {
			status = 0;
		}

		return status;
	}

	public static boolean updateBakiye(kredi kk, double fiyat) {
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();
		boolean status = true;
		System.out.println(fiyat);
		if(kk.getBakiye()<fiyat){
			status = false;
		}
		if(status!=false){
		kk.setBakiye(kk.getBakiye() - fiyat);
		System.out.println("gifiyat: " + kk.getBakiye());
		try {
			;
			String sql = "UPDATE tb_kkart SET bakiye = ? " + " WHERE no = ?";
			System.out.println("kkkk" + kk.getBakiye() + "lklk"
					+ (kk.getBakiye()) + "no" + kk.getNo());
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setDouble(1, kk.getBakiye());
			pst.setInt(2, kk.getNo());
			pst.executeUpdate();
			System.out.println("Updated Successfully!");

			connection.close();

		} catch (Exception e) {
			status = false;
		}
		}
		return status;

	}

	public static int yiyecekEkle(Yiyecek y, String table) {
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();
		int status = 1;
		System.out.println(y.getId() + y.getKey() + y.getValue());
		try {
			String sql = "insert into " + table + "(id, ad, fiyat ) values('"
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

	public static boolean siparisEkle(siparisBean siparis) throws SQLException {
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();
		
		ResultSet rs = null;
		PreparedStatement pst = connection.prepareStatement("select id from tb_siparis");
		rs = pst.executeQuery();
		int id = 0;
		while (rs.next()) {
			id = rs.getInt("id");
		}		
		id += 1;
		boolean status = true;
		int yemekboy, icecekboy, salataboy;
		yemekboy = siparis.getyemek().size();
		icecekboy = siparis.geticecek().size();
		salataboy = siparis.getsalata().size();
		int[] dizi = new int[3];
		dizi[0] = yemekboy;
		dizi[1] = icecekboy;
		dizi[2] = salataboy;
		Arrays.sort(dizi);

		String sql1, sql2, sql3, sql4, sql5, sql6, sql7, sql8 = null, sql9 = null;

		int kucuk, orta, buyuk;
		kucuk = dizi[0];
		orta = dizi[1];
		buyuk = dizi[2];

		int i = 0, j = 0, k = 0 ;

		sql1 = "insert into tb_siparis (id, yemekID, yemekAdet, icecekID, icecekAdet, toplamFiyat) values('"
				+ id
				+ "','"
				+ siparis.getyemek().get(j).getId()
				+ "','"
				+ siparis.getyemek().get(j).getAdet()
				+ "','"
				+ siparis.geticecek().get(j).getId()
				+ "','"
				+ siparis.geticecek().get(j).getAdet()
				+ "','"
				+ siparis.gettoplamFiyat() + "')";
		sql2 = "insert into tb_siparis (id, yemekID, yemekAdet, toplamFiyat) values('"
				+ id
				+ "','"
				+ siparis.getyemek().get(k).getId()
				+ "','"
				+ siparis.getyemek().get(k).getAdet()
				+ "','"
				+ siparis.gettoplamFiyat() + "')";

		sql3 = "insert into tb_siparis (id, yemekID, yemekAdet, salataID, salataAdet, toplamFiyat) values('"
				+ id
				+ "','"
				+ siparis.getyemek().get(j).getId()
				+ "','"
				+ siparis.getyemek().get(j).getAdet()
				+ "','"
				+ siparis.getsalata().get(j).getId()
				+ "','"
				+ siparis.getsalata().get(j).getAdet()
				+ "','"
				+ siparis.gettoplamFiyat() + "')";

		sql4 = "insert into tb_siparis (id, icecekID, icecekAdet, toplamFiyat) values('"
				+ id
				+ "','"
				+ siparis.geticecek().get(k).getId()
				+ "','"
				+ siparis.geticecek().get(k).getAdet()
				+ "','"
				+ siparis.gettoplamFiyat() + "')";

		sql5 = "insert into tb_siparis (id, icecekID, icecekAdet, salataID, salataAdet, toplamFiyat) values('"
				+ id
				+ "','"
				+ siparis.geticecek().get(j).getId()
				+ "','"
				+ siparis.geticecek().get(j).getAdet()
				+ "','"
				+ siparis.getsalata().get(j).getId()
				+ "','"
				+ siparis.getsalata().get(j).getAdet()
				+ "','"
				+ siparis.gettoplamFiyat() + "')";

		sql6 = "insert into tb_siparis (id, salataID, salataAdet, toplamFiyat) values('"
				+ id
				+ "','"
				+ siparis.geticecek().get(k).getId()
				+ "','"
				+ siparis.geticecek().get(k).getAdet()
				+ "','"
				+ siparis.gettoplamFiyat() + "')";

		for (; i < kucuk; i++) {
			try {

				System.err.println("for1");
				Statement s = connection.createStatement();
				sql7 = "insert into tb_siparis (id, yemekID, yemekAdet, icecekID, icecekAdet, salataID, salataAdet, toplamFiyat) values('"
						+ id
						+ "','"
						+ siparis.getyemek().get(i).getId()
						+ "','"
						+ siparis.getyemek().get(i).getAdet()
						+ "','"
						+ siparis.geticecek().get(i).getId()
						+ "','"
						+ siparis.geticecek().get(i).getAdet()
						+ "','"
						+ siparis.getsalata().get(i).getId()
						+ "','"
						+ siparis.getsalata().get(i).getAdet()
						+ "','"
						+ siparis.gettoplamFiyat() + "')";
				s.executeUpdate(sql7);
				System.err.println("h1");
				s.close();

			} catch (Exception e) {
				status = false;
			}
		}
		

		if (yemekboy > icecekboy & icecekboy > salataboy) {
			sql8 = sql1;
			sql9 = sql2;
		}

		else if (yemekboy > salataboy & salataboy > icecekboy) {
			sql8 = sql3;
			sql9 = sql2;

		} else if (icecekboy > yemekboy & yemekboy > salataboy) {
			sql8 = sql1;
			sql9 = sql4;
		} else if (icecekboy > yemekboy & yemekboy < salataboy) {
			sql8 = sql5;
			sql9 = sql4;
		} else if (icecekboy > yemekboy & icecekboy < salataboy) {
			sql8 = sql5;
			sql9 = sql6;
		} else if (icecekboy > yemekboy & yemekboy < salataboy) {
			sql8 = sql3;
			sql9 = sql6;
		}

		
		for (j = kucuk; j < orta; j++) {
			try {

				System.err.println("f2");
				Statement s = connection.createStatement();

				s.executeUpdate(sql8);
				System.err.println("h2");
				s.close();

			} catch (Exception e) {
				status = false;
			}
		}

		for (k = orta; k < buyuk; k++) {
			try {
				System.err.println("f3");
				Statement s = connection.createStatement();

				s.executeUpdate(sql9);
				System.err.println("h3");
				

			} catch (Exception e) {
				status = false;
			}
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
					bean.setadres(result.getString("adres"));
					status2 = true;
				}

			}
			connection.close();

		} catch (Exception e) {
			status2 = false;
		}

		return status2;
	}

	public static boolean KKsorgula(kredi kk) {
		kredi kk2 = new kredi();
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();
		boolean status2 = false;

		try {
			Statement st = connection.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM tb_kkart");
			while (result.next()) {

				kk2.setNo(Integer.parseInt(result.getString("no")));

				kk2.setAd(result.getString("ad"));
				kk2.setSoyad(result.getString("soyad"));
				kk2.setskt(result.getString("skt"));

				kk2.setcsv(Integer.parseInt(result.getString("csv")));
				kk2.setBakiye(Double.parseDouble(result.getString("bakiye")));
				System.out.println("*******" + kk2.getAd() + kk2.getBakiye()
						+ kk2.getcsv() + kk2.getNo() + kk2.getskt()
						+ kk2.getSoyad());
				System.out.println("-------" + kk.getAd() + kk.getBakiye()
						+ kk.getcsv() + kk.getNo() + kk.getskt()
						+ kk.getSoyad());

				if (kk2.getAd().equals(kk.getAd())
						& kk2.getcsv() == kk.getcsv()
						& kk2.getNo() == kk.getNo()
						& kk2.getskt().equals(kk.getskt())
						& kk2.getSoyad().equals(kk.getSoyad())) {
					status2 = true;
					kk.setBakiye(kk2.getBakiye());
					break;
				}

			}
			connection.close();

		} catch (Exception e) {
			status2 = false;
		}

		return status2;
	}

	public static ArrayList<siparisBean> SiparisListele(int siparisID) {
		DatabaseConnection r = new DatabaseConnection();

		ArrayList<siparisBean> siparis = new ArrayList<>();
		r.Baglanti();
		try {
			String yemek, icecek, salata;
			double yemekf, icecekf, salataf;
			Statement st = connection.createStatement();
			ResultSet result = st
					.executeQuery("SELECT * FROM tb_siparis where id = "
							+ siparisID);
			while (result.next()) {
				siparisBean sip = new siparisBean();
				Yiyecek y = new Yiyecek();
				Yiyecek i = new Yiyecek();
				Yiyecek s = new Yiyecek();
				sip.setyemekAdet(Integer.parseInt(result.getString("yemekAdet")));
				sip.seticecekAdet(Integer.parseInt(result
						.getString("icecekAdet")));
				sip.setsalataAdet(Integer.parseInt(result
						.getString("salataAdet")));
				y.setId(Integer.parseInt(result.getString("yemekID")));
				yemek = sorgula(y.getId(), "tb_yemek", "ad");
				yemekf = Double.parseDouble(sorgula(y.getId(), "tb_yemek",
						"fiyat"));

				y.setKey(yemek);

				y.setValue(yemekf);

				i.setId(Integer.parseInt(result.getString("icecekID")));

				icecek = sorgula(i.getId(), "tb_icecek", "ad");

				icecekf = Double.parseDouble(sorgula(i.getId(), "tb_icecek",
						"fiyat"));

				i.setKey(icecek);
				i.setValue(icecekf);
				s.setId(Integer.parseInt(result.getString("salataID")));
				salata = sorgula(s.getId(), "tb_salata", "ad");
				salataf = Double.parseDouble(sorgula(s.getId(), "tb_salata",
						"fiyat"));
				System.out.println("dasdasd");

				s.setKey(salata);

				s.setValue(salataf);
				sip.setyemek(y);
				sip.seticecek(i);
				sip.setsalata(s);
				sip.settoplamFiyat(Double.parseDouble(result
						.getString("toplamFiyat")));
				siparis.add(sip);
				System.out.println("dasdasd");
			}

			connection.close();

		} catch (Exception e) {
			System.err.println("aaa");
		}

		return siparis;
	}

	public static String sorgula(int id, String table, String sorulan) {
		String ad = null;
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();

		try {
			System.out.println(id);
			Statement st = connection.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM " + table
					+ " where id = " + id);
			while (result.next()) {
				ad = result.getString(sorulan);
			}

			connection.close();

		} catch (Exception e) {

		}
		return ad;

	}

	
	  public static ArrayList<siparisBean> yiyecekListele(String table) {
	  ArrayList<siparisBean> siparis = new ArrayList<>(); DatabaseConnection r
	  = new DatabaseConnection(); r.Baglanti();
	  
	  try { Statement st = connection.createStatement(); String sql =
	  "SELECT * FROM  " + table;
	  
	  ResultSet rs = st.executeQuery(sql); // STEP 5: Extract data from result
	   
	  while (rs.next()) { 
		  beans.siparisBean s = new siparisBean();
		  
	  s.setID(rs.getInt("id")); 
	  s.setyemekID(rs.getInt("yemekID"));
	  s.seticecekID(rs.getInt("icecekID"));
	  s.setsalataID(rs.getInt("salataID"));
	  s.setyemekAdet(rs.getInt("yemekAdet"));
	  s.seticecekAdet(rs.getInt("icecekAdet"));
	  s.setsalataAdet(rs.getInt("salataAdet"));
	  s.settoplamFiyat(rs.getDouble("toplamFiyat"));
	  
	 siparis.add(s); 
	 } System.out.println("id" + siparis.get(0).getID() +
	  "iadet" + siparis.get(0).geticecekAdet() + "fiyat" +
	  siparis.get(0).gettoplamFiyat()); System.out.println("id" +
	  siparis.get(1).getID() + "iadet" + siparis.get(1).geticecekAdet() +
	  "fiyat" + siparis.get(1).gettoplamFiyat());
	  
	  rs.close(); } catch (Exception e) {
	  
	  } return siparis; }
	 
	public static ArrayList<Yiyecek> yiyecek(String table) {
		ArrayList<Yiyecek> yiyecekler = new ArrayList<>();
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();

		try {
			Statement st = connection.createStatement(
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY,
					ResultSet.CLOSE_CURSORS_AT_COMMIT);
			String sql = "SELECT * FROM  " + table;

			ResultSet rs = st.executeQuery(sql);
			// STEP 5: Extract data from result set
			while (rs.next()) {
				beans.Yiyecek s = new Yiyecek();

				s.setId(rs.getInt("id"));
				s.setKey(rs.getString("ad"));
				s.setValue(rs.getDouble("fiyat"));
				yiyecekler.add(s);
			}
			System.out.println("id" + yiyecekler.get(0).getId());
			System.out.println("id" + yiyecekler.get(1).getId());

			rs.close();
		} catch (Exception e) {

		}
		return yiyecekler;
	}

	public static int deleteKullanici(String id) {
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();
		int status = 1;
		try {

			String sql = "Delete from tb_kullanicilar " + " WHERE userid = ?";

			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();

			System.out.println("Deleted Successfully!");

			connection.close();

		} catch (Exception e) {
			status = 0;
		}

		return status;
	}

	public static String kullaniciSorgula(String id, String table,
			String sorulan) {
		String sorulandeger = null;
		DatabaseConnection r = new DatabaseConnection();
		r.Baglanti();

		try {
			Statement st = connection.createStatement();
			String sql = "SELECT * FROM tb_kullanicilar ";

			ResultSet rs = st.executeQuery(sql);
			// STEP 5: Extract data from result set
			while (rs.next()) {
				String last = rs.getString("userid");
				String first = rs.getString(sorulan);

				if (last.equals(id)) {
					sorulandeger = first;
				}

			}
			rs.close();

		} catch (Exception e) {

		}
		return sorulandeger;

	}
}
