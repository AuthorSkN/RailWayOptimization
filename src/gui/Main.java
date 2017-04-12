package gui;

import gui.custom.controllers.Explorer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Окно авторизации");

        Explorer exp = new Explorer();


        Parent root = FXMLLoader.load(getClass().getResource("scenes/authorization.fxml"));
        //primaryStage.setScene(new Scene(root, 320,160));
        primaryStage.setScene(new Scene(exp));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
