package com.e_commerce_aplication.group_O;

import java.util.List;
import java.util.Scanner;

public class ViewCartDriverFunction {
		public void viewMyCartItems() {
			
			Scanner sc = new Scanner(System.in);
			
			// View Cart
		    System.out.print("Enter your UserID: ");
		    int userId = sc.nextInt(); // Assuming you have a Scanner object named 'sc'

		    // Retrieve and display the user's cart items
		    List<CartItem> cartItems = ViewCartFunction.getCartItemsByUserId(userId);
		    if (cartItems.isEmpty()) {
		        System.out.println("Your cart is empty.");
		    } else {
		        System.out.println("Products in your cart:");
		        for (CartItem cartItem : cartItems) {
		            System.out.println(cartItem);
		        }
		    }
		}
}
