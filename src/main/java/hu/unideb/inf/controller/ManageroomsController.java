package hu.unideb.inf.controller;

import hu.unideb.inf.model.RoomData;
import hu.unideb.inf.model.RoomDataDAOInterface;
import hu.unideb.inf.model.RoomDataManager;
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

    RoomDataDAOInterface rdm = new RoomDataManager();
    ObservableList<RoomData> roomDataObservableList;
    @FXML
    public TableView roomTableView;

    @FXML
    public TableColumn<RoomData, String> roomNoTableColumn;

    @FXML
    public TableColumn<RoomData, String> roomTypeTableColumn;
    @FXML
    public TableColumn<RoomData, String> bedTableColumn;
    @FXML
    public TableColumn<RoomData, String> priceTableColumn;
    @FXML
    public TableColumn<RoomData, String> statusTableColumn;
    @FXML
    private ComboBox combo;
    @FXML
    private ComboBox comb;

    @FXML
    void select(ActionEvent event) {
        String s = comb.getSelectionModel().getSelectedItem().toString();
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
        comb.setItems(list);

        ObservableList<String> list1 = FXCollections.observableArrayList("Single","Double","Triple");
        combo.setItems(list1);

        roomNoTableColumn.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
        roomTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("RoomType"));
        bedTableColumn.setCellValueFactory(new PropertyValueFactory<>("Bed"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
        
        roomDataObservableList = FXCollections.observableArrayList(rdm.getAllRoomData());
        roomTableView.setItems(roomDataObservableList);
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

    }
}
