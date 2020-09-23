/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import java.awt.PopupMenu;
import javax.swing.JPanel;
import utils.ArbolPost;
import utils.ArbolUsuario;
import utils.CustomList.Lista;
import utils.CustomList.Nodo;

/**
 *
 * @author luisf
 */
public class Post {

    private int id;
    private int userId;
    //private static Post[] hijosNuevos;
    private static int idGen = 1;
    private String title;
    private String body;

    //Comment[] comments;
    private Lista<Comment> comentarios;

    public Post(int idUsuario, int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = idUsuario;

        comentarios = new Lista();
    }

    public Post(int idUsuario, String title, String body) {
        this.id = idGen++;
        this.title = title;
        this.body = body;
        this.userId = idUsuario;

        comentarios = new Lista();
    }

    public static Lista<Post> destructuring(String[] atributos) {
        int tam = 6;
        //Post[] posts = new Post[atributos.length / tam];
        Lista<Post> posts = new Lista();
        int id;
        for (int i = 0; (i + 1) * tam <= atributos.length; i++) {
            int marcador = i * tam;
            Post post = new Post(
                    Integer.parseInt(atributos[marcador + 1]),
                    atributos[marcador + 3],
                    atributos[marcador + 4]
            );
            id =  Integer.parseInt(atributos[marcador + 2]);
            posts.add(id, post);
            idGen = id++;
        }

        return posts;
    }

    public void addComment(int id, Comment comment) {
        comentarios.add(id, comment);
    }

    public Nodo<Comment> getComentario(int id) {
        for (int i = 0; i < comentarios.count(); i++) {
            Nodo<Comment> comentario = comentarios.getNodo(i);
            if (comentario.getId() == id) {
                return comentario;
            }
        }
        return null;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return this.id;
    }

    public static int getIdGen() {
        return idGen;
    }

    public static void setIdGen(int idGen) {
        Post.idGen = idGen;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Lista<Comment> getComments() {
        return comentarios;
    }

    public JPanel getDibujo() {
        return new ArbolPost(new Nodo(this.id, this));
    }
}
