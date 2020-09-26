/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.CustomList;

import java.awt.Graphics;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import loremred.Usuario;
import utils.ArbolGrafico;

/**
 *
 * Nodo de Lista simple enlazada
 *
 * @param
 */
public class Nodo {

    private int id;
    // información visible al momento de msotrar el nodo graficamente
    private String info;
    private Nodo der;
    private Nodo hijos;
    private static int idGen = 0;

    public Nodo(int id, String info) {
        this.id = id;
        this.info = info;
        hijos = null;
    }
    
    public Nodo(String info) {
        this.id = idGen++;
        this.info = info;
        hijos = null;
    }

    public void setHijos(Nodo hijos) {
        this.hijos = hijos;
    }

    public void addHijo(Nodo hijo) {
        if (this.hijos == null) {
            hijos = hijo;
        } else {
            hijo.setDer(hijos);
            hijos = hijo;
        }
    }

    public Nodo getHijos() {
        return hijos;
    }

    public int getId() {
        return id;
    }

    public Nodo getDer() {
        return der;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
    
    public int getSize() {
        Nodo p = this;
        int cont = 0;
        while (p != null) {
            cont ++;
            p = p.getDer();
        }
        
        return cont;
    }
    
    public Nodo getNodo(int id) {
        Nodo p = this;
        while (p != null && p.getId() !=  id) {
            p = p.getDer();
        }
        return p;
    }

    public String getInfo() {
        return info;
    }
}
