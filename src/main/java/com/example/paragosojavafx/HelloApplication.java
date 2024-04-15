package com.example.paragosojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("JavaFX huhu");
//        GridPane grid = new GridPane();
////        grid.setAlignment(Pos.CENTER);
////        grid.setHgap(10);
////        grid.setVgap(10);
////        //grid.setPadding(new Insets(25, 25, 25, 25));
////        scene = new Scene(grid, 300, 275);
//        Button btn = new Button("Sign in");
//        HBox hbBtn = new HBox(10);
//        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//        hbBtn.getChildren().add(btn);
//        grid.add(hbBtn, 1, 4);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("hello.css").toExternalForm());
        stage.show();
    }

    public static void main(String[] args) {
        launch();


    }
}