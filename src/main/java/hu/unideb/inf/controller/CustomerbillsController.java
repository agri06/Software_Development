package hu.unideb.inf.controller;

import hu.unideb.inf.model.BillData;
import hu.unideb.inf.model.BillDataDAOInterface;
import hu.unideb.inf.model.BillDataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CustomerbillsController implements Initializable {

    Alert warn = new Alert(Alert.AlertType.WARNING);
    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);

    BillDataDAOInterface billDataManager = new BillDataManager();
    ObservableList<BillData> billDataObservableList;
    
    @FXML
    private TextField searchNameTextField;
    @FXML
    private TextField searchIdTextField;
    public TableView billTableView;
    public TableColumn<BillData, String> idTableColumn;
    public TableColumn<BillData, String> nameTableColumn;
    public TableColumn<BillData, String> idProofTableColumn;
    public TableColumn<BillData, String> addressTableColumn;
    public TableColumn<BillData, String> checkInDateTableColumn;
    public TableColumn<BillData, String> numberOfDaysTableColumn;
    public TableColumn<BillData, String> petTagTableColumn;
    public TableColumn<BillData, String> priceTableColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        idProofTableColumn.setCellValueFactory(new PropertyValueFactory<>("IdProof"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        checkInDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("CheckInDate"));
        numberOfDaysTableColumn.setCellValueFactory(new PropertyValueFactory<>("NumberOfDays"));
        petTagTableColumn.setCellValueFactory(new PropertyValueFactory<>("PetTag"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

        billDataObservableList = FXCollections.observableArrayList(billDataManager.getAllBillData());
        billTableView.setItems(billDataObservableList);
    }
    @FXML
    public void handlebutton(ActionEvent event) {
        int a = JOptionPane.showConfirmDialog(null,"Want to go Back?","select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            StageHelper.setScene("/fxml/adminpage.fxml","Admin Page");
        }
    }

    public void searchByNameButtonClicked(ActionEvent actionEvent) {
        List<BillData> bills = billDataManager.getAllBillData();
        List<BillData> newList = bills.stream()
                .filter(billData -> billData.getName().toLowerCase().startsWith(searchNameTextField.getText().toLowerCase()))
                .collect(Collectors.toList());

        billDataObservableList = FXCollections.observableArrayList(newList);
        billTableView.setItems(billDataObservableList);
    }

    public void searchByIdButtonClicked(ActionEvent actionEvent) {
        List<BillData> bills = billDataManager.getAllBillData();
        List<BillData> newList = bills.stream()
                .filter(billData -> billData.getId() == Integer.parseInt(searchIdTextField.getText()))
                .collect(Collectors.toList());

        billDataObservableList = FXCollections.observableArrayList(newList);
        billTableView.setItems(billDataObservableList);
    }
}
