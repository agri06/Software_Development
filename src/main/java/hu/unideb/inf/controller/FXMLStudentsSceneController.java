/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kocsisg
 */
public class FXMLStudentsSceneController {

    public TextField userIDTextField;
    public PasswordField passwordField;

    private String username = "ashish";
    private String password = "abcd";

    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    Alert error = new Alert(Alert.AlertType.ERROR);



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
    @FXML
    void handlepasswordPushed() {

    
    }


}
