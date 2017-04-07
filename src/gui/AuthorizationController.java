package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthorizationController {

    @FXML
    RadioButton likeAdminRadio;
    @FXML
    RadioButton likeUserRadio;
    @FXML
    TextField textFieldPass;
    @FXML
    Label labelError;

    private static String password = "123";

    public void onLikeUserChecked(ActionEvent actionEvent) {
        textFieldPass.setDisable(true);
    }

    public void onLikeAdminChecked(ActionEvent actionEvent) {
        textFieldPass.setDisable(false);
    }

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

    public void onExitPressed(ActionEvent actionEvent) {
        stageClose();
    }

    private void stageClose(){
        Stage stage = (Stage) textFieldPass.getScene().getWindow();
        stage.close();
    }
}