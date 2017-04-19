package gui.controllers;

import gui.Main;
import gui.custom.mapview.MapView;
import gui.custom.mapview.graphics.MapLine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.Point;

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
    MapView mapView;

    /**
     * <p>Обработчик события нажатия кнопки показа</p>
     */
    public void onClickShow(ActionEvent actionEvent) {
        if(mapView.getListLine().size() > 0){
            mapView.showLine(0);
        }else{
            MapLine l = new MapLine(new Point(56.1061136, 40.37346183),
                    new Point(56.226410,40.61104117), "#FF00FF", 4);
            mapView.addLine(l);
        }
    }

    /**
     * <p>Обработчик события нажатия кнопки скрытия</p>
     */
    public void onClickHide(ActionEvent actionEvent) {
        if(mapView.getListLine().size() > 0)
            mapView.hideLine(0);
    }
}