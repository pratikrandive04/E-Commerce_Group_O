package com.e_commerce_aplication.group_O;

class CartItem {
    private int productId;
    private int quantity;
	private String productName;
	private String description;
	private double price;

    public CartItem(int productId, String productName, String description, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Product ID: " + productId + "\n" +
               "Product Name: " + productName + "\n" +
               "Price: " + price + "\n" +
               "Quantity: " + quantity + "\n";
    }
    
    public CartItem(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

