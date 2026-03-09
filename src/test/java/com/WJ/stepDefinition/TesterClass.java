package com.WJ.stepDefinition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.*;

import static org.junit.Assert.assertArrayEquals;

import java.io.*;
import java.net.*;

public class TesterClass {

	public static void main(String[] args) throws IOException {

		// ------------------------------Datatabase Connection
		// String-------------------------------------------
		/*
		 * String url =
		 * "jdbc:sqlserver://localhost:1433;databaseName=MyFirstDB;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
		 * Connection conn = DriverManager.getConnection(url);
		 * System.out.println("Connected to SQL Server with Windows Authentication!");
		 * 
		 * Statement stmt = conn.createStatement(); String SQL =
		 * "Select TOP 1 Name from Employees"; ResultSet rs = stmt.executeQuery(SQL);
		 * //for select query //int affectedrows = stmt.executeUpdate(SQL); //for update
		 * query
		 * 
		 * while (rs.next()) { System.out.println("fetched value from DB is: " +
		 * rs.getString("Name"));
		 */
		// ------------------------------End of Datatabase Connection
		// String-------------------------------------------

		// ------------------------------Reading a File from URL and handling the string
		// -------------------------------------------
		/*
		 * URL url = new URL("https://temp.staticsave.com/69aa7a3a8ff85.txt");
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(url.openStream())); String line;
		 * System.out.println(br.readLine());
		 * 
		 * LocalDateTime now = LocalDateTime.now(); DateTimeFormatter formatter =
		 * DateTimeFormatter.ofPattern("yyyy-MM-dd"); String date =
		 * now.format(formatter);
		 * 
		 * String date1 = "2026-03-06"; int count=0; try {
		 * while((line=br.readLine())!=null) { System.out.println(line); String[] parts
		 * = line.split(" "); if(parts.length>4) { continue; }
		 * if(parts[0].equals(date1)) { if(parts[2].equals("Block")){ count = count+1; }
		 * } } System.out.println("The blocked IPs for the given days is: "+count); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */
		// ------------------------------End of Reading a File from URL and handling the
		// string -------------------------------------------
		
		
		// ------------------------------Reading a File from Local directory and handling the string
				// -------------------------------------------
				
		  
		/*
		 * BufferedReader br = new BufferedReader(new
		 * FileReader("C:\\Work\\Project\\mySeleniumBDDFramework\\target\\iPsText.txt"))
		 * ; String line; System.out.println(br.readLine());
		 * 
		 * LocalDateTime now = LocalDateTime.now(); DateTimeFormatter formatter =
		 * DateTimeFormatter.ofPattern("yyyy-MM-dd"); String date =
		 * now.format(formatter); String date1 = "2026-03-06"; int count=0; try {
		 * while((line=br.readLine())!=null) { System.out.println(line); String[] parts
		 * = line.split(" "); if(parts.length>4) { continue; }
		 * if(parts[0].equals(date1)) { if(parts[2].equals("Block")){ count = count+1; }
		 * } } System.out.println("The blocked IPs for the given days is: "+count); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */
		 
		// ------------------------------End of Reading a File from Local directory and handling the
		// string -------------------------------------------
	
		//-------------------------------Start of Train Ticket Calculation Program ----------------------------------
		//---------------------------------------------------
		
		/*
		 * List<String> stations=
		 * Arrays.asList("Alandur","Guindy","Saidapet","Little Mount","Nandanam",
		 * "Teynampet","Thosand Lights","LIC","Governer's Estate","Central Station");
		 * 
		 * String BoardingStation = "Central Station"; String DestinationStation =
		 * "Alandur"; int costPerStation = 2;
		 * 
		 * int boardingStationIndex = stations.indexOf(BoardingStation); int
		 * destinationStation = stations.indexOf(DestinationStation);
		 * 
		 * int stationsTravelled = Math.abs(boardingStationIndex-destinationStation);
		 * int fare = stationsTravelled*costPerStation;
		 * 
		 * System.out.println("total cost of station travelled $"+fare);
		 */
		
		//-------------------------------End of Train Ticket Calculation Program ----------------------------------
		//---------------------------------------------------
		
		String name = "Test";
	
	}

}
