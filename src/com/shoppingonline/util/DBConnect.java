package com.shoppingonline.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection con;
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/shoppingonline";
		String user = "zmy";
		String password = "123456";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
	
	
}
