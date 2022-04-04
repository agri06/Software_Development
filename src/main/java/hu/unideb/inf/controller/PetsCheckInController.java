package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PetsCheckInController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void buttonpushed(ActionEvent event) {
        StageHelper.setScene("/fxml/CustomerCheckIn.fxml","Customer Check In");
    }
}
