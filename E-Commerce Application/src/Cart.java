package com.e_commerce_aplication.group_O;

import java.util.ArrayList;
import java.util.List;

class Cart {
    private int userId;
    private List<CartItem> items;

    public Cart(int userId) {
        this.userId = userId;
        items = new ArrayList<>();
    }

    public void addProduct(int productId, int quantity) {
        for (CartItem item : items) {
            if (item.getProductId() == productId) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        CartItem newItem = new CartItem(productId, quantity);
        items.add(newItem);
    }

    public List<CartItem> getCartItems() {
        return items;
    }
}


