/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import Interfaz.Launcher;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.CustomList.Lista;
import utils.Utils;

/**
 *
 * @author luisf
 */
public class LoremRed {

    public static void main(String[] args) {

        try {

            Launcher launcher = new Launcher();

            App app = App.getInstancia();
            String URL = app.getURL();

            Utils.fetchData(URL + "/users", "C:/Users/Public/Documents/users.txt");
            Utils.fetchData(URL + "/posts", "C:/Users/Public/Documents/posts.txt");
            Utils.fetchData(URL + "/comments", "C:/Users/Public/Documents/comments.txt");

            app.setUsuarios("C:/Users/Public/Documents/users.txt");

            Lista<Post> posts = Post.destructuring(Utils.JsonParser("C:/Users/Public/Documents/posts.txt"));
            for (int i = 0; i < posts.count(); i++) {
                Post post = posts.get(i);
                System.out.println(post.getTitle());
                app.getUsuario(post.getUserId()).addPost(post);
            }

            Lista<Comment> comentarios = Comment.destructuring(Utils.JsonParser("C:/Users/Public/Documents/comments.txt"));
            for (int i = 0; i < comentarios.count(); i++) {
                for (int j = 0; j < app.getUsuarios().count(); j++) {
                    Post post = app.getUsuarios().get(j).getPost(comentarios.get(i).getPostId());
                    if (post != null) {
                        post.addComment(comentarios.get(i));
                    }
                }
            }
            launcher.animar();

        } catch (IOException ex) {
            Logger.getLogger(LoremRed.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
