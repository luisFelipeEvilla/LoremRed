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

/**
 *
 * @author luisf
 */
public class Utils {

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

            System.out.println("");
            System.out.println("");

            String[] atributos = json.toString().split("\n");
            
            for (int i = 0; i < atributos.length; i++) {
                if (atributos[i].split(":").length > 1) {
                    String valor = atributos[i].split(":")[1].trim();
                    atributos[i] = valor.substring(0, valor.length()-1);
                }
               
            }
            return atributos;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void ObjetosAAtributos(String objeto) {
        String[] atributos;

        atributos = objeto.split(",");
        /*
        for (int i = 0; i < atributos.length - 1; i++) {
            atributos[i] = atributos[i].split(": ")[1];
        }
        
        for (int i = 0; i < atributos.length - 1; i++) {
            System.out.println(atributos[i]);
        }
         */
    }
}
