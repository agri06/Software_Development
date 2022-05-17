package hu.unideb.inf.controller;

import hu.unideb.inf.model.CustomerData;
import hu.unideb.inf.model.CustomerDataDAOInterface;
import hu.unideb.inf.model.CustomerDataManager;
import hu.unideb.inf.model.RoomData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CustomercheckoutController implements Initializable {

    public TextField customerNameTextBox;
    public TableView customerTableView;
    public TableColumn<CustomerData, String> idTableColumn;
    public TableColumn<CustomerData, String> nameTableColumn;
    public TableColumn<CustomerData, String> nationalityTableColumn;
    public TableColumn<CustomerData, String> genderTableColumn;
    public TableColumn<CustomerData, String> emailTableColumn;
    public TableColumn<CustomerData, String> idProofTableColumn;
    public TableColumn<CustomerData, String> addressTableColumn;
    public TableColumn<CustomerData, String> checkInDateTableColumn;
    public TableColumn<CustomerData, String> numberOfDaysTableColumn;
    public TableColumn<CustomerData, String> roomNumberTableColumn;
    public TableColumn<CustomerData, String> petTagTableColumn;
    public TableColumn<CustomerData, String> priceTableColumn;
    public TextField customerIdTextBox;

    CustomerDataDAOInterface customerDataManager = new CustomerDataManager();
    ObservableList<CustomerData> customerDataObservableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        nationalityTableColumn.setCellValueFactory(new PropertyValueFactory<>("Nationality"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
        idProofTableColumn.setCellValueFactory(new PropertyValueFactory<>("IdProof"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        checkInDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("checkInDate"));
        numberOfDaysTableColumn.setCellValueFactory(new PropertyValueFactory<>("NumberOfDays"));
        roomNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("RoomNumber"));
        petTagTableColumn.setCellValueFactory(new PropertyValueFactory<>("PetTag"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

        customerDataObservableList = FXCollections.observableArrayList(customerDataManager.getAllCustomerData());
        customerTableView.setItems(customerDataObservableList);
    }

    public void checkOutButtonClicked(ActionEvent actionEvent) {
        //get customerId, Generate bill in billDataBase
    }

    @FXML
    public void handlepushed(ActionEvent event) {
        int a = JOptionPane.showConfirmDialog(null,"Want to go Back?","select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            StageHelper.setScene("/fxml/adminpage.fxml","Admin Page");
        }


    }

    public void clearButtonClicked(ActionEvent actionEvent) {
    }


    public void searchButtonClicked(ActionEvent actionEvent) {
        List<CustomerData> customerDataList = customerDataManager.getAllCustomerData();
        List<CustomerData> newList = customerDataList.stream()
                .filter(customerData -> customerData.getName().equals(customerNameTextBox))
                .collect(Collectors.toList());

        customerDataObservableList = FXCollections.observableArrayList(newList);
        customerTableView.setItems(customerDataObservableList);
    }
}
