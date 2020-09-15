/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import java.util.ArrayList;

/**
 *
 * @author luisf
 */
public class Nodo {
    private int id;

    public Nodo(int id) {
        this.id = id;
    }
    
    public void addNodo(ArrayList<Nodo> hijos, Nodo nuevo) {
        int lastChild = hijos.size() -1;
        hijos.add(nuevo);
    }
    
    public Nodo eliminar(ArrayList<Nodo> hijos, int id) {
        int index = 0;
        for (Nodo hijo: hijos ) {
            if (hijo.getId() ==  id) {
                hijos.remove(index);
            }
            index++;
        }
        return null;
    }

    public int getId() {
        return id;
    }
}
