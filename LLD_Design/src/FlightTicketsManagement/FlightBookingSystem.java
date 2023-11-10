package FlightTicketsManagement;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

enum AccountStatus {
    ACTIVE, BLOCKED, INACTIVE;
}
enum FlightOperationStatus {
    WORKING, MAINTAINANCE, NOT_FUNCTIONING;
}
enum PaymentStatus {
    PAID, REFUNDED, PROCESSING, INITIATED_PAYMENT, FAILED;
}
enum PaymentMode {
    CREDIT, DEBIT, CASH, PAYPAL, ONLINE;
}
enum SeatClass {
    ECONOMY, BUSINESS, FIRST_CLASS;
}
enum SeatType {
    EMERGENCY, REGULAR, EXTRA_LEGROOM;
}
class Account {
    Person person;
    String password;
    String userId;
    void makeReservation(String flightSchedule) {
        // make a reservation for this particular schedule for the current user
    }
}

class Address {
    String street;
    String apartmentNum;
    String state;
    String country;
    String zip;
}

class Person {
    String userName;
    String email;
    String phoneNum;
    Address address;
}

class Admin extends Account {
    void addFlight(Flight flight) {

    }
    void addFlightSchedule(Flight flight, Timestamp departureTime, Timestamp arrivalTime) {
        // add to the list of flight schedules
    }

    void cancelFlight(Flight flight, Timestamp departureTime, String airportId) {
        // remove from the list of flight schedules
    }
    void addPilot(Pilot pilotDetails, FlightSchedule flightSchedule) {
        //add pilot details to a flight schedule
    }
    void assignFlightCrew(FlightSchedule flightSchedule, String flightCrewId) {
        //assign flight crew to the particular flight schedule
    }
}

class Aircarft {
    String aircarftID;
    String aircraftName;
    List<Flight> lifOfFlights;
}

class Flight {
    String flightNumber;
    String modelName;
    String manufacturerName;
    FlightOperationStatus flightOperationStatus;
    Date manufactingDate;
    Double flightWeight;
    Integer numberOfSeats;
    List<Seat> seats;
}
class Seat {
    Integer seatNumber;
    SeatType seatType;
    SeatClass seatClass;
    Double seatPrice;
}
class Airport {
    String airportId;
    String airportName;
    String airportAddress;
}
class FlightSchedule {
    String flightId;
    String departureAirportId;
    String arrivalAirportId;
    Timestamp departureTime;
    Timestamp arrivalTime;
}
class Reservation {
    String reservationNum;
    String customerId;
    Timestamp dateOfReservation;
    PaymentStatus status;
    String paymentId;
    void cancelReservation(String reservationNumber) {
        NotificationService.sendNotification("cancelled", reservationNumber, customerId);
    }
    void updateReservation(String reservationNumber) {
        NotificationService.sendNotification("updated", reservationNumber, customerId);
    }
}
class Payment {
    String paymentId;
    Timestamp paymentDate;
    PaymentStatus paymentStatus;
    Double ticketCost;
    PaymentMode paymentMode;
    String customerId;
    PaymentStatus checkPaymentStatus(String paymentId) {
        return PaymentStatus.PAID;///to check for paymentStatus of a user
    }
}

class Pilot {
    String airlineName;
    Person pilotDetails;
}
class FlightCrew {
    String airlineName;
    Person flightCrewDetails;
}

class NotificationService {
   static void sendNotification(String message, String reservatioNumber, String customerId) {
        //send notif via email and text
    }
}
public class FlightBookingSystem {
    List<FlightSchedule> flightSchedules;

    void displayAllSchedules(String customerId) {
        //check if the user is registered and display flight schedule to the user
    }
    void displayAllAirports() {
        //display all the airports that are running
    }

    List<FlightSchedule> checkAvailableFlights(String customerId, String departure, String arrival, Timestamp departureDate) {
        List<FlightSchedule> flightsAvailable = null;
        for(int i=0;i<flightSchedules.size();i++) {
            if(flightSchedules.get(i).arrivalAirportId==arrival && flightSchedules.get(i).departureAirportId == departure && departureDate == flightSchedules.get(i).departureTime) {
                flightsAvailable.add(flightSchedules.get(i));
            }
        }
        return flightsAvailable;
    }
}
