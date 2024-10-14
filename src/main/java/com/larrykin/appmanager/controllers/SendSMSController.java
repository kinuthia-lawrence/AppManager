package com.larrykin.appmanager.controllers;

import com.fazecast.jSerialComm.SerialPort;
import com.larrykin.appmanager.utils.DatabaseConn;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

public class SendSMSController {

    @FXML
    private Hyperlink DeselectAllHyperlink;

    @FXML
    private Label EnglishLabel;

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

        sendButton.setOnAction(event -> {
            sendSMS();
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
    private void sendSMS() {
        SerialPort port = SerialPort.getCommPort("COM7");
        port.setComPortParameters(9600, 8, 1, 0); // Baud rate, data bits, stop bits, parity
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 1000, 1000);

        if (port.openPort()) {
            EnglishLabel.setText("Port opened successfully!\n");
            System.out.println("Port opened successfully!");  // Log success to the console

            try {
                OutputStream outputStream = port.getOutputStream();
                InputStream inputStream = port.getInputStream();

                // Set modem to SMS text mode
                sendATCommand(outputStream, "AT+CMGF=1\r");
                String response = readResponse(inputStream);
                EnglishLabel.setText("Modem Response (Set to Text Mode):\n" + response);
                System.out.println("Modem Response (Set to Text Mode):\n" + response);

                // Get phone number and message text from JTextField and JTextArea
                String phoneNumber = toNumberTextfield.getText();
                String messageText = messageTextField.getText();

                // Send AT command to send an SMS
                sendATCommand(outputStream, "AT+CMGS=\"" + phoneNumber + "\"\r");

                // Wait for modem to prompt for the message (i.e., '>')
                response = readResponse(inputStream);
                if (response.contains(">")) {
                    // Send the message text followed by Ctrl+Z (ASCII code 26)
                    outputStream.write((messageText + "\u001A").getBytes());
                    outputStream.flush();
                    EnglishLabel.setText("Sending message...");
                    System.out.println("Sending message...");

                    // Read the final response from the modem
                    response = readResponse(inputStream);
                    EnglishLabel.setText("Modem Response:\n" + response);
                    System.out.println("Modem Response:\n" + response);

                    // Update JLabel with the status
                    if (response.contains("OK")) {
                        EnglishLabel.setText("SMS sent successfully to " + phoneNumber);
                        System.out.println("SMS sent successfully to " + phoneNumber);
                    } else {
                        EnglishLabel.setText("Failed to send SMS to " + phoneNumber);
                        System.out.println("Failed to send SMS to " + phoneNumber);
                    }
                }

                // Close the port after operations
                port.closePort();
                EnglishLabel.setText("Port closed.");
                System.out.println("Port closed.");
            } catch (Exception e) {
                // Log the error to System.out and update the UI with the error message
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();  // Print the full stack trace to the console
                EnglishLabel.setText("Error: " + e.getMessage());
            }
        } else {
            // Log failure to open the port and update the UI
            EnglishLabel.setText("Failed to open the port.");
            System.out.println("Failed to open the port.");
        }
    }
    private void sendATCommand(OutputStream outputStream, String command) throws Exception {
        outputStream.write(command.getBytes());
        outputStream.flush();
        Thread.sleep(500);  // Short delay to allow modem to process the command
    }

    // Function to read the modem's response
    private String readResponse(InputStream inputStream) throws Exception {
        Scanner scanner = new Scanner(inputStream);
        StringBuilder response = new StringBuilder();

        // Read all available data from the input stream
        while (scanner.hasNextLine()) {
            response.append(scanner.nextLine()).append("\n");
        }
        return response.toString().trim();  // Trim extra whitespace
    }


}
