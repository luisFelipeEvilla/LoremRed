/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisf
 */
public class LoremRed {
    
    private Usuario[] users;
    private int noHijos = 0;
    private ArrayList<Comment> comments;
    private ArrayList<Post> posts;
    private static final String APIURL = "https://jsonplaceholder.typicode.com/users";

    public LoremRed() {
        this.users = new Usuario[20];
        this.posts = new ArrayList();
        this.comments = new ArrayList();
        
        this.users = new Usuario[noHijos];
        
        Adress ad = new Adress("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", new Geo( -37.3159, 81.1496));
        Company c = new Company("Romaguera-Crona", "Multi-layered client-server neural-net", "harness real-time e-markets");
        this.addUser(new Usuario("Leanne Graham", "Bret", "Sincere@april.biz", ad, "1-770-736-8031 x56442",  "hildegard.org", c));
        this.addUser(new Usuario("Leanne b", "Bret", "Sincere@april.biz", ad, "1-770-736-8031 x56442",  "hildegard.org", c));
        this.addUser(new Usuario("Leanne 3", "Bret", "Sincere@april.biz", ad, "1-770-736-8031 x56442",  "hildegard.org", c));
        System.out.println(users[0].getName());
        System.out.println(users[1].getName());
        System.out.println(users[2].getName());
        this.removeUser(1);
        // this.users.add(new User("Leanne Graham", "Bret", "Sincere@april.biz", ad, "1-770-736-8031 x56442",  "hildegard.org", c));
        
        System.out.println();
        
        this.users[0].addPost(new Post(1,"sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
        this.users[0].addPost(new Post(1,"22sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
        this.users[0].addPost(new Post(1,"33sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
        System.out.println(this.users[0].getPost(3).getTitle()); 
        System.out.println(this.users[0].getPost(2).getTitle()); 
        System.out.println(this.users[0].getPost(1).getTitle()); 
        
        System.out.println();
        
        this.users[0].getPost(3).addComment(new Comment(1, "id labore ex et quam laborum", "Eliseo@gardner.biz",  "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"));
        this.users[0].getPost(3).addComment(new Comment(2, "22id labore ex et quam laborum", "Eliseo@gardner.biz",  "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"));
        this.users[0].getPost(3).addComment(new Comment(3, "33id labore ex et quam laborum", "Eliseo@gardner.biz",  "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"));
        System.out.println("");
        System.out.println(this.users[0].getPost(3).getComentario(1).getBody()); 
        System.out.println("");
        System.out.println(this.users[0].getPost(3).getComentario(2).getBody()); 
        System.out.println("");
        System.out.println(this.users[0].getPost(3).getComentario(3).getBody()); 
    }
    

    
    public void addUser(Usuario user) {
        this.users = Usuario.addUsuario(users, user, noHijos);
        this.noHijos++;
    }
    
    public void removeUser(int id) {
        users = Usuario.removeUsuario(users, id, noHijos);
        noHijos--;
    }
    
    /*
     busca el indice en el cual se encuentra el usuario con el id suministrado
    */
    public int searchUser(int id) {
        int index = -1;
        int aux = -1;
        for (int i = 0; i < noHijos; i++) {
            aux ++;
            if (users[i].getId() == id) {
                    index = aux;
                    return index;
            }
        }
        
        return index;
    }

    public static void getRequest() throws IOException {
        URL api = new URL(APIURL);
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) api.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            // print result
            System.out.println(response);
            System.out.println("JSON String Result " + response.toString());
            //GetAndPost.POSTRequest(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoremRed app = new LoremRed();
    }

}
