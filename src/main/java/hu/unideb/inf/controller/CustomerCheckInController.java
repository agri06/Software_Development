package hu.unideb.inf.controller;

import hu.unideb.inf.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
                room.setStatus("BOOKED");
                roomDataManager.setRoomData(room);
                break;
            }
        }

        StageHelper.setScene("/fxml/adminpage.fxml","Admin Page");

    }

    public void getEstimatedPriceButtonClicked(ActionEvent actionEvent) {
        List<RoomData> rooms = roomDataManager.getAllRoomData();
        for (RoomData room: rooms) {
            if(room.getRoomNo().equals(roomNumberTextField.getText())){
                priceTextField.setText(room.getPrice());
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
