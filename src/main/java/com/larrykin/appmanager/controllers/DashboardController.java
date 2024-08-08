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
            case HOME -> borderPane.setCenter(Model.getInstance().getViewFactory().getTableviewScrollPane());
            case SMS -> {
                BorderPane innerBorderPane = new BorderPane();
                innerBorderPane.setCenter(Model.getInstance().getViewFactory().getSmsScrollPane());
                innerBorderPane.setRight(Model.getInstance().getViewFactory().getSendSMSScrollPane());
                borderPane.setCenter(innerBorderPane);
            }
            case DAILING_PLAN -> borderPane.setCenter(Model.getInstance().getViewFactory().getDailingPlanScrollPane());
            case BLOCK_GUARD -> borderPane.setCenter(Model.getInstance().getViewFactory().getBlockGuardScrollPane());
            case CODEC -> borderPane.setCenter(Model.getInstance().getViewFactory().getCodecScrollPane());
            case USSD -> borderPane.setCenter(Model.getInstance().getViewFactory().getUssdScrollPane());
            case USSD_API -> borderPane.setCenter(Model.getInstance().getViewFactory().getUssdApiScrollPane());
            case MANAGE_USAGE -> borderPane.setCenter(Model.getInstance().getViewFactory().getManageUsageScrollPane());
            case BLACK_AND_WHITE_LIST -> borderPane.setCenter(Model.getInstance().getViewFactory().getBlackAndWhiteListScrollPane());
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
        dailingPlanButton.setOnAction(e ->setDailingPlan());
        blockGuardButton.setOnAction(e -> setBlockGuard());
        CodecButton.setOnAction(e -> setCodec());
        ussdButton.setOnAction(e -> setUssd());
        ussdApiButton.setOnAction(e -> setUssdApi());
        manageUseButton.setOnAction(e -> setManageUsage());
        BlackWhitelistButton.setOnAction(e -> setBlackAndWhiteList());
    }



    //?listener for the buttons
    public void setSettings() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.SETTINGS);
    }
    private void setHome() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.HOME);
    }
    private void setSms() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.SMS);
    }
    private void setDailingPlan() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.DAILING_PLAN);
    }
    private void setBlockGuard() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.BLOCK_GUARD);
    }
    private void setCodec() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.CODEC);
    }
    private void setUssd() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.USSD);
    }
    private void setUssdApi() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.USSD_API);
    }
    private void setManageUsage() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.MANAGE_USAGE);
    }
    private void setBlackAndWhiteList() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.BLACK_AND_WHITE_LIST);
    }

}
