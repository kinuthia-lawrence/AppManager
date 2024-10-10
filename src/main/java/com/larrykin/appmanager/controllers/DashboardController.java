package com.larrykin.appmanager.controllers;

import com.larrykin.appmanager.enums.DashboardOptions;
import com.larrykin.appmanager.models.Model;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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
    private Button smppServerSettingsButton;

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
        Model.getInstance().getViewFactory().getDashboardSelectedItem().addListener((observable, oldVal, newVal) -> {
            switch (newVal) {
                case SETTINGS -> borderPane.setCenter(Model.getInstance().getViewFactory().getSettingsScrollPane());
                case HOME -> borderPane.setCenter(Model.getInstance().getViewFactory().getTableviewScrollPane());
                case SMS -> {
                    SplitPane splitPane = new SplitPane();

                    // Left pane with buttons
                    VBox buttonBox = new VBox();
                    buttonBox.setPrefWidth(150); // Set preferred width for the left pane
                    buttonBox.setMaxWidth(150); // Ensure the VBox does not expand beyond this width
                    buttonBox.setSpacing(20); // Set spacing between buttons
                    buttonBox.setPadding(new Insets(10)); // Add padding to the VBox

                    Button smsButton = new Button("SMS Inbox");
                    Button sendSmsButton = new Button("Send SMS");
                    buttonBox.getChildren().addAll(smsButton, sendSmsButton);

                    // Right pane with a BorderPane to switch content
                    BorderPane innerBorderPane = new BorderPane();

                    // Set initial content
                    innerBorderPane.setCenter(Model.getInstance().getViewFactory().getSmsScrollPane());

                    // Add button actions
                    smsButton.setOnAction(event -> innerBorderPane.setCenter(Model.getInstance().getViewFactory().getSmsScrollPane()));
                    sendSmsButton.setOnAction(event -> innerBorderPane.setCenter(Model.getInstance().getViewFactory().getSendSMSScrollPane()));

                    // Add panes to SplitPane
                    splitPane.getItems().addAll(buttonBox, innerBorderPane);

                    // Set SplitPane as the center of the main BorderPane
                    borderPane.setCenter(splitPane);
                }
                case DAILING_PLAN ->
                        borderPane.setCenter(Model.getInstance().getViewFactory().getDailingPlanScrollPane());
                case BLOCK_GUARD ->
                        borderPane.setCenter(Model.getInstance().getViewFactory().getBlockGuardScrollPane());
                case CODEC -> borderPane.setCenter(Model.getInstance().getViewFactory().getCodecScrollPane());
                case USSD -> borderPane.setCenter(Model.getInstance().getViewFactory().getUssdScrollPane());
                case USSD_API -> borderPane.setCenter(Model.getInstance().getViewFactory().getUssdApiScrollPane());
                case MANAGE_USAGE ->
                        borderPane.setCenter(Model.getInstance().getViewFactory().getManageUsageScrollPane());
                case BLACK_AND_WHITE_LIST ->
                        borderPane.setCenter(Model.getInstance().getViewFactory().getBlackAndWhiteListScrollPane());
                case SMPP_SETTINGS -> borderPane.setCenter(Model.getInstance().getViewFactory().getSmppSettingsPane());
                case REGISTER_SIP -> borderPane.setCenter(Model.getInstance().getViewFactory().getRegisterSIPPane());
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
        homeButton.setOnAction(e -> setHome());
        settingsButton.setOnAction(e -> setSettings());
        smsButton.setOnAction(e -> setSms());
        dailingPlanButton.setOnAction(e -> setDailingPlan());
        blockGuardButton.setOnAction(e -> setBlockGuard());
        CodecButton.setOnAction(e -> setCodec());
        ussdButton.setOnAction(e -> setUssd());
        ussdApiButton.setOnAction(e -> setUssdApi());
        manageUseButton.setOnAction(e -> setManageUsage());
        BlackWhitelistButton.setOnAction(e -> setBlackAndWhiteList());
        registerToSipServerButton.setOnAction(e -> setRegisterSIP());
        smppServerSettingsButton.setOnAction(e -> setSmppSettings());
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

    private void setSmppSettings() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.SMPP_SETTINGS);
    }

    private void setRegisterSIP() {
        Model.getInstance().getViewFactory().getDashboardSelectedItem().set(DashboardOptions.REGISTER_SIP);
    }

}
