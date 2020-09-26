/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Screens.BotonNodo;
import Screens.BotonRaiz;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import loremred.Comment;
import loremred.Usuario;
import loremred.Post;
import utils.CustomList.Nodo;

/**
 * Arbol generico, que recibe un nodo generico y dibuja todos sus hijos, nietos y hasta bisnietos
 *
 * @author luisf
 */
public class ArbolGrafico extends JPanel {

    private Nodo usuarios;
    private HashMap posicionNodos = null;
    private HashMap subtreeSizes = null;
    private boolean dirty = true;
    private int parent2child = 20, child2child = 30;
    private Dimension empty = new Dimension(0, 0);
    private FontMetrics fm = null;
    private boolean home;
    private Nodo raiz;

    /**
     * Constructor de la clase ArbolGrafico. El constructor permite inicializar
     * los atributos de la clase ArbolExpresionGrafico y llama al método
     * repaint(), que es el encargado de pintar el Arbol.
     *
     * @param raiz: Nodo raiz del arbol
     */
    public ArbolGrafico(Nodo raiz) {
        this.usuarios = raiz;
        this.setBackground(Color.WHITE);
        this.setSize(1100, 403);
        this.setVisible(true);
        this.raiz = raiz;
        
        if (!raiz.getClass().equals(Usuario.class)) {
            if (!raiz.getClass().equals(Post.class)) {
                home = true;
            }
        } 
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        
        FontMetrics fm = g.getFontMetrics();
        g.setColor(Color.red);
        Graphics2D g2d = (Graphics2D) g;

        Rectangle dimensiones = new Rectangle(this.getSize().width / 2 - 75, fm.getHeight() * 2, 150, fm.getHeight() + 5);
        BotonRaiz padre = new BotonRaiz(raiz, dimensiones);
        
        this.add(padre);

        int contHijos = 0;
        int contNietos = 0;
        int contBisNietos = 0;

        int separacionHijosX = 60;
        int separacionNietosX = 15;
        int separacionBisNietosX = 5;

        int separacionHijosY = fm.getHeight() * 6;
        int separacionPostsY = fm.getHeight() * 11;
        int separacionComentariosY = fm.getHeight() * 15;

        int alturaNodos = fm.getHeight() + 5;
        Nodo hijo = raiz.getHijos();

        while (hijo != null && contHijos < 3) {
            dimensiones = new Rectangle(separacionHijosX, separacionHijosY, 200, fm.getHeight() + 5);
            BotonNodo nodo = new BotonNodo(hijo, dimensiones);
            g2d.drawLine(this.getSize().width / 2, fm.getHeight() * 3 + 5, separacionHijosX + 100, fm.getHeight() * 6);
            this.add(nodo);

            Nodo nieto = hijo.getHijos();
            while (nieto != null && contNietos < 3) {
                dimensiones = new Rectangle(separacionNietosX, fm.getHeight() * 11, 100, fm.getHeight() + 5);
                nodo = new BotonNodo(nieto, dimensiones);
                g2d.drawLine(separacionHijosX + 100, separacionHijosY + fm.getHeight(), separacionNietosX + 50, separacionPostsY);
                nodo.setToolTipText(nieto.getInfo());
                nodo.setVisible(true);
                this.add(nodo);

                Nodo bisNieto = nieto.getHijos();
                while (bisNieto != null && contBisNietos < 2) {
                    g2d.drawLine(separacionNietosX + 50, fm.getHeight() * 12 + 5, separacionBisNietosX + 30, fm.getHeight() * 15);
                    dimensiones = new Rectangle(separacionBisNietosX, fm.getHeight() * 15, 55, fm.getHeight() + 5);
                    nodo = new BotonNodo(bisNieto, dimensiones);
                    nodo.setToolTipText("Click para ver más");
                    this.add(nodo);
                    
                    separacionBisNietosX += 60;
                    bisNieto = bisNieto.getDer();
                    contBisNietos++;
                }

                if (contBisNietos < 2) {
                    separacionBisNietosX += 60 * (2 - contBisNietos);
                }

                contBisNietos = 0;
                separacionNietosX += 110;
                nieto = nieto.getDer();
                contNietos++;
            }

            if (contNietos < 3) {
                separacionNietosX += 110 * (3 - contNietos);
            }

            separacionHijosX += 350;
            contHijos++;
            contNietos = 0;
            hijo = hijo.getDer();
        }
    }
}
