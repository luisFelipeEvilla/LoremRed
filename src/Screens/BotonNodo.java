/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import loremred.Comment;
import loremred.Post;
import loremred.Usuario;
import utils.CustomList.Nodo;

/**
 *
 * @author luisf
 */
public class BotonNodo extends JButton {

    public BotonNodo(String contenido, Rectangle dimensiones) {
        super(contenido);
        this.setBounds(dimensiones);
        this.setVisible(true);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public BotonNodo(Nodo dat, Rectangle dimensiones) {
        if (dat.getDat().getClass().equals(Usuario.class)) {
            Usuario usuario = (Usuario) (dat.getDat());
            this.setText(usuario.getName());
            this.setBounds(dimensiones);
            this.setVisible(true);
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));

            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    JFrame app = new JFrame(usuario.getName());
                    app.setSize(1100, 403);
                    app.add(usuario.getDibujo());
                    app.setLocationRelativeTo(null);
                    app.setVisible(true);
                    app.requestFocus();
                }

            });
        } else {
            if (dat.getDat().getClass().equals(Post.class)) {
                Post post = (Post) (dat.getDat());
                this.setText(post.getTitle());
                this.setBounds(dimensiones);
                this.setVisible(true);
                this.setCursor(new Cursor(Cursor.HAND_CURSOR));

                this.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        JFrame app = new JFrame(post.getTitle());
                        app.setSize(1100, 403);
                        app.add(post.getDibujo());
                        app.setVisible(true);
                        app.setLocationRelativeTo(null);
                        app.requestFocus();
                    }
                });
            } else {
                Comment coment = (Comment) (dat.getDat());
                this.setText(coment.getName());
                this.setBounds(dimensiones);
                this.setVisible(true);
                this.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                StringBuffer info = new StringBuffer();
                info.append("Email: " + coment.getEmail() + "\n");
                info.append(coment.getBody());
                
                 this.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        JOptionPane.showMessageDialog(null, info.toString() , coment.getName(), 1);
                    }
                });
                
            }
        }

    }

}
