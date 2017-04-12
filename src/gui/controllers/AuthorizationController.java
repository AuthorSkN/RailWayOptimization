package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * <p>Класс контроллера окна авторизации</p>
 */
public class AuthorizationController {

    /**
     * <p>Радиобаттон авторизации как администратора</p>
     */
    @FXML
    RadioButton likeAdminRadio;
    /**
     * <p>Радиобаттон авторизации как пользователя</p>
     */
    @FXML
    RadioButton likeUserRadio;
    /**
     * <p>Поле ввода пароля для входа администратора</p>
     */
    @FXML
    TextField textFieldPass;
    /**
     * <p>Надпись ошибки авторизации (невидима по умолчанию)</p>
     */
    @FXML
    Label labelError;

    /**
     * <p>Просто пароль здесь. Скорее всего надо будет убрать это отсюда</p>
     */
    private static String password = "123";

    /**
     * <p>Обработчик события чека радиобаттона входа как пользователя</p>
     */
    public void onLikeUserChecked(ActionEvent actionEvent) {
        textFieldPass.setDisable(true);
    }

    /**
     * <p>Обработчик события чека радиобаттона входа как администратора</p>
     */
    public void onLikeAdminChecked(ActionEvent actionEvent) {
        textFieldPass.setDisable(false);
    }

    /**
     * <p>Обработчик события нажатия кнопки входа</p>
     */
    public void onEnterPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) textFieldPass.getScene().getWindow();
        if(likeUserRadio.isSelected()){
            MainController.sceneShow(false,stage);
        } else if (likeAdminRadio.isSelected()){
            if (textFieldPass.getText().equals(password)){
                MainController.sceneShow(true,stage);
            } else labelError.setVisible(true);
        }
    }

    /**
     * <p>Обработчик события нажатия кнопки выхода</p>
     */
    public void onExitPressed(ActionEvent actionEvent) {
        stageClose();
    }

    /**
     * <p>Метод закрытия текущего стейджа</p>
     */
    private void stageClose(){
        Stage stage = (Stage) textFieldPass.getScene().getWindow();
        stage.close();
    }
}