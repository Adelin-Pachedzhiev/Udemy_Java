module com.example.javafx_sample {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_sample to javafx.fxml;
    exports com.example.javafx_sample;
}