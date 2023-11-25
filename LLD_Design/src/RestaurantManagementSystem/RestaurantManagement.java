package RestaurantManagementSystem;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

enum ReservationStatus {
    RESERVED, EATING_AT_TABLE, AVAILABLE, CANCELLED;
}
enum OrderStatus {
    ORDERED, COOKING, EATING, CANCELLED;
}
enum MenuType {
    VEG, NON_VEG, CHINESE, DRINKS, DESSERTS;
}
enum PaymentStatus {
    PAID, PENDING, REFUNDED, IN_PROCESS, FAILED;
}
class Address {
    String street;
    String city;
    String state;
    String country;
    String pincode;
}
class Restaurant {
    String restaurantName;
    Address address;
    List<RestaurantBranch> branchList;
    void addRestaurantBranch(RestaurantBranch restaurantBranch) {

    }
}
class RestaurantBranch {
    String restaurantBranchID;
    Address address;
    Menu menu;
    List<Table> tables;
    void addTable(Table table) {

    }
}
class Menu {
    String restaurantBranchID;
    List<MenuItem> menuItems;
    MenuType menuType;
}
class MenuItem {
    String menuItemName;
    Double price;
}
class Meal {
    // maps a menu item ordered w.r.t the quantity
    HashMap<MenuItem, Integer> menuItem;
    Integer seatNumber;
    Integer tableNumber;
}
class Order {
    String orderID;
    String reservationNumber;
    Date orderDate;
    Integer tableNumber;
    OrderStatus orderStatus;
    List<Meal> meals;
}
class Table {
    String restuarantBranchName;
    Integer tableNumber;
    List<Seat> seats;
    Integer tableCapacity;
}
class Seat {
    Integer seatNumber;
    Integer tableNumber;
}
class Account {
    String accountId;
    String email;
    String accountName;
    String password;
    List<Reservation> getReservations() {
        //pull all reservations of this account
        return null;
    }
    ReservationStatus cancelReservation(String reservationId) {
        //cancel reservation logic goes here;
        return ReservationStatus.CANCELLED;
    }
}
class Receiptionist {

}
class Reservation {
    String reservationId;
    String reservationName;
    Timestamp reservationTime;
    ReservationStatus reservationStatus;
    String restaurantBranchId;
    Integer tableNumber;
    Integer peopleCount;
}
class Payment {
    String paymentId;
    String reservationID;
    PaymentStatus paymentStatus;
    Double totalBill;
    Date paymentDate;
}
class NotificationService {
    void generateNotification(String message) {

    }
}
class SMSNotification extends NotificationService {
    @Override
    void generateNotification(String message) {

    }
}
class EmailNotification extends NotificationService {
    @Override
    void generateNotification(String message) {

    }
}
class ReservationService {
    List<Reservation> reservationList;
    //returns the new reservation
    Reservation reserveTable(String restaurantId, Timestamp reservationTime, Integer peopleCount) {
        // check if the tables in the restaurant has available table for this reservation time and reserve that table
        Reservation reservation = new Reservation();
        this.reservationList.add(reservation);
        return reservation;
    }
}
interface SearchService {
    List<Reservation> reservationList = new ArrayList<>();
    HashMap<String, RestaurantBranch> restaurantBranchTables = new HashMap<>();
    List<Integer> getReservationsByDate(Timestamp timestamp, String restaurantId);
    List<Table> getAvailableTablesByDate(Timestamp timestamp, String restaurantId);
}
class Catalog {
    List<Reservation> reservationList = new ArrayList<>();
    HashMap<String, RestaurantBranch> restaurantBranchTables = new HashMap<>();
    List<Integer> getReservationsByDate(Timestamp timestamp, String restaurantId) {
        List<Integer> tablesList = new ArrayList<>();
        for(int i=0;i<reservationList.size(); i++) {
            if(reservationList.get(i).reservationTime==timestamp) {
                tablesList.add(reservationList.get(i).tableNumber);
            }
        }
        return tablesList;
    }
    List<Table> getAvailableTablesByDate(Timestamp timestamp, String restaurantId) {
        List<Table> tablesList = restaurantBranchTables.get(restaurantId).tables;
        List<Integer> reservationsByDate = getReservationsByDate(timestamp, restaurantId);
        List<Table> availableTables = new ArrayList<>();
        for(int i=0;i<tablesList.size();i++) {
            boolean flag = false;
            for(int j=0;j<reservationsByDate.size();j++) {
                if (reservationsByDate.get(i) == tablesList.get(i).tableNumber) {
                    flag=true;
                }
            }
            if(!flag) {
                availableTables.add(tablesList.get(i));
            }
        }
        return availableTables;
    }
}
public class RestaurantManagement {
}
