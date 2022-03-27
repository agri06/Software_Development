/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.model.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author kocsisg
 */
public class FXMLStudentsSceneController {

    public TextField userIDTextField;
    public PasswordField passwordField;

    private String username = "pranay";
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
}
