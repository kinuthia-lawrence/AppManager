package com.larrykin.appmanager.controllers;

import com.larrykin.appmanager.enums.DashboardOptions;
import com.larrykin.appmanager.models.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class DashboardController {

    @FXML
    private Button BlackWhitelistButton;

    @FXML
    private Button CodecButton;

    @FXML
    private ImageView IconAcd;

    @FXML
    private Label TotalCallsLabel;

    @FXML
    private Label acdLabel;

    @FXML
    private Label amppServerStatusLabel;

    @FXML
    private Label asrLabel;

    @FXML
    private Button blockGuardButton;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button dailingPlanButton;

    @FXML
    private Button helpButton;

    @FXML
    private ImageView iconASR;

    @FXML
    private ImageView iconLostCalls;

    @FXML
    private ImageView iconSms;

    @FXML
    private ImageView iconTotalCalls;

    @FXML
    private ImageView iconUtilization;

    @FXML
    private Button logsButton;

    @FXML
    private Label lostCallsLabel;

    @FXML
    private Button manageUseButton;

    @FXML
    private Button onlineMonitorBUtton;

    @FXML
    private Label queueSMSLabel;

    @FXML
    private Button recordCallsButton;

    @FXML
    private Button registerToSipServerButton;

    @FXML
    private Label sentSMSLabel;

    @FXML
    private Button settingsButton;

    @FXML
    private Label sipServerStatusLabel;

    @FXML
    private Button smppServerSettings;

    @FXML
    private Button smsButton;

    @FXML
    private Button ussdApiButton;

    @FXML
    private Button ussdButton;

    @FXML
    private Label utilizationLabel;

    @FXML
    private Button viewModelButton;

    @FXML
    public void initialize() {
        addListeners();
        loadDashboard();
        loadImages();

    }



    private void loadDashboard() {
    borderPane.setCenter(Model.getInstance().getViewFactory().getTableviewScrollPane());
    Model.getInstance().getViewFactory().getDashboardSelectedItem().addListener((observable ,oldVal, newVal) ->{
        switch (newVal){
            case SETTINGS -> borderPane.setCenter(Model.getInstance().getViewFactory().getSettingsAnchorPane());
        }
    });

    }

    private void loadImages() {
    }

    private void addListeners() {
        settingsButton.setOnAction(e -> setSettings());
    }
    public void setSettings() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.SETTINGS);
    }

}
