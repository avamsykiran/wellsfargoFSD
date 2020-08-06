package com.wellsfargo.fsd.ims.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {

	public static void main(String[] args) {
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imsDb","root","root")) {			
			//con.setAutoCommit(false);
			System.out.println("Connection Established!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
