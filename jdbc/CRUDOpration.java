package com.jdbcDemo;

//Import driver package
import java.sql.*;
import java.util.Scanner;

public class CRUDOpration {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Connection con = establishConnection();
		
		while(true) {
			System.out.println("What CRUD operation do you want to perform (C, R, U, D) or E for exit:");
			char operation = Character.toUpperCase(sc.next().charAt(0));
			if (operation != 'E') {
				System.out.println("Enter roll number and name for C|U, roll number for R|D:");
				int rollNumber = sc.nextInt();
				String studentName = "";
				if (operation == 'C' || operation == 'U')
					studentName = sc.next();
				
				switch(operation) {
				case 'C':
					insertData(con, rollNumber, studentName);
					break;
				case 'R':
					fetchData(con, rollNumber);
					break;
				case 'U':
					updateData(con, rollNumber, studentName);
					break;
				case 'D':
					deleteData(con, rollNumber);
					break;
				}
			} else {
				break;
			}
		}		
		sc.close();
	}

	public static Connection establishConnection() throws Exception {
		// connecting with driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// establish the connection
		String url = "jdbc:mysql://localhost:3306/j2ee";
		Connection con = DriverManager.getConnection(url, "root", "Aj@080123");
		
		//System.out.println("Connection established : "+con);
		return con;
	}
	
	public static void insertData(Connection con, int roll, String name) throws Exception {
		// write the SQL qurey for static data
		//String sql = "INSERT INTO student values(8, 'Anani')";			
		// SQL query for dynamic data		
		// Send static data query through statement
		//Statement st = establishConnection().createStatement(); When dynamic data needs to be sent use prepared data
		//int r = st.executeUpdate(sql);
		
		//Dynamic data use PreparedStatement , try-with-resources for auto closing Connection, PreparedStatement
		String sql = "INSERT INTO student values(?,?)";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, roll);
			ps.setString(2, name);
			int r = ps.executeUpdate(); //0 parameterized executeUpdate
			System.out.println(r +" rows inserted");
		}		
	}
	
	public static void updateData(Connection con, int roll, String name) throws Exception {
		
		//String sql = "UPDATE student SET name='Apoorva' WHERE roll=1";		
//		Statement st = establishConnection().createStatement();
//		int r = st.executeUpdate(sql);
		
		String sql = "UPDATE student SET name=? WHERE roll=?";
		try (PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, name);
			ps.setInt(2, roll);
			int r = ps.executeUpdate();
			
			System.out.println(r +" rows updated");
		}
	}
	
	public static void fetchData(Connection con, int roll) throws Exception {
	    String sql = "SELECT roll, name FROM student WHERE roll=?";
	    try (PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, roll);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                System.out.println("Roll: " + rs.getInt("roll") + ", Name: " + rs.getString("name"));
	            } else {
	                System.out.println("No student found with roll " + roll);
	            }
	        }
	    }
	}

	
	public static void deleteData(Connection con, int roll) throws Exception {
		// write the SQL qurey		
		// Send query through statement
//		Statement st = establishConnection().createStatement();
//		int r = st.executeUpdate(sql);
		
		String sql = "DELETE FROM student WHERE roll = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, roll);
		int r = ps.executeUpdate();
		
		System.out.println(r +" rows deleted");
	}
}
