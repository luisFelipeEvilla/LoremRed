/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loremred;

/**
 *
 * @author luisf
 */
public class Comment {

    private int id;
    private static int idGen = 1;
    private static Comment[] hijosNuevos;
    private int postId;
    private String name;
    private String email;
    private String body;
    private Usuario user;

    public Comment(int idPost, String name, String email, String body) {
        this.id = idGen++;
        this.postId = idPost;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public static Comment[] addComment(Comment[] hijos, Comment hijoNuevo, int noHijos) {
        hijosNuevos = new Comment[noHijos + 1];

        for (int i = 0; i < noHijos; i++) {
            hijosNuevos[i] = hijos[i];
        }

        hijosNuevos[noHijos] = hijoNuevo;
        System.out.println("Comentario añadido satisfactoriamente");
        return hijosNuevos;
    }

    public static Comment[] removeComment(Comment[] hijos, int id, int noHijos) {
        int index = buscarComentario(hijos, id, noHijos);
        hijosNuevos = new Comment[noHijos - 1];

        for (int i = 0; i < noHijos - 1; i++) {
            if (i < index) {
                hijosNuevos[i] = hijos[i];
            } else {
                hijosNuevos[i] = hijos[i + 1];
            }
        }

        System.out.println("usuario " + hijos[index].getBody()+ " removido satisfactoriamente");

        return hijosNuevos;
    }

    public static int buscarComentario(Comment[] hijos, int id, int noHijos) {
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

    public int getId() {
        return id;
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
