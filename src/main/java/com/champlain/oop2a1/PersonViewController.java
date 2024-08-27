package com.champlain.oop2a1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * The PersonViewController class is the controller for the UI that allows
 * users to interact with a Person object. It handles actions such as saving
 * a person's data, loading example data, and purchasing a parking pass.
 */
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

    /**
     * Handles the save button click event. This method saves the data entered
     * into the text fields into a Person object. If the data is valid, it displays
     * the person's details and shows a confirmation alert.
     */
    @FXML
    protected void onSaveButtonClick() {
        // Making sure there is a Person object to work with.
        if (this.aPerson == null) {
            this.aPerson = new Person();
        }
        try {
            this.aPerson.setName(aNameTextField.getText());
            this.aPerson.setEmailAddress(aEmailAddressTextField.getText());
            this.aPerson.setPhoneNumber(aPhoneNumberTextField.getText());
        } catch (IllegalArgumentException e) {
            handleInputError(e);
            return;
        }

        this.displayPerson(this.aPerson);
        Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION, "Entered data saved successfully!");
        successAlert.showAndWait();
    }

    /**
     * Handles the load example button click event. This method loads an example
     * person's data into the text fields and displays the data.
     */
    @FXML
    protected void onLoadExampleButtonClick() {
        this.aPerson = new Person();
        try {
            this.aPerson.setName("John Doe");
            this.aPerson.setPhoneNumber("(819) 555-0123");
            this.aPerson.setEmailAddress("john@gmail.com");
        } catch (IllegalArgumentException e) {
            handleInputError(e);
        }

        this.displayPerson(this.aPerson);
    }

    /**
     * Handles the buy parking pass button click event. This method changes the
     * parking pass status of the person and displays the updated information.
     * If the person already has a parking pass, an error alert is shown.
     */
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

    /**
     * Displays the details of the person in the corresponding text fields and updates
     * the parking pass label based on the person's parking pass status.
     *
     * @param person the person whose details are to be displayed.
     */
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

    /**
     * Handles input errors by displaying an error alert with the corresponding message.
     *
     * @param e the exception thrown when input data is invalid.
     */
    private void handleInputError(IllegalArgumentException e) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Entered data invalid: " + e.getMessage());
        errorAlert.showAndWait();
    }
}
