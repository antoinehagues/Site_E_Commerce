package com.hitema.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBController {
	
	private final static String URL = "jdbc:mysql://localhost/hitema.ecommerce";
	private Connection connection;
	
	public DBController(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			setConnection(DriverManager.getConnection(URL, "root", ""));	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			getConnection().close();
		} catch (SQLException e) {
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
