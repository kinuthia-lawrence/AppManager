package com.larrykin.appmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;

public class TableViewController {

    @FXML
    private TableColumn<?, ?> audiPortColumn;

    @FXML
    private TableColumn<?, ?> audioFlowColumn;

    @FXML
    private TableColumn<?, ?> callStatusColumn;

    @FXML
    private TableColumn<?, ?> codecColumn;

    @FXML
    private TableColumn<?, ?> comPortColumn;

    @FXML
    private TableColumn<?, ?> dailedNumbersColumn;

    @FXML
    private TableColumn<?, ?> imeiACDColumn;

    @FXML
    private TableColumn<?, ?> imeiAsrColumn;

    @FXML
    private TableColumn<?, ?> imeiColumn;

    @FXML
    private TableColumn<?, ?> lastConnectedCallColumn;

    @FXML
    private TableColumn<?, ?> modemNameColumn;

    @FXML
    private TableColumn<?, ?> operatornameColumn;

    @FXML
    private TableColumn<?, ?> phoneModelColumn;

    @FXML
    private TableColumn<?, ?> remainingCallsColumn;

    @FXML
    private TableColumn<?, ?> remainingMinutesColumn;

    @FXML
    private TableColumn<?, ?> resetColumn;

    @FXML
    private TableColumn<?, ?> responseTimeColumn;

    @FXML
    private TableColumn<?, ?> signalQualityColumn;

    @FXML
    private ScrollPane tableViewScrollPane;

}
