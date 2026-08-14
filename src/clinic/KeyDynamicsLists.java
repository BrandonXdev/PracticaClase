/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clinic;

/**
 *
 * @author joanreciojimenez
 */
public interface KeyDynamicsLists <T,K> extends DynamicsLists<T>{
    public T get (K id);
    public boolean remove (K id);
}
