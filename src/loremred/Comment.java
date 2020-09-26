/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import utils.CustomList.Nodo;

/**
 *
 * @author luisf
 */
public class Comment extends Nodo {

    private static int idGen = 1;
    //private static Comment[] hijosNuevos;
    private int postId;
    private String name;
    private String email;
    private String body;

    public Comment(int idPost, int id, String name, String email, String body) {
        super(id, name);
        this.postId = idPost;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Comment(int idPost, String name, String email, String body) {
        super(idGen++, name);
        this.postId = idPost;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Comment(Comment comment) {
        super(comment.getId(), comment.getInfo());
        this.postId = comment.getPostId();
        this.name = comment.getName();
        this.email = comment.getEmail();
        this.body = comment.getBody();
    }
    
    

    public static Comment destructuring(String[] atributos) {
        int tam = 7;
        //Comment[] comments = new Comment[atributos.length / tam];
        Nodo comentarios = new Nodo(1, null);
        Comment comentario;
        int id;
        for (int i = 0; (i + 1) * tam <= atributos.length; i++) {
            int marcador = i * tam;
            id = Integer.parseInt(atributos[marcador + 2]);
            comentario = new Comment(
                    Integer.parseInt(atributos[marcador + 1]),
                    id,
                    atributos[marcador + 3],
                    atributos[marcador + 4],
                    atributos[marcador + 5]
            );

            comentario.setDer(comentarios.getDer());
            comentarios.setDer(comentario);

            idGen = id++;
        }
        comentarios = comentarios.getDer();
        return (Comment) comentarios;
    }

    public int getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
