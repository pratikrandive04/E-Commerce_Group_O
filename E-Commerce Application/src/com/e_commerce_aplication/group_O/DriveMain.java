package com.e_commerce_aplication.group_O;

import java.util.Scanner;

public class DriveMain {
	
	public void userMenuDisplay() {
		
		//for user operations
		System.out.println("User Operations : ");
		System.out.println("    1. New User Registration");
		System.out.println("    2. User Login");
		System.out.println("    3. User View Product Item As Sorted Order");
		System.out.println("    4. Buy Product");
		System.out.println("    5. View Cart");
		System.out.println("    6. Purchase The Item");
		System.out.println();
		
		//admin operations
		System.out.println("Admin Operations : ");
		System.out.println("    7. Add Product");
		System.out.println("    8. Calculate Bill");
		System.out.println("    9. Display Ammount To End User");
		System.out.println("   10. Check Quantity");
		System.out.println("   11. Check Registered Users");
		System.out.println("   12. Check The Particular User History");
		System.out.println();
		
		// guest operations
		System.out.println("Guest Operations :");
		System.out.println("   13. View Product Items");
		System.out.println("   14. Not Purchase Item");
		System.out.println();
	}
	
	
	//function for performing operations 
	public static void performOperations() {
		int a;
		Scanner sc = new Scanner(System.in);					// scanner class for taking input from user
		System.out.print("Enter Your Choice : ");
		a = sc.nextInt();
		System.out.println();
		
			switch (a) {			// switch case for performing operations according to the choice entered by user 
			case 1:
				UserRegistration u1 = new UserRegistration();
		        try {
		          u1.doUserRegistration();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
				break;
				
			default :
				System.out.println("Invalid Choice");
			}	
		}
	
	public static void main(String[] args) {
		
		DriveMain dm = new DriveMain();
		
		dm.userMenuDisplay();
		dm.performOperations();
		
	}
}
