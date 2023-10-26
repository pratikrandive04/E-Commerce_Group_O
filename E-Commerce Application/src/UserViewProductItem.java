package com.e_commerce_aplication.group_O;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserViewProductItem{
public List<Product> viewProductsSortedById() {
    List<Product> products = new ArrayList<>();

    try {
        // Load the JDBC driver (replace with the appropriate driver for your database)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a database connection (modify the URL, username, and password)
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "admin");

        String query = "SELECT * FROM Products ORDER BY ProductID";
        
        PreparedStatement preparedStatement = con.prepareStatement(query);
        
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int productID = resultSet.getInt("ProductID");
            String productName = resultSet.getString("ProductName");
            String description = resultSet.getString("Description");
            double price = resultSet.getDouble("Price");
            int quantityAvailable = resultSet.getInt("QuantityAvailable");

            Product product = new Product(productID, productName, description, quantityAvailable, price);
            products.add(product);
        }

        resultSet.close();
        preparedStatement.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return products;
  }
}


