package com.champlain.oop2a1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class PersonViewController {
    @FXML
    private Label aParkingPassLabel;
    @FXML
    private TextField aNameTextField;
    @FXML
    private TextField aPhoneNumberTextField;
    @FXML
    private TextField aEmailAddressTextField;

    private Person aPerson;

    @FXML
    protected void onSaveButtonClick() {
        // Making sure there is a Person object to work with.
        if (this.aPerson == null) {
            this.aPerson = new Person();
        }
        this.aPerson.setName(aNameTextField.getText());
        this.aPerson.setEmailAddress(aEmailAddressTextField.getText());
        this.aPerson.setPhoneNumber(aPhoneNumberTextField.getText());
        this.displayPerson(this.aPerson);
        Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION, "Entered data saved successfully!");
        errorAlert.showAndWait();
    }

    @FXML
    protected void onLoadExampleButtonClick() {
        this.aPerson = new Person();
        this.aPerson.setName("John Doe");
        this.aPerson.setPhoneNumber("(819) 555-0123");
        this.aPerson.setEmailAddress("john@gmail.com");
        this.displayPerson(this.aPerson);
    }

    @FXML
    protected void onBuyPassButtonClick() {
        // Making sure there is a Person object to work with.
        if (this.aPerson == null) {
            this.aPerson = new Person();
        }

        // Changing the value and displaying it.
        boolean purchaseResult = this.aPerson.PurchaseParkingPass();
        this.displayPerson(this.aPerson);
        if (!purchaseResult) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR, "This person already had a parking pass! Don't waste my money!");
            errorAlert.showAndWait();
        }
    }

    private void displayPerson(Person person) {
        aNameTextField.setText(aPerson.getName());
        aPhoneNumberTextField.setText(aPerson.getPhoneNumber());
        aEmailAddressTextField.setText(aPerson.getEmailAddress());
        if (person.isPurchasedParkingPass()) {
            aParkingPassLabel.setText("This person has a parking pass!");
            aParkingPassLabel.setTextFill(Color.color(0, 1, 0));
        } else {
            aParkingPassLabel.setText("This person does not have a parking pass!");
            aParkingPassLabel.setTextFill(Color.color(1, 0, 0));
        }
    }
}