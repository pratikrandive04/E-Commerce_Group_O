package com.e_commerce_aplication.group_O;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

class AddProduct{
	
	 	private int productID;
	    private String productName;
	    private String description;
	    private double price;
	    private int quantityAvailable;
	
	    
	public int getProductID() {
			return productID;
		}

		public String getProductName() {
			return productName;
		}

		public String getDescription() {
			return description;
		}

		public double getPrice() {
			return price;
		}

		public int getQuantityAvailable() {
			return quantityAvailable;
		}


	public void doProductAddition() {
		try {
	        // Load the JDBC driver (replace with the appropriate driver for your database)
	        Class.forName("com.mysql.cj.jdbc.Driver");
	
	        // Establish a database connection (modify the URL, username, and password)
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "admin");
	
	        // Define the SQL statement to insert a new user
	        PreparedStatement ps = con.prepareStatement("INSERT INTO Products (ProductName, Description, Price, QuantityAvailable) " + "VALUES (?, ?, ?, ?)" );
	        
	        //use scanner class for taking inputs from the user
	        
	        Scanner sc = new Scanner(System.in);
	        
	        // input values for the new user ()
	        System.out.println("Enter The Product Name : ");
	        productName = sc.next();
	        
	        sc.nextLine();
	        
	        System.out.println("Enter The Description Of The Product : ");
	        description = sc.nextLine();
	        
	        System.out.println("Enter The Quantity Available : ");
	        quantityAvailable = sc.nextInt();
	        
	        System.out.println("Enter The Price  :");
	        price = sc.nextDouble();
	       
	        // Set the values for the new user ()
	        ps.setString(1, getProductName());
	        ps.setString(2, getDescription());
	        ps.setDouble(3, getPrice());
	        ps.setLong(4, getQuantityAvailable());
	
	        // Execute the insert statement
	        int i = ps.executeUpdate();
	
	        if (i > 0) {
	            System.out.println("New Product Added Successfully!!!!.");
	        } else {
	            System.out.println("Addition Of Product Failed!!!!");
	        }
	
	        // Close the connection and prepared statement
	        con.close();
	        ps.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}

