package FoodOrderingSystem;

import java.awt.*;
import java.util.List;

class OrderConstants {
    public static Integer MAX_NO_ORDERS = 0;
}
class MenuItem {
    String menuItemName;
    Double itemCost;
}
class Order {
    String customerName;
    String restaurantId;
    String restaurantName;
    List<MenuItem> foodItems;
    Double orderCost;
}

class Restaurant {
    String restaurantName;
    String restaurantId;
    String restaurantAddress;
    Double restaurantRating;
    Integer max_orders;
    List<MenuItem> menuDetails;
    public Restaurant(String restaurantName, String restaurantId, String restaurantAddress, Double restaurantRating, Integer max_orders) {
        this.restaurantName = restaurantName;
        this.restaurantId = restaurantId;
        this.restaurantAddress = restaurantAddress;
        this.restaurantRating = restaurantRating;
        this.max_orders = max_orders;
    }
//    void updateItem(MenuItem item, Double price, ) {
//
//    }
}
public class RestaurantFoodOrdering {

    void addNewRestaurant(String restaurantName, String restaurantId, String restaurantAddress, Double restaurantRating, Integer max_orders) {

    }

}
