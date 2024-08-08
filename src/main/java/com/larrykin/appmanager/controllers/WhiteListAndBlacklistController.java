package com.larrykin.appmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class WhiteListAndBlacklistController {

    @FXML
    private TextField blacklistPathTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private CheckBox enableBlackListRuleCheckBox;

    @FXML
    private CheckBox enableWhiteListRuleCheckBox;

    @FXML
    private Button saveButton;

    @FXML
    private TextField whitelistPathTextField;

}
