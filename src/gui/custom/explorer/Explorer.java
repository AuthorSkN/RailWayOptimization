package gui.custom.explorer;

import gui.Main;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;

import java.io.IOException;

/**
 * <p>Класс контроллера обозревателя объектов</p>
 */
public class Explorer extends TabPane {

    /**
     * Конструктор, реализующий механизм связи с .fxml
     */
    public Explorer(){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("custom/explorer/explorer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}