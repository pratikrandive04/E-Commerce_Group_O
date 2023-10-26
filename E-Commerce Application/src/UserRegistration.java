package com.e_commerce_aplication.group_O;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserRegistration {
	
		public void doUserRegistration() {
			try {
	            // Load the JDBC driver (replace with the appropriate driver for your database)
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establish a database connection (modify the URL, username, and password)
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "admin");

	            // Define the SQL statement to insert a new user
	            PreparedStatement ps = con.prepareStatement("INSERT INTO Users (FirstName, LastName, Username, Password, City, Email, MobileNumber, UserRole) " +
	                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	            
	            //user data required
	            
	            String firstname,lastName,userName,password,city,email,userRole,Mobilenumber;
	            
	            //use scanner class for taking inputs from the user
	            
	            Scanner sc = new Scanner(System.in);
	            
	            // input values for the new user ()
	            System.out.println("Enter The First Name : ");
	            firstname = sc.next();
	            System.out.println("Enter The Last Name : ");
	            lastName = sc.next();
	            System.out.println("Enter The Username : ");
	            userName = sc.next();
	            System.out.println("Choose A Password :");
	            password = sc.next();
	            System.out.println("Enter Your City : ");
	            city = sc.next();
	            System.out.println("Enter Your Mail Id :");
	            email = sc.next();
	            System.out.println("Enter Your Mobile Number");
	            Mobilenumber = sc.next();
	           
	            // Set the values for the new user ()
	            ps.setString(1, firstname);
	            ps.setString(2, lastName);
	            ps.setString(3, userName);
	            ps.setString(4, password);
	            ps.setString(5, city);
	            ps.setString(6, email);
	            ps.setString(7, Mobilenumber);
	            ps.setString(8, "User"); // Set the appropriate user role

	            // Execute the insert statement
	            int i = ps.executeUpdate();

	            if (i > 0) {
	                System.out.println("New user created successfully.");
	            } else {
	                System.out.println("User creation failed.");
	            }

	            // Close the connection and prepared statement
	            con.close();
	            ps.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
}
