package com.larrykin.appmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class registerSIPController {

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
    private ComboBox<?> transportComboBox;

}
