package hu.unideb.inf.controller;

import hu.unideb.inf.model.AdminData;
import hu.unideb.inf.model.AdminDataDAOInterface;
import hu.unideb.inf.model.AdminDataManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class forgotController implements Initializable {

    Alert warn = new Alert(Alert.AlertType.ERROR);
    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);

    AdminDataDAOInterface dataManager = new AdminDataManager();

    @FXML
    public TextField usernameTextBox;

    @FXML
    public TextField adminIdTextBox;

    @FXML
    public TextField newPasswordTextBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void onbackbutton(ActionEvent event) {
        StageHelper.setScene("/fxml/FXMLStudentsScene.fxml","Admin Login");
    }

    public void saveButtonClicked(ActionEvent actionEvent) {
        if(usernameTextBox.getText().equals("")){
            warn.setContentText("Username can't be empty!");
            warn.showAndWait();
            return;
        }

        if(adminIdTextBox.getText().equals("")){
            warn.setContentText("AdminId can't be empty!");
            warn.showAndWait();
            return;
        }

        if(newPasswordTextBox.getText().equals("")){
            warn.setContentText("new Password can't be empty!");
            warn.showAndWait();
            return;
        }

        List<AdminData> adminDataList = dataManager.getAllData();

        boolean flag = false;
        for (AdminData data: adminDataList) {
            if(data.getUsername().equals(usernameTextBox.getText())){
                if(adminIdTextBox.getText().equals("lol")){
                    AdminData updatedData = new AdminData();
                    updatedData.setId(data.getId());
                    updatedData.setUsername(data.getUsername());
                    updatedData.setEmailAddress(data.getEmailAddress());
                    updatedData.setPassword(newPasswordTextBox.getText());
                    dataManager.updateAdminData(updatedData);
                }
                else{
                    warn.setContentText("Admin Id incorrect, Please try again!");
                    warn.showAndWait();
                    return;
                }
                flag = true;
            }
            if (flag){
                break;
            }
        }
        if(!flag){
            warn.setContentText("Username not found, Please try again!");
            warn.showAndWait();
            return;
        }
        else{
            confirm.setContentText("Password updated successfully!");
            confirm.showAndWait();
            StageHelper.setScene("/fxml/FXMLStudentsScene.fxml","Admin Login");
        }
    }
}
