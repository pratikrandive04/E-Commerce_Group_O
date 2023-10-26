package com.e_commerce_aplication.group_O;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewCartFunction {

	    public static  List<CartItem> getCartItemsByUserId(int userId) {
	        List<CartItem> cartItems = new ArrayList<>();

	        try {
	        	// Load the JDBC driver (replace with the appropriate driver for your database)
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establish a database connection (modify the URL, username, and password)
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "admin");
	            
	            // Prepare an SQL statement to retrieve cart items by user ID
	            String sql = "SELECT c.productID, p.productName, p.description, c.quantity, p.price " +
	                         "FROM cartitems c " +
	                         "JOIN products p ON c.productID = p.productID " +
	                         "WHERE c.userID = ?";

	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setInt(1, userId);

	            ResultSet result = statement.executeQuery();

	            while (result.next()) {
	                int productId = result.getInt("productID");
	                String productName = result.getString("productName");
	                String description = result.getString("description");
	                int quantity = result.getInt("quantity");
	                double price = result.getDouble("price");

	                cartItems.add(new CartItem(productId, productName, description, quantity, price));
	            }

	            // Close the resources
	            statement.close();
	            result.close();
	            con.close();
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	        return cartItems;
	    }
}

