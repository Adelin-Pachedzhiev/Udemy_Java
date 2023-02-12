package com.example.ex56_fxcontacts;

import com.example.ex56_fxcontacts.Contacts.Contact;
import com.example.ex56_fxcontacts.Contacts.ContactData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private TableView<Contact> tableView;

    @FXML
    private VBox vBox;

    @FXML
    private ContextMenu contextMenu;

    private Contact selectedContact;


    public void initialize() {

        contextMenu = new ContextMenu();

        MenuItem deleteItem = new MenuItem("Delete");
        deleteItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleDeleteItem();
            }
        });

        MenuItem editItem = new MenuItem("Edit Item");
        editItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleEditItem();
            }
        });

        MenuItem addItem = new MenuItem("Add Contact");
        addItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleNewItem();
            }
        });

        contextMenu.getItems().addAll(addItem, editItem, deleteItem);

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(ContactData.getInstance().getContacts());
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.getSelectionModel().select(0);

        tableView.setContextMenu(contextMenu);

        TableColumn<Contact, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));


        TableColumn<Contact, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Contact, String> phoneNumberCol = new TableColumn<>("Phone Number");
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<Contact, String> notesCol = new TableColumn<>("Notes");
        notesCol.setCellValueFactory(new PropertyValueFactory<>("notes"));


        tableView.getColumns().addAll(firstNameCol, lastNameCol, phoneNumberCol, notesCol);

    }

    @FXML
    public void handleNewItem() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(vBox.getScene().getWindow());
        dialog.setTitle("Add New Contact");
        dialog.setHeaderText("Enter Contact Info");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("dialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController dialogController = fxmlLoader.getController();
            Contact newContact = dialogController.addItemResult();
            if(newContact != null){
                tableView.getSelectionModel().select(newContact);
            }
        }

    }

    @FXML
    public void handleEditItem() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(vBox.getScene().getWindow());
        dialog.setTitle("Edit Contact");
        dialog.setHeaderText("Edit Contact Info");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("dialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        selectedContact = tableView.getSelectionModel().getSelectedItem();

        ButtonType okButton = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);

        dialog.getDialogPane().getButtonTypes().add(okButton);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        DialogController dialogController = fxmlLoader.getController();
        dialogController.setEditFields(selectedContact);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == okButton) {
            dialogController.editContactResult(selectedContact);
            tableView.getSelectionModel().select(selectedContact);
        }


    }

    @FXML
    public void handleDeleteItem() {
        selectedContact = tableView.getSelectionModel().getSelectedItem();
        if (selectedContact == null) {
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact ?");
        alert.setHeaderText("Are you sure you want to delete contact " +
                (selectedContact.getFirstName() != null ? selectedContact.getFirstName() : "") + " " +
                (selectedContact.getLastName() != null ? selectedContact.getLastName() : ""));


        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            ContactData.getInstance().deleteContact(selectedContact);
        }


    }


}