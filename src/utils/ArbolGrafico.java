/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Screens.BotonNodo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import loremred.Comment;
import loremred.Usuario;
import loremred.Post;
import utils.CustomList.Lista;
import utils.CustomList.Nodo;

/**
 * Arbol de usuarios, con sus posts y sus comentarios
 * @author luisf
 */
public class ArbolGrafico extends JPanel {

    private Nodo<Usuario> usuarios;
    private HashMap posicionNodos = null;
    private HashMap subtreeSizes = null;
    private boolean dirty = true;
    private int parent2child = 20, child2child = 30;
    private Dimension empty = new Dimension(0, 0);
    private FontMetrics fm = null;

    /**
     * Constructor de la clase ArbolGrafico. El constructor permite
     * inicializar los atributos de la clase ArbolExpresionGrafico y llama al
     * método repaint(), que es el encargado de pintar el Arbol.
     *
     * @param miArbol: * @param miArbol Nodo PTR de la lista de usuarios
     */
    public ArbolGrafico(Nodo<Usuario> miArbol) {
        this.usuarios = miArbol;
        this.setBackground(Color.WHITE);
        this.setSize(1100, 403);
        

        dirty = false;
    }

    /**
     * Sobreescribe el metodo paint y se encarga de pintar todo el árbol.
     *
     * @param g: Objeto de la clase Graphics.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.removeAll();
        fm = g.getFontMetrics();
        Graphics2D g2d = (Graphics2D) g;
 
        Rectangle dimensiones = new Rectangle(this.getSize().width / 2 - 75, fm.getHeight() * 2, 150, fm.getHeight() + 5);
        BotonNodo padre = new BotonNodo("LoremdRed", dimensiones);
        this.add(padre);
        
        int contUsuarios = 0;
        int contPosts = 0;
        int contComentarios = 0;
        
        int separacionUsuariosX = 60;
        int separacionpostsX = 15;
        int separacionComentariosX = 5;
        
        int separacionUsuariosY = fm.getHeight() * 6;
        int separacionPostsY = fm.getHeight() * 11;
        int separacionComentariosY = fm.getHeight() * 15;
        
        int alturaNodos = fm.getHeight() + 5;
        Nodo<Usuario> u = usuarios;

        while (u != null && contUsuarios < 3) {
            dimensiones = new Rectangle(separacionUsuariosX, separacionUsuariosY, 200, fm.getHeight() + 5);
            BotonNodo nodo = new BotonNodo(u, dimensiones);
            g2d.drawLine( this.getSize().width/2, fm.getHeight() * 3 + 5, separacionUsuariosX + 100, fm.getHeight() * 6);
            this.add(nodo);

            Nodo<Post> p = u.getDat().getPosts().getRaiz();
            while (p != null && contPosts < 3) {
                dimensiones = new Rectangle(separacionpostsX, fm.getHeight() * 11, 100, fm.getHeight() + 5);
                nodo = new BotonNodo(p, dimensiones);
                g2d.drawLine(separacionUsuariosX + 100, separacionUsuariosY + fm.getHeight(), separacionpostsX + 50, separacionPostsY);
                nodo.setToolTipText(p.getDat().getTitle());
                nodo.setVisible(true);
                this.add(nodo);

                Nodo<Comment> c = p.getDat().getComments().getRaiz();
                while (c != null && contComentarios < 2) {
                    g2d.drawLine(separacionpostsX + 50, fm.getHeight() * 12 + 5, separacionComentariosX + 30, fm.getHeight() * 15);
                    dimensiones = new Rectangle(separacionComentariosX, fm.getHeight() * 15, 55, fm.getHeight() + 5);
                    nodo = new BotonNodo(c, dimensiones);
                    nodo.setToolTipText("Click para ver más");
                    this.add(nodo);
                    
                    separacionComentariosX += 60;
                    c = c.getDer();
                    contComentarios++;
                }
                
                if (contComentarios < 2) {
                    separacionComentariosX += 60 * (2 - contComentarios);
                }
                
                contComentarios = 0;
                separacionpostsX += 110;
                p = p.getDer();
                contPosts++;
            }
            
            if (contPosts < 3) {
                separacionpostsX += 110 * (3-contPosts);
            }

            separacionUsuariosX += 350;
            contUsuarios++;
            contPosts = 0;
            u = u.getDer();
        }
    }

}
