/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Screens.BotonNodo;
import Screens.BotonRaiz;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;
import loremred.Comment;
import loremred.Post;
import loremred.Usuario;
import utils.CustomList.Nodo;

/**
 *
 * @author luisf
 */
public class ArbolPost extends JPanel {

    private Nodo<Post> post;
    private FontMetrics fm = null;

    public ArbolPost(Nodo<Post> post) {
        this.post = post;
        this.setBackground(Color.WHITE);
        this.setSize(1100, 403);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        this.removeAll();
        fm = g.getFontMetrics();
        Graphics2D g2d = (Graphics2D) g;

        Rectangle dimensiones = new Rectangle(this.getSize().width / 2 - 75, fm.getHeight() * 2, 150, fm.getHeight() + 5);
        BotonRaiz padre = new BotonRaiz(post, dimensiones);
        this.add(padre);

        int contPosts = 0;
        int contComentarios = 0;

        int separacionpostsX = 15;
        int separacionComentariosX = 5;

        int separacionPostsY = fm.getHeight() * 11;
        int separacionComentariosY = fm.getHeight() * 15;

        int alturaNodos = fm.getHeight() + 5;

        Nodo<Comment> c = post.getDat().getComments().getRaiz();
        while (c != null && contComentarios < 8) {
            g2d.drawLine(this.getSize().width/2, fm.getHeight() * 3 + 10, separacionComentariosX + 30, fm.getHeight() *  6);
            dimensiones = new Rectangle(separacionComentariosX, fm.getHeight() * 6, 55, fm.getHeight() + 5);
            BotonNodo nodo = new BotonNodo(c, dimensiones);
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
        contPosts++;

    }
}
