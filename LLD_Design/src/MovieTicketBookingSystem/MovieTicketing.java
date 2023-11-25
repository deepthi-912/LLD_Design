package MovieTicketBookingSystem;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

enum BookingStatus {
    BOOKED, CANCELLED, PENDING, FAILED, REFUNDED;
}
enum SeatReservationStatus {
    BOOKED, RESERVED, BLOCKED, UNAVAILABLE;
}
enum SeatType {
    RECLINER, CORNER, MIDDLE, FRONT, VIP;
}
enum GENRE {
    THRILLER, SCI_FI, FICTION, ROM_COM, COMEDY, DRAMA;
}
enum PaymentStatus {
    PAID, PENDING, PROCESSING, FAILED, REQUESTED;
}
enum PaymentType {
    CREDIT, DEBIT, CASH, PAYPAL, APPLEPAY;
}
class Cinema {
    String title;
    String cinemaID;
    GENRE genre;
    Date releaseDate;
    String language;
}
class MovieHall {
    String movieHallId;
    Address address;
    String cinemaId;
}
class Address {
    String street;
    String apartment;
    String country;
    String state;
    String cityName;
    String pincode;
}
class ShowTime {
    LocalTime showStartTime;
    LocalTime showEndTime;
    String movieHallId;
    List<Seat> seatsList;
}
class Account {
    Person person;
    String accountId;
    String password;
    void updatePassword() {

    }
}
class Person {
    String personName;
    String email;
    String phoneNumber;
    Address address;
}
class Customer {
    Account accountId;
}
class Admin {
    Account accountId;
    void addMovie(Cinema cinema) {

    }
    void addMovieHall(MovieHall hallId) {

    }
}
class Seat {
    String seatNumber;
    SeatType seatType;
    String MovieHallId;
}
class SeatDetails {
    String seatNumber;
    Double price;
    ShowTime showTime;
    SeatReservationStatus reservationStatus;
    String movieHallId;
}
class Booking {
    String bookingId;
    BookingStatus bookingStatus;
    String bookerName;
    List<Seat> bookingSeatsList;
    String showTimeId;
    Date bookingDate;
    Payment paymentDetails;
}
class Payment {
    String paymentId;
    String payeeName;
    PaymentType paymentType;
    Double price;
    PaymentStatus paymentStatus;
    Double updatePayment(DiscountCoupon coupon) {
        //update price
        return 0.0;
    }
}
class DiscountCoupon {
    String paymentId;
    Double couponAmount;
    Double couponDiscount;
    String couponName;
    Date expiryDate;
}
class SearchService {
    //get the cities names w.r.t particular cinema
    List<String> getCitiesByCinema(String cinemaName) {
        return null;
    }
    List<Cinema> getMoviesByTitle(String title) {
        return null;
    }
    List<Cinema> getMoviesByLanguage(String language) {
        return null;
    }
    List<Cinema> getMoviesByReleaseDate(String releaseDate) {
        return null;
    }
    List<Cinema> getMoviesByCityName(String cityName) {
        return null;
    }
    List<ShowTime> getShowsByMovie(String movieName) {
        return null;
    }
}
class BookingManagementService {
    private Lock lock = new ReentrantLock();
    BookingStatus bookTicket(String customerId, List<Seat> seatsList, ShowTime showTime) {
        lock.lock();
        try{
        // create a new booking
        //make payment
            return BookingStatus.BOOKED;
        } finally {
            lock.unlock();
        }
    }
    BookingStatus cancelBooking(String bookingId) {
        //logic goes here
        return BookingStatus.CANCELLED;
    }
    BookingStatus modifyBooking(String bookingId) {
        //logic goes here
        return BookingStatus.CANCELLED;
    }

}
class PaymentService {
    PaymentStatus makePayment(Booking booking) {
        // create a new booking
        //make payment
        return PaymentStatus.PAID;
    }
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

public class MovieTicketing {
}
