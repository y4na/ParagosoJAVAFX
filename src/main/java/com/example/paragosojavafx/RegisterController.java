package com.example.paragosojavafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.paragosojavafx.Main.stage;

public class RegisterController implements Initializable {

    private double x = 0, y = 0;
    @FXML
    private Button btnSignUp;

    @FXML
    private Button btn_signIn1;

    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane sideBarLogin;

    @FXML
    private TextField tfPhoneOrEmail;

    @FXML
    private PasswordField tfconfirmpassword;

    @FXML
    private PasswordField tfpassword;

    @FXML
    private TextField tfusername, tfpasswordVisible, tfconfirmpasswordVisible;

    @FXML
    private CheckBox cbShowHidePass;

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
        tfconfirmpassword.textProperty().bindBidirectional(tfconfirmpasswordVisible.textProperty());
    }

    @FXML
    private void togglePassword() {
        if (cbShowHidePass.isSelected()) {
            tfpassword.setVisible(false);
            tfpasswordVisible.setVisible(true);

            tfconfirmpassword.setVisible(false);
            tfconfirmpasswordVisible.setVisible(true);
        } else {
            tfpassword.setVisible(true);
            tfpasswordVisible.setVisible(false);

            tfconfirmpassword.setVisible(true);
            tfconfirmpasswordVisible.setVisible(false);
        }
    }

    @FXML
    private void registerUser() {

        System.out.println("Sign up button clicked");

        String username = tfusername.getText();
        String password = tfpassword.getText();
        String confirmPassword = tfconfirmpassword.getText();
        String contactInfo = tfPhoneOrEmail.getText();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || contactInfo.isEmpty()) {
            System.out.println("All fields are required");
            return;
        }

        if (password.equals(confirmPassword)) {
            boolean success = InsertData.registerUser(username, password, contactInfo);
            if (success) {
                System.out.println("Registration successful");
                Main.goToLogin();
            } else {
                System.out.println("Registration failed");
            }
        } else {
            System.out.println("Passwords do not match");
        }
    }

    @FXML
    private void showLoginPage() throws IOException {
        Main.goToLogin();
    }
}
