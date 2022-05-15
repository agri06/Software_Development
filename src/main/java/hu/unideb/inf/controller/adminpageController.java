package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static hu.unideb.inf.MainApp.startDatabase;
import static hu.unideb.inf.MainApp.stopDatabase;

public class adminpageController implements Initializable {





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void logoutbuttonpushed(ActionEvent event) {
        int a = JOptionPane.showConfirmDialog(null,"Do you really want to logout","select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            StageHelper.setScene("/fxml/FXMLStudentsScene.fxml","Hotel Management");
        }
    }
    @FXML
    public void exitbuttonpushed(ActionEvent event) throws SQLException {

        startDatabase();
        int a = JOptionPane.showConfirmDialog(null,"Do you really want to exit","select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            System.exit(0);
        }
        stopDatabase();
    }
    @FXML
    public void managebuttonpushed(ActionEvent event) {
        StageHelper.setScene("/fxml/Managerooms.fxml","Manage Rooms");
    }

    public void buttonpushed(ActionEvent event) {

        StageHelper.setScene("/fxml/CustomerCheckIn.fxml","Customer Check In");
    }
    @FXML
    public void handlepushed(ActionEvent event) {

            StageHelper.setScene("/fxml/Customercheckout.fxml","Customer Check Out");




    }
    @FXML
    public void handlebutton(ActionEvent event) {
        StageHelper.setScene("/fxml/Customerbills.fxml","Customer Bill Details");
    }
}

