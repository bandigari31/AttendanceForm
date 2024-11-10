package com.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	private JdbcConnection()
	{
		
	}
	private static JdbcConnection instance;

	private Connection connection = null;

	public static JdbcConnection getInstance() {
		if (instance == null) {
			instance = new JdbcConnection();
		}
		return instance;
	}

	public void connectToDB() throws SQLException {
		String url = "jdbc:sqlserver://LINMBA6963\\SQLEXPRESS:1433;databaseName=testdb;encrypt=true;trustServerCertificate=true";
		String username = "GSI";
		String pwd = "Glory110";
		connection = DriverManager.getConnection(url, username, pwd);
		System.out.println("connection success..");
	}

	public Connection getConnection() throws SQLException {
		if (connection == null) connectToDB();
		return connection;
	}

}
