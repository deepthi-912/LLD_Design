package AmazonOrdering;//Amazon Online Shopping System
//System Requirements
//        We will be designing a system with the following requirements:

//        Users should be able to add new products to sell.
//        Users should be able to search for products by their name or category.
//        Users can search and view all the products, but they will have to become a registered member to buy a product.
//        Users can add products to checkout and make payments
//        Users should be able to add/remove/modify product items in their shopping cart.
//        Users can check out and buy items in the shopping cart.
//        Users can rate and add a review for a product.
//        The user should be able to specify a shipping address where their order will be delivered.
//        Users can cancel an order if it has not shipped.
//        Users should get notifications whenever there is a change in the order or shipping status.
//        Users should be able to pay through credit cards or electronic bank transfer.
//        Users should be able to track their shipment to see the current state of their order.


import java.sql.Timestamp;
import java.util.*;

import static AmazonOrdering.NotificationService.generateNotification;

enum AccountStatus {
    ACTIVE, INACTIVE, BLOCKED
}

enum PaymentMode {
    CARD, ONLINE, CASH_ON_DELIVERY, PAYPAL
}
enum OrderStatus {
    ORDER_RECEIVED, SHIPPED, IN_TRANSIT, OUT_FOR_DELIVERY, DELIVERED, CANCELLED, FAILED;
}
enum PaymentStatus {
    PAID, PROCESSING, REFUNDED, PAYMENT_INITIATED, FAILED
}
class User {
    String userId;
    String password;
    AccountStatus status;
    Person person;
    Address address;
    Date accountCreationDate;
}

class Person {
    String personName;
    Address address;
    String email;
}

class Address {
    String streetName;
    String apartmentNum;
    String country;
    String zipCode;
    String state;
}

class Product {
    String productId;
    String ProductCategory;
    String productName;
    Double productPrice;
    String productDescription;

}

class Payment {
    String paymentId;
    Timestamp paymentDate;
    PaymentStatus paymentStatus;
    Product productId;
    Double totalCost;
    String checkOutId;
}

class Review {
    String userId;
    Product productId;
    Integer rating;
    String reviewDetails;
}

class OrderCheckOut {
    //map which has all details of productId and the quantity of items in the checkout
    HashMap<String, Integer> checkOutOrder = new HashMap<>();
    String userId;
    String checkOutId;
}

class Order {
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    String orderId;
    String paymentId;

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    OrderStatus orderStatus;
    String userId;
    Timestamp orderPlacedTime;
}

class Seller extends User {
    String userId;
   List<Product> productList = new ArrayList<>();
    public void addProduct(Product product) {
        this.productList.add(product);
    }
}

public class AmazonOnlineRetailSystem {

}

class SearchService {
    HashMap<String, List<Product>> searchByCategory = new HashMap<>();
    HashMap<String, List<Product>> searchByName = new HashMap<>();
    List<Product> getProductsByCategory(String productCategory) {
        return this.searchByCategory.get(productCategory);
    }

    List<Product> getProductsByName(String productName) {
        return this.searchByCategory.get(productName);
    }

}

class PaymentService {
    Payment makePayment(String checkOutId) {
        //calculateCost
        // generate a new receipt and update payment status
        //if payment is success/failed --->update the status and generate receipt
        return new Payment();
    }
}

class OrderService {
    HashMap<String, List<Order>> ordersListOfUser = new HashMap<>();
    OrderStatus trackOrder(String orderId, String userId) {
        List<Order> orderList = ordersListOfUser.get(userId);
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderId() == orderId) {
                return orderList.get(i).getOrderStatus();
            }
        }
        return OrderStatus.DELIVERED;
    }
    OrderStatus cancelOrder(String orderId, String userId) {
        List<Order> orderList = ordersListOfUser.get(userId);
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderId() == orderId) {
                orderList.get(i).setOrderStatus(OrderStatus.CANCELLED);
                orderList.remove(i);
            }
        }
        return OrderStatus.FAILED;
    }
    OrderStatus updateStatus(String orderId, OrderStatus status, String userId) {
        List<Order> orderList = ordersListOfUser.get(userId);
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderId() == orderId) {
                orderList.get(i).setOrderStatus(OrderStatus.OUT_FOR_DELIVERY);
                generateNotification(userId, orderId, status);
            }
        }
        return OrderStatus.FAILED;
    }
}

class CartModificationService {
    //map which has all details of productId and the quantity of items in the checkout
    HashMap<String, Integer> checkOutOrder = new HashMap<>();
    void addItem(String productId, Integer quantity) {
        checkOutOrder.put(productId, quantity + checkOutOrder.getOrDefault(productId, 0));
    }

    //assuming we are not going below zero
    void delete(String productId, Integer quantity) {
        checkOutOrder.put(productId, checkOutOrder.getOrDefault(productId, 0)-quantity);
    }
}

class NotificationService {
    static void generateNotification(String userId, String orderId, OrderStatus orderStatus) {
        // send notification to the user for the corresponding order status using email/ text message
    }
}
