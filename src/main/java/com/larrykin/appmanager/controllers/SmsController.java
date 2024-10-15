package com.larrykin.appmanager.controllers;

import com.larrykin.appmanager.utils.AdbConnector;
import com.larrykin.appmanager.utils.DatabaseConn;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SmsController {

    @FXML
    private Hyperlink DeselectAllHyperlink;

    @FXML
    private TableColumn<?, ?> addressColumn;

    @FXML
    private TableColumn<?, ?> bodyColumn;

    @FXML
    private AnchorPane checkboxAnchorPane;

    @FXML
    private TableColumn<?, ?> dateTimeColumn;

    @FXML
    private Button fetchButton;

    @FXML
    private ImageView iconrefresh;

    @FXML
    private TableColumn<?, ?> imeiColumn;

    @FXML
    private TextField readingLimitTextfield;

    @FXML
    private TextField receivingTimeTextField;

    @FXML
    private Button refreshButton;

    @FXML
    private Hyperlink selectAllHyperlink;

    //? Instantiate database
    private DatabaseConn databaseConn = new DatabaseConn();

    @FXML
    public void initialize() {
        loadReources();
        addImeiCheckboxes();
        initializeButtons();
    }

    //? Initialize Buttons
    private void initializeButtons() {
        // refresh button
        refreshButton.setOnAction(event -> {
            checkboxAnchorPane.getChildren().clear();
            addImeiCheckboxes();
        });

        //select all hyperlink
        selectAllHyperlink.setOnAction(event -> {
            checkboxAnchorPane.getChildren().forEach(node -> {
                if (node instanceof CheckBox) {
                    CheckBox checkBox = (CheckBox) node;
                    checkBox.setSelected(true);
                }
            });
        });

        //deselect all hyperlink
        DeselectAllHyperlink.setOnAction(event -> {
            checkboxAnchorPane.getChildren().forEach(node -> {
                if (node instanceof CheckBox) {
                    CheckBox checkBox = (CheckBox) node;
                    checkBox.setSelected(false);
                }
            });
        });
    }

    //? Add IMEI Checkboxes
    private void addImeiCheckboxes() {
        try {
            // Create a list to hold all IMEIs
            List<String> allImeis = new ArrayList<>();

            // Fetch IMEIs from the database
            String query = "SELECT imei FROM details";
            Connection connection = databaseConn.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String imei = resultSet.getString("imei").trim(); // Trim and add to the list
                allImeis.add(imei);
            }

            connection.close();

            // Fetch cleaned IMEIs from ADB
            AdbConnector adbConnector = new AdbConnector();
            List<String> adbImeis = adbConnector.getCleanedImeis(); // Fetch IMEIs from ADB
            allImeis.addAll(adbImeis); // Add ADB IMEIs to the list

            // Create checkboxes for each unique IMEI
            double layoutY = 10.0; // Initial Y position for the first checkbox
            Set<String> uniqueImeis = new HashSet<>(allImeis); // Use a Set to avoid duplicates

            for (String imei : uniqueImeis) {
                CheckBox checkBox = new CheckBox(imei);
                checkBox.setLayoutX(10.0); // X position for the checkbox
                checkBox.setLayoutY(layoutY); // Y position for the checkbox
                layoutY += 30.0; // Increment Y position for the next checkbox

                checkboxAnchorPane.getChildren().add(checkBox);
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }


}

    //? load resources
    private void loadReources() {
        Image refreshImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/refresh.png")));
        iconrefresh.setImage(refreshImage);
    }

}
