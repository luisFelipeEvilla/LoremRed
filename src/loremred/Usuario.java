/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import java.util.ArrayList;
import utils.CustomList.Lista;

/**
 *
 * @author luisf
 */
public class Usuario {

    private int id;
    private static int idGen = 1;
    //private static Usuario[] hijosNuevos;
    private String name;
    private String userName;
    private String email;
    private Adress adress;
    private String phone;
    private String website;
    private Company company;
    private Comment comments;

    private Lista<Post> posts;

    public Usuario(int id, String name, String userName, String email, Adress adress, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.adress = adress;
        this.company = company;

        posts = new Lista();
    }

    public Usuario(String name, String userName, String email, Adress adress, String phone, String website, Company company) {
        this.id = idGen++;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.adress = adress;
        this.company = company;

        posts = new Lista();
    }

    public static Lista<Usuario> destructuring(String[] atributos) {
        int tam = 23;
        Lista<Usuario> usuarios = new Lista();
        for (int i = 0; (i + 1) * 23 <= atributos.length; i++) {
            int marcador = i * tam;
            Usuario usuario = new Usuario(
                    Integer.parseInt(atributos[marcador + 1]),
                    atributos[marcador + 2],
                    atributos[marcador + 3],
                    atributos[marcador + 4],
                    new Adress(
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
                    new Company(
                            atributos[marcador + 18],
                            atributos[marcador + 19],
                            atributos[marcador + 20]
                    )
            );
            usuarios.add(usuario);
        }

        return usuarios;
    }

    public void addPost(Post post) {
        posts.add(post);
        System.out.println("Post: " + post.getTitle() + " del usuario " + userName + " añadido satisfactoriamente");
    }

    public Post getPost(int id) {
        for (int i = 0; i < posts.count(); i++) {
            Post post = posts.get(i);
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public int getId() {
        return this.id;
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

    public Lista<Post> getPosts() {
        return this.posts;
    }
}
