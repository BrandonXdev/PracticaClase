/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic;

import appointments.Appointment;
import interfaces.iViews.iView;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import patients.Patient;



public class ClinicController {
    
    private  Clinic clinic;
    private iView view;
    
    public void setView(iView view){
        this.view = view;
    }

    private ClinicController( iView view) {
        this.clinic =  new Clinic(); 
        this.view = view;
    }
    
    private static ClinicController controller;
    
    public static ClinicController getIntance(iView view){
        if(controller==null)
            controller= new ClinicController (view);
            return controller;
    }
   public void addPatient(Patient patient){
    clinic.addPatient(patient);
    }

    public Patient findPatient(String id){
     return clinic.findPatient(id);   
    }

    public void removePatient(String id){
     clinic.removePatient(id);   
    }

    public Iterator<Patient> getPatients(){
      return clinic.getPatients();  
    }

    public boolean scheduleAppointment(Appointment appointment){
        return clinic.scheduleAppointment(appointment);
    }

    public Appointment findAppointment(String code){
        return clinic.findAppointment(code);
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime){
     return clinic.rescheduleAppointment(code, newDate, newTime);
    }

    public boolean cancelAppointment(String code){
        return clinic.cancelAppointment(code);
    }

    public Iterator<Appointment> getAppointments(){
      return clinic.getAppointments();  
    }

    public boolean checkInPatient(String patientId){
        boolean status= clinic.checkInPatient(patientId);
        if(status){
            view.showMenssage("Se hizo un registro exitosamente");
                    }else{
            view.showError("El registro no fue completado, el paciente no tiene citas para el dia de hoy");
            
        }
        return status;
    }

    public Patient getNextPatient(){
       return clinic.getNextPatient();
    }

    public Patient attendNextPatient(){
       return clinic.attendNextPatient();
    }

    public int getWaitingPatientCount(){
       return clinic.getWaitingPatientCount();
    }

    public boolean isPatientWaiting(String patientId){
      return clinic.isPatientWaiting(patientId);
    }   
}   

