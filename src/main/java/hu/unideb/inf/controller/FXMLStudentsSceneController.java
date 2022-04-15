/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import hu.unideb.inf.model.AdminData;
import hu.unideb.inf.model.AdminDataManager;
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
    public AdminDataManager adminDataManager = new AdminDataManager();

    private String username = "ashish";
    private String password = "abcd";

    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    Alert error = new Alert(Alert.AlertType.ERROR);
    private ActionEvent event;
    private Stage stage;


    @FXML
    void handleButtonPushed(ActionEvent event) {

        List<AdminData> adminDataList = adminDataManager.getAllData();

        boolean usernameCheck = false;
        for (int i = 0; i < adminDataList.size(); i++) {
            if(adminDataList.get(i).getUsername().equals(userIDTextField.getText())){

                usernameCheck = true;

                if(adminDataList.get(i).getPassword().equals(passwordField.getText())){
                    confirm.setContentText("You've logged in successfully!");
                    confirm.showAndWait();
                    StageHelper.setScene("/fxml/adminpage.fxml","Welcome Admin");
                }
                else{
                    error.setContentText("You've entered incorrect password! Please try again!");
                    error.showAndWait();
                }

            }
        }
        if(!usernameCheck){
            error.setContentText("You've entered incorrect username, please try again!");
            error.showAndWait();
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
