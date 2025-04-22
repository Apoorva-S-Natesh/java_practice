package hibernateIntro;

import java.sql.*;
//import java.util.Scanner;

class Student{
	int kodId;
	String name;
	String address;
	int yop;
	
	public Student(int kodId, String name, String address, int yop) {
		this.kodId = kodId;
		this.name = name;
		this.address = address;
		this.yop = yop;
	}
}

public class NeedforHibernate
{
	public static void main(String[] args) throws Exception
	{
		Student st = new Student(1001, "Apoo", "Halle", 2020);
		regStudent(st);
	}
	
	public static void regStudent(Student st) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/j2ee";
		String uname = "root";
		String password = "Aj@080123";
		Connection con = DriverManager.getConnection(url, uname, password);
		
		int kodId = st.kodId;
		String name = st.name;
		String address = st.address;
		int yop = st.yop;
		
		
		String sql = "INSERT INTO student values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, kodId);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setInt(4, yop);
		
		int r = ps.executeUpdate();
		System.out.println(r +" rows inserted");
		
		con.close();
	}
}

/*
 * Hibernate is an ORM : Object Relational Mapping
 * Objects are data structures like a user or an order in java code.
 * Relational: Databases store data in tables
 * Mapping: ORM is about linking or mapping those java objects to the database tables where the data is stored.
 * 
 * Why Hibernate?:
 * Simplified Database Interactions
 * need not worry about SQL syntaxes - Need not worry about specific syntax of different flavors of SQL. Hibernate uses (Hibernate Query Language)
 * automatic table creation
 * Lazy-loading : only loads data when needed.
 * */
 