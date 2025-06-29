package com.pluralsight.corejdbc.m3c1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProductsComponent {

	public boolean tryConnection() throws Exception {	

		
		Connection connection = 
		DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?"
				+ "user=root&password=pluralsight&serverTimezone=UTC");

		//Using an Oracle Database
//		Connection connection =
//				DriverManager.getConnection("jdbc:oracle:thin:@myhost:1521:orcl", "root", "pluralsight");

		//Using a Microsoft SQL Server
//		Connection connection =
//				DriverManager.getConnection("jdbc:sqlserver://localhost;" + "user=root;password=pluralsight");


		boolean isValid = connection.isValid(2);
		
		
		connection.close();	
			
		
		return isValid;
    }

}

