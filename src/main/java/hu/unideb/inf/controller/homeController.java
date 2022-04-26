package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static hu.unideb.inf.MainApp.startDatabase;
import static hu.unideb.inf.MainApp.stopDatabase;

public class homeController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void exitbuttonpushed(ActionEvent event) throws SQLException {

        startDatabase();
        int a = JOptionPane.showConfirmDialog(null,"Do you really want to exit","select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            MainApp.stopDatabase();
            System.exit(0);
        }
       stopDatabase();
    }
    @FXML
    public void enterbuttonpushed(ActionEvent event) {
        StageHelper.setScene("/fxml/FXMLStudentsScene.fxml","Admin Log In");
    }
}
