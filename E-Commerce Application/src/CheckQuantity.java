package com.e_commerce_aplication.group_O;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckQuantity {

    public void checkProductQuantityById() {
        try {
            // Prompt the admin to enter the product ID
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the Product ID: ");
            int productId = scanner.nextInt();

            // Query the database to retrieve product information
            Product product = getProductById(productId);

            if (product != null) {
                // Display product name and quantity
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Available Quantity: " + product.getQuantityAvailable());
            } else {
                System.out.println("Product not found with the given ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve product details by ID from your database
    private Product getProductById(int productId) throws ClassNotFoundException, SQLException {
    	// Load the JDBC driver (replace with the appropriate driver for your database)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a database connection (modify the URL, username, and password)
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "admin");
        // This is a simplified example assuming you have a ProductDAO class

        ProductDAO productDAO = new ProductDAO(); // Create a ProductDAO instance

        try {
            // Query the database to get product details by ID
            Product product = productDAO.getProductById(productId);

            return product; // Return the product details
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // Return null if the product is not found
    }
}

