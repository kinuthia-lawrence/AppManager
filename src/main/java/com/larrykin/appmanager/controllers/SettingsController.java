package com.larrykin.appmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class SettingsController {

    @FXML
    private Button CancelButton;

    @FXML
    private TextField DelayBetweenCalls;

    @FXML
    private RadioButton FistIdleRoutingAlgorithmRadio;

    @FXML
    private TextField RTPPortFrom;

    @FXML
    private ToggleGroup RoutingAlgorithm;

    @FXML
    private ToggleGroup SDPInRingingMsg;

    @FXML
    private RadioButton SDPInRingingYesRadioButton;

    @FXML
    private RadioButton SDPinRinginNoRadioButton;

    @FXML
    private TextField SIPRejectionCode;

    @FXML
    private RadioButton avoidRobotNORadioButton;

    @FXML
    private ToggleGroup avoidRobotRecaptcha;

    @FXML
    private RadioButton avoidRobotYESRadioButton;

    @FXML
    private RadioButton callRecordingNORadioButton;

    @FXML
    private RadioButton callRecordingYesRadioButton;

    @FXML
    private RadioButton callbackRadioButton;

    @FXML
    private ToggleGroup callsRecording;

    @FXML
    private CheckBox componentLoggerCheckBox;

    @FXML
    private ComboBox<?> connectionModeComboBox;

    @FXML
    private CheckBox dailedNumberLoggerCheckBox;

    @FXML
    private CheckBox gsmLoggerCheckBox;

    @FXML
    private TextField keepAliveInterval;

    @FXML
    private CheckBox logicLoggerCheckBox;

    @FXML
    private RadioButton lowestLoadedRoutingAlgorithmRadio;

    @FXML
    private RadioButton originationRadioButton;

    @FXML
    private TextField prefixForOrigination;

    @FXML
    private TextField prefixForTermination;

    @FXML
    private TextField restartSoftwareEvery;

    @FXML
    private Button saveButton;

    @FXML
    private ScrollPane settingsPane;

    @FXML
    private CheckBox smppLogerCheckBox;

    @FXML
    private ToggleGroup softwareRole;

    @FXML
    private RadioButton stcpTransportRadioButton;

    @FXML
    private RadioButton tcpTransportRadioButton;

    @FXML
    private RadioButton terminationAndOriginationRadioButton;

    @FXML
    private RadioButton terminationRadioButton;

    @FXML
    private RadioButton tlsTransportRadioButton;

    @FXML
    private ToggleGroup transportType;

    @FXML
    private TextField trustedIPAddress;

    @FXML
    private RadioButton udpTransportRadioButton;

    @FXML
    private RadioButton utilizeBestACDRoutingAlgorithRadio;

    @FXML
    private RadioButton utilizeBestAsrRoutingAlgorithRadio;

    @FXML
    private RadioButton whatsappRadioButton;

}
