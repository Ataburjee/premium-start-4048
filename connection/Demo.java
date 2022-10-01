package com.masai.connection;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn = DBConn.provideConnection();
		
		System.out.println(conn);
		
	}

}