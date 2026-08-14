/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package waitingroom;

import clinic.SecuencialDynamicsList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import patients.Patient;

/**
 *
 * @author brand
 */
public class WaitingRoomList implements SecuencialDynamicsList<Patient> {
  
    private Queue<Patient> waitingList;

    public WaitingRoomList() {
        this.waitingList = new LinkedList();
    }    
    

    
    
}
