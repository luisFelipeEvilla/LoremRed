/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.CustomList;

/**
 *
 * @author Usuario
 * @param <T>
 */
public final class Nodo<T> {

    private T dat;
    private Nodo<T> der;
    private Nodo<T> izq;

    public Nodo(T dat) {
        this.clear();
        this.dat = dat;
    }

    public T get() {
        return dat;
    }
    public Nodo<T> getDer()
    {
        return der;
    }
        public Nodo<T> getIzq()
    {
        return izq;
    }
    public void setDer(Nodo<T> nodo) {
        der = nodo;
        nodo.izq = this;
    }

    public void setIzq(Nodo<T> nodo) {
        izq = nodo;
        nodo.der = this;
    }
    public void clear()
    {
        dat = null;
        der = null;
        izq = null;
    }
}
