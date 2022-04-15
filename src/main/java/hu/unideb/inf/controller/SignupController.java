package hu.unideb.inf.controller;

import hu.unideb.inf.model.AdminData;
import hu.unideb.inf.model.AdminDataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class SignupController implements Initializable {

    AdminDataManager adminDataManager = new AdminDataManager();
    Alert keyError = new Alert(Alert.AlertType.ERROR);
    Alert signupSuccessful = new Alert(Alert.AlertType.CONFIRMATION);
    @FXML
    private TextField emailfield;

    @FXML
    private TextField keyfeild;

    @FXML
    private PasswordField passwordfeild;

    @FXML
    private TextField usernamefield;

    @java.lang.Override
    public void initialize(java.net.URL url, java.util.ResourceBundle resourceBundle) {

    }
    @FXML
    public void savebuttonpushed(ActionEvent event) {
        if(keyfeild.getText().equals("lol")){
            AdminData adminData = new AdminData();
            adminData.setUsername(usernamefield.getText());
            adminData.setEmailAddress(emailfield.getText());
            adminData.setPassword(passwordfeild.getText());

            adminDataManager.setAdminData(adminData);
            signupSuccessful.setContentText("Signup was successful!");
            signupSuccessful.showAndWait();
            StageHelper.setScene("/fxml/FXMLStudentsScene.fxml","Admin Log In");;
        }
        else{
            keyError.setContentText("You have Entered A wrong key! Please try again!");
            keyError.show();
        }
    }
}
