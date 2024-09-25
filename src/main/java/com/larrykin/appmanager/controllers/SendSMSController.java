package com.larrykin.appmanager.controllers;

import com.larrykin.appmanager.utils.DatabaseConn;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
            String query = "SELECT imei FROM details";
            Connection connection = databaseConn.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            double layoutY = 10.0; // Initial Y position for the first checkbox

            while (resultSet.next()) {
                String imei = resultSet.getString("imei");
                CheckBox checkBox = new CheckBox(imei);
                checkBox.setLayoutX(10.0); // X position for the checkbox
                checkBox.setLayoutY(layoutY); // Y position for the checkbox
                layoutY += 30.0; // Increment Y position for the next checkbox

                checkboxAnchorPane.getChildren().add(checkBox);
            }

            connection.close();
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
