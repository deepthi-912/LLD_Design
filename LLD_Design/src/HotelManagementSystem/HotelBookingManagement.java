package HotelManagementSystem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

enum RoomType {
    DELUXE, FAMILY_SUITE, STANDARD, PRESIDENT;
}
enum BookingStatus {
    BOOKED, CANCELLED, PENDING, CHECKED_IN;
}
enum PaymentStatus {
    PAID, NOT_PAID, PROCESSING, REQUESTED, REFUNDED
}
enum AccountStatus {
    ACTIVE, CLOSED, BLACKLISTED, BLOCKED;
}
enum RoomStatus {
    AVAILABLE, BOOKED, CLEANING, CHECKED_IN, UN_AVAILABLE;
}
class Address {
    String street;
    String city;
    String state;
    String country;
    String pincode;
}
class Room {
    RoomType roomType;
    String hotelId;
    String roomNumber;
    Integer floorNumber;
    RoomStatus roomStatus;
}
class RoomTypeInstance {
    RoomType roomType;
    Integer capacity;
    String hotelId;
    Double price;
    Integer availableRooms;
}
class Hotel {
    String hotelId;
    String hotelName;
    Address address;
    void addRoom(Room room) {

    }
    void checkOutRoom(Room room) {
        // make the room
    }
    void checkIn(Room room) {

    }
}
class Booking {
    String accountId;
    String bookingId;
    String bookingName;
    Date bookingDate;
    Date roomCheckInDate;
    Date checkOutDate;
    String roomNumber;
    HashMap<RoomType, Integer> bookingsMap;
    String hotelId;
}
class Payment {
    String paymentId;
    Date paymentDate;
    String bookingId;
    Double totalAmount;
    PaymentStatus paymentStatus;
}
interface PaymentService {
    void processPayment(Payment payment);
}
class CreditCardPayment implements PaymentService {
    @Override
    public void processPayment(Payment payment) {

    }
}
class CashPayment implements PaymentService {
    @Override
    public void processPayment(Payment payment) {

    }
}
class Account {
    String accountId;
    String name;
    String email;
    String phoneNumber;
    String password;
    Address address;
    AccountStatus status;
}
class Customer {
    Account account;
    void getReservationsByAccount() {

    }
}
class HouseKeeping {

}
class CleaningService extends  HouseKeeping {
    Timestamp cleaningTime;
    String roomNumber;
    String hotelId;
}
class LaundryService extends  HouseKeeping {
    Timestamp laundryTime;
    String roomNumber;
    String hotelId;
}
class FoodService extends  HouseKeeping {
    Timestamp orderTime;
    String roomNumber;
    String hotelId;
}
class BookingManagementService {
    HashMap<RoomType, RoomTypeInstance> roomTypeRoomTypeInstanceHashMap = new HashMap<>();
    Booking bookRoom(Date checkInTime, Customer customer, RoomType roomType, Integer numOfRooms) {
        // checks for the available rooms from roomType instance
        // if available, book one Room from the same and return the booking
        if(roomTypeRoomTypeInstanceHashMap.get(roomType).availableRooms>=numOfRooms) {
            roomTypeRoomTypeInstanceHashMap.get(roomType).availableRooms -= numOfRooms;
        }

        return null;
    }
}
class SearchService {
    List<Room> getRoomBookingByCustomer(Customer customer) {
        return null;
    }
    Customer getReservationDetailsByRoom(Room room) {
        return null;
    }
}
public class HotelBookingManagement {
    List<CleaningService> cleaningServiceList = new ArrayList<>();
}
