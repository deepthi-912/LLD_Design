package AmazonOnlineOrdering;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum AccountStatus {
    ACTIVE, CLOSED, DISABLED;
}
enum OrderStatus {
    ORDERED, SHIPPED, DELIVERED, IN_TRANSIT, OUT_FOR_DELIVERY, CANCELLED;
}
enum PaymentStatus {
    PAID, PENDING, FAILED, REFUNDED, IN_PROCESS;
}
enum PaymentType {
    CASH, CREDIT, DEBIT;
}
class Person {
    String name;
    String email;
    String phoneNumber;
}
class Address {
    String street;
    String city;
    String country;
    String state;
    String pincode;
}
class Account {
    Person person;
    Address address;
    String password;
}
class Customer {
    Account accountId;
    AccountStatus accountStatus;
}
class Admin {
    Account account;
    void addProduct(Product productId) {

    }
    void deleteProduct(Product productId) {

    }
}
class Product {
    String productId;
    String productCategory;
    String productName;
    Double productPrice;
    Integer availableItems;

}
class Review {
    String userId;
    String reviewId;
    String reviewText;
    Timestamp reviewTime;
    String productId;
    Double rating;
}
class OrderLog {
    String orderNumber;
    OrderStatus status;
    LocalTime orderChangeDate;
}
class Order {
    String orderId;
    Account userId;
    LocalDate orderTime;
    HashMap<Product, Integer> productsList;
    List<OrderLog> orderLogs;
    Address address;
    PaymentStatus paymentStatus;
    public Order(String orderId, Account userId, LocalDate orderTime, HashMap<Product, Integer> productsList, List<OrderLog> orderLogs, Address address, PaymentStatus paymentStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderTime = orderTime;
        this.productsList = productsList;
        this.orderLogs = new ArrayList<>();
        this.address = address;
        this.paymentStatus = paymentStatus;
    }
}
class ShoppingCart {
    HashMap<Product, Integer> productList;
    String shoppingCartId;
    String userId;
    Address address;
    void addProductToCart(Product productId, Integer quantity) {
        this.productList.put(productId, quantity);
    }
    void removeProductFromCart(Product productId, Integer quantity) {
        if(this.productList.containsKey(productId)) {
            this.productList.put(productId, this.productList.getOrDefault(productId, 0)-quantity);
        }
    }
}
class Payment {
    String paymentId;
    String shoppingCartId;
    LocalDate paymentDate;
    PaymentStatus paymentStatus;
    Double paymentPrice;
    PaymentType paymentType;

    public Payment(String shoppingCartId, LocalDate paymentDate, Double paymentPrice, PaymentType paymentType) {
        this.shoppingCartId = shoppingCartId;
        this.paymentDate = paymentDate;
        this.paymentPrice = paymentPrice;
        this.paymentType = paymentType;
    }
}
class NotificationService {
    static void sendNotification() {

    }
}
class OrderService {
    Order orderProduct(ShoppingCart shoppingCart, Customer customer, PaymentType paymentType) throws IllegalAccessException {
        if(customer.accountStatus == AccountStatus.ACTIVE) {
            Double totalPrice = 0.0;
            for(Map.Entry<Product, Integer> entry : shoppingCart.productList.entrySet()) {
                totalPrice+= entry.getKey().productPrice;
            }
            PaymentService payment = new PaymentService();
            PaymentStatus status = payment.makePayment(shoppingCart.shoppingCartId, totalPrice, paymentType);
            if(status.equals(PaymentStatus.PAID)) {
                Order order = new Order("ABC", customer.accountId, LocalDate.now(), shoppingCart.productList, new ArrayList<>(new OrderLog("ABC")),  shoppingCart.address,  status);
                NotificationService.sendNotification();
                return order;
            }
            return null;
        } else {
            throw new IllegalAccessException("User not found");
        }
    }
    OrderStatus cancelOrder(Order order, Customer customer) throws IllegalAccessException {
        if(customer.accountStatus == AccountStatus.ACTIVE && order.status == OrderStatus.ORDERED) {
            PaymentService.refundPayment(order);
            //refund for the payment and update the payment status
            order.status = OrderStatus.CANCELLED;
            NotificationService.sendNotification();
            return order.status;
        } else {
            throw new IllegalAccessException("User not found");
        }
    }
}
class PaymentService {
    static PaymentStatus makePayment(String shoppingCartId, Double paymentPrice, PaymentType paymentType) {
        Payment payment = new Payment(shoppingCartId, LocalDate.now(), paymentPrice, paymentType);
        //payment logic with third party goes here!
        return PaymentStatus.PAID;
    }
    static PaymentStatus refundPayment(Order order) {
        //payment logic with third party goes here!
        order.paymentStatus = PaymentStatus.REFUNDED;
        return PaymentStatus.REFUNDED;
    }
}
class SMSNotification extends NotificationService {

}
class EmailNotification extends NotificationService {

}
class SearchService {
    HashMap<String, Product> productHashMap = new HashMap<>();
    List<Product> getProductsByName(String name) {
        List<Product> productsList = new ArrayList<>();
        for(Map.Entry<String, Product> entry : productHashMap.entrySet()) {
            if(entry.getValue().productName.equals(name)) {
                productsList.add(entry.getValue());
            }
        }
        return productsList;
    }
    List<Product> getProductsByCategory(String category) {
        List<Product> productsList = new ArrayList<>();
        for(Map.Entry<String, Product> entry : productHashMap.entrySet()) {
            if(entry.getValue().productCategory.equals(category)) {
                productsList.add(entry.getValue());
            }
        }
        return productsList;
    }
}

public class AmazonOnline {
}
