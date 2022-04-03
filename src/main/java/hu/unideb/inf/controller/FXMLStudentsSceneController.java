/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hu.unideb.inf.MainApp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kocsisg
 */
public class FXMLStudentsSceneController implements Initializable {

    public TextField userIDTextField;
    public PasswordField passwordField;

    private String username = "ashish";
    private String password = "abcd";

    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    Alert error = new Alert(Alert.AlertType.ERROR);
    private ActionEvent event;
    private Stage stage;


    @FXML
    void handleButtonPushed(ActionEvent event) {
        if(userIDTextField.getText().equals(username)){
            if(passwordField.getText().equals(password)){
                confirm.setContentText("Login is successful");
                confirm.show();
            }else{
                error.setContentText("Password was incorrect!");
                error.show();
            }
        }else{
            error.setContentText("Username was incorrect!");
            error.show();
        }

    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handlepasswordPushed(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/forgot.fxml"));

    }
}
