package com.example.digitron;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Digitron extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Digitron.class.getResource("digitron.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 220, 320);
        stage.setMinHeight(320);
        stage.setMinWidth(220);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}