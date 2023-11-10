package HospitalAppointmentsManagement;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    Time inTime;
    Time outTime;
    String descriptionOfAppointment;

    public Appointment(String doctorId, String patientId, Time inTime, Time outTime, String descriptionOfAppointment) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.inTime = inTime;
        this.outTime = outTime;
        this.descriptionOfAppointment = descriptionOfAppointment;
    }

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

    public Time getInTime() {
        return inTime;
    }

    public void setInTime(Time inTime) {
        this.inTime = inTime;
    }

    public Time getOutTime() {
        return outTime;
    }

    public void setOutTime(Time outTime) {
        this.outTime = outTime;
    }

    public String getDescriptionOfAppointment() {
        return descriptionOfAppointment;
    }

    public void setDescriptionOfAppointment(String descriptionOfAppointment) {
        this.descriptionOfAppointment = descriptionOfAppointment;
    }
}
class SearchService {
    HashMap<String, List<Appointment>> listOfAppointmentsByDoc;
    HashMap<String, List<Appointment>> listOfAppointmentsByPatient;

    List<Appointment> searchAppointmentsByDoctorName(String doctorName) {
        return listOfAppointmentsByDoc.get(doctorName);
    }
    List<Appointment> searchAppointmentsByPatientName(String patientName) {
        return listOfAppointmentsByPatient.get(patientName);
    }
    List<TimeSlot> searchAvailableAppointments(String patientName) {
        for(Map.Entry<String, List<Appointment>> entry: listOfAppointmentsByDoc.entrySet()) {
            for(Time time = 0; time<=9; time++) {
                //search for the appointment that is not in the list
                //add it to list
            }
            //return all the entries
        }
    }
}
class AppointmentsManagement {
    HashMap<String, List<Appointment>> listOfAppointmentsByPatient; ///fetched from Search service
    HashMap<String, List<Appointment>> listOfAppointmentsByDoctor; ///fetched from Search service
    List<Appointment> totalAppointmentsList;
    void cancelAppointment(String appointmentId, String userId) {
        List<Appointment> listOfAppointments = listOfAppointmentsByPatient.get(userId);
        for(int i=0;i<listOfAppointments.size();i++) {
            if(listOfAppointments.get(i).getAppointmentId()==appointmentId) {
                listOfAppointments.remove(i);
                totalAppointmentsList.remove(listOfAppointments.get(i));
            }
        }
    }
    Appointment bookAppointment(Time inTime, Time outTime, String userId, String doctorId) {
        List<Appointment> listOfAppointments = listOfAppointmentsByPatient.get(userId);
        for(int i=0;i<listOfAppointments.size();i++) {
            if(listOfAppointments.get(i).getInTime()==inTime) {
                return null;
            } else {
                // add this appointment to the doctor appointment list
                // add this appointment to the patient apppointment list
                return new Appointment(doctorId, userId, inTime, outTime, "descriptionOfAppointment");
            }
        }
        return null;
    }
}
public class AppointmentsBookingSystem {
    List<Doctor> listOfDoctors;
    List<TimeSlot> listOfTimes;
    List<Patient> patients;
    List<Appointment> listOfAppointments;

    public List<Doctor> getListOfDoctors() {
        return listOfDoctors;
    }

    public void setListOfDoctors(List<Doctor> listOfDoctors) {
        this.listOfDoctors = listOfDoctors;
    }

    public List<TimeSlot> getListOfTimes() {
        return listOfTimes;
    }

    public void setListOfTimes(List<TimeSlot> listOfTimes) {
        this.listOfTimes = listOfTimes;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Appointment> getListOfAppointments() {
        return listOfAppointments;
    }

    public void setListOfAppointments(List<Appointment> listOfAppointments) {
        this.listOfAppointments = listOfAppointments;
    }
}
