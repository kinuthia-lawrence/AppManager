package com.larrykin.appmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
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
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }

//        // Get the primary screen's bounds
//        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
//        double screenWidth = screenBounds.getWidth();
//        double screenHeight = screenBounds.getHeight();
//
        stage.setScene(dashboard);
        stage.setTitle("App Manager");
//        stage.setWidth(screenWidth);
//        stage.setHeight(screenHeight);
        stage.setResizable(false);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}