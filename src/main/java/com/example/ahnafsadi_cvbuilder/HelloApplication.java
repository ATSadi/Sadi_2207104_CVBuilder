package com.example.ahnafsadi_cvbuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            // Initialize SQLite database
            DataBaseHelper.initDataBase();
        } catch (Exception e) {
            System.err.println("Warning: Database initialization failed, but continuing...");
            e.printStackTrace();
        }
        
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("AhnafSadi CV Builder");
        stage.setScene(scene);
        stage.show();
    }
}
