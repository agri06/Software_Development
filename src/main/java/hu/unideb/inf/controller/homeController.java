package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void exitbuttonpushed(ActionEvent event) {
        int a = JOptionPane.showConfirmDialog(null,"Do you really want to exit","select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            System.exit(0);
        }

    }
    @FXML
    public void enterbuttonpushed(ActionEvent event) {
        StageHelper.setScene("/fxml/FXMLStudentsScene.fxml","Admin Log In");
    }
}
