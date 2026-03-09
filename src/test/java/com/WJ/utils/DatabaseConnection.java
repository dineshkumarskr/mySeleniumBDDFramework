package com.WJ.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	
	public static Connection connectSQLServerDB() throws SQLException {
		Connection conn = DriverManager.getConnection(ConfigManager.get("dbURL"));
		System.out.println("Connected to SQL Server with Windows Authentication!");
		//Statement stmt = conn.createStatement();
		return conn;
	}

}
