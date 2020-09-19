/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.CustomList;

import static java.lang.Integer.min;
import static java.lang.Math.abs;
import java.util.Objects;

/**
 *
 * @author Usuario
 * @param <T>
 */
public class Lista<T> {

    private Nodo<T> punt;
    private Nodo<T> sel;
    private int ind;
    private int tam;

    public Lista() {
        punt = new Nodo(null);
        sel = new Nodo(null);
        tam = 0;
    }

    public void add(T dato) {
        Nodo<T> p = new Nodo(dato);
        if (punt.get() == null) {
            punt = p;
            reiniciarSelector();
        } else {
            punt.getIzq().setDer(p);
        }
        p.setDer(punt);
        tam++;
    }

    public void remove(T dato) {
        Objects.requireNonNull(dato, "Este metodo no acepta variables del tipo NULL");
        Nodo<T> p = sel;
        do {
            if (p.get() == dato) {
                if (p == punt) {
                    punt = p.getDer();
                }
                p.getIzq().setDer(p.getDer());
                p.clear();
                tam--;
                reiniciarSelector();
                return;
            } else {
                p = p.getDer();
            }
        } while (p != sel);
    }

    public T get(int ind) {
        if (ind < 0 || ind >= tam) {
            return null;
        }
        int dist = ind - this.ind;
        if (dist < 0) {
            for (int i = 0; i < abs(dist); i++) {
                sel = sel.getIzq();
            }
        } else {
            for (int i = 0; i < abs(dist); i++) {
                sel = sel.getDer();
            }
        }
        this.ind = ind;
        return sel.get();
    }

    public T getOptimized(int ind) {
        if (ind <= tam && ind > 0) {
            int dist = ind - this.ind;
            int dist1 = abs(dist);
            int dist2 = tam - dist1;
            int distMin = min(dist1, dist2);
            if (distMin == dist2) {
                dist = -dist;
            }
            if (dist < 0) {
                for (int i = 0; i < distMin; i++) {
                    sel = sel.getDer();
                }
            } else {
                for (int i = 0; i < distMin; i++) {
                    sel = sel.getIzq();
                }
            }
            this.ind = ind;
            return sel.get();
        } else {
            return null;
        }
    }

    private void reiniciarSelector() {
        sel = punt;
        ind = 0;
    }

    public int count() {
        return tam;
    }
}
