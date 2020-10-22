package com.wellsfargo.batch7.jdbcdemo.ui;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcDemo {
	public static void main(String a[]) {
		
		Scanner scan = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}

		try(Connection con = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/wb5","root","root")){
			System.out.println("Connection Opened!");
			
			DatabaseMetaData dbmd = con.getMetaData();
			
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getDriverVersion());
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseProductVersion());
		/*	
			String insQry = "INSERT INTO courses VALUES(?,?,?)";
			
			PreparedStatement psIns = con.prepareStatement(insQry);
						
			System.out.print("CourseId: ");
			psIns.setInt(1, scan.nextInt());
			System.out.print("Course Name:");
			psIns.setString(2,scan.next());
			System.out.print("Fee: ");
			psIns.setDouble(3, scan.nextDouble());
			
			int rows = psIns.executeUpdate();
			System.out.println(rows + "Record(s) are inserted!");*/
			
			PreparedStatement psSel = con.prepareStatement("SELECT * FROM courses");
			ResultSet rs =  psSel.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
