package gui.custom.explorer.tabcontent;

import gui.Main;
import gui.controllers.MainController;
import gui.custom.mapview.MapView;
import gui.custom.mapview.graphics.MapPoint;
import gui.custom.mapview.graphics.MapPointStyle;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import model.Point;
import model.Production;
import model.XlsLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>Класс контроллера содержимого вкладки</p>
 */
public class TabContentProduction extends VBox {

    /**
     * Представление списка загруженных объектов
     */
    @FXML
    ListView<Production> listView;

    @FXML
    Label testLabel;

    /**
     * Конструктор, реализующий механизм связи с .fxml
     */
    public TabContentProduction() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("custom/explorer/tabcontent/tabcontentProduction.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
            prepareListView();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void prepareListView() {
        MultipleSelectionModel selectionModel = listView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        listView.setCellFactory(CheckBoxListCell.forListView(new Callback<Production, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(Production param) {
                boolean checkedValue = param.checkedProperty().getValue();

                return  param.checkedProperty();
            }
        }));
        //listView.setCellFactory(ComboBoxListCell.forListView(listView));
    }

    /**
     * Обработчик нажатия на кнопку "Загрузить"
     *
     * @param actionEvent
     */
    public void loadFromXlsx(ActionEvent actionEvent) {
        MapView mapView = getMapView();
        ////
        FileChooser fileChooser = new FileChooser();
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("excell files", XlsLoader.FILE_EXTENSION_2, XlsLoader.FILE_EXTENSION_1));
        File selectedFile = fileChooser.showOpenDialog(this.getScene().getWindow());
        if (selectedFile != null) {
            try {
                listView.getItems().clear();
                ObservableList<Production> listViewList = listView.getItems();
                XlsLoader xlsLoader = new XlsLoader(selectedFile);
                List<Production> prods = readProductions(xlsLoader);
                for (Production prod : prods) {
                    handleProduction(mapView, listViewList, prod);
                }
                //listView.getSelectionModel().selectAll();
                mapView.clustering();
            } catch (IOException | InvalidFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void testButton_click(ActionEvent actionEvent) {
        testLabel.setText("");
        ObservableList<Production> l = listView.getSelectionModel().getSelectedItems();
        for (Production prod : l) {
            //testLabel.setText(testLabel.getText() + " -<>- " + o.toString() + "\n");
            int preWeight = (int)prod.getWeight();
            int afterWeight = preWeight * 3;
            prod.setWeight(afterWeight);
            testLabel.setText("preweight:" + preWeight + "\nafterweight:" + afterWeight);
        }
    }

    private MapView getMapView(){
        MainController maincontroller = ((FXMLLoader) this.getScene().getUserData()).getController();
        return maincontroller.getMapView();
    }

    private void handleProduction(MapView mapView, ObservableList listViewList, Production prod) {
        Point p1;
        MapPoint mappoint;
        MapPointStyle style = new MapPointStyle(MapPointStyle.TRIANGLE, "#FFA500", "#FFFFFF");
        listViewList.add(prod);
        p1 = new Point(prod.getLatitude(), prod.getLongitude());
        mappoint = new MapPoint(p1, prod.getName(), style, 5);
        mapView.addPoint(mappoint);
    }

    private List<Production> readProductions(XlsLoader xlsLoader) throws IOException {
        List<Production> prods = xlsLoader.readProductions();
        return prods;
    }
}