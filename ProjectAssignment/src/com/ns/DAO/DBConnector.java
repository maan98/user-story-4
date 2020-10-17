package com.ns.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	static DBConnector db;
	static Connection con;
	
	private DBConnector() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schemaone","root","M@@n98n@v");
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(db==null)
		db=new DBConnector();
		return con;
	}

}
