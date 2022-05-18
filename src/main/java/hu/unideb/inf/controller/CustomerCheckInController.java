package hu.unideb.inf.controller;

import hu.unideb.inf.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class CustomerCheckInController implements Initializable {
    CustomerDataDAOInterface customerDataManager = new CustomerDataManager();
    RoomDataDAOInterface roomDataManager = new RoomDataManager();
    Alert warn = new Alert(Alert.AlertType.WARNING);
    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    @FXML
    private ComboBox comb;
    @FXML
    private ComboBox combooo;
    @FXML
    private ComboBox Combo;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField mobileNumberTextField;
    @FXML
    private TextField nationalityTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField idProofTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField checkInDateTextField;
    @FXML
    private TextField numberOfDaysTextField;
    @FXML
    private TextField roomNumberTextField;
    @FXML
    private TextField petTagTextField;
    @FXML
    private TextField priceTextField;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("Male","Female","Others");
        comb.setItems(list);
    }

    public void allotRoomButtonClicked(ActionEvent actionEvent) {
        CustomerData customerData = new CustomerData();
        customerData.setName(nameTextField.getText());
        customerData.setMobileNumber(mobileNumberTextField.getText());
        customerData.setNationality(nationalityTextField.getText());
        customerData.setGender(comb.getSelectionModel().getSelectedItem().toString());
        customerData.setEmail(emailTextField.getText());
        customerData.setIdProof(idProofTextField.getText());
        customerData.setAddress(addressTextField.getText());
        customerData.setCheckInDate(checkInDateTextField.getText());
        customerData.setNumberOfDays(numberOfDaysTextField.getText());
        customerData.setRoomNumber(roomNumberTextField.getText());
        customerData.setPetTag(petTagTextField.getText());
        customerData.setPrice(priceTextField.getText());

        customerDataManager.setCustomerData(customerData);
        List<RoomData> rooms =roomDataManager.getAllRoomData();

        for (RoomData room: rooms) {
            if(room.getRoomNo().equals(roomNumberTextField.getText())){
                if(room.getStatus().equals("AVAILABLE")) {
                    room.setStatus("BOOKED");
                    roomDataManager.setRoomData(room);
                }
                else{
                    warn.setContentText("Please choose an available Room!");
                    warn.showAndWait();
                }
                break;
            }
        }

        confirm.setContentText("Room Allotment Successful!");
        confirm.showAndWait();
        StageHelper.setScene("/fxml/adminpage.fxml","Admin Page");

    }

    public void getEstimatedPriceButtonClicked(ActionEvent actionEvent) {
        if(roomNumberTextField.getText().equals(null)){
            warn.setContentText("Please enter correct room number!");
            warn.showAndWait();
            return;
        }

        if(numberOfDaysTextField.getText().equals(null)){
            warn.setContentText("Please enter correct number of days!");
            warn.showAndWait();
            return;
        }

        List<RoomData> rooms = roomDataManager.getAllRoomData();
        for (RoomData room: rooms) {
            if(room.getRoomNo().equals(roomNumberTextField.getText())){
                int price = Integer.parseInt(room.getPrice())*Integer.parseInt(numberOfDaysTextField.getText());
                if (!petTagTextField.getText().equals("") && !petTagTextField.getText().toLowerCase().equals("null")) {
                    price += 2000;
                }
                priceTextField.setText(price+"");
                break;
            }
        }
    }

    public void clearButtonClicked(ActionEvent actionEvent) {
        nameTextField.setText("");
        mobileNumberTextField.setText("");
        nationalityTextField.setText("");
        emailTextField.setText("");
        idProofTextField.setText("");
        addressTextField.setText("");
        checkInDateTextField.setText("");
        numberOfDaysTextField.setText("");
        roomNumberTextField.setText("");
        petTagTextField.setText("");
        priceTextField.setText("");
    }

    @FXML
    public void backbuttonpushed(ActionEvent event) {
        int a = JOptionPane.showConfirmDialog(null,"Want to go Back?","select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            StageHelper.setScene("/fxml/adminpage.fxml","Admin Page");
        }

        try {
            customerDataManager.close();
            roomDataManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void ComboButtonPushed(ActionEvent event) {
    }

    public void combooobutton(ActionEvent actionEvent) {
    }

    @FXML
    public void select(javafx.event.ActionEvent event) {
    }
}
