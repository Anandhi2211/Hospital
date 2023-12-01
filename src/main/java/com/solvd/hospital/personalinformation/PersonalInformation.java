package com.solvd.hospital.personalinformation;

import java.util.regex.Pattern;

public class PersonalInformation <S> {
    private S firstname;
    private S gender;
    private S contactNumber;
    private S emailAddress;
    public S getFirstName() {
        return firstname;
    }
    public void setFirstName(S firstName) throws ExceptionPersonalInformation {
        String regex = "[A-Za-z]+";
        if (!Pattern.matches(regex, (CharSequence) firstName)) {
            throw new ExceptionPersonalInformation("Not Valid Name");
        } else {
            this.firstname = firstName;
        }
    }
    public S getGender() {
        return gender;
    }
    public void setGender(S gender) throws ExceptionPersonalInformation {
        if ((!gender.equals("M")) && (!gender.equals("F"))) {
            throw new ExceptionPersonalInformation("Gender should be either M/F");
        } else {
            this.gender = gender;
        }
    }
    public S getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(S contactNumber) {
        this.contactNumber = contactNumber;
    }
    public S getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(S emailAddress) {
        this.emailAddress = emailAddress;
    }

}
