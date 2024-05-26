package com.example.paragosojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    static FXMLLoader loaderlogin;
    static FXMLLoader loadersignup;
    static FXMLLoader loaderhome;
    static LoginController loginController;
    static RegisterController registerController;
    static HomeController homeController;
    static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        loaderlogin = new FXMLLoader(getClass().getResource("login-page.fxml"));
        loadersignup = new FXMLLoader(getClass().getResource("register-page.fxml"));
        loaderhome = new FXMLLoader(getClass().getResource("home-page.fxml"));

        try {
            Parent root = loaderlogin.load();
            Parent root2 = loadersignup.load();
            Parent root3 = loaderhome.load();

            registerController = loadersignup.getController();
            loginController = loaderlogin.getController();
            homeController = loaderhome.getController();

            Scene scene = new Scene(root);
            Scene scene2 = new Scene(root2);
            Scene scene3 = new Scene(root3);

            scene2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            scene3.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

            primaryStage.setTitle("AudioSphere");

            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);

            primaryStage.setScene(scene);
            primaryStage.show();

            loginController.setStage(primaryStage);

        } catch (IOException e) {
            System.err.println("Error loading FXML file: " + e.getMessage());
            System.exit(1);
        }
    }

    static void goToLogin() {
        try {
            Parent root = loaderlogin.getRoot();
            Scene scene = root.getScene();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
            loginController.setStage(stage);

        } catch (Exception e) {
            System.err.println("Error loading FXML file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    static void goToRegister() {
        try {
            Parent root = loadersignup.getRoot();
            Scene scene = root.getScene();
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
            loginController.setStage(stage);
        } catch (Exception e) {
            System.err.println("Error loading FXML file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void goToHomePage() {
        try {
            Parent root = loaderhome.getRoot();
            Scene scene = root.getScene();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (Exception e) {
            System.err.println("Error loading FXML file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
