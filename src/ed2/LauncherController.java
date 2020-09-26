/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2;

import Screens.Home;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import loremred.LoremRed;
import utils.CustomList.Nodo;

/**
 * FXML Controller class
 *
 * @author Juan Camilo
 */
public class LauncherController implements Initializable {

    @FXML
    private GridPane gridPane;
    @FXML
    private Hyperlink hipIniciaSesion;
    @FXML
    private Hyperlink hipRegistrate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        animacionInicio();
    }

    @FXML
    private void hipIniciaSesion(ActionEvent event) {
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(gridPane.layoutXProperty(), -400, Interpolator.EASE_OUT);
        KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    @FXML
    private void hipRegistrate(ActionEvent event) {
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(gridPane.layoutXProperty(), 0, Interpolator.EASE_OUT);
        KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    private void animacionInicio() {
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(gridPane.getColumnConstraints().get(1).prefWidthProperty(), 400, Interpolator.EASE_OUT);
        KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    @FXML
    private void botIniciarSesion(ActionEvent event) {
        Nodo raiz = new Nodo(0, "LoremRed");
        raiz.addHijo(LoremRed.usuarios);
        System.out.println(LoremRed.usuarios.getInfo());
        Home ui = new Home(raiz);
        ui.setVisible(true);
    }

}
