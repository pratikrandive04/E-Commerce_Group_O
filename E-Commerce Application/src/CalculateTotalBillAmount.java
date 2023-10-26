package com.e_commerce_aplication.group_O;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateTotalBillAmount {
	public static double calculateTotalBill(int userId) throws SQLException, ClassNotFoundException {
	    double totalBill = 0;
	    
	 // Load the JDBC driver (replace with the appropriate driver for your database)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a database connection (modify the URL, username, and password)
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "admin");
	    
	    // Retrieve cart items for the user
	    String sql = "SELECT p.Price * c.quantity AS itemTotal FROM cartitems c " +
	                 "JOIN products p ON c.productID = p.ProductID " +
	                 "WHERE c.userID = ?";
	    try (PreparedStatement statement = con.prepareStatement(sql)) {
	        statement.setInt(1, userId);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                totalBill += resultSet.getDouble("itemTotal");
	            }
	        }
	    }

	    return totalBill;
	}

}
