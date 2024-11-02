package com.encryption.fileencryption;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @FXML
    Button buttonChooseFile, buttonProcess;

    public void chooseFile(ActionEvent actionEvent) {
        System.out.println("Pressed");
    }

    public void process(ActionEvent actionEvent) {
        System.out.println("Processed");
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        FileChooser fileChooser = new FileChooser();




        stage.show();


//        Encryptor encryptor = new Encryptor();
//        Decryptor decryptor = new Decryptor();
    }

    public static void main(String[] args) {
        launch();
    }
}