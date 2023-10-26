package com.e_commerce_aplication.group_O;

public class Product {
    private int productID;
    private String productName;
    private String description;
    private int quantityAvailable;
    private double price;
	private int id;
	private String name;

    public Product(int productID, String productName, String description, int quantityAvailable, double price) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
    }

    public Product(int productId, String productName, String description, double price) {
        this.productID = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }
    
    public Product(int id, String name, String description, double price, int quantityAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }
    
    // Getter methods for the fields

    // Override the toString() method to format the product information
    @Override
    public String toString() {
        return "Product Id: " + productID + "\n" +
               "Product Name: " + productName + "\n" +
               "Product Description: " + description + "\n" +
               "Available Quantity: " + quantityAvailable + "\n" +
               "Price: " + price;
    }

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
    
}


