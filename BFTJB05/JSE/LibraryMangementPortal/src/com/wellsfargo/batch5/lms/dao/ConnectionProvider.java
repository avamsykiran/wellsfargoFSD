package com.wellsfargo.batch5.lms.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
	
	private static DataSource datasource;

	public static Connection getConnection() throws SQLException {
		
		if(datasource==null) {
			try {
			InitialContext context = new InitialContext();
			datasource = (DataSource)context.lookup("java:/comp/env/jdbc/MyDB");
			}catch(NamingException exp) {
				exp.printStackTrace();
			}
		}
		
		return datasource.getConnection();
	}
}
