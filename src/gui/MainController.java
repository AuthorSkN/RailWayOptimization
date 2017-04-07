package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by alexUnder on 07.04.2017.
 */
public class MainController {
    public static void sceneShow(boolean asAdmin, Stage showOn) {
        try{
        Parent root = FXMLLoader.load(Main.class.getResource("main.fxml"));
        showOn.setTitle("Rail-BRO-ad");
        showOn.setScene(new Scene(root, 1000, 700));
        showOn.show();
        } catch(IOException exc){
            JOptionPane.showMessageDialog(null,"IO exception occured while showing scene:\n" + exc.getMessage());
        }
    }

    @FXML
    Button buttonShow;
    @FXML
    Button buttonHide;
    @FXML
    WebView webView;



    public void onClickShow(ActionEvent actionEvent) {
        WebEngine engine = webView.getEngine();
        engine.loadContent("poka nichego net(9");
    }

    public void onClickHide(ActionEvent actionEvent) {
        WebEngine engine = webView.getEngine();
        engine.loadContent("");
    }
}
