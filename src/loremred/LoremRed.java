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
import utils.Utils;

/**
 *
 * @author luisf
 */
public class LoremRed {
    
    private Usuario[] users;
    private int noHijos = 0;
    

    private static final String APIURL = "https://jsonplaceholder.typicode.com";

    public LoremRed() {
        this.users = new Usuario[noHijos];
    }
    
    public void addUser(Usuario user) {
        this.users = Usuario.addUsuario(users, user, noHijos);
        System.out.println("usuario: " + user.getUserName() + " agregado satisfactoriamente");
        this.noHijos++;
    }
    
    public void removeUser(int id) {
        users = Usuario.removeUsuario(users, id, noHijos);
        noHijos--;
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
            
            Usuario[] usuarios = Usuario.destructuring(Utils.JsonParser("C:/Users/Public/Documents/users.txt"));
            for (int i = 0; i < usuarios.length; i++) {
                app.addUser(usuarios[i]);
            }
            
            Post[] posts = Post.destructuring(Utils.JsonParser("C:/Users/Public/Documents/posts.txt"));
            
            for (int i = 0; i < posts.length; i++) {
                Usuario usuario = Usuario.getUsuario(app.users, posts[i].getUserId(), app.noHijos);
                usuario.addPost(posts[i]);
            }
            
            Comment[] comments = Comment.destructuring(Utils.JsonParser("C:/Users/Public/Documents/comments.txt"));
            
            for (int i = 0; i < comments.length; i++) {
                for (int j = 0; j < app.users.length; j++) {
                    Post post = app.users[j].getPost(comments[i].getPostId());
                    if (post != null) {
                        post.addComment(comments[i]);
                    }
                }
            }
            
            System.out.println("");
            
            //mostrar todos los post del usuario con id: 1
            Usuario u = Usuario.getUsuario(usuarios, 1, app.noHijos);
            posts = u.getPosts();
            System.out.println("Todos los post del usuario con id: 1");
            for (int i = 0; i < posts.length; i++) {
                System.out.println(posts[i].getTitle());
            } 
            
            System.out.println(""); 
            //mostrar todos los comentarios del post con id: 3 del usuario con id:1
            Post p = Post.getPost(posts, 3 , posts.length);
            comments = p.getComments();
            System.out.println("Todos los comentarios del post con id:3 del usuario con id: 1");
            for (int i = 0; i < comments.length; i++) {
                System.out.println(comments[i].getName());
            }
            
            System.out.println("");
            // mostrar todos los posts
            System.out.println("Mostrar todos los posts");
            for (int i = 0; i < app.users.length; i++) {
                posts = app.users[i].getPosts();
                for (int j = 0; j < posts.length; j++) {
                    System.out.println(posts[j].getTitle());
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(LoremRed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
