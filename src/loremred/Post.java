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
class Post {
    private int id;
    private int userId;
    private static Post[] hijosNuevos;
    private static int idGen = 1;
    private String title;
    private String body;

    Comment[] comments;
    private int noHijos = 0;

    public Post(int idUsuario, int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = idUsuario;

        this.comments = new Comment[noHijos];
    }

    public Post(int idUsuario, String title, String body) {
        this.id = idGen++;
        this.title = title;
        this.body = body;
        this.userId = idUsuario;

        this.comments = new Comment[noHijos];
    }

    public static Post[] destructuring(String[] atributos) {
        int tam = 6;
        Post[] posts = new Post[atributos.length / tam];
        for (int i = 0; (i + 1) * tam <= atributos.length; i++) {
            int marcador = i*tam;
            Post post = new Post(
                    Integer.parseInt(atributos[marcador + 1]),
                    Integer.parseInt(atributos[marcador + 2]),
                    atributos[marcador + 3],
                    atributos[marcador + 4]
            );
            posts[i] = post;
        }

        return posts;
    }

    public void addComment(Comment comment) {
        this.comments = Comment.addComment(comments, comment, noHijos);
        System.out.println("El comentario del usuario " + comment.getEmail() + " se ha añadido correctamente en el post con id: " + this.id);
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
    
    public static Post getPost(Post[] hijos, int id, int noHijos) {
        int resultado = Post.buscarPost(hijos, id, noHijos);
        if (resultado != -1) {
             return hijos[resultado];
        } else {
            return null;
        }
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
    
    public Comment[] getComments() {
        return this.comments;
    }
}
