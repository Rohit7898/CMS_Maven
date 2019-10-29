package com.cms.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	Connection conn = null;
	public Connection getConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/cms?allowPublicKeyRetrieval=true&useSSL=false";
		String username = "root";
		String password = "Hexaware123";
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	     conn = DriverManager.getConnection(dbURL, username, password);
		} catch (SQLException ex) {
	ex.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
		return conn;
	}

}
