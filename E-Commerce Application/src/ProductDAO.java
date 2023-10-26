package com.e_commerce_aplication.group_O;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    // ... (other methods)

    // Retrieve a product by its ID
    public Product getProductById(int productId) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM products WHERE productID = ?";
        Product product = null;

     // Load the JDBC driver (replace with the appropriate driver for your database)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a database connection (modify the URL, username, and password)
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "admin");
        
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, productId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("productID");
                    String name = resultSet.getString("productName");
                    String description = resultSet.getString("description");
                    double price = resultSet.getDouble("price");
                    int quantityAvailable = resultSet.getInt("quantityAvailable");

                   product = new Product(id, name, description, price, quantityAvailable);
                }
            }
        }

        return product;
    }
}


