/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import java.awt.PopupMenu;
import javax.swing.JPanel;
import utils.CustomList.Nodo;

/**
 *
 * @author luisf
 */
public class Post extends Nodo {

    private int userId;
    //private static Post[] hijosNuevos;
    private static int idGen = 1;
    private String title;
    private String body;


    public Post(int idUsuario, int id, String title, String body) {
        super(id, title);
        this.title = title;
        this.body = body;
        this.userId = idUsuario;
    }

    public Post(int idUsuario, String title, String body) {
        super(idGen++, title);
        this.title = title;
        this.body = body;
        this.userId = idUsuario;
    }

    public Post(Post post, Comment hijos) {
        super(post.getId(), post.getInfo());
        this.userId = post.getUserId();
        this.title = post.getTitle();
        this.body = post.getBody();
        
        Comment q = hijos;
        
        while (q!= null) {
            Comment nuevoHijo = new Comment (q);
            addHijo(nuevoHijo);
            q = (Comment) q.getDer();
        }
    }
    
    

    public static Post destructuring(String[] atributos) {
        int tam = 6;
        //Post[] posts = new Post[atributos.length / tam];
        Post posts = new Post(100, 100, "", "");
        Post post;
        int id;
        for (int i = 0; (i + 1) * tam <= atributos.length; i++) {
            int marcador = i * tam;
            id = Integer.parseInt(atributos[marcador + 2]);
            post = new Post(
                    Integer.parseInt(atributos[marcador + 1]),
                    Integer.parseInt(atributos[marcador + 2]),
                    atributos[marcador + 3],
                    atributos[marcador + 4]
            );
            post.setDer(posts.getDer());
            posts.setDer(post);
           

            idGen = id++;
        }
        
        posts = (Post) posts.getDer();
        return posts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
