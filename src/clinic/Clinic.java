/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic;

import appointments.Appointment;
import appointments.AppointmentsList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import patients.Patient;
import waitingroom.WaitingRoomList;

/**
 *
 * @author brand
 */
public class Clinic {
    private PatiensList patients;
    private AppointmentsList appointments;
    private WaitingRoomList waitingroom;

    public Clinic() {
        this.patients = new PatientsList();
        this.appointments = new AppointmentsList();
        this.waitingroom = new WaitingRoomList();
    }
    
    public boolean addPatient(Patient patient) {
    }

    public Patient findPatient(String id) {
    }

    public boolean removePatient(String id) {
    }

    public Iterator<Patient> getPatients() {
    }

    public boolean scheduleAppointment(Appointment appointment) {
    }

    public Appointment findAppointment(String code) {
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime) {
        if (appointments.isEmpty()) return false;
        Appointment appo = appointments.get(code);
        if (appo == null) return false;
        appo.reschedule(newDate, newTime);
        return true;
    }

    public boolean cancelAppointment(String code) {

    }

    public Iterator<Appointment> getAppointments() {

    }

    public boolean checkInPatient(String patientId) {
        Iterator<Appointment> itAppo = appointments.getAll();
        
        while (itAppo.hasNext()) {
            Appointment appo = itAppo.next();
            
            if (appo.getPatient().getId().equals(patientId) && appo.isToday()) {
                waitingroom.add(appo.getPatient());
                return true;
            }
        }
        return false;
    }

    public Patient getNextPatient() {

    }

    public Patient attendNextPatient() {

    }

    public int getWaitingPatientCount() {

    }

    public boolean isPatientWaiting(String patientId) {

    }
    
    
}
