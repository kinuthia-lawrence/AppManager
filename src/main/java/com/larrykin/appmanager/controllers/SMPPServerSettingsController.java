package com.larrykin.appmanager.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SMPPServerSettingsController {

    @FXML
    private TextField addressRangeTextField;

    @FXML
    private ComboBox<String> bindComboBox;

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
    private ComboBox<String> sourceAddressNPIComboBox;

    @FXML
    private ComboBox<String> sourceAddressTONComboBox;

    @FXML
    private TextField systemIDTextField;

    @FXML
    private TextField systemTypeTextField;

    @FXML
    private ComboBox<String> tonAndNPIForSourceDestinationAddressComboBox;
    @FXML
    public void initialize(){
        loadComboboxes();
    }

    private void loadComboboxes() {
        ObservableList<String> bindType = FXCollections.observableArrayList(
          "Transmitter (TX)", "Receiver (RX)", "Transceiver (TRX)"
        );
        bindComboBox.setItems(bindType);
        ObservableList<String> sourceAddressTON = FXCollections.observableArrayList(
                "1:International", "2:National", "3:Network Specific","5:Alphanumeric", "6:Abbreviated"
        );
        sourceAddressTONComboBox.setItems(sourceAddressTON);
        ObservableList<String> sourceAddressNPI = FXCollections.observableArrayList(
                "1:ISDN(E.164)","3:Data(X.121)","6:Land Mobile(E.2121)"
        );
        sourceAddressNPIComboBox.setItems(sourceAddressNPI);
        ObservableList<String> destinationAddress = FXCollections.observableArrayList(
                "International", "National"
        );
        tonAndNPIForSourceDestinationAddressComboBox.setItems(destinationAddress);
    }

}
