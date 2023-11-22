package LibraryBookManagement;
// We will focus on the following set of requirements while designing the Library Management System:
//
//        Any library member should be able to search books by their title, author, subject category as well by the publication date.
//        Each book will have a unique identification number and other details including a rack number which will help to physically locate the book.
//        There could be more than one copy of a book, and library members should be able to check-out and reserve any copy. We will call each copy of a book, a book item.
//        The system should be able to retrieve information like who took a particular book or what are the books checked-out by a specific library member.
//        There should be a maximum limit (5) on how many books a member can check-out.
//        There should be a maximum limit (10) on how many days a member can keep a book.
//        The system should be able to collect fines for books returned after the due date.
//        Members should be able to reserve books that are not currently available.
//        The system should be able to send notifications whenever the reserved books become available, as well as when the book is not returned within the due date.
//        Each book and member card will have a unique barcode. The system will be able to read barcodes from books and members’ library cards.

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

enum GENRE {
    THRILLER, SCIENCE, MATHEMATICS, PHYSICS;
}
enum BookItemStatus {
    BOOKED, AVAILABLE, LOST, UNAVAILABLE;
}
enum AccountStatus {
    ACTIVE, CLOSED, BLOCKED, DISABLED;
}
enum CheckoutStatus {
    RETURNED, FINED, CHECKED_OUT, WITH_MEMBER;
}
enum ReservationStatus {
    RESERVED, AVAILABLE, BOOKED, CANCELLED;
}
class BookItem {
    String bookIdentificationNumber;
    String bookId;
    BookItemStatus reservationStatus;
    Location bookLocation;
    void updateBookLocation(Location location) {

    }
    void updateReservationStatus(BookItemStatus status) {

    }
 }
class Location {
    Integer rackNumber;
    Integer columnNumber;
}
class Book {
    String bookId;
    String title;
    GENRE genre;
    String author;
    Date publication;
    Integer numOfPages;
    Integer numOfCopies;
    void addBookInstance(BookItem bookInstance) {
        //update num of Copies
        //notify the first user from the queue if available and remove if so
    }
    void addReserveBookByMember(Member member) {

    }
}
class Reservation {
    String memberId;
    String bookId;
    Timestamp reservationTimeStamp;
    ReservationStatus reservationStatus;
}

class Member {
    String memberId;
    Person person;
    Address address;
}
class Person {
    String personId;
    String personName;
    String email;
    String phoneNumber;
    AccountStatus status;
}
class Address {
    String street;
    String country;
    String pincode;
    String state;
}
class CheckOut {
    String checkOutId;
    String memberId;
    BookItem itemId;
    Date checkOutDate;
    Date dueDate;
    Date returnDate;
    CheckoutStatus status;
    Double fine;
    void updateReturnStatus(BookItem bookInstance) {
        // call book management to update the status of reservation
    }
}
interface NotificationService {
    default void generateNotification(String message) {

    }
}
class SMSNotification implements NotificationService{
    @Override
    public void generateNotification(String message) {

    }
}
class EmailNotification implements NotificationService {
    @Override
    public void generateNotification(String message) {

    }
}
class SearchService {
    List<BookItem> getBooksCheckedOutByMember(String memberid) {
        return null;
    }
    Member getMemberDetailsOfBook(BookItem bookItem) {
        return null;
    }
}
class LibraryManagementService {
    void manageBookReturnStatus(String ubin) {

    }
    void manageBookReservation(BookItem bookItem) {

    }
}
class LibraryMember extends Member {

}
public class BookManagementSystem {
    void setBookLimitForCheckOut() {

    }
    void setTimeLimitForCheckOut() {

    }
}
