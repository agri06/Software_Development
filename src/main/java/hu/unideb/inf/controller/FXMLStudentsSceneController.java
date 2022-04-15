/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author kocsisg
 */
public class FXMLStudentsSceneController implements Initializable {

    public TextField userIDTextField;
    public PasswordField passwordField;
    public CheckBox button4;

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
               // confirm.setContentText("Login is successful");
                StageHelper.setScene("/fxml/adminpage.fxml","Welcome Admin");
               // confirm.show();


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
    @FXML
    public void handlepasswordPushed(ActionEvent actionEvent) throws IOException{
        StageHelper.setScene("/fxml/forgot.fxml", "Forgot password");
    }

    @FXML
    public void buttonpushed(ActionEvent event) {
        int a = JOptionPane.showConfirmDialog(null,"Do you really want to exit","select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            System.exit(0);
        }

    }
    @FXML
    public void buttonpressed(ActionEvent event) {
        if(button4.isSelected()){
            passwordField.setVisible(false);


        }
        else{
            passwordField.setVisible(true);
        }

    }
    @FXML
    public void signbuttonpushed(ActionEvent event) {
        StageHelper.setScene("/fxml/signup.fxml","Sign Up");
    }
}
