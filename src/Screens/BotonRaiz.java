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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import loremred.Post;
import loremred.Usuario;
import utils.CustomList.Nodo;

/**
 *
 * @author luisf
 */
public class BotonRaiz extends JButton {

    public BotonRaiz(Nodo dat, Rectangle dimensiones) {
        if (dat.getDat().getClass().equals(Usuario.class)) {
            Usuario usuario = (Usuario) (dat.getDat());
            this.setText(usuario.getName());
            this.setBounds(dimensiones);
            this.setVisible(true);
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            StringBuffer info = new StringBuffer();
            info.append("Name: " + usuario.getName() + "\n");
            info.append("UserName: " + usuario.getUserName() + "\n");
            info.append("Phone: " + usuario.getPhone() + "\n");
            info.append("Wehsite: " + usuario.getWebsite());

            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    JOptionPane.showMessageDialog(null, info.toString(), usuario.getName(), 1);
                }

            });
        } else {
            if (dat.getDat().getClass().equals(Post.class)) {
                Post post = (Post) (dat.getDat());
                this.setText(post.getTitle());
                this.setBounds(dimensiones);
                this.setVisible(true);
                this.setCursor(new Cursor(Cursor.HAND_CURSOR));
                StringBuffer info = new StringBuffer();
                info.append("Title: " + post.getTitle() + "\n");
                info.append("Body: " + post.getBody() + "\n");

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
