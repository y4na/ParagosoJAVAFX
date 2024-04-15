package com.example.paragosojavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HelloController {

    @FXML
    private AnchorPane pnMain;
    @FXML
    private AnchorPane pnWelcome;
    @FXML
    private VBox pnLogin;
    @FXML
    private VBox pnHome;

    @FXML
    private ColorPicker colorPick;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnLogin;

    @FXML
    protected void onLoginClick() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("welcome-view.fxml"));
//        Scene scene = new Scene(root);
        pnMain.getChildren().remove(pnLogin);
        pnMain.getChildren().add(root);
    }
    @FXML
    protected void onLogoutClick() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//        pnWelcome.getScene().getStylesheets().add(getClass().getResource("hello.css").toExternalForm());
//        Scene scene = new Scene(root);
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(getClass().getResource("hello.css").getPath()));
            bw.write(".root { -fx-background-image: url(\"pink.jpg\");}");
            bw.newLine();
            bw.write("button { -fx-background-color: #" + colorPick.getValue().toString().substring(2,8) + "; }");
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        pnWelcome.getChildren().remove(pnHome);
        pnWelcome.getChildren().add(root);

//        @FXML
//        protected void updateButton() throws IOException {
//            String color = colorPick.getValue().toString().substring(2, 8);
//            btnLogin.setStyle("-fx-background-color: #" + color);
//            btnLogout.setStyle("-fx-background-color: #" + color);
//        }
    }

    public void updateButton(MouseEvent mouseEvent) {
        String color = colorPick.getValue().toString().substring(2, 8);
        btnLogin.setStyle("-fx-background-color: #" + color);
        btnLogout.setStyle("-fx-background-color: #" + color);
    }


}