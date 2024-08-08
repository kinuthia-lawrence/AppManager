package com.larrykin.appmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

public class ManageUsageController {

    @FXML
    private Button DeleteSelectedButton;

    @FXML
    private Hyperlink DeselectAllHyperlink;

    @FXML
    private TableColumn<?, ?> callLimitColumn;

    @FXML
    private TextField callsLimitTextField;

    @FXML
    private AnchorPane checkboxAnchorPane;

    @FXML
    private Button deleteAllButton;

    @FXML
    private ImageView iconrefresh;

    @FXML
    private TableColumn<?, ?> imeiColumn;

    @FXML
    private TextField minutesLImitTextField;

    @FXML
    private TableColumn<?, ?> minutesLimitColumn;

    @FXML
    private Button refreshButton;

    @FXML
    private Button saveButton;

    @FXML
    private Hyperlink selectAllHyperlink;

    @FXML
    public  void  initialize(){
        loadReources();
    }

    private void loadReources() {
        Image refreshImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/refresh.png")));
        iconrefresh.setImage(refreshImage);
    }
}
