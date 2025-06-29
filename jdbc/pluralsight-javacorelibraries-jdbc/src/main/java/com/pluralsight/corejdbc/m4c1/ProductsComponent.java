package com.pluralsight.corejdbc.m4c1;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class ProductsComponent {

	public void printProductList() throws Exception {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");
		Statement statement = connection.createStatement();
		//ResultsSet is used to view the actual data
		ResultSet resultSet = 
		statement.executeQuery("SELECT * FROM products");	
		
		while(resultSet.next()) {
			String name = resultSet.getString("productName");
			System.out.println(name);
		}

		//Each of these JDBC types manufactured here should be closed in the reverse order that they were created
		resultSet.close();
		statement.close();
		connection.close();
		
	}
}
