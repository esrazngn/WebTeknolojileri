package org.me.jsp.beans;

import java.sql.*;
import java.util.*;

public class GuestDataBean {
	private Connection connection;
	private PreparedStatement addRecord, getRecords;

	public GuestDataBean() throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					
					"jdbc:mysql://localhost:3306/yemeksepetim", "root",
					"test");

			getRecords = connection
					.prepareStatement("SELECT ad, soyad, adres FROM tb_kullanicilar");

			addRecord = connection.prepareStatement("INSERT INTO guests ( "
					+ "firstName, lastName, email ) " + "VALUES ( ?, ?, ? )");

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

	public List<GuestBean> getGuestList() throws SQLException {
		List<GuestBean> guestList = new ArrayList<GuestBean>();

		// obtain list of titles
		ResultSet results = getRecords.executeQuery();

		// get row data
		while (results.next()) {
			GuestBean guest = new GuestBean();

			guest.setFirstName(results.getString(1));
			guest.setLastName(results.getString(2));
			guest.setEmail(results.getString(3));

			guestList.add(guest);
		}

		return guestList;
	}

	public void addGuest(GuestBean guest) throws SQLException {
		addRecord.setString(1, guest.getFirstName());
		addRecord.setString(2, guest.getLastName());
		addRecord.setString(3, guest.getEmail());

		addRecord.executeUpdate();
	}

	protected void finalize() {
		try {
			getRecords.close();
			addRecord.close();
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

}
