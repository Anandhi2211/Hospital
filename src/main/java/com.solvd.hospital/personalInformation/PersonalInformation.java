package com.solvd.hospital.personalInformation;

import java.util.regex.Pattern;

public abstract class PersonalInformation {

    String firstName;
    String gender;
    int age;
    String contactNumber;
    String emailAddress;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws ExceptionPersonalInformation {

        String regex = "[A-Za-z]+";
        if (!Pattern.matches(regex, firstName)) {
            throw new ExceptionPersonalInformation("Not Valid Name");
        } else {
            this.firstName = firstName;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public abstract void printInformation(); // Abstract method overloading

}
