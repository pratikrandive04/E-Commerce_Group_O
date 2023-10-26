package com.e_commerce_aplication.group_O;

import java.sql.SQLException;
import java.util.List;
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
	public static void performOperations() throws ClassNotFoundException {
		int a;
		Scanner sc = new Scanner(System.in);					// scanner class for taking input from user
		System.out.print("Enter Your Choice : ");
		a = sc.nextInt();
		System.out.println();
		
			switch (a) {			// switch case for performing operations according to the choice entered by user 
			case 1:
				UserRegistration ur = new UserRegistration();
		         ur.doUserRegistration();
				break;
			case 2:
				UserLogin ul = new UserLogin();
				ul.doUserLogin();
				break;
			case 3:
				UserViewProductItem up = new UserViewProductItem();
				List<Product> sortedProducts = up.viewProductsSortedById();

		        // Display the sorted products
		        for (Product product : sortedProducts) {
		            System.out.println(product);
		            System.out.println(); // Add an empty line for separation
		        }
				break;
			case 4:
				AddCartDriveCode ACDC = new AddCartDriveCode();
				ACDC.addToCart();
			    break;
			case 5:
				ViewCartDriverFunction vcdf = new ViewCartDriverFunction();
				vcdf.viewMyCartItems();
				break;
			case 6:
			    // Purchase the Item
			    System.out.print("Enter your UserID: ");
			    int userId = sc.nextInt(); // Assuming you have a Scanner object named 'sc'

			    try {
			        double totalBill = CalculateTotalBillAmount.calculateTotalBill(userId);
			        System.out.println("Total Bill Amount: $" + totalBill);
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			    break;

			case 7:
				AddProduct ap = new AddProduct();
				ap.doProductAddition();
				break;
			case 8:
				GenerateBillDriverClass g1 = new GenerateBillDriverClass();
				g1.generateUserBill();
				break;
			case 9:
			    // Purchase the Item
			    System.out.print("Enter your UserID: ");
			    int userId1 = sc.nextInt(); // Assuming you have a Scanner object named 'sc'

			    try {
			        double totalBill = CalculateTotalBillAmount.calculateTotalBill(userId1);
			        System.out.println("Total Amount To Be Paid : $" + totalBill);
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			    break;
			    case 10:
			    	CheckQuantity c1 = new CheckQuantity();
			    	c1.checkProductQuantityById();
			    	break;
			default :
				System.out.println("Invalid Choice");
			}	
		}
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		DriveMain dm = new DriveMain();
		
		dm.userMenuDisplay();
		dm.performOperations();
		
	}
}
