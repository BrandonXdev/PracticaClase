/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patients;

import clinic.KeyDynamicsLists;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author hilar
 */
public class PatientsList implements KeyDynamicsLists<Patient, String>{
    private HashMap<String, Patient> patients;

    public PatientsList() {
        this.patients = new HashMap();
    }

    @Override
    public String get(Patient id) {
     if(!patients.containsKey(id))  return null;
     return patients.get(id);
    }

    @Override
    public boolean remove(Patient id) {
      return patients.remove(id) !=null;
    }

    @Override 
    public boolean add() {
     if(patients.containsKey(item.id()))  return false;
     return patients.put(item.getid(), item)==null;
    }

    @Override
    public Iterator getAll() {
     if(patients.isEmpty()) return null;
     return patients.values().iterator();
    }

    @Override
    public int size() {
      return patients.size();
    }

    @Override
    public boolean isEmpty() {
      return patients.isEmpty();
    }
    
}
