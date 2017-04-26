package gui.custom.explorer.tabcontent;

import gui.Main;
import gui.controllers.MainController;
import gui.custom.mapview.graphics.MapLine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import model.Point;
import model.Production;
import model.Station;
import model.XlsLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import sun.security.krb5.internal.crypto.Des;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Класс контроллера содержимого вкладки</p>
 */
public class TabContent extends VBox {

    /**
     * Представление списка загруженных объектов
     */
    @FXML
    ListView listView;

    public enum Destination{
        Production,
        Station
    }

    /**
     * Назначение текущей вкладки
     * - хранение производств/станций/etc.
     */
    private Destination destination;
    public Destination getDestination(){
        return destination;
    }
    public void setDestination(Destination destination){
        this.destination=destination;
    }

    /**
     * Конструктор, реализующий механизм связи с .fxml
     */
    public TabContent() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("custom/explorer/tabcontent/tabcontent.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void bindListView(){

    }

    int currMapLineID=0;
    /**
     * Обработчик нажатия на кнопку "Загрузить"
     *
     * @param actionEvent
     */
    public void loadFromXlsx(ActionEvent actionEvent) {
        MainController maincontroller = ((FXMLLoader) this.getScene().getUserData()).getController();
        ////
        FileChooser fileChooser = new FileChooser();
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("excell files", XlsLoader.FILE_EXTENSION_2, XlsLoader.FILE_EXTENSION_1));
        Window mainWindow = this.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(mainWindow);
        if (selectedFile != null) {
            try {
                XlsLoader xlsLoader = new XlsLoader(selectedFile);
                listView.getItems().clear();
                List objects;
                if(destination==Destination.Production){
                    objects = xlsLoader.readProductions();
                } else if (destination==Destination.Station){
                    objects = xlsLoader.readStations();
                } else throw new IOException("Назначение " + destination.toString() + " пока не поддерживается");
                ObservableList listViewList = listView.getItems();
                for(Object obj : objects){
                    if(destination==Destination.Production){
                        Production prod = (Production)obj;
                        listViewList.add(prod);
                        //mapview:
                        Point p1 = new Point(prod.getLatitude(),prod.getLongitude());
                        Point p2 = new Point(prod.getLatitude()+0.00001,prod.getLongitude()+0.00001);
                        MapLine mapline = new MapLine(p1,p2,"#FFA500",4);
                        maincontroller.getMapView().addLine(mapline);
                        maincontroller.getMapView().showLine(currMapLineID++);
                    } else if (destination==Destination.Station){
                        Station sta = (Station)obj;
                        listViewList.add(sta);
                        //mapview:
                        Point p1 = new Point(sta.getLatitude(),sta.getLongitude());
                        Point p2 = new Point(sta.getLatitude()+0.00001,sta.getLongitude()+0.00001);
                        MapLine mapline = new MapLine(p1,p2,"#FFA500",4);
                        maincontroller.getMapView().addLine(mapline);
                        maincontroller.getMapView().showLine(currMapLineID++);
                    }

                }
                /*ObservableList objectsObs = FXCollections.observableList(objects);
                listView.setItems(objectsObs);*/
            } catch (IOException | InvalidFormatException e) {
                e.printStackTrace();
            }
        }
    }
}