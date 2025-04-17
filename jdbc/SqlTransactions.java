package com.jdbcDemo;

import java.sql.*;
public class SqlTransactions{

	public static void main(String[] args)  throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/j2ee";
		String username = "root";
		String password = "1234";
			
		Connection con = DriverManager.getConnection(url, username, password);
		con.setAutoCommit(false);
		
		String sql1 = "UPDATE bank SET BALANCE=15000 WHERE acc_num=20002";
		String sql2 = "UPDATE bank SET BALANCE=40000 WHERE acc_num=10001";
		
		Statement st = con.createStatement();
		try {
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
		} catch (Exception ex) {
			con.rollback(); // Rollback if something goes wrong
		}
		con.commit();
		
		con.setAutoCommit(true); // Turn on auto-commit again
	}
}

/* 
 * Only when both the queries are correct and can be executed, 
 * it will execute both. Otherwise if one the queries is wrong, 
 * both will not be executed(rolled back). To check this behaviour, 
 * comment out setAutoCommit() lines and make one of the queries wrong by changing the table name.
 * In that case, only the correct query will be executed and changes will be made to the table.
 * 
 * */
