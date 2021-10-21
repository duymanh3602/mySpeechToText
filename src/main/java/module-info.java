module com.example.myspeechtotext {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;
    requires sdk.core;
    requires assistant;
    requires speech.to.text;
    requires java.sql;


    opens com.example.myspeechtotext to javafx.fxml;
    exports com.example.myspeechtotext;
}