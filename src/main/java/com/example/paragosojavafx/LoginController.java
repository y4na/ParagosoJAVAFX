package com.example.paragosojavafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private double x = 0, y = 0;


    @FXML
    private AnchorPane sideBarLogin;

    private Stage stage;

    @FXML
    private Button btnSignIn;

    @FXML
    private Button btn_signUp1;

    @FXML
    private AnchorPane root;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (sideBarLogin!= null) {
            sideBarLogin.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();
            });

            sideBarLogin.setOnMouseDragged(mouseEvent -> {
                if (stage!= null) {
                    stage.setX(mouseEvent.getScreenX() - x);
                    stage.setY(mouseEvent.getScreenY() - y);
                }
            });
        }
    }

    public void login(){

    }
    @FXML
    private void showRegisterPage() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("register-page.fxml"));  // Ensure path is correct
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);


        Stage stage = (Stage) btnSignIn.getScene().getWindow();
        stage.setTitle("Registration");
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

    }

}