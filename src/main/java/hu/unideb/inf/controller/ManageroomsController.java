package hu.unideb.inf.controller;

import hu.unideb.inf.RoomAndCustomers.ManageRoomTable;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class ManageroomsController implements Initializable {

    @FXML
    public TableView roomTableView;

    @FXML
    public TableColumn<ManageRoomTable, String> roomNoTableColumn;

    @FXML
    public TableColumn<ManageRoomTable, String> roomTypeTableColumn;
    @FXML
    public TableColumn<ManageRoomTable, String> bedTableColumn;
    @FXML
    public TableColumn<ManageRoomTable, String> priceTableColumn;
    @FXML
    public TableColumn<ManageRoomTable, String> statusTableColumn;
    @FXML
    private ComboBox combo;

    @FXML
    void select(ActionEvent event) {
        String s = combo.getSelectionModel().getSelectedItem().toString();
        JLabel.setDefaultLocale(Locale.forLanguageTag(s));

    }

    @FXML
    void cselect(ActionEvent event) {
        String a = combo.getSelectionModel().getSelectedItem().toString();
        JLabel.setDefaultLocale(Locale.forLanguageTag(a));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("AC","Non-AC");
        combo.setItems(list);

        ObservableList<String> list1 = FXCollections.observableArrayList("Single","Double","Triple");
        combo.setItems(list1);

        roomNoTableColumn.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
        roomTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("RoomType"));
        bedTableColumn.setCellValueFactory(new PropertyValueFactory<>("Bed"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
    }
    @FXML
    public void backbuttonpushed(ActionEvent event) {
        int a = JOptionPane.showConfirmDialog(null,"Want to go Back?","select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            StageHelper.setScene("/fxml/adminpage.fxml","Admin Page");
        }

    }

    public void onSearchRoom(ActionEvent actionEvent) {
        roomTableView.setItems(manageRoomTableObservableList);
        
    }

    private ObservableList<ManageRoomTable> manageRoomTableObservableList = FXCollections.observableArrayList(
            new ManageRoomTable("101","AC","3","400","booked")
            );
}
