/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import utils.CustomList.Lista;
import utils.CustomList.Nodo;

/**
 *
 * @author luisf
 */
public class LoremRed {

    public static Lista<Usuario> usuarios;

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
}
