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
class Post extends Nodo {

    private int userId;
    private static Post[] hijosNuevos;
    private static int idGen = 1;
    private String title;
    private String body;

    Comment[] comments;
    private int noHijos = 0;

    public Post(int idUsuario, String title, String body) {
        super(idGen++);
        this.title = title;
        this.body = body;
        this.userId = idUsuario;

        this.comments = new Comment[noHijos];
    }

    public void addComment(Comment comment) {
        this.comments = Comment.addComment(comments, comment, noHijos);
        noHijos++;
    }
    
    public Comment getComentario(int id) {
        int index = Comment.buscarComentario(comments, id, noHijos);
        return comments[index];
    }

    public static Post[] addPost(Post[] hijos, Post hijoNuevo, int noHijos) {
        hijosNuevos = new Post[noHijos + 1];

        for (int i = 0; i < noHijos; i++) {
            hijosNuevos[i] = hijos[i];
        }

        hijosNuevos[noHijos] = hijoNuevo;
        System.out.println("Post añadido satisfactoriamente");
        return hijosNuevos;
    }

    public static Post[] removePost(Post[] hijos, int id, int noHijos) {
        int index = buscarPost(hijos, id, noHijos);
        hijosNuevos = new Post[noHijos - 1];

        for (int i = 0; i < noHijos - 1; i++) {
            if (i < index) {
                hijosNuevos[i] = hijos[i];
            } else {
                hijosNuevos[i] = hijos[i + 1];
            }
        }

        System.out.println("usuario " + hijos[index].getTitle() + " removido satisfactoriamente");

        return hijosNuevos;
    }

    public static int buscarPost(Post[] hijos, int id, int noHijos) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return super.getId();
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
}
