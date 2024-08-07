package com.larrykin.appmanager.controllers;

import com.larrykin.appmanager.enums.DashboardOptions;
import com.larrykin.appmanager.models.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.util.Objects;

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
    private Button homeButton;

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
            case SETTINGS -> borderPane.setCenter(Model.getInstance().getViewFactory().getSettingsScrollPane());
            case TABLEVIEW -> borderPane.setCenter(Model.getInstance().getViewFactory().getTableviewScrollPane());
            case SMS -> borderPane.setCenter(Model.getInstance().getViewFactory().getSmsScrollPane());
        }
    });

    }

    //? Adding icons programmatically
    private void loadImages() {
        Image callIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/call.png")));
        iconTotalCalls.setImage(callIcon);
        Image asrIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/asr.png")));
        iconASR.setImage(asrIcon);
        Image lostCallsIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/missedCalls.png")));
        iconLostCalls.setImage(lostCallsIcon);
        Image smsIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/sms.png")));
        iconSms.setImage(smsIcon);
        Image utilizationIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/utilization.png")));
        iconUtilization.setImage(utilizationIcon);
        Image acdIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/acd.png")));
        IconAcd.setImage(acdIcon);
    }

    //? Adding listeners to the buttons
    private void addListeners() {
        homeButton.setOnAction(e ->setHome());
        settingsButton.setOnAction(e -> setSettings());
        smsButton.setOnAction(e -> setSms());
    }



    //?listener for the buttons
    public void setSettings() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.SETTINGS);
    }
    private void setHome() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.TABLEVIEW);
    }
    private void setSms() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.SMS);
    }

}
