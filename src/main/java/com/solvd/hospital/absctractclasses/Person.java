package com.solvd.hospital.absctractclasses;

import com.solvd.hospital.billing.Insurance;
import com.solvd.hospital.patient.personalinformation.PersonalInformation;

public abstract class Person {
    private Insurance insurance;
    private int annualIncome;
    private boolean financialBenefits;
    private PersonalInformation personalInformation;

    public Person() {
    }

    public PersonalInformation getPersonalInformation() {
        return this.personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public boolean isFinancialBenefits() {
        return this.financialBenefits;
    }

    public void setFinancialBenefits(boolean financialBenefits) {
        this.financialBenefits = financialBenefits;
    }

    public int getAnnualIncome() {
        return this.annualIncome;
    }

    public void setAnnualIncome(int annualIncome) {
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
        return "\tFirst Name =" + this.personalInformation.getFirstName() + "\n" +
                "\tGender =" + this.personalInformation.getGender() + "\n" +
                "\tEmail Address =" + this.personalInformation.getEmailAddress() + "\n" +
                "\tContact Number =" + this.personalInformation.getContactNumber() + "\n" +
                "\tinsurance Number =" + this.insurance.getInsuranceNumber() + "\n" +
                "\tinsurance Name =" + this.insurance.getInsuranceName() + "\n" +
                "\tannualIncome='" + this.annualIncome + '\'' +
                '}';
    }
}
