package com.encryption.fileencryption;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {

    @FXML
    Button buttonChooseFile, buttonProcess;
    @FXML
    Label labelFileLocation;
    @FXML
    RadioButton radioButtonEncrypt, radioButtonDecrypt;

    String path = "";

    public void chooseFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        path = file.getAbsolutePath();
        labelFileLocation.setText(path);
    }

    public void process(ActionEvent actionEvent) {
        if(path != "") {
            if (radioButtonDecrypt.isSelected()) {
                System.out.println("1");
            }
            if (radioButtonEncrypt.isSelected()) {
                System.out.println("2");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid");
            alert.setHeaderText(null); // Optional, you can remove this line if you want a header
            alert.setContentText("Please select a file to encrypt/decrypt");
            alert.showAndWait();
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        stage.show();


//        Encryptor encryptor = new Encryptor();
//        Decryptor decryptor = new Decryptor();
    }

    public static void main(String[] args) {
        launch();
    }
}