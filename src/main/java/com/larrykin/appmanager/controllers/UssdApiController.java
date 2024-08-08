package com.larrykin.appmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

public class UssdApiController {

    @FXML
    private Hyperlink DeselectAllHyperlink;

    @FXML
    private AnchorPane checkboxAnchorPane;

    @FXML
    private TableColumn<?, ?> dateGmtColumn;

    @FXML
    private ImageView iconrefresh;

    @FXML
    private TableColumn<?, ?> imeiColumn;

    @FXML
    private TableColumn<?, ?> lastResponseColumn;

    @FXML
    private Button refreshButton;

    @FXML
    private Hyperlink selectAllHyperlink;

    @FXML
    private Button sendButton;

    @FXML
    private CheckBox sendToAllPhonesCheckBox;

    @FXML
    private TextField ussdCodeTextField;

    @FXML
    private Label warningLabel;

    @FXML
    public  void  initialize(){
        loadReources();
    }

    private void loadReources() {
        Image refreshImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/refresh.png")));
        iconrefresh.setImage(refreshImage);
    }
}
