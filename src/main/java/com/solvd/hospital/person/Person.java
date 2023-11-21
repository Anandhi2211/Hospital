package com.solvd.hospital.person;

import com.solvd.hospital.insurance.Insurance;
import com.solvd.hospital.personalinformation.PersonalInformation;

public class Person extends PersonalInformation {
    private Insurance insurance;
    private String annualIncome;
    public Person( ) {
    }
    public String getAnnualIncome() {
        return this.annualIncome;
    }
    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }
    public Insurance getInsurance() {
        return this.insurance;
    }
    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
    @Override
    public void printInformation() {
    }
    @Override
    public String toString() {
        return  "\tFirst Name =" + this.getFirstName() + "\n"+
                "\tGender =" + this.getGender() +"\n"+
                "\tEmail Address =" + this.getEmailAddress() +"\n"+
                "\tContact Number =" + this.getContactNumber() +"\n"+
                "\tinsurance Number =" + this.insurance.getInsuranceNumber() +"\n"+
                "\tinsurance Name =" + this.insurance.getInsuranceName() +"\n"+
                "\tannualIncome='" + this.annualIncome + '\'' +
                '}';
    }
}
