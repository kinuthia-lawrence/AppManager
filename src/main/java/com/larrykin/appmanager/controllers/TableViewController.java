package com.larrykin.appmanager.controllers;

import com.larrykin.appmanager.models.Details;
import com.larrykin.appmanager.utils.DatabaseConn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TableViewController {

    @FXML
    private TableColumn<Details, String> audiPortColumn;

    @FXML
    private TableColumn<Details, String> audioFlowColumn;

    @FXML
    private TableColumn<Details, String> callStatusColumn;

    @FXML
    private TableColumn<Details, String> codecColumn;

    @FXML
    private TableColumn<Details, String> comPortColumn;

    @FXML
    private TableColumn<Details, String> dailedNumbersColumn;

    @FXML
    private TableColumn<Details, String> imeiACDColumn;

    @FXML
    private TableColumn<Details, String> imeiAsrColumn;

    @FXML
    private TableColumn<Details, String> imeiColumn;

    @FXML
    private TableColumn<Details, String> lastConnectedCallColumn;

    @FXML
    private TableColumn<Details, String> modemNameColumn;

    @FXML
    private TableColumn<Details, String> operatornameColumn;

    @FXML
    private TableColumn<Details, String> phoneModelColumn;

    @FXML
    private TableColumn<Details, String> remainingCallsColumn;

    @FXML
    private TableColumn<Details, String> remainingMinutesColumn;

    @FXML
    private TableColumn<Details, String> resetColumn;

    @FXML
    private TableColumn<Details, String> responseTimeColumn;

    @FXML
    private TableColumn<Details, String> signalQualityColumn;

    @FXML
    private TableView<Details> detailsTable;

    @FXML
    private ScrollPane tableViewScrollPane;

    @FXML
    public void initialize() {
        populateTable();
    }

    DatabaseConn databaseConn = new DatabaseConn();


    private void populateTable() {
        ObservableList<Details> detailsList = FXCollections.observableArrayList();
        detailsList.addAll(getDetailsFromDatabase());

        // Bind the properties to the respective columns
        imeiColumn.setCellValueFactory(cellData -> cellData.getValue().imeiProperty());
        operatornameColumn.setCellValueFactory(cellData -> cellData.getValue().operatorNameProperty());
        signalQualityColumn.setCellValueFactory(cellData -> cellData.getValue().signalQualityProperty());
        callStatusColumn.setCellValueFactory(cellData -> cellData.getValue().callStatusProperty());
        dailedNumbersColumn.setCellValueFactory(cellData -> cellData.getValue().dailedNumberProperty());
        imeiACDColumn.setCellValueFactory(cellData -> cellData.getValue().imeiAcdProperty());
        imeiAsrColumn.setCellValueFactory(cellData -> cellData.getValue().imeiAsrProperty());
        remainingMinutesColumn.setCellValueFactory(cellData -> cellData.getValue().remainingMinutesProperty());
        lastConnectedCallColumn.setCellValueFactory(cellData -> cellData.getValue().lastConnectedProperty());
        codecColumn.setCellValueFactory(cellData -> cellData.getValue().codecProperty());
        audioFlowColumn.setCellValueFactory(cellData -> cellData.getValue().audioFlowProperty());
        phoneModelColumn.setCellValueFactory(cellData -> cellData.getValue().phoneModelProperty());
        modemNameColumn.setCellValueFactory(cellData -> cellData.getValue().modemNameProperty());
        audiPortColumn.setCellValueFactory(cellData -> cellData.getValue().audioPortProperty());
        comPortColumn.setCellValueFactory(cellData -> cellData.getValue().comPortProperty());
        responseTimeColumn.setCellValueFactory(cellData -> cellData.getValue().responseTimeProperty());

        // Set the items for the TableView
        detailsTable.setItems(detailsList);
    }

    private List<Details> getDetailsFromDatabase() {
        List<Details> detailsList = new ArrayList<>();

        try{
            String query = "SELECT * FROM details";
            Connection connection = databaseConn.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                Details details = new Details();
                details.setImei(resultSet.getString("imei"));
                details.setOperatorName(resultSet.getString("operator_name"));
                details.setSignalQuality(resultSet.getString("signal_quality"));
                details.setCallStatus(resultSet.getString("call_status"));
                details.setDailedNumber(resultSet.getString("dailed_number"));
                details.setImeiAcd(resultSet.getString("imei_acd"));
                details.setImeiAsr(resultSet.getString("imei_asr"));
                details.setRemainingMinutes(resultSet.getString("remaining_minutes"));
                details.setLastConnected(resultSet.getString("last_connected"));
                details.setCodec(resultSet.getString("codec"));
                details.setAudioFlow(resultSet.getString("audio_flow"));
                details.setPhoneModel(resultSet.getString("phone_model"));
                details.setModemName(resultSet.getString("modem_name"));
                details.setAudioPort(resultSet.getString("audio_port"));
                details.setComPort(resultSet.getString("com_port"));
                details.setResponseTime(resultSet.getString("response_time"));
                detailsList.add(details);
            }
            connection.close();
        }catch (Exception e){
            System.out.println("Errror fetching :" + e.getMessage());
            e.printStackTrace();
        }

        return detailsList;
    }

}
