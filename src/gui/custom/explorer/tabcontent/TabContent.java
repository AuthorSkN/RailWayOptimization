package gui.custom.explorer.tabcontent;

import gui.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import model.Production;
import model.XlsLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
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

    /**
     * Конструктор, реализующий механизм связи с .fxml
     */
    public TabContent(){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("custom/explorer/tabcontent/tabcontent.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Обработчик нажатия на кнопку "Загрузить"
     * @param actionEvent
     */
    public void loadFromXlsx(ActionEvent actionEvent){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("excell files", XlsLoader.FILE_EXTENSION_2,XlsLoader.FILE_EXTENSION_1));
        Window mainWindow = this.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(mainWindow);
        if(selectedFile!=null){
            try {
                XlsLoader xlsLoader = new XlsLoader(selectedFile);
                List<Production> prods = xlsLoader.readAll();

            } catch (IOException | InvalidFormatException e) {
                e.printStackTrace();
            }
        }
    }

}