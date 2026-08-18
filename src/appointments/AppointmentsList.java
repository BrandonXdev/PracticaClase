/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appointments;

import clinic.KeyDynamicsLists;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author joanreciojimenez
 */
public class AppointmentsList implements KeyDynamicsLists<Appointment, String>{
    private TreeSet<Appointment> appointments;
    public AppointmentsList (){
        this.appointments = new TreeSet();
    }

    @Override
    public Appointment get(String id) {
        for(Appointment actual : appointments){
            if (actual.getCode().equals(id)) {
                return actual;
            }
        }
        return null;

    }

    @Override
    public boolean remove(String id) {
        Appointment encontrado = get(id);
        if(encontrado == null){
            return false;
        }
        return appointments.remove(encontrado);
    }

    @Override
    public boolean add(Appointment item) {
       return appointments.add(item);
    }

    @Override
    public Iterator getAll() {
        if(appointments.isEmpty()) return null;
        return appointments.iterator();
    }

    @Override
    public int size() {
        return appointments.size();
    }

    @Override
    public boolean isEmpty() {
        return appointments.isEmpty();
    }
}

