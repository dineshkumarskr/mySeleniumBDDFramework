package stepDefinition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesterClass {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=MyFirstDB;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
		Connection conn = DriverManager.getConnection(url);
		System.out.println("Connected to SQL Server with Windows Authentication!");

		Statement stmt = conn.createStatement();
		String SQL = "Select TOP 1 Name from Employees";
		ResultSet rs = stmt.executeQuery(SQL); //for select query
		//int affectedrows = stmt.executeUpdate(SQL); //for update query	
		
		while (rs.next()) { 
			System.out.println("fetched value from DB is: " + rs.getString("Name")); 
		}
		 
		
		//System.out.println("Rows updated: " + affectedrows);
		
	}

}
