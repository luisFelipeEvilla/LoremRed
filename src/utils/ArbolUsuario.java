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
public class ArbolUsuario extends JPanel {

    private Nodo<Usuario> usuario;
    private FontMetrics fm = null;

    public ArbolUsuario(Nodo<Usuario> usuario) {
        this.usuario = usuario;
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
        BotonRaiz padre = new BotonRaiz(usuario, dimensiones);
        this.add(padre);

        int contPosts = 0;
        int contComentarios = 0;

        int separacionpostsX = 15;
        int separacionComentariosX = 5;

        int separacionPostsY = fm.getHeight() * 11;
        int separacionComentariosY = fm.getHeight() * 15;

        int alturaNodos = fm.getHeight() + 5;

        Nodo<Post> p = usuario.getDat().getPosts().getRaiz();
        while (p != null && contPosts < 9) {
            dimensiones = new Rectangle(separacionpostsX, fm.getHeight() * 11, 100, fm.getHeight() + 5);
            BotonNodo nodo = new BotonNodo(p.getDat().getTitle(), dimensiones);
            g2d.drawLine(this.getSize().width / 2, fm.getHeight() * 3, separacionpostsX + 50, separacionPostsY);
            nodo.setToolTipText(p.getDat().getTitle());
            nodo.setVisible(true);
            this.add(nodo);

            Nodo<Comment> c = p.getDat().getComments().getRaiz();
            while (c != null && contComentarios < 2) {
                g2d.drawLine(separacionpostsX + 50, fm.getHeight() * 12 + 5, separacionComentariosX + 30, fm.getHeight() * 15);
                dimensiones = new Rectangle(separacionComentariosX, fm.getHeight() * 15, 55, fm.getHeight() + 5);
                nodo = new BotonNodo(c.getDat().getName(), dimensiones);
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
            separacionpostsX += 110 * (3 - contPosts);
        }

    }
}
