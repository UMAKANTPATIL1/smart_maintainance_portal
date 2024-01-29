package com.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivityDemo {
	static Connection conn=null;
	public static Connection connectDb()
	{
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_maintainance","root","");
			//System.out.println("Database Connected !!!");
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return conn;
		
	}
}
