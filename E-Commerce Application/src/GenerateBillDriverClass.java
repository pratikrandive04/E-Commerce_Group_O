package com.e_commerce_aplication.group_O;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class GenerateBillDriverClass {
		public void generateUserBill() throws ClassNotFoundException {
			
			Scanner sc = new Scanner(System.in);
			
		    // Calculate Bill (Admin)
		    System.out.print("Enter the UserID for whom you want to generate the bill: ");
		    int targetUserId = sc.nextInt(); // Assuming you have a Scanner object named 'sc'

		    try {
		        Map<Product, Integer> billDetails = GenerateTheBill.generateFullBillForUser(targetUserId);
		        
		        double fullBill = 0;
		        System.out.println("Bill for User ID " + targetUserId + ":");
		        for (Map.Entry<Product, Integer> entry : billDetails.entrySet()) {
		            Product product = entry.getKey();
		            int quantity = entry.getValue();
		            double itemTotal = product.getPrice() * quantity;
		            
		            System.out.println("Product ID: " + product.getProductID());
		            System.out.println("Product Name: " + product.getProductName());
		            System.out.println("Description: " + product.getDescription());
		            System.out.println("Price: $" + product.getPrice());
		            System.out.println("Quantity: " + quantity);
		            System.out.println("Total Amount: $" + itemTotal);
		            System.out.println();
		            
		            fullBill += itemTotal;
		        }
		        
		        System.out.println("Full Bill Amount: $" + fullBill);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		}
}
