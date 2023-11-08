package AmazonOrdering.Services;

import AmazonOrdering.Views.Order;

import AmazonOrdering.Views.OrderStatus;

import java.util.HashMap;
import java.util.List;

import static AmazonOrdering.Services.NotificationService.generateNotification;

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
                generateNotification(userId, orderId, OrderStatus.CANCELLED);
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
