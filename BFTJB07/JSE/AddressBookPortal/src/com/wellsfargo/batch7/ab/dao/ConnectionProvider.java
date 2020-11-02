package com.wellsfargo.batch7.ab.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
	private static DataSource dataSource;

	public static Connection getConn() throws SQLException {
		if(dataSource==null) {
			
			try {
				InitialContext context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/MyDB");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return dataSource.getConnection();
	}
}
