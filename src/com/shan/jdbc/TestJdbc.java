package com.shan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		DatabaseConnectionInfo info = new DatabaseConnectionInfo();
		
		try {
			System.out.println("Connecting to database: " + info.getJdbcUrl());
			Connection myConn = DriverManager.getConnection(info.getJdbcUrl(), info.getUser(), info.getPass());
			System.out.println("Connection successfull!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
