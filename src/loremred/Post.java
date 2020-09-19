/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import utils.CustomList.Lista;

/**
 *
 * @author luisf
 */
class Post {

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
        for (int i = 0; (i + 1) * tam <= atributos.length; i++) {
            int marcador = i * tam;
            Post post = new Post(
                    Integer.parseInt(atributos[marcador + 1]),
                    Integer.parseInt(atributos[marcador + 2]),
                    atributos[marcador + 3],
                    atributos[marcador + 4]
            );
            posts.add(post);
        }

        return posts;
    }

    public void addComment(Comment comment) {
        comentarios.add(comment);
        System.out.println("El comentario del usuario " + comment.getEmail() + " se ha añadido correctamente en el post con id: " + this.id);
    }

    public Comment getComentario(int id) {
        for (int i = 0; i < comentarios.count(); i++) {
            Comment comentario = comentarios.get(i);
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
}
