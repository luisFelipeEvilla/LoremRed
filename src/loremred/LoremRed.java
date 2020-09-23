/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import Screens.Home;
import Screens.Signin;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.CustomList.Lista;
import utils.CustomList.Nodo;
import utils.Utils;

/**
 *
 * @author luisf
 */
public class LoremRed {

    private Lista<Usuario> usuarios;

    

    public LoremRed() {
        usuarios = new Lista();
    }

    public Nodo<Usuario> getUser(int id) {
        for (int i = 0; i < usuarios.count(); i++) {
            Nodo<Usuario> usuario = usuarios.getNodo(i);
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public void addUser(int id, Usuario usuario) {
        usuarios.add(id, usuario);
        System.out.println("usuario: " + usuario.getUserName() + " agregado satisfactoriamente");
    }

    public void removeUser(int id) {
        usuarios.remove(id);
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoremRed app = new LoremRed();
        try {
            app.usuarios = utils.Utils.saveData();

            Home ui = new Home(app.usuarios);
            ui.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(LoremRed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
