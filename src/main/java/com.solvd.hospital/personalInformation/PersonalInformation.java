package com.solvd.hospital.personalInformation;

import com.solvd.hospital.patient.Patient;

public abstract class PersonalInformation {

    private String fistName;
    private String lastName;
    private String gender;
    private int age;
    private String contactNumber;
    private String emailAddress;

    public abstract void printInformation(); // Abstract method overloading

    public abstract void printInformation(Patient patient); //Abstract Method Overloading
    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }



}
