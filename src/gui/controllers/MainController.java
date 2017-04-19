package gui.controllers;

import gui.Main;
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
 * <p>Класс контроллера основного окна</p>
 */
public class MainController {

    /**
     * <p>Статический метод натягивания сцены на указанный стейдж</p>
     */
    public static void sceneShow(boolean asAdmin, Stage showOn) {
        try{
        Parent root = FXMLLoader.load(Main.class.getResource("scenes\\main.fxml"));
        showOn.setTitle("Rail-BRO-ad");
        showOn.setScene(new Scene(root, 1000, 700));
        showOn.show();
        } catch(IOException exc){
            JOptionPane.showMessageDialog(null,"IO exception occured while showing scene:\n" + exc.getMessage());
        }
    }

    /**
     * <p>Кнопка показа веб-представления на панели инструментов</p>
     */
    @FXML
    Button buttonShow;
    /**
     * <p>Кнопка скрытия веб-представления на панели инструментов</p>
     */
    @FXML
    Button buttonHide;
    /**
     * <p>Компонент веб-представления для отображения карты</p>
     */
    @FXML
    WebView webView;

    /**
     * <p>Обработчик события нажатия кнопки показа</p>
     */
    public void onClickShow(ActionEvent actionEvent) {
        WebEngine engine = webView.getEngine();
        engine.loadContent("poka nichego net(9");
    }

    /**
     * <p>Обработчик события нажатия кнопки скрытия</p>
     */
    public void onClickHide(ActionEvent actionEvent) {
        WebEngine engine = webView.getEngine();
        engine.loadContent("");
    }
}