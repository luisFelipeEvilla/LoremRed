/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;


/**
 *
 * @author luisf
 */
public class LoremRed {

    public static Usuario usuarios;

    public LoremRed() {
        usuarios = null;
    }

    public Usuario getUser(int id) {
        for (int i = 0; i < usuarios.getSize(); i++) {
            Usuario usuario = (Usuario) (usuarios.getNodo(i));
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
    public void removeUser(int id) {
        
    }

}
