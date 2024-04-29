package com.example.paragosojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-page.fxml"));
        try {
            Parent root = loader.load();
            LoginController controller = loader.getController();
            Scene scene = new Scene(root);

            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

            primaryStage.setTitle("AudioSphere");
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);

            primaryStage.setScene(scene);
            primaryStage.show();
            controller.setStage(primaryStage);

        } catch (IOException e) {
            System.err.println("Error loading FXML file: " + e.getMessage());
            System.exit(1);
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}