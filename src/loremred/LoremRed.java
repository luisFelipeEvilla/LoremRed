/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.CustomList.Lista;
import utils.Utils;

/**
 *
 * @author luisf
 */
public class LoremRed {
    
    private Lista<Usuario> usuarios;
    

    private static final String APIURL = "https://jsonplaceholder.typicode.com";

    public LoremRed() {
        usuarios = new Lista();
    }
    public Usuario getUser(int id)
    {
        for (int i = 0; i < usuarios.count(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
    
    public void addUser(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("usuario: " + usuario.getUserName() + " agregado satisfactoriamente");
    }
    
    public void removeUser(int id) {
        for (int i = 0; i < usuarios.count(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getId() == id) {
                usuarios.remove(usuario);
                return;
            }
        }
    }
    
    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoremRed app = new LoremRed();
        try {
            Utils.fetchData(app.APIURL+"/users", "C:/Users/Public/Documents/users.txt");
            Utils.fetchData(app.APIURL+"/posts", "C:/Users/Public/Documents/posts.txt");
            Utils.fetchData(app.APIURL+"/comments", "C:/Users/Public/Documents/comments.txt");
            
            app.usuarios = Usuario.destructuring(Utils.JsonParser("C:/Users/Public/Documents/users.txt"));
            
            Lista<Post> posts = Post.destructuring(Utils.JsonParser("C:/Users/Public/Documents/posts.txt"));
            
            for (int i = 0; i < posts.count(); i++) {
                Post post = posts.get(i);
                System.out.println(post.getTitle());
                app.getUser(post.getUserId()).addPost(post);
            }
            
            //Comment[] comments = Comment.destructuring(Utils.JsonParser("C:/Users/Public/Documents/comments.txt"));
            Lista<Comment> comentarios = Comment.destructuring(Utils.JsonParser("C:/Users/Public/Documents/comments.txt"));
            for (int i = 0; i < comentarios.count(); i++) {
                for (int j = 0; j < app.usuarios.count(); j++) {
                    Post post = app.usuarios.get(j).getPost(comentarios.get(i).getPostId());
                    if (post != null) {
                        post.addComment(comentarios.get(i));
                    }
                }
            }
            
            System.out.println("");
            
            //mostrar todos los post del usuario con id: 1
            Usuario usuario = app.getUser(1);
            posts = usuario.getPosts();
            System.out.println("Todos los post del usuario con id: 1");
            for (int i = 0; i < posts.count(); i++) {
                System.out.println(posts.get(i).getTitle());
            } 
            
            System.out.println(""); 
            //mostrar todos los comentarios del post con id: 3 del usuario con id:1
            Post p = app.getUser(1).getPost(3);
            comentarios = p.getComments();
            System.out.println("Todos los comentarios del post con id:3 del usuario con id: 1");
            for (int i = 0; i < comentarios.count(); i++) {
                System.out.println(comentarios.get(i).getName());
            }
            
            System.out.println("");
            // mostrar todos los posts
            System.out.println("Mostrar todos los posts");
            for (int i = 0; i < app.usuarios.count(); i++) {
                posts = app.usuarios.get(i).getPosts();
                for (int j = 0; j < posts.count(); j++) {
                    System.out.println(posts.get(j).getTitle());
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(LoremRed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
