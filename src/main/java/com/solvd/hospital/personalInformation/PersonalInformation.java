package com.solvd.hospital.personalInformation;

import java.util.regex.Pattern;

public abstract class PersonalInformation {

//    Parameter<String> firstName;

    private String firstname;
    private String gender;
//    private Integer age;
    private String contactNumber;
    private String emailAddress;

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) throws ExceptionPersonalInformation {

        String regex = "[A-Za-z]+";
        if (!Pattern.matches(regex, firstName)) {
            throw new ExceptionPersonalInformation("Not Valid Name");
        } else {
            this.firstname=firstName;
        }
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) throws ExceptionPersonalInformation {
        if((!gender.equals("M")) && (!gender.equals("F")))
        {
            throw new ExceptionPersonalInformation("Gender should be either M/F");
        }
        else{
            this.gender = gender;
        }
    }

//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//
//
//        this.age = age;
//    }

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
