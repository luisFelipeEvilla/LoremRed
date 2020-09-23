/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.CustomList;

import javax.swing.JPanel;
import loremred.Usuario;
import utils.ArbolGrafico;

/**
 *
 * Nodo de Lista simple enlazada
 * @param <T>
 */
public final class Nodo<T> {
    private int id;
    private T dat;
    private Nodo<T> der;

    public Nodo(int id, T dat) {
        this.dat = dat;
        this.id = id;
    }

    public T get() {
        return dat;
    }

    public Nodo<T> getDer() {
        return der;
    }

    public void setDer(Nodo<T> nodo) {
        der = nodo;
    }

    public int getId() {
        return id;
    }

    public T getDat() {
        return dat;
    }
    
     public JPanel getDibujo() {
        return new ArbolGrafico((Nodo<Usuario>) (this));
    }
}
