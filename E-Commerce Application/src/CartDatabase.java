package com.e_commerce_aplication.group_O;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CartDatabase {

    public void storeCartInDatabase(int userId, List<CartItem> cartItems) throws ClassNotFoundException {
        try {
        	
        	// Load the JDBC driver (replace with the appropriate driver for your database)
	        Class.forName("com.mysql.cj.jdbc.Driver");
	
	        // Establish a database connection (modify the URL, username, and password)
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "admin");
        			
            // Prepare SQL statements to insert cart items into the database
            String insertCartItemSQL = "INSERT INTO cartitems (userID, productID, quantity) VALUES (?, ?, ?)";
            String updateProductQuantitySQL = "UPDATE products SET QuantityAvailable = QuantityAvailable - ? WHERE productID = ?";

            PreparedStatement insertCartItemStatement = con.prepareStatement(insertCartItemSQL);
            PreparedStatement updateProductQuantityStatement = con.prepareStatement(updateProductQuantitySQL);

            for (CartItem cartItem : cartItems) {
                int productId = cartItem.getProductId();
                int quantity = cartItem.getQuantity();

                // Insert cart item into the cartitems table
                insertCartItemStatement.setInt(1, userId);
                insertCartItemStatement.setInt(2, productId);
                insertCartItemStatement.setInt(3, quantity);
                insertCartItemStatement.executeUpdate();

                // Update product quantity in the products table
                updateProductQuantityStatement.setInt(1, quantity);
                updateProductQuantityStatement.setInt(2, productId);
                updateProductQuantityStatement.executeUpdate();
            }

            // Commit the transaction
            con.commit();

            // Close prepared statements
            insertCartItemStatement.close();
            updateProductQuantityStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
