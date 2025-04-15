package com.jdbcDemo;

import java.sql.*;

public class JdbcIntroduction {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/j2ee";
		String uname = "root";
		String pass = "1234";
		//String sql = "INSERT INTO student VALUES(7, 'Shashu'),(8, 'Anani')";
		String sql = "SELECT * FROM student";
		
		Connection con = DriverManager.getConnection(url, uname, pass);
		System.out.println("Connection established to DBMS");
		
		//Creating Statement that carries sql query from java to DBMS
		Statement st = con.createStatement();
		// st.execute(sql);
		/*
		int r = st.executeUpdate(sql);
		System.out.println(r + " row inserted");
		*/
		
		ResultSet rs = st.executeQuery(sql); //rs will also act like a pointer or iterator 
		System.out.println("Data received: ");
		/*
		rs.next(); //Pointer moves from before the table(or start of table to the first row. If not given, gives the below error
		System.out.println("Roll: " + rs.getInt(1)); // Row 1, Column 1
		System.out.println("Name: " + rs.getString(2)); //ROw 1, column 2
		*/
		//to print all rows:
		while(rs.next()) {
			System.out.print("Roll: " + rs.getInt(1) + " | ");
			System.out.print("Name: " + rs.getString(2));
			System.out.println();
		}
		
		/*
		Error:
		Exception in thread "main" java.sql.SQLException: Before start of result set
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:121)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:89)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:81)
		 */
		
	}
}
