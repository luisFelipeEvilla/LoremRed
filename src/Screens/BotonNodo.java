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

    public BotonNodo(Nodo nodo, Rectangle dimensiones) {
        this.setText(nodo.getInfo());
        this.setBounds(dimensiones);
        this.setVisible(true);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

        if (nodo.getClass().equals(Comment.class)) {
            Comment coment = (Comment) (nodo);

            StringBuffer info = new StringBuffer();
            info.append("Email: " + coment.getEmail() + "\n");
            info.append(coment.getBody());

            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    JOptionPane.showMessageDialog(null, info.toString(), coment.getName(), 1);
                }
            });
        } else {
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Home screen = new Home(nodo);
                }
            });
            
        }
    }
}
