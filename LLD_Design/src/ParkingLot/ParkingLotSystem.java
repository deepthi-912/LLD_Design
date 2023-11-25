package ParkingLot;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

enum ParkingSpotType {
    COMPACT, LARGE, HANDICAPPED, MOTORCYCLE, ELECTRIC;
}
enum VehicleType {
    CAR, TRUCK, VAN, MOTORCYCLE;
}
enum PaymentMode {
    CASH, CREDIT_CARD, DEBIT_CARD, PAYPAL;
}
enum PaymentStatus {
    PAID, REFUNDED, FAILED, PROCESSING, PENDING;
}
enum ParkingSpotStatus {
   FILLED, EMPTY, RESERVED, UNAVAILABLE;
}
enum ParkingLotStatus {
    FILLED, SPOTS_AVAILABLE, EMPTY;
}
enum AccountStatus {
    CLOSED, ACTIVE, BLOCKED, DISABLED;
}

class ParkingSpot {
    String parkingSpotId;
    String parkingFloorId;
    ParkingSpotStatus status;
}
class CompactParkingSpot extends ParkingSpot {
    Integer emptySpots;
}

class ParkingTicket {
    String parkingTicketNum;
    String customerName;
    VehicleType vehicle;
    PaymentStatus paymentStatus;
    Timestamp printTimeStamp;
}
class ParkingFloor {
    Integer floorNumber;
    Integer ParkingLotCapacity;
    String parkingLotId;
    Integer emptyParkingSpotsCompact;
    Integer emptyParkingSpotsLarge;
}
class Payment {
    String parkingTicketNumber;
    String payerName;
    Double ticketPrice;
    PaymentMode paymentMode;
    Date paymentDate;
}
class ParkingLot {
    String parkingLotId;
    Integer parkingFloors;
    Integer parkingLotCapacity;
    ParkingLotStatus parkingLotStatus;
    void addParkingFloor(ParkingFloor parkingFloor) {

    }
}
class Vehicle {
    String vehicleId;
    VehicleType vehicleType;
    String registrationNumber;
}
class EntryPanel {
    String entryPanelId;
    //give the empty spot details and print the ticket
    ParkingTicket printTicket(Vehicle vehicle) {
        return null;
    }
}
class ExitPanel {
    String exitPanelId;
    PaymentStatus payTicket(String ticketNumber) {
        return PaymentStatus.PAID;
    }
}
class InfoPortal {
    String parkingFloorId;
    PaymentStatus payTicket(String ticketNumber) {
        return PaymentStatus.PAID;
    }
}

class Account {
    String name;
    String email;
    String password;
    String phoneNumber;
    String address;
    AccountStatus status;
}
class Customer {
    Account accountNumber;

}



public class ParkingLotSystem {

}
