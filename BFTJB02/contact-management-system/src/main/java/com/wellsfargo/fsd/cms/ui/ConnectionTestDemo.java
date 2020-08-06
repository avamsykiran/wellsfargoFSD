package com.wellsfargo.fsd.cms.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTestDemo {

	public static void main(String[] args) {
		 try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","root");
			System.out.println("con is open");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
