package com.shan.jdbc;

public class DatabaseConnectionInfo {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
	private String user = "hbstudent";
	private String pass = "hbstudent";
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public String getUser() {
		return user;
	}
	public String getPass() {
		return pass;
	}
	
	
}
