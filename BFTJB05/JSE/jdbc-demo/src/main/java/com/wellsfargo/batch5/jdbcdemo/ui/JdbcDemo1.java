package com.wellsfargo.batch5.jdbcdemo.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;

public class JdbcDemo1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException exception) {
			System.out.println("Driver not loaded!");
			System.exit(0);
		}		
		
		try(Connection con = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/wb7", "root", "root")){
			System.out.println("Connected!");
			
			DatabaseMetaData dbmd = con.getMetaData();
			
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getDriverVersion());
					
			
			PreparedStatement pt = con.prepareStatement("INSERT INTO categories values(?,?,?)");

			System.out.println("Cat Id: ");
			pt.setInt(1,scan.nextInt());
			System.out.println("Cat Name: ");
			pt.setString(2, scan.next());
			System.out.println("Cat GST: ");
			pt.setDouble(3, scan.nextDouble());
			
			int rowsEffected = pt.executeUpdate();
			
			System.out.println(rowsEffected + " records inserted!" );
						
			PreparedStatement pt2 = con.prepareStatement("SELECT * FROM categories");
			ResultSet rs = pt2.executeQuery();
			while(rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3)
						);
			}
		}catch(SQLException exception) {
			System.out.println(exception.getMessage());
		}
	}

}
