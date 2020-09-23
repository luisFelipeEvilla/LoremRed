/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import loremred.Comment;
import loremred.Post;
import loremred.Usuario;
import utils.CustomList.Lista;
import utils.CustomList.Nodo;

/**
 *
 * @author luisf
 */
public class Utils {

    private static final String APIURL = "https://jsonplaceholder.typicode.com";

    public static void fetchData(String url, String path) throws IOException {
        // realiza la  peticion a la api
        URL api = new URL(url);
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) api.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();

        // si la api responde manera correcta
        if (responseCode == HttpURLConnection.HTTP_OK) {

            // se guarda la informacion que envio la api en forma de StringBuffer
            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine + '\n');
            }
            in.close();

            //Se guarda la información en un fichero
            FileWriter fichero = new FileWriter(path);
            fichero.append(response.toString());
            fichero.close();
        } else {
            System.out.println("Error al realizar la petición a la API");
        }
    }

    public static Lista<Usuario> saveData() throws IOException {

        fetchData(APIURL + "/users", "C:/Users/Public/Documents/users.txt");
        fetchData(APIURL + "/posts", "C:/Users/Public/Documents/posts.txt");
        fetchData(APIURL + "/comments", "C:/Users/Public/Documents/comments.txt");

        Lista<Usuario> usuarios = Usuario.destructuring(JsonParser("C:/Users/Public/Documents/users.txt"));
        Nodo<Usuario> u;

        Lista<Post> posts = Post.destructuring(Utils.JsonParser("C:/Users/Public/Documents/posts.txt"));
        Nodo<Post> p = posts.getRaiz();
        int userId;
        while (p != null) {
            userId = p.getDat().getUserId();
            u = usuarios.getNodo(userId);
            u.getDat().addPost(p.getId(), p.getDat());
            p = p.getDer();
        }

        Lista<Comment> comentarios = Comment.destructuring(Utils.JsonParser("C:/Users/Public/Documents/comments.txt"));
        Nodo<Comment> c = comentarios.getRaiz();
        u = usuarios.getRaiz();
        p = u.getDat().getPosts().getRaiz();

        int postId;
        boolean sw = true;

        while (c != null) {
            postId = c.getDat().getPostId();

            while (u != null && sw) {
                p = u.getDat().getPosts().getRaiz();

                while (p != null && p.getId() != postId) {
                    p = p.getDer();
                }

                if (p != null) {
                    p.getDat().addComment(c.getId(), c.getDat());
                }

                u = u.getDer();
            }
            u = usuarios.getRaiz();
            c = c.getDer();
        }
        return usuarios;
    }

    public static String[] JsonParser(String path) {
        File inputFile = new File(path);
        StringBuffer json = new StringBuffer();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            int line = 0;

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // se eliminan los caracteres '[' y ']' al inicio y final del archivo
                if (!currentLine.trim().equals("[") && !currentLine.trim().equals("]")) {
                    json.append(currentLine.trim() + "\n");
                } else {
                    continue;
                }
            }
            reader.close();

            String[] atributos = json.toString().split("\n");

            for (int i = 0; i < atributos.length; i++) {
                if (atributos[i].split(":").length > 1) {
                    String valor = atributos[i].split(":")[1].trim();
                    atributos[i] = valor.substring(0, valor.length() - 1);
                }

            }
            return atributos;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
