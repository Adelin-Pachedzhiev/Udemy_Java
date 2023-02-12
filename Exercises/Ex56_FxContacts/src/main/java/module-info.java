module com.example.ex56_fxcontacts {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    opens com.example.ex56_fxcontacts.Contacts to javafx.fxml;
    opens com.example.ex56_fxcontacts to javafx.fxml;

    exports com.example.ex56_fxcontacts.Contacts;
    exports com.example.ex56_fxcontacts;
}