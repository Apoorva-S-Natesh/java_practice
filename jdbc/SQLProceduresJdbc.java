package com.jdbcDemo;

import java.sql.*;
import java.util.Scanner;

public class SQLProceduresJdbc {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/j2ee";
		String name = "root";
		String password = "Aj@080123";
		
		Connection con = DriverManager.getConnection(url, name, password);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the account number:");
		int acc_number = sc.nextInt();
		System.out.println("Enter the account holder name:");
		String acc_name = sc.next();
		System.out.println("Enter the account balance:");
		int acc_balance = sc.nextInt();
		
		sc.close();
		
		String sql = "{CALL inset_data(?, ?, ?)}";
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, acc_number);
		cs.setString(2, acc_name);
		cs.setInt(3, acc_balance);
		
		cs.execute(); // or cs.executeUpdate();
	}
}

/*
 * create a stored procedure on my sql and that be called from java using CallableStatement and sql string is enclose in {}
 * 
mysql> delimiter //
mysql> CREATE PROCEDURE inset_data(
    -> IN acc_balance INT,
    -> IN acc_name varchar(15),
    -> IN acc_number INT
    -> )
    -> BEGIN
    -> insert into bank values(
    -> acc_number, acc_name, acc_balance
    -> );
    -> END
    -> //
Query OK, 0 rows affected (0.11 sec)

mysql> DElimiter ;

IN to specify its an Input-only parameter
TO capture an output parameter from a stores procedure, we call it with a variable prefixed by @.
CREATE PROCEDURE get_balance(
    -> OUT acc_balance INT
    -> )
    -> BEGIN
    -> select balance into acc_balacne from bank;
    -> END
    
 * */
