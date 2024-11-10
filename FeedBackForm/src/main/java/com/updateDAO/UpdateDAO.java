package com.updateDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.singleton.JdbcConnection;

public class UpdateDAO {
	static JdbcConnection dbInstance = JdbcConnection.getInstance();

	public static boolean updateData(int gin, String name, Date date, String Workingstatus) throws SQLException {
		boolean status = false;
		LocalTime ltime = LocalTime.now();
		Time time = Time.valueOf(ltime);
		Connection con = dbInstance.getConnection();
		PreparedStatement ps = con.prepareStatement("update attendance set name=?,Date=?,workingstatus=?,Time=? where gin=?");
		ps.setString(1, name);
		ps.setDate(2, date);
		ps.setString(3, Workingstatus);
		ps.setTime(4, time);
		ps.setInt(5, gin);
		int i = ps.executeUpdate();
		if (i == 1) {
			status = true;
		}
		return status;
	}

}
