/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicalrecords;

import clinic.SecuencialDynamicsList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author joanreciojimenez
 */
public class MedicalsRecordsList implements SecuencialDynamicsList<MedicalRecord>{
    private Stack<MedicalRecord> medicalHistory;
    public MedicalsRecordsList(){
        this.medicalHistory = new Stack();
    }

    @Override
    public MedicalRecord get() {
        try {
            return medicalHistory.peek();
        } catch (EmptyStackException e) {
            return null;
        }
    }
    

    @Override
    public boolean remove() {
        try {
            medicalHistory.pop();
        } catch (EmptyStackException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean add( MedicalRecord item) {
        medicalHistory.push(item); 
        return true;
        
    }
    @Override
    public Iterator getAll() {
       if(medicalHistory.isEmpty()) return null;
       return medicalHistory.iterator();
    }

    @Override
    public int size() {
        return medicalHistory.size();
    }
    
    @Override
    public boolean isEmpty() {
        return medicalHistory.isEmpty();
    }
    
}
