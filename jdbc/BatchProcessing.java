package com.jdbcDemo;

import java.sql.*;
//import java.util.Arrays;
import java.util.Scanner;

public class BatchProcessing {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/j2ee";
		String username = "root";
		String password = "1234";
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection con = DriverManager.getConnection(url, username, password);
		
		/*
		 * String sql1 = "INSERT INTO student values(9,'name1')"; String sql2 =
		 * "INSERT INTO student values(10,'name2')"; String sql3 =
		 * "INSERT INTO student values(11,'name3')";
		 * 
		 * try (Statement st = con.createStatement()) { 
		 * st.addBatch(sql1);
		 * st.addBatch(sql2); 
		 * st.addBatch(sql3); 
		 * int[] r = st.executeBatch();
		 * System.out.println(Arrays.toString(r) +" rows inserted"); //Output: [1, 1, 1]
		 * rows inserted }
		 */
		
		//Dynamic data batch processing
		try (
	            Connection con = DriverManager.getConnection(url, username, password);
	            Scanner sc = new Scanner(System.in);
	            PreparedStatement ps = con.prepareStatement("INSERT INTO student VALUES (?, ?)");
	        ) {
	            int count = 0;
	            System.out.println("Enter roll and name space-separated, or 'exit' to finish:");

	            while (true) {
	                String input = sc.nextLine();
	                if (input.equalsIgnoreCase("exit")) {
	                    break;
	                }

	                String[] parts = input.split("\\s+");
	                if (parts.length < 2) {
	                    System.out.println("Invalid input. Try again.");
	                    continue;
	                }

	                try {
	                    int roll = Integer.parseInt(parts[0]);
	                    String name = parts[1];

	                    ps.setInt(1, roll);
	                    ps.setString(2, name);
	                    ps.addBatch();
	                    count++;
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid roll number. Try again.");
	                }
	            }

	            if (count > 0) {
	                int[] results = ps.executeBatch();
	                System.out.println(results.length + " records inserted.");
	            } else {
	                System.out.println(count + " Rows Affected, No data to insert.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
