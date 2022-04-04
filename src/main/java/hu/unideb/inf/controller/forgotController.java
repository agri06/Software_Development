package hu.unideb.inf.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class forgotController extends Application {
    @Override
    public void start(Stage stage) throws Exception {

    }
    @FXML
    public void onbackbutton(ActionEvent event) {
        StageHelper.setScene("/fxml/FXMLStudentsScene.fxml","Admin Login");
    }
}
