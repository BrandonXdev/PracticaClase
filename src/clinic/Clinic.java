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

import patients.PatientsList;
import waitingroom.WaitingRoomList;

/**
 *
 * @author brand
 */
public class Clinic {
    private PatientsList patients;
    private AppointmentsList appointments;
    private WaitingRoomList waitingroom;

    public Clinic() {
        this.patients = new PatientsList();
        this.appointments = new AppointmentsList();
        this.waitingroom = new WaitingRoomList();
    }
    
    public boolean addPatient(Patient patient) {
        
        if (patient == null) return false;
        return patients.add(patient);    
    }

    public Patient findPatient(String id) {
        if (id == null || patients.isEmpty()) return null;
        
        return patients.get(id); 
    }

    public boolean removePatient(String id) {
        if (patients.isEmpty()){
            return false;
        }
        
        return patients.remove(id);
    }

    public Iterator<Patient> getPatients() {
        return patients.getAll();    
    }

    public boolean scheduleAppointment(Appointment appointment) {
        if (appointment == null) return false;
        if (appointments.get(appointment.getCode()) != null) {
        return false;
        }
        return appointments.add(appointment);
    }

    public Appointment findAppointment(String code) {
        if (code == null || appointments.isEmpty()) {
            return null;
        }
        return appointments.get(code);
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime) {
        if (appointments.isEmpty()) return false;
        Appointment appo = appointments.get(code);
        if (appo == null) return false;
        appo.reschedule(newDate, newTime);
        return true;
    }

    public boolean cancelAppointment(String code) {
        if (code == null || appointments.isEmpty()) {
            return false;
        }
        return appointments.remove(code);
    }

    public Iterator<Appointment> getAppointments() {
        return appointments.getAll();    
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
        if (waitingroom.isEmpty()) {
            return null;
        }
        return waitingroom.get();

    }

    public Patient attendNextPatient() {
        if (waitingroom.isEmpty()) {
            return null;
        }
        Patient patient = waitingroom.get();
        waitingroom.remove();
        
        return patient;
    }

    public int getWaitingPatientCount() {
       return waitingroom.size();
    }
    
     public boolean isPatientWaiting(String patientId) {

        if (patientId == null || waitingroom.isEmpty()) {
            return false;
        }

        Iterator<Patient> it = waitingroom.getAll();

        while (it.hasNext()) {

            Patient patient = it.next();

            if (patient.getId().equals(patientId)) {
                return true;
            }
        }

        return false;
    }
     
    public Iterator<Patient> getWaitingPatients() {
        return waitingroom.getAll();
    }

     
}

 
    

