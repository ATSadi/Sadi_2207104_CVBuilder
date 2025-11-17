package com.example.ahnafsadi_cvbuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label welcomeLabel;

    @FXML
    void onClickCreateCv(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("The CV form will be added in the next step.");
        alert.showAndWait();
    }
}
