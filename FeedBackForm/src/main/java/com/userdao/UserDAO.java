package com.userdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import com.singleton.JdbcConnection;

public class UserDAO {

	static JdbcConnection dbInstance = JdbcConnection.getInstance();
	 
	
	public static boolean checkData(int gin,Date date) throws SQLException
	{
		boolean status=false;
		Connection con = dbInstance.getConnection();
		PreparedStatement ps = con.prepareStatement("select gin,Date from attendance");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			if(gin==(rs.getInt("gin"))&&date.equals(rs.getDate("Date")))
			{
				status=true;
			}
		}
		return status;
	}
	public static boolean collectData(int gin, String name, Date date, String workingstatus, Time time) {
		boolean status = false;

		try {
			Connection con = dbInstance.getConnection();
			String query = "insert into attendance values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, gin);
			ps.setString(2, name);
			ps.setDate(3, date);
			ps.setString(4, workingstatus);
			ps.setTime(5, time);
			int i = ps.executeUpdate();
			if (i == 1) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
