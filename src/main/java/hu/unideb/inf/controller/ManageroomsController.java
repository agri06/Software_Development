package hu.unideb.inf.controller;

import hu.unideb.inf.model.RoomData;
import hu.unideb.inf.model.RoomDataDAOInterface;
import hu.unideb.inf.model.RoomDataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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
    private ComboBox roomTypeComboBox;
    @FXML
    private ComboBox selectBedComboBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("AC","NON-AC");
        roomTypeComboBox.setItems(list);

        ObservableList<String> list1 = FXCollections.observableArrayList("1","2","3");
        selectBedComboBox.setItems(list1);

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
            try {
                rdm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            StageHelper.setScene("/fxml/adminpage.fxml","Admin Page");
        }

    }

    public void onSearchRoom(ActionEvent actionEvent) {
        String roomType = String.valueOf(roomTypeComboBox.getSelectionModel().getSelectedItem());
        String NoOfBeds = String.valueOf(selectBedComboBox.getSelectionModel().getSelectedItem());

        if(!roomType.equals("null")) {
            List<RoomData> roomFilterList = rdm.getAllRoomData().stream()
                    .filter(roomData -> roomData.getRoomType().equals(roomType))
                    .collect(Collectors.toList());
            if(!NoOfBeds.equals("null")){
                roomFilterList = roomFilterList.stream()
                        .filter(roomData -> roomData.getBed().equals(NoOfBeds))
                        .collect(Collectors.toList());
            }

            ObservableList<RoomData> newObservableList = FXCollections.observableList(roomFilterList);
            roomTableView.setItems(newObservableList);
        }
    }
}
