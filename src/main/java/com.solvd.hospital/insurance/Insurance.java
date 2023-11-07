package com.solvd.hospital.insurance;

public class Insurance {
    private String insuranceName;
    private String insuranceNumber;
    private String benefitsEligibilityStatus;

    public void setInsuranceName(String insuranceName) {

        this.insuranceName = insuranceName;
    }

    public void setInsuranceNumber(String insuranceNumber) {

        this.insuranceNumber = insuranceNumber;
    }

    public void setBenefitsEligibilityStatus(String benefitsEligibilityStatus) {
        this.benefitsEligibilityStatus = benefitsEligibilityStatus;
    }

    public String getInsuranceName() {

        return insuranceName;
    }

    public String getInsuranceNumber() {

        return insuranceNumber;
    }

    public String getBenefitsEligibilityStatus() {

        return benefitsEligibilityStatus;
    }
}
