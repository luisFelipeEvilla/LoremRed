/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.CustomList;

import static java.lang.Integer.min;
import static java.lang.Math.abs;
import java.util.Objects;
import javax.swing.JPanel;
import loremred.Usuario;
import utils.ArbolGrafico;

/**
 *Lista simple enlazada
 * @param <T>
 */
public class Lista<T> {
    
    private Nodo<T> PTR;
    private int ind;
    private int tam;

    public Lista() {
        PTR = new Nodo(-1, null);
        tam = 0;
    }
    
    /**
    *La inserción se hace en forma de pila, de tal forma que el nuevo nodo siempre quedara de primero
    */
    public void add(int id, T dato) {
        Nodo<T> p = new Nodo(id, dato);
        if (PTR.get() == null) {
            PTR = p;
        } else {
            p.setDer(PTR);
            PTR = p;
        }
        tam++;
    }

    public void remove(int id) {
        Objects.requireNonNull(id, "Este metodo no acepta variables del tipo NULL");
        Nodo<T> p = PTR;
        Nodo<T> q = PTR;
        while (p != null && p.getId() != id) {
            q = p;
            p = p.getDer();
        }
        
        if (p != null) {
            q.setDer(p.getDer());
        }
    }

    public Nodo<T> getNodo(int id) {
        Nodo<T> p = PTR;
        while (p != null && p.getId() !=  id) {
            p = p.getDer();
        }
        return p;
    }

    public int count() {
        return tam;
    }

    public Nodo<T> getRaiz() {
        return PTR;
    }
}
