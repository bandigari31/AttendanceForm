package com.editdata;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.bean.BeanClass;
import com.singleton.JdbcConnection;

public class AccessData {

	static JdbcConnection dbInstance = JdbcConnection.getInstance();
	public static List<BeanClass> getData() throws SQLException
	{
		ArrayList<BeanClass> list=new ArrayList<>();
		Connection con=dbInstance.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from attendance");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int tgin=rs.getInt("gin");
			String tname=rs.getString("name");
			String tworkingstatus=rs.getString("workingstatus");
			Date tdate=rs.getDate("Date");
			Time ttime=rs.getTime("Time");
			BeanClass bc=new BeanClass(tgin,tname,tworkingstatus,ttime);
			list.add(bc);
			//System.out.println(list);
		}
		return list;
	}
}
