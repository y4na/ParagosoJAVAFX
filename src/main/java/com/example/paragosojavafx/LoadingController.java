package com.example.paragosojavafx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadingController implements Initializable{

    @FXML
    private ProgressBar progressBar;
    @FXML
    private Text loadingText;

    LoadingScreen loadingScreen;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadingScreen = new LoadingScreen(progressBar, loadingText);
    }

    @FXML
    void startProgress(ActionEvent event) {
        Thread thread = new Thread(loadingScreen);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    void restart(ActionEvent event) {
        progressBar.setProgress(0);
        loadingText.setText("Loading...");
    }


    //Loading screen runnable class
    public class LoadingScreen implements Runnable {

        ProgressBar progressBar;
        Text loadingText;

        public LoadingScreen(ProgressBar progressBar, Text loadingText) {
            this.progressBar = progressBar;
            this.loadingText = loadingText;
        }

        @Override
        public void run() {
            while(progressBar.getProgress() <= 1) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(progressBar.getProgress() + 0.1);
                    }
                });
                synchronized (this){
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }
            }
            loadingText.setText("Done Loading");
        }
    }
}