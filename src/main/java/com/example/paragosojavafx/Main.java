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
    static FXMLLoader loaderlogin;

    static FXMLLoader loadersignup;
    static LoginController loginController;
    static RegisterController registerController;
    static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage=primaryStage;
        loaderlogin = new FXMLLoader(getClass().getResource("login-page.fxml"));
        loadersignup = new FXMLLoader(getClass().getResource("register-Page.fxml"));
        try {
            Parent root = loaderlogin.load();
            Parent root2=loadersignup.load();
            registerController= loadersignup.getController();
            loginController= loaderlogin.getController();

            if(registerController==null){
                System.out.println("hehehe");
            }
            Scene scene = new Scene(root);
            Scene scene2= new Scene(root2);
            scene2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());


            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

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
    static void goToLogin(){

        try {
            Parent root = loaderlogin.getRoot();
            System.out.println("here");
            Scene scene = root.getScene();
            stage.setScene(scene);
            stage.show();

            loginController.setStage(stage);

        } catch (Exception e) {
            System.err.println("Error loading FXML file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
    static void goToRegister(){

        try {
            Parent root = loadersignup.getRoot();
            System.out.println("here");
            Scene scene = root.getScene();
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            loginController.setStage(stage);
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