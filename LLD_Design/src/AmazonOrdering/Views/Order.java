package AmazonOrdering.Views;

import AmazonOrdering.Views.OrderStatus;

import java.sql.Timestamp;

public class Order {
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
