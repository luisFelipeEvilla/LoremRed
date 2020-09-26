/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import java.awt.Cursor;
import java.awt.Rectangle;
import static java.awt.SystemColor.info;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
public class BotonRaiz extends JButton {

    public BotonRaiz(Nodo nodo, Rectangle dimensiones) {
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
            if (nodo.getClass().equals(Usuario.class)) {
                StringBuffer info = new StringBuffer();
                Usuario usuario = (Usuario) (nodo);
                info.append("ID" + usuario.getId() + "\n");
                info.append("Nombre: " + usuario.getName() + "\n");
                info.append("Nombre de usuario:" + usuario.getUserName() + "\n");
                info.append("Email: " + usuario.getEmail() + "\n");
                info.append("Phone: " + usuario.getPhone() + "\n");

                this.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        JOptionPane.showMessageDialog(null, info.toString(), usuario.getUserName(), 1);
                    }
                });
            } else {
                StringBuffer info = new StringBuffer();
                Post post = (Post) (nodo);
                info.append("Usuario: " + post.getUserId()+ "\n");
                info.append("ID: " + post.getId() + "\n");
                info.append("Titulo: " + post.getTitle() + "\n");
                info.append(post.getBody() + "\n");
                this.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        JOptionPane.showMessageDialog(null, info.toString(), post.getTitle(), 1);
                    }
                });
            }

        }
    }
}
