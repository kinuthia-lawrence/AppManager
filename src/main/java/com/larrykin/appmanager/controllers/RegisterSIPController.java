package com.larrykin.appmanager.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegisterSIPController {

    @FXML
    private TextField authUsernameTextField;

    @FXML
    private TextField callerIDTextField;

    @FXML
    private TextField outBoundProxyTextField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField registrarServerTextfield;

    @FXML
    private TextField sipPasswordTextField;

    @FXML
    private TextField sipPortTextField;

    @FXML
    private TextField sipProxyTextField;

    @FXML
    private TextField sipServerTextField;

    @FXML
    private TextField sipUsernameTextField;

    @FXML
    private ComboBox<String> transportComboBox;
    @FXML
    public void initialize(){
        loadComboBox();
    }

    private void loadComboBox() {
        ObservableList<String> transportProtocal = FXCollections.observableArrayList(
            "UDP","TCP","TLS"
        );
        transportComboBox.setItems(transportProtocal);
    }

}
