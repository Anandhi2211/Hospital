package com.solvd.hospital.person;

import com.solvd.hospital.insurance.Insurance;
import com.solvd.hospital.personalinformation.PersonalInformation;

public abstract class Person  {
    private Insurance insurance;
    private String annualIncome;

    public PersonalInformation getPersonalInformation() {
        return this.personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    private PersonalInformation personalInformation;
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
    public void printInformation() {
    }
    @Override
    public String toString() {
        return  "\tFirst Name =" + personalInformation.getFirstName() + "\n"+
                "\tGender =" + personalInformation.getGender() +"\n"+
                "\tEmail Address =" + personalInformation.getEmailAddress() +"\n"+
                "\tContact Number =" + personalInformation.getContactNumber() +"\n"+
                "\tinsurance Number =" + this.insurance.getInsuranceNumber() +"\n"+
                "\tinsurance Name =" + this.insurance.getInsuranceName() +"\n"+
                "\tannualIncome='" + this.annualIncome + '\'' +
                '}';
    }
}
