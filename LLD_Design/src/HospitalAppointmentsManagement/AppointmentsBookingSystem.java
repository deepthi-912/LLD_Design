package HospitalAppointmentsManagement;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum AppointmentStatus {
    VALID, INVALID, ACTIVE, BOOKED;
}
class Doctor {
    String doctorId;
    String doctorName;
    List<TimeSlot> timeSlots;
    String specialityDepartment;
    Date joinedDate;
    String email;
    String phoneNum;
}

class Patient {
    String patientId;
    String patientName;
    String email;
    String phoneNum;
    List<Appointment> listOfAppointments;
}

class TimeSlot {
    Time startTime;
    Time endTime;
    boolean isAvailable;
    boolean isAppointmentAvailable;
    String doctorId;
}
class Appointment {
    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    String appointmentId;
    String doctorId;
    String patientId;
    TimeSlot timeSlot;
    String descriptionOfAppointment;
    AppointmentStatus appointmentStatus;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDescriptionOfAppointment() {
        return descriptionOfAppointment;
    }

    public void setDescriptionOfAppointment(String descriptionOfAppointment) {
        this.descriptionOfAppointment = descriptionOfAppointment;
    }
}
class SearchService {
    HashMap<String, List<String>> listOfAppointmentsByDoc; //map of appointments corresponding to the doctorid and his list of appointment ids
    HashMap<String, List<String>> listOfAppointmentsByPatient;
    HashMap<String, Appointment> listOfAppointments;
    HashMap<String, HashMap<Time, TimeSlot>> listOfTimeSlots;
    List<Appointment> searchAppointmentsByDoctorName(String doctorId) {
        List<String> appointments = listOfAppointmentsByDoc.get(doctorId);
        List<Appointment> output = null;
        for(int i=0;i<appointments.size();i++) {
            output.add(listOfAppointments.get(appointments.get(i)));
        }
        return output;
    }
    List<Appointment> searchAppointmentsByPatientName(String patientName) {
            List<String> appointments = listOfAppointmentsByPatient.get(patientName);
            List<Appointment> output = null;
            for(int i=0;i<appointments.size();i++) {
                output.add(listOfAppointments.get(appointments.get(i)));
            }
            return output;
        }
    List<TimeSlot> searchAvailableAppointments() {
        List<TimeSlot> availableSlots = null;
        for(Map.Entry<String, HashMap<Time, TimeSlot>> entry : listOfTimeSlots.entrySet()) {
            for(Map.Entry<Time, TimeSlot> entryInner : entry.getValue().entrySet()) {
                if(entryInner.getValue().isAppointmentAvailable) {
                    availableSlots.add(entryInner.getValue());
                }
            }
        }
        return availableSlots;
    }
}
class AppointmentsManagement {
    HashMap<String, HashMap<Time, TimeSlot>> listOfTimeSlots;
    HashMap<String, Appointment> listOfAppointments;
    AppointmentStatus cancelAppointment(String appointmentId, String doctorId) {
        listOfAppointments.get(appointmentId).appointmentStatus=AppointmentStatus.INVALID;
        listOfTimeSlots.get(doctorId).get(listOfAppointments.get(appointmentId).timeSlot.startTime).isAppointmentAvailable=true;
        return AppointmentStatus.INVALID;
    }

    AppointmentStatus bookAppointment(String appointmentId, String doctorId) {
        listOfAppointments.get(appointmentId).appointmentStatus=AppointmentStatus.BOOKED;
        listOfTimeSlots.get(doctorId).get(listOfAppointments.get(appointmentId).timeSlot.startTime).isAppointmentAvailable=false;
        return AppointmentStatus.BOOKED;
    }

}
public class AppointmentsBookingSystem {
   HashMap<String, Appointment> listOfAppointments;

    public Appointment getAppointmentById(String appointmentId) {
        return listOfAppointments.get(appointmentId);
    }

}
