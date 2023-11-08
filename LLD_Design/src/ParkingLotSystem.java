//Parking Lot System
//
//        System Requirements
//The parking lot should have multiple floors where customers can park their cars.
//        The parking lot should have multiple entry and exit points.
//        Customers can collect a parking ticket from the entry points and can pay the parking fee at the exit points on their way out.
//        Customers can pay the tickets at the automated exit panel or to the parking attendant.
//        Customers can pay via both cash and credit cards.
//        Customers should also be able to pay the parking fee at the customer’s info portal on each floor. If the customer has paid at the info portal, they don’t have to pay at the exit.

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

enum VehicleType {
    CAR, VAN, ELECTRIC, BUS, MOTORCYCLE;
}

enum ParkingStatus {
    RESERVED, AVAILABLE, NOT_AVAILABLE, OUT_OF_ORDER;
}

enum PaymentMode {
    CREDIT, DEBIT, CASH, PAYPAL, APPLE_PAY
}

enum PaymentStatus {
    SUCCESS, FAILURE, REFUNDED, PROCESSING, INITIATED
}

enum AccountStatus {
    ACTIVE, BLOCKED, INACTIVE, DEACTIVATED, DELETED;
}
class Vehicle {
    String vehicleId;
    VehicleType vehicleType;
    String registrationNum;
}
class ParkingSpot {
    String parkingSpotID;

    public VehicleType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(VehicleType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    VehicleType parkingSpotType;

    Double parkingSpotCost;

    Long floorNum;
}

class ParkingSpotStatus {
    String parkingSpotId;

    public ParkingSpotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSpotStatus status) {
        this.status = status;
    }

    ParkingSpotStatus status;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    VehicleType vehicleType;
}

class Customer {
    String userId;
    String password;
    Person person;
    AccountStatus status;
}

class Admin extends Customer {
    String userId;
    String password;
    Person person;
}
class Person {
    String personName;
    String phNum;
    String email;
    Address address;
}

class Address {
    String streetName;
    String country;
    String state;
    String pinCode;
}

class Ticketing {
    String ticketNum;
    String parkingSpotNum;
    String vehicleNum;
    Timestamp entryTime;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    VehicleType vehicleType;
}

class Payment {
    String paymentId;
    Timestamp entryTime;
    Timestamp exitTime;
    String ticketNum;
    PaymentMode paymentMode;
    PaymentStatus paymentStatus;
    Timestamp timeOfPayment;
}


public class ParkingLotSystem {
    String parkingLotName;
    Long totalnumOfFloors;
    Address address;
    HashMap<VehicleType, Double> vehicleCost = new HashMap<>();
    public ParkingLotSystem(String parkingLotName, Long numOfFloors, Address address) {

    }
    //update parking rates for a vehicle type
    public void updateVehicleTypeCost(Double cost, VehicleType type) {
        vehicleCost.put(type, cost);
    }
    public void addParkingFloor(Long floorNum) {
        this.totalnumOfFloors = floorNum;
    }
}
    class PaymentService {
        HashMap<Integer, Ticketing> ticketingMap = new HashMap<Integer, Ticketing>();

        //define a default values of parking cost wrt vehicles that can be modified by admin
        HashMap<VehicleType, Double> vehicleCost = new HashMap<>();
        PaymentStatus makePayment(String ticketNum) {
            VehicleType vehicleType = ticketingMap.get(ticketNum).getVehicleType();
            Double cost = vehicleCost.get(vehicleType);
            //calculate cost according to current time and the corresponding entry time
            //initiate payment with the card/cash/online and update payment status
            return PaymentStatus.SUCCESS;
        }
    }

    class TicketingService {
        String generateTicket (VehicleType vehicleType, String vehicleNum) {
            //generate ticket num and return
            return "";
        }
    }

    class SearchService {
        HashMap<String, ParkingSpotStatus> parkingSpotsStatuses = new HashMap<>();
        ParkingSpotStatus getParkingSpotStatus(String parkingSpotId) {
            return parkingSpotsStatuses.get(parkingSpotId);
        }
        boolean isParkingSpotAvailable(VehicleType vehicleType) {
            for(Map.Entry<String, ParkingSpotStatus> parkingSpot: parkingSpotsStatuses.entrySet()) {
                if(parkingSpot.getValue().getVehicleType()==vehicleType && parkingSpot.getValue().getStatus().equals(ParkingStatus.AVAILABLE)) {
                    return true;
                }
            }
            return false;
        }

    }



