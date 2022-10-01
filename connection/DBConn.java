package com.masai.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	public static Connection provideConnection() {

		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/sb101_project_gpm";
		
		try {
			con = DriverManager.getConnection(url, "root", "1179");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}

}
