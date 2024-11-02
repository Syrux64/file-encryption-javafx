module com.encryption.fileencryption {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.encryption.fileencryption to javafx.fxml;
    exports com.encryption.fileencryption;
}