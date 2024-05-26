package com.example.paragosojavafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

    @FXML
    private TextField tfusername, tfpasswordVisible;

    @FXML
    private PasswordField tfpassword;
    @FXML
    private CheckBox cbShowHidePass;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (sideBarLogin != null) {
            sideBarLogin.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();
            });

            sideBarLogin.setOnMouseDragged(mouseEvent -> {
                if (stage != null) {
                    stage.setX(mouseEvent.getScreenX() - x);
                    stage.setY(mouseEvent.getScreenY() - y);
                }
            });
        }
        tfpassword.textProperty().bindBidirectional(tfpasswordVisible.textProperty());
    }

    @FXML
    private void togglePassword() {
        if (cbShowHidePass.isSelected()) {
            tfpassword.setVisible(false);
            tfpasswordVisible.setVisible(true);
        } else {
            tfpassword.setVisible(true);
            tfpasswordVisible.setVisible(false);
        }
    }

    @FXML
    private void loginUser() {
        String username = tfusername.getText();
        String password = tfpassword.getText();

        boolean authenticated = RetrieveData.authenticateUser(username, password);
        if (authenticated) {
            System.out.println("Login successful");
            Main.goToHomePage();
        } else {
            System.out.println("Invalid username or password");
        }
    }

    @FXML
    private void showRegisterPage() throws IOException {
        Main.goToRegister();
    }
}
