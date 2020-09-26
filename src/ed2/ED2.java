/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import loremred.LoremRed;

/**
 *
 * @author Juan Camilo
 */
public class ED2 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setTitle("ED2");
        Parent root = FXMLLoader.load(getClass().getResource("Launcher.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        
        try {
            //Launcher launcher = new Launcher();
            //launcher.setVisible(true);
            LoremRed app = new LoremRed();
            LoremRed.usuarios = utils.Utils.saveData();
            //launcher.animar();
        } catch (IOException ex) {
            Logger.getLogger(LoremRed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
