package hu.unideb.inf.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class CustomerCheckInController implements Initializable {
    @FXML
    private ComboBox comb;
    @FXML
    private ComboBox combo;

    @FXML
    private ComboBox comboo;

    @FXML
    private ComboBox combooo;
    @FXML
    private ComboBox Combo;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("Male","Female","Others");
        comb.setItems(list);

        ObservableList<String> list1 = FXCollections.observableArrayList("1","2","3","4");
        Combo.setItems(list1);


        ObservableList<String> list3 = FXCollections.observableArrayList();
        combooo.setItems(list3);

    }



    @FXML
    void combooobutton(ActionEvent event) {


    }

    @FXML
    public void select(javafx.event.ActionEvent event) {
        String s = comb.getSelectionModel().getSelectedItem().toString();
        JLabel.setDefaultLocale(Locale.forLanguageTag(s));


    }

    @FXML
    public void backbuttonpushed(ActionEvent event) {
        int a = JOptionPane.showConfirmDialog(null,"Want to go Back?","select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            StageHelper.setScene("/fxml/adminpage.fxml","Admin Page");
        }
    }
    
    @FXML
    public void ComboButtonPushed(ActionEvent event) {

    }

    public void yesPetButton(ActionEvent actionEvent) {
    }

    public void noPetButton(ActionEvent actionEvent) {
    }

    @FXML
    public void yesPetButtonClicked(ActionEvent actionEvent) {
        StageHelper.setScene("/fxml/PetsCheckIn.fxml","Pets Check In Details");

    }

    public void noPetButtonClicked(ActionEvent actionEvent) {
    }
}
