package com.e_commerce_aplication.group_O;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {
	
	// User data required
	private String userName, password;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void doUserLogin() {
		try {
			// Load the JDBC driver 
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish a database connection 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "admin");

			// Define the SQL statement to check user login details
			String sql = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			// Use Scanner class for taking inputs from the user
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter Your Username: ");
			userName = sc.next();

			System.out.println("Enter Your Password: ");
			password = sc.next();

			// Check user login details
			ps.setString(1, getUserName());
			ps.setString(2, getPassword());

			// Execute the query
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				System.out.println("User Successfully Logged in.");
			} else {
				System.out.println("User Login failed.");
			}

			// Close the connection and prepared statement
			con.close();
			ps.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
