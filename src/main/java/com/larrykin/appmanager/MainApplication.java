package com.larrykin.appmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dashboard.fxml"));
        Scene dashboard = null;
        try {
            dashboard = new Scene(loader.load(),1300,620);
        } catch (Exception e) {
            System.out.println("Error loading Dashboard"+e.getMessage());
            e.printStackTrace();
        }
        stage.setScene(dashboard);
        stage.setTitle("App Manager");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}