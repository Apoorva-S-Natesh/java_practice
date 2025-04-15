package com.jdbcDemo;

//1- importing sql package (my sql connector jar)
//downladed and added the jar file in buildpath (rightclick project name and then choose libraries, class path, add external jar file )
import java.sql.*;

public class JdbcDemo {

	public static void main(String[] args) throws Exception{
		// 2- Loading the driver - in case of mysql this automatically done, can omit this
		//type4 driver, Thin driver
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		//3- establishing connection
		String url="jdbc:mysql://localhost:3306/j2ee"; /*if required ip address of system where DB is present instead of localhost : 3306 port where sql is running internally / name of the database
		can check if the port by typing : <netstat -aon | findstr :3306> on cmd, default for mysql is 3306. then to find which program is suing this port <tasklist /FI "PID eq 2432"> or go to the config file my.ini or my.cnf by typing where my.ini ad check [mysqld] port=3306) */ 
		
		/*
		 *    url:		tech:db://ipaddress or localost:portNumber/database name
		 */
		String uname="root";
		String pass="1234"; //username and password of mysql
		Connection con = DriverManager.getConnection(url, uname, pass); //establishing the connection, Connection is a interface
		
		System.out.println("Connection Established: " + con);
	}
}
