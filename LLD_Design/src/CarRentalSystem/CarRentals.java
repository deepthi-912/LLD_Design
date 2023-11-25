package CarRentalSystem;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

enum VehicleReservationStatus {
    AVAILABLE, BOOKED, WITH_CUSTOMER, UNAVAILABLE, DAMAGED;
}
enum ReservationStatus {
    RESERVED, CANCELLED, PENDING, FAILED, MODIFIED, SELECTED;
}
enum AccountStatus {
    ACTIVE, CLOSED, BLOCKED, BLACKLISTED;
}
enum VehicleType {
    SUV, VAN, MOTORCYCLE, CAR, TRUCK;
}
enum PaymentStatus {
    PAID, UNPAID,
}
class Vehicle {
    String vehicleRegistrationNumber;
    String barcode;
    VehicleType vehicleType;
    Integer parkingstallNumber;
    VehicleReservationStatus status;
    List<VehicleLog> vehicleLogs;
    void selectVehicle() {

    }
}
class VehicleLog {
    String logId;
    String vehicleNumber;
    String eventDescription;
    Timestamp timestamp;
}
class VehicleInventory {
    public List<Vehicle> getVehiclesList() {
        return vehiclesList;
    }
    String rentalLocation;
    Integer capacity;
    List<Vehicle> vehiclesList;
    void addVehicle(Vehicle vehicle) {

    }
}
class Account {
    String accountId;
    String name;
    String email;
    String password;
    String address;
    AccountStatus accountStatus;
}
class Reservation {
    String reservationId;
    String vehicleNumber;
    Date reservationStartDate;
    LocalDate reservationEndDate;
    String memberId;
    Date reservationDate;
    List<RentalInsurance> insurances;
    void addInsurance(RentalInsurance insurance) {

    }
}
class RentalInsurance {
    String insuranceName;
    Double insurancePrice;
    String insuranceId;
}
class PersonalInsurance extends RentalInsurance {

}
class LiabilityInsurance extends RentalInsurance {

}
class AdditionalEquipment {

}
class NotificationService {
    void sendNotification(String content) {

    }
}
class CarPrices {
    VehicleType vehicleType;
    Double price;
}
class Member {
    Account account;

}
class Receptionist {

}
class ReservationManagementService {

    //store the vehicles reservations list by date as a primary index
    HashMap<LocalDate, List<Reservation>> reservationsByDate;
    VehicleInventory vehicleInventory = new VehicleInventory();
    List<Vehicle> getAvailableVehilcesByDate(LocalDate startDate, LocalDate endDate) {
        List<Reservation> reservationList = reservationsByDate.get(startDate);
        List<Vehicle> vehicleList = vehicleInventory.getVehiclesList();
        List<Vehicle> availableVehicles = new ArrayList<>();
        for(int i=0;i<vehicleList.size();i++) {
            if(!reservationList.contains(vehicleList.get(i))) {
                availableVehicles.add(vehicleList.get(i));
            }
        }
        return availableVehicles;
    }
    Double calculateTotalPrice(Reservation reservation) {
        //check for the extra fees and calculate the amount
        Double totalPrice = 0.0;
        if(LocalDate.now().compareTo(reservation.reservationEndDate)>0) {
            // calculate fine
            totalPrice+=0.0;
        }
        return 0.0;
    }
    ReservationStatus bookReservation(Vehicle vehicle, String memberId, LocalDate startDate, LocalDate endDate) {
        // since we will be displaying the available vehicles, make a transaction or create lock in the code on vehicle
        // while reserving the vehicle
        //log this in vehicle log
        return ReservationStatus.RESERVED;
    }
    ReservationStatus modifyReservation(RentalInsurance rentalInsurance) {
        // since we will be displaying the available vehicles, make a transaction or create lock in the code on vehicle
        // while reserving the vehicle
        // log this in the Vehicle log event
        return ReservationStatus.MODIFIED;
    }
    ReservationStatus cancelReservation(Reservation reservation) {
        // log this in the vehicle log event and update the reservation status of the vehicle
        return ReservationStatus.CANCELLED;
    }
}
class SearchService {
    List<Reservation> reservationList;
    List<Vehicle> getVehicleRentalsByMember(String memberId) {
        return null;
    }
    Member getMemberReservationByVehicle(Vehicle vehicle) {
        return null;
    }
}
class PaymentService {
    PaymentStatus makePayment(Double amount) {
        return null;
    }
}
class SMSNotification extends NotificationService {
    PaymentStatus makePayment(Double amount) {
        return PaymentStatus.PAID;
    }
}
class EmailNotification extends NotificationService {

}
public class CarRentals {
}
