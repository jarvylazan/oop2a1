package com.champlain.oop2a1;

public class Person {

    private String aName;
    private String aEmailAddress;
    private String aPhoneNumber;
    private boolean aPassStatus;

    public Person() {
        aName = "";
        aEmailAddress = "";
        aPhoneNumber = "";
        aPassStatus = false;
    }

    public  Person(String pName, String pEmailAddress, String pPhoneNumber, boolean pPassStatus) {
        aName = pName;
        aEmailAddress = pEmailAddress;
        aPhoneNumber = pPhoneNumber;
        aPassStatus = pPassStatus;
    }

    public void setName(String pName) {
        aName = pName;
    }

    public void setEmailAddress(String pEmailAddress) {
        if (pEmailAddress.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            aEmailAddress = pEmailAddress;
        } else {
            throw new IllegalArgumentException("\"" + pEmailAddress + "\" is not a valid email address.");
        }
    }

    public void setPhoneNumber(String pPhoneNumber) {
        aPhoneNumber = pPhoneNumber;
    }

    public boolean PurchaseParkingPass() {
        return aPassStatus = true;
    }

    public String getName() {
        return aName;
    }

    public String getPhoneNumber() {
        return aPhoneNumber;
    }

    public boolean isPurchasedParkingPass() {
        return aPassStatus;
    }

    public String getEmailAddress() {
        return aEmailAddress;
    }
}
