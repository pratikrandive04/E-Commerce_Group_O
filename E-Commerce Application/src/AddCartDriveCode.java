package com.e_commerce_aplication.group_O;

import java.util.Scanner;

public class AddCartDriveCode {
		public void addToCart() {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Your ID : ");
			int userId = sc.nextInt();
		    // Add to Cart
		    Cart userCart = new Cart(userId); // Initialize a user's cart
		    // Prompt the user for product ID and quantity and add to the cart
		    System.out.println("Enter Product ID : ");
		    int productId = sc.nextInt();
		    System.out.println("Enter The Quantity : ");
		    int quantity = sc.nextInt();
		    userCart.addProduct(productId, quantity);

		    // Use CartDatabase to store the cart in the database and update product quantities
		    CartDatabase cartDatabase = new CartDatabase();
		    try {
		        cartDatabase.storeCartInDatabase(userId, userCart.getCartItems());
		        // Inform the user that the product has been added to the cart
		        System.out.println("Product added to cart.");
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    }
		}
}
