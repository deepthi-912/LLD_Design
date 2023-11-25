package HotelManagementSystem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
//The system should support the booking of different room types like standard, deluxe, family suite, etc.
//        Guests should be able to search the room inventory and book any available room.
//        The system should be able to retrieve information, such as who booked a particular room, or what rooms were booked by a specific customer.
//        The system should allow customers to cancel their booking - and provide them with a full refund if the cancelation occurs before 24 hours of the check-in date.
//        The system should be able to send notifications whenever the booking is nearing the check-in or check-out date.
//        The system should maintain a room housekeeping log to keep track of all housekeeping tasks.
//        Any customer should be able to add room services and food items.
//        Customers can ask for different amenities.
//        The customers should be able to pay their bills through credit card, check or cash.

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
enum RoomServiceType {
    HOUSEKEEPING, LAUNDRY, FOOD_SERVICE;
}
enum WorkerType {
    HOUSEKEEPER, RECEPTIONIST, CHEF, MANAGER;
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
    Double roomPrice;
    void checkOutRoom() {
        // make the room
    }
    void checkIn() {

    }
}
class Hotel {
    String hotelId;
    String hotelName;
    Address address;
    void addRoom(Room room) {

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
    String hotelId;
    void addEminity() {

    }

}
class Eminity {

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
class Receiptionist {
    Account account;
    String hotelId;
    Booking createReservation() {
        return null;
    }
}
class Housekeeper {
    Account account;
    String hotelId;
    void assignHouseKeepingService(String roomNumber, Timestamp timestamp, RoomServiceType roomServiceType) {

    }
}
class RoomServiceLog {
    RoomServiceType roomServiceType;
    String workerId;
    Timestamp timestamp;
    String roomNumber;
    String hotelId;
}

class BookingManagementService {
    Booking bookRoom(Date checkInTime, Customer customer, String roomNumber, Integer numOfRooms) {
        // checks for the available rooms from roomType instance
        // if available, book one Room from the same and return the booking
        return null;
    }
    BookingStatus cancelBooking(Booking booking) {
        return BookingStatus.CANCELLED;
    }
    BookingStatus modifyBooking(Booking booking) {
        return BookingStatus.CANCELLED;
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
}
