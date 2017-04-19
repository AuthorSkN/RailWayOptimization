package gui.cstm.mapview;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;


/**
 * Графический компонент карты.
 * Предназначен для отображения карты и навигации по ней, добавления меток и геометрических фигур, с целью повышения информативности.
 * @author Складнев Н.С.
 */
public class MapView extends BorderPane {

    @FXML
    private WebView webView;
    private WebEngine webEngine;


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
            throw new RuntimeException(exception);
        }
    }
}



