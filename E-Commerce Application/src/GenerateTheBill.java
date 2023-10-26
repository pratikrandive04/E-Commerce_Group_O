package com.e_commerce_aplication.group_O;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class GenerateTheBill {
	public static Map<Product, Integer> generateFullBillForUser(int userId) throws SQLException, ClassNotFoundException {
	    Map<Product, Integer> billDetails = new LinkedHashMap<>(); // Using a LinkedHashMap to maintain order
	    	
	    // Load the JDBC driver (replace with the appropriate driver for your database)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a database connection (modify the URL, username, and password)
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "admin");
	    
	    // Retrieve cart items for the user along with product details
	    String sql = "SELECT p.ProductID, p.ProductName, p.Description, p.Price, c.quantity " +
	                 "FROM cartitems c " +
	                 "JOIN products p ON c.productID = p.ProductID " +
	                 "WHERE c.userID = ?";
	    try (PreparedStatement statement = con.prepareStatement(sql)) {
	        statement.setInt(1, userId);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                int productId = resultSet.getInt("ProductID");
	                String productName = resultSet.getString("ProductName");
	                String description = resultSet.getString("Description");
	                double price = resultSet.getDouble("Price");
	                int quantity = resultSet.getInt("quantity");
	                
	                Product product = new Product(productId, productName, description, price);
	                billDetails.put(product, quantity);
	            }
	        }
	    }

	    return billDetails;
	}

}
