package com.larrykin.appmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SMPPServerSettingsController {

    @FXML
    private TextField addressRangeTextField;

    @FXML
    private ComboBox<?> bindComboBox;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField destianationAddressNPITextfield;

    @FXML
    private TextField destiantionAddressTONTextField;

    @FXML
    private TextField interfaceVersionTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField portTextField;

    @FXML
    private Button saveButton;

    @FXML
    private TextField smppServerTextField;

    @FXML
    private ComboBox<?> sourceAddressNPIComboBox;

    @FXML
    private ComboBox<?> sourceAddressTONComboBox;

    @FXML
    private TextField systemIDTextField;

    @FXML
    private TextField systemTypeTextField;

    @FXML
    private ComboBox<?> tonAndNPIForSourceDestinationAddressComboBox;
    @FXML
    public void initialize(){
        loadComboboxes();
    }

    private void loadComboboxes() {
    }

}
