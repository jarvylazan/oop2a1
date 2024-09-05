package com.champlain.oop2a1;

/**
 * The Person class represents a person with a name, email address, phone number,
 * and parking pass status.
 */
public class Person {

    // Private member variables
    private String aName;
    private String aEmailAddress;
    private String aPhoneNumber;
    private boolean aPassStatus;

    /**
     * Default constructor for the Person class.
     * Initializes the name, email address, and phone number to empty strings,
     * and not have the parking pass by default.
     */
    public Person() {
        aName = "";
        aEmailAddress = "";
        aPhoneNumber = "";
        aPassStatus = false;
    }

    /**
     * Parameterized constructor for the Person class, permitting
     * initialization of an instant of a Person with a set of attributes.
     *
     * @param pName         the name of the person.
     * @param pEmailAddress the email address of the person.
     * @param pPhoneNumber  the phone number of the person.
     * @param pPassStatus   the parking pass status of the person.
     */
    public Person(String pName, String pEmailAddress, String pPhoneNumber, boolean pPassStatus) {
        aName = pName;
        aPhoneNumber = pPhoneNumber;
        if (!pEmailAddress.isEmpty()) {
            validateEmailAddress(pEmailAddress);
        }
        // Assign the email nonetheless, so it will be shown in the textbox.
        aEmailAddress = pEmailAddress;
        aPassStatus = pPassStatus;
    }

    /**
     * Sets the name of the person.
     *
     * @param pName the name to set.
     */
    public void setName(String pName) {
        aName = pName;
    }

    /**
     * Sets the phone number of the person.
     *
     * @param pPhoneNumber the phone number to set phone number from the text field.
     */
    public void setPhoneNumber(String pPhoneNumber) {
        aPhoneNumber = pPhoneNumber;
    }

    /**
     * Sets the email address of the person.
     * Validates the email address format before setting it.
     * An empty email address is considered valid.
     *
     * @param pEmailAddress the email address to set.
     * @throws IllegalArgumentException if the email address is not in a valid format.
     */
    public void setEmailAddress(String pEmailAddress) {
        if (pEmailAddress.isEmpty() || validateEmailAddress(pEmailAddress)) {
            aEmailAddress = pEmailAddress;
        }
    }


    /**
     * Purchases a parking pass for the person.
     * If the person already has a parking pass, it does not change the status.
     *
     * @return true if the parking pass is already purchased, otherwise false.
     */
    public boolean PurchaseParkingPass() {
        if (!aPassStatus) {
            return aPassStatus = true;
        } else {
            return false;
        }
    }

    /**
     * Gets the name of the person.
     *
     * @return the name of the person.
     */
    public String getName() {
        return aName;
    }

    /**
     * Gets the phone number of the person.
     *
     * @return the phone number of the person.
     */
    public String getPhoneNumber() {
        return aPhoneNumber;
    }

    /**
     * Checks if the person has purchased a parking pass.
     *
     * @return true if the person has purchased a parking pass, otherwise false.
     */
    public boolean isPurchasedParkingPass() {
        return aPassStatus;
    }

    /**
     * Gets the email address of the person.
     *
     * @return the email address of the person.
     */
    public String getEmailAddress() {
        return aEmailAddress;
    }

    /**
     * Validates the email address format.
     * Throws an exception if the email address is invalid.
     *
     * @param pEmailAddress the email address to validate.
     * @return true if the email address is valid.
     * @throws IllegalArgumentException if the email address is not in a valid format.
     */
    private boolean validateEmailAddress(String pEmailAddress) {
        if (pEmailAddress.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return true;
        } else {
            throw new IllegalArgumentException("\"" + pEmailAddress + "\" is not a valid email address.");
        }
    }
}
