package gui.controllers;

import gui.Main;
import gui.custom.mapview.MapView;
import gui.custom.mapview.graphics.MapLine;
import gui.custom.mapview.graphics.MapPoint;
import gui.custom.mapview.graphics.MapPointStyle;
import gui.custom.mapview.graphics.MapPolyline;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    private List<Point> createPoints(){
        List<Point> res = new ArrayList<>();
        res.add(new Point(55.715477685918465,37.82481358714641));
        res.add(new Point(55.47843545024241,38.41055806292251));
        res.add(new Point(55.414427328052945,38.6522572816725));
        res.add(new Point(55.3268330154383,38.68796284807877));
        res.add(new Point(55.10069514468944,38.79233296526625));
        res.add(new Point(54.97608463240059,39.07111104143813));
        res.add(new Point(54.97424490393586,39.14343902930939));
        res.add(new Point(54.88013115271283,39.315100406262516));
        res.add(new Point(54.75085982740156,39.47440216407501));
        res.add(new Point(54.66024425659747,39.638144483547734));
        res.add(new Point(54.58454066266523,39.794699659328984));
        res.add(new Point(54.57337237817825,39.834525098782095));
        res.add(new Point(54.532823823124296,39.8733891304875));
        res.add(new Point(54.501664863790666,39.99423873986251));
        ///
        res.add(new Point(54.296540904671126,40.22769821251876));
        res.add(new Point(54.25957342242049,40.408972626581246));
        res.add(new Point(54.29332766356659,40.656165009393746));
        res.add(new Point(54.32785680702392,40.94180954064374));
        ///
        res.add(new Point(54.33531776590902,41.17375635041497));
        res.add(new Point(54.444741693608755,41.283048059068314));
        res.add(new Point(54.539874720046804,41.30364742430268));
        res.add(new Point(54.6817597554209,41.30639400633395));
        return res;
    }

    /**
     * <p>Обработчик события нажатия кнопки показа</p>
     */
    public void onClickShow(ActionEvent actionEvent) {
        if(mapView.getListLine().size() > 0){
            mapView.showLine(0);
        }else{
            MapPolyline l = new MapPolyline(createPoints(), "#7b68ee", 3);
            mapView.addLine(l);
            for(int i = 0; i < 900; i++){
                double rnd1 = Math.random();
                double rnd2 = Math.random();
                double lat = rnd1*9 + 52.0;
                double lng = rnd2*14 + 43.0;
                Point p = new Point(lat, lng);
                mapView.addPoint(new MapPoint(p, "Станция", new MapPointStyle(0), 2));
            }
            mapView.clustering();
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