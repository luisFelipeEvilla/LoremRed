/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import java.util.ArrayList;

/**
 *
 * @author luisf
 */
public class Usuario extends Nodo {

    private static int idGen = 1;
    private static Usuario[] hijosNuevos;
    private String name;
    private String userName;
    private String email;
    private Adress adress;
    private String phone;
    private String website;
    private Company company;
    private Comment comments;

    private Post[] posts;
    private int noHijos = 0;

    public Usuario(String name, String userName, String email, Adress adress, String phone, String website, Company company) {
        super(idGen++);
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.adress = adress;
        this.company = company;

        this.posts = new Post[noHijos];
    }
    
    public void addPost(Post post) {
        this.posts = Post.addPost(posts, post, noHijos);
        noHijos++;
    }
    
    public Post getPost(int id) {
        int index = Post.buscarPost(posts, id, noHijos);
        return posts[index];
    }

    public static Usuario[] addUsuario(Usuario[] usuario, Usuario usuarioNuevo, int noHijos) {
        hijosNuevos = new Usuario[noHijos + 1];

        for (int i = 0; i < noHijos; i++) {
            hijosNuevos[i] = usuario[i];
        }

        hijosNuevos[noHijos] = usuarioNuevo;

        return hijosNuevos;
    }

    public static Usuario[] removeUsuario(Usuario[] usuario, int id, int noHijos) {
        int index = buscarUsuario(usuario, id, noHijos);
        hijosNuevos = new Usuario[noHijos - 1];

        for (int i = 0; i < noHijos - 1; i++) {
            if (i < index) {
                hijosNuevos[i] = usuario[i];
            } else {
                hijosNuevos[i] = usuario[i + 1];
            }
        }

        System.out.println("usuario " + usuario[index].getName() + " removido satisfactoriamente");

        return hijosNuevos;
    }

    public static int buscarUsuario(Usuario[] hijos, int id, int noHijos) {
        int index = -1;
        int aux = -1;
        for (int i = 0; i < noHijos; i++) {
            aux++;
            if (hijos[i].getId() == id) {
                index = aux;
                return index;
            }
        }

        return index;
    }

    public int getId() {
        return super.getId();
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}