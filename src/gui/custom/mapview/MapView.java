package gui.custom.mapview;

import gui.custom.mapview.graphics.MapLine;
import gui.custom.mapview.graphics.MapPoint;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.Point;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Графический компонент карты.</p>
 * <p>Предназначен для отображения карты и навигации по ней, добавления меток и геометрических фигур, с целью повышения информативности.</p>
 * @author Складнев Н.С.
 */
public class MapView extends BorderPane {

    @FXML
    private WebView webView;
    private WebEngine webEngine;

    private List<MapLine> listLine = new ArrayList<>();
    private List<MapPoint> listPoint = new ArrayList<>();


    /**
     * <p>Графический компонент карты, способный отображать графические приметивы и метки.</p>
     */
    public MapView() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mapview.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
            webEngine = this.webView.getEngine();
            webEngine.load(this.getClass().getResource("web/map.html").toExternalForm());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    /**
     * <p>Возвращяет все линии на карте</p>
     * @return список линий карты
     */
    public List<MapLine> getListLine() {
        return listLine;
    }

    /**
     * <p>Изменяет список линий карты</p>
     * @param listLine список линий
     */
    public void setListLine(List<MapLine> listLine) {
        this.listLine = listLine;
    }

    /**
     * <p>Добавляет линию на карту</p>
     * @param line
     */
    public void addLine(MapLine line){
        listLine.add(line);
        JSObject win = (JSObject)webEngine.executeScript("window");
        win.call("addLine", line);
    }

    public void addPoint(MapPoint point){
        listPoint.add(point);
        JSObject win = (JSObject)webEngine.executeScript("window");
        win.call("addPoint", point);
    }

    public void showLine(int id){
        if(id < listLine.size()) {
            JSObject win = (JSObject)webEngine.executeScript("window");
            win.call("showLine", id);
        }
    }

    public void hideLine(int id){
        if(id < listLine.size()) {
            JSObject win = (JSObject)webEngine.executeScript("window");
            win.call("hideLine", id);
        }
    }

    public void clustering(){
        JSObject win = (JSObject)webEngine.executeScript("window");
        win.call("clustering");
    }

}



