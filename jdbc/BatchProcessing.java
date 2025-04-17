package com.jdbcDemo;

import java.sql.*;
import java.util.Arrays;

public class BatchProcessing {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/j2ee";
		String username = "root";
		String password = "Aj@080123";
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		
		String sql1 = "INSERT INTO student values(9,'name1')";
		String sql2 = "INSERT INTO student values(10,'name2')";
		String sql3 = "INSERT INTO student values(11,'name3')";
		
		try (Statement st = con.createStatement()) {
			st.addBatch(sql1);
			st.addBatch(sql2);
			st.addBatch(sql3);
			int[] r = st.executeBatch();
			System.out.println(Arrays.toString(r) +" rows inserted"); //Output: [1, 1, 1] rows inserted
		}
	}
}
