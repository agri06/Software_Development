package hu.unideb.inf.controller;

import javafx.beans.Observable;
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

public class ManageroomsController implements Initializable {
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

    }
    @FXML
    public void backbuttonpushed(ActionEvent event) {
        int a = JOptionPane.showConfirmDialog(null,"Want to go Back?","select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            StageHelper.setScene("/fxml/adminpage.fxml","Admin Page");
        }

    }
}
