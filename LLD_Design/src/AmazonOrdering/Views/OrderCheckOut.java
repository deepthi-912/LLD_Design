package AmazonOrdering.Views;

import java.util.HashMap;

class OrderCheckOut {
    //map which has all details of productId and the quantity of items in the checkout
    HashMap<String, Integer> checkOutOrder = new HashMap<>();
    String userId;
    String checkOutId;
}
