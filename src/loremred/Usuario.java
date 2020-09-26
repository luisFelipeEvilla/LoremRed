/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import java.util.ArrayList;
import javax.swing.JPanel;
import utils.ArbolGrafico;
import utils.CustomList.Nodo;

/**
 *
 * @author luisf
 */
public class Usuario extends Nodo {

    private static int idGen = 1;
    private String name;
    private String userName;
    private String email;
    private direccion adress;
    private String phone;
    private String website;
    private Compania company;
    private Comment comments;

    public Usuario(int id, String name, String userName, String email, direccion adress, String phone, String website, Compania company) {
        super(id, name);
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.adress = adress;
        this.company = company;

    }

    public Usuario(String name, String userName, String email, direccion adress, String phone, String website, Compania company) {
        super(idGen++, name);
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.adress = adress;
        this.company = company;

    }

    public Usuario(Usuario usuario, Nodo hijos) {
        super(usuario.getId(), usuario.getInfo());
        this.name = usuario.getName();
        this.email = usuario.getEmail();
        this.adress = usuario.getAdress();
        this.phone = usuario.getPhone();
        this.website = usuario.getWebsite();
        this.company = usuario.getCompany();

        Post q = (Post) hijos;

        while (q != null) {
            Post nuevoHijo = new Post(q, (Comment) q.getHijos());
            this.addHijo(nuevoHijo);
            q = (Post) q.getDer();
        }
    }

    /**
     * Recibe una lista de atributos en forma de string y en base a ella retorna
     * una lista de usuarios
     *
     * @param atributos lista de atributos en formato string
     * @return Lista de usuarios creados en base a la lista de atributos pasados
     * como parametro.
     */
    public static Usuario destructuring(String[] atributos) {
        int tam = 23;
        Nodo usuarios = new Nodo(1, "");
        int idNuevo;
        for (int i = 0; (i + 1) * tam <= atributos.length; i++) {
            int marcador = i * tam;
            idNuevo = Integer.parseInt(atributos[marcador + 1]);
            Usuario usuario = new Usuario(
                    idNuevo,
                    atributos[marcador + 2],
                    atributos[marcador + 3],
                    atributos[marcador + 4],
                    new direccion(
                            atributos[marcador + 6],
                            atributos[marcador + 7],
                            atributos[marcador + 8],
                            atributos[marcador + 9],
                            new Geo(
                                    Double.parseDouble(atributos[marcador + 11].replaceAll("\"", "")),
                                    Double.parseDouble(atributos[marcador + 12].replaceAll("\"", ""))
                            )
                    ),
                    atributos[marcador + 15],
                    atributos[marcador + 16],
                    new Compania(
                            atributos[marcador + 18],
                            atributos[marcador + 19],
                            atributos[marcador + 20]
                    )
            );
            usuario.setDer(usuarios.getDer());
            usuarios.setDer(usuario);
            idGen = idNuevo++;
        }

        usuarios = usuarios.getDer();

        return (Usuario) usuarios;
    }

    public String getEmail() {
        return email;
    }

    public Comment getComments() {
        return comments;
    }

    public static int getIdGen() {
        return idGen;
    }

    public static void setIdGen(int idGen) {
        Usuario.idGen = idGen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public direccion getAdress() {
        return adress;
    }

    public void setAdress(direccion adress) {
        this.adress = adress;
    }

    public Compania getCompany() {
        return company;
    }

    public void setCompany(Compania company) {
        this.company = company;
    }
}
