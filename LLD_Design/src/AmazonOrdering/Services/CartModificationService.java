package AmazonOrdering.Services;

import java.util.HashMap;

class CartModificationService {
    //map which has all details of productId and the quantity of items in the checkout
    HashMap<String, Integer> checkOutOrder = new HashMap<>();

    void addItem(String productId, Integer quantity) {
        checkOutOrder.put(productId, quantity + checkOutOrder.getOrDefault(productId, 0));
    }

    //assuming we are not going below zero
    void delete(String productId, Integer quantity) {
        checkOutOrder.put(productId, checkOutOrder.getOrDefault(productId, 0) - quantity);
    }
}
