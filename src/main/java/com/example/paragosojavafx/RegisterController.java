package com.example.paragosojavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    private Stage stage;
    private double x = 0, y = 0;
    @FXML
    private Button btnSignUp;

    @FXML
    private Button btn_signIn1;

    @FXML
    private AnchorPane sideBarLogin;

    @FXML
    private TextField tfPhoneOrEmail;

    @FXML
    private TextField tfconfirmpassword;

    @FXML
    private PasswordField tfpassword;

    @FXML
    private TextField tfusername;

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

    @FXML
    private void showLoginPage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login-page.fxml"));  // Ensure path is correct
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);


        Stage stage = (Stage) btnSignUp.getScene().getWindow();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

    }
}
