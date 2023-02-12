package com.example.ex56_fxcontacts.Contacts;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contact {
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty phoneNumber;
    private StringProperty notes;


    public Contact(){

    }
    public Contact(String firstName, String lastName, String phoneNumber, String notes) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setNotes(notes);
    }

    public String getFirstName() {
        return firstNameProperty().get();
    }

    public void setFirstName(String firstName) {
        firstNameProperty().set(firstName);
    }

    public StringProperty firstNameProperty(){
        if(firstName == null){
            firstName = new SimpleStringProperty(this, "First name");
        }
        return firstName;
    }

    public String getLastName() {
        return lastNameProperty().get();
    }

    public void setLastName(String lastName) {
        lastNameProperty().set(lastName);
    }
    public StringProperty lastNameProperty(){
        if(lastName == null){
            lastName = new SimpleStringProperty(this, "Last Name");
        }
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumberProperty().get();
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumberProperty().set(phoneNumber);
    }
    public StringProperty phoneNumberProperty(){
        if(phoneNumber == null){
            phoneNumber = new SimpleStringProperty(this, "Phone number");
        }
        return phoneNumber;
    }

    public String getNotes() {
        return notesProperty().get();
    }

    public void setNotes(String notes) {
        notesProperty().set(notes);
    }

    public StringProperty notesProperty(){
        if(notes == null){
            notes = new SimpleStringProperty(this, "Notes");
        }
        return notes;
    }
}
