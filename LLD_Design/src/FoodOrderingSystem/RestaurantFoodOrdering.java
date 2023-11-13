package FoodOrderingSystem;

import java.util.*;

enum OrderStatus {
    ACCEPTED, COMPLETED, NOT_AVAILABLE, ORDER_PLACED;
}
enum PaymentStatus {
    PAID, PROCESSING, REFUNDED, PAYMENT_INITIATED, FAILED;
}

class Order {
    Integer orderId;
    String customerName;
    String restaurantName;
    Double orderAmount;
    HashMap<String, Integer> orderItems;
    PaymentStatus paymentStatus;
    OrderStatus orderStatus;

    public Order(Integer orderId, String customerName, String restaurantName, Double orderAmount, HashMap<String, Integer> orderItems, PaymentStatus paymentStatus, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.restaurantName = restaurantName;
        this.orderAmount = orderAmount;
        this.orderItems = orderItems;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public HashMap<String, Integer> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(HashMap<String, Integer> orderItems) {
        this.orderItems = orderItems;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
class MenuItem {
    String itemName;
    Double cost;
    String restaurantName;

    public MenuItem(String itemName, Double cost) {
        this.itemName = itemName;
        this.cost = cost;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

}
class Restaurant {
    String restaurantId;
    String restaurantName;
    String restaurantAddress;
    HashMap<String, Double> menuItemPriceMap;
    Double rating;

    public Integer getCurrentOrderNumber() {
        return currentOrderNumber;
    }

    public void setCurrentOrderNumber(Integer currentOrderNumber) {
        this.currentOrderNumber = currentOrderNumber;
    }

    Integer currentOrderNumber;
    Integer maxOrderNumber;

    public Restaurant(String restaurantId, String restaurantName, String restaurantAddress, HashMap<String, Double> menuItems, Double rating, Integer maxOrderNumber) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.menuItemPriceMap = menuItems;
        this.rating = rating;
        this.maxOrderNumber = maxOrderNumber;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public HashMap<String, Double> getMenuItems() {
        return menuItemPriceMap;
    }

    public void setMenuItems(HashMap<String, Double> menuItems) {
        this.menuItemPriceMap = menuItems;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getMaxOrderNumber() {
        return maxOrderNumber;
    }

    public void setMaxOrderNumber(Integer maxOrderNumber) {
        this.maxOrderNumber = maxOrderNumber;
    }
}
class Customer {
    String customerId;
    String customerName;
    String email;
    String phoneNum;
    String address;
}
public class RestaurantFoodOrdering {

    //restaurant map of restaurant id with respect to the restaurant details
    HashMap<String, Restaurant> restaurantHashMap = new HashMap<>();
    Integer orderId = 1;
    //map of orders with the respective orderid generated
    HashMap<String, Order> orderHashMap = new HashMap<>();

    void addNewRestaurant(String restaurantId, String restaurantName, String restaurantAddress, HashMap<String, Double> menuItems, Double rating, Integer maxOrderNumber) {
        Restaurant restaurant = new Restaurant(restaurantId, restaurantName, restaurantAddress, menuItems,  rating,  maxOrderNumber);
        restaurantHashMap.put(restaurantId, restaurant);
    }

    void updateOrAddRestaurantMenuItem(String restaurantId, String menuItem, Double price) {
        HashMap<String, Double> menuItems = restaurantHashMap.get(restaurantId).getMenuItems();
        boolean flag = false;
        menuItems.put(menuItem, price);
    }

    void updateOrderStatus(String orderId, OrderStatus orderStatus) {
        orderHashMap.get(orderId).setOrderStatus(orderStatus);
    }

    void createNewOrder(HashMap<String, Integer> orderList, String userId, String restaurantId) {
        Order order = new Order(orderId, userId, restaurantId,  0.0, orderList, PaymentStatus.PAID, OrderStatus.ORDER_PLACED);
        orderId++;
        pickAndUpdateRestaurant(orderList, userId, orderId);
    }

    void pickAndUpdateRestaurant(HashMap<String, Integer> orderList, String userId, Integer orderId) {
        HashMap<String, Double> orderTotalMapList = new HashMap<>();
        for(Map.Entry<String, Restaurant> restaurantEntry : restaurantHashMap.entrySet()) {
            Double billAmount = 0.0;
            for(Map.Entry<String, Integer> order : orderList.entrySet()) {
                if(!restaurantEntry.getValue().getMenuItems().containsKey(order.getKey())) {
                    billAmount = 0.0;
                    break;
                } else {
                    billAmount += restaurantEntry.getValue().getMenuItems().get(order.getKey());
                }
            }
            orderTotalMapList.put(restaurantEntry.getValue().getRestaurantId(), billAmount);
        }
        String restaurantId = reArrangeAndRankRestaurants(orderTotalMapList);
        updateRestaurantOrder(orderList, restaurantId, userId, orderId);
    }

    String reArrangeAndRankRestaurants(HashMap<String, Double> orderTotalMapList) {
        Comparator<String> valueComparator = (k1, k2) -> orderTotalMapList.get(k1).compareTo(orderTotalMapList.get(k2));

        // Create a TreeMap with the custom comparator
        Map<String, Double> sortedMap = new TreeMap<>(valueComparator);

        // Put all elements from the unsorted map to the sorted map
        sortedMap.putAll(orderTotalMapList);
        Map.Entry<String, Double> topEntry = sortedMap.entrySet().iterator().next();
        return topEntry.getKey();
    }
    void updateRestaurantOrder(HashMap<String, Integer> orderList, String restaurantId, String userId, Integer orderId) {
        Integer orders = restaurantHashMap.get(restaurantId).getCurrentOrderNumber();
        restaurantHashMap.get(restaurantId).setCurrentOrderNumber(orders+1);
        orderHashMap.get(orderId).setOrderStatus(OrderStatus.ACCEPTED);
    }

}
