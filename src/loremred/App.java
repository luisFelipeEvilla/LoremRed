/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import utils.CustomList.Lista;
import utils.Utils;

/**
 *
 * @author Usuario
 */
public class App {

    private static App app;

    private Lista<Usuario> usuarios;

    private final String APIURL = "https://jsonplaceholder.typicode.com";

    public static App getInstancia() {
        if (app == null) {
            app = new App();
        }
        return app;
    }

    private App() {
        usuarios = new Lista();
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
        //System.out.println("usuario: " + usuario.getUserName() + " agregado satisfactoriamente");
    }

    public void removeUsuario(int id) {
        for (int i = 0; i < usuarios.count(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getId() == id) {
                usuarios.remove(usuario);
                return;
            }
        }
    }
    public Lista<Usuario> getUsuarios()
    {
        return usuarios;
    }
    public void setUsuarios(String direccion)
    {
        usuarios = Usuario.destructuring(Utils.JsonParser(direccion));
    }

    public Usuario getUsuario(int id) {
        for (int i = 0; i < usuarios.count(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
    
    public String getURL()
    {
        return APIURL;
    }
    
}
