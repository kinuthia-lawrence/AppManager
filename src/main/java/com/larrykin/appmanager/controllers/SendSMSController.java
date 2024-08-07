package com.larrykin.appmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

public class SendSMSController {

    @FXML
    private Hyperlink DeselectAllHyperlink;

    @FXML
    private AnchorPane checkboxAnchorPane;

    @FXML
    private ImageView iconrefresh;

    @FXML
    private TextArea messageTextField;

    @FXML
    private CheckBox method1CheckBox;

    @FXML
    private CheckBox method2CheckBox;

    @FXML
    private CheckBox method3CheckBox;

    @FXML
    private Button refreshButton;

    @FXML
    private Hyperlink selectAllHyperlink;

    @FXML
    private Button sendButton;

    @FXML
    private TextField toNumberTextfield;

    @FXML
    public  void  initialize(){
        loadReources();
    }

    private void loadReources() {
        Image refreshImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/refresh.png")));
        iconrefresh.setImage(refreshImage);
    }

}
