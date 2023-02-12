package com.example.ex56_fxcontacts;

import com.example.ex56_fxcontacts.Contacts.Contact;
import com.example.ex56_fxcontacts.Contacts.ContactData;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

public class DialogController {

    @FXML
    private DialogPane dialogPane;
    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField noteField;

    public Contact addItemResult() {

        if (firstNameField.getText().isBlank() || lastNameField.getText().isBlank() ||
                phoneNumberField.getText().isBlank() || noteField.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incorrect input");
            alert.setHeaderText("Fill all the fields.");
            alert.showAndWait();
            return null;
        }


        Contact contact = new Contact(firstNameField.getText(), lastNameField.getText(), phoneNumberField.getText(), noteField.getText());
        ContactData.getInstance().addContact(contact);
        return contact;
    }

    public void setEditFields(Contact contact) {
        firstNameField.setText(contact.getFirstName());
        lastNameField.setText(contact.getLastName());
        phoneNumberField.setText(contact.getPhoneNumber());
        noteField.setText(contact.getNotes());
    }

    public void editContactResult(Contact contact) {
        if (firstNameField.getText().isBlank() || lastNameField.getText().isBlank() ||
                phoneNumberField.getText().isBlank() || noteField.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incorrect input");
            alert.setHeaderText("Fill all the fields.");
            alert.showAndWait();
            return;
        }
        contact.setFirstName(firstNameField.getText());
        contact.setLastName(lastNameField.getText());
        contact.setPhoneNumber(phoneNumberField.getText());
        contact.setNotes(noteField.getText());

    }


}
