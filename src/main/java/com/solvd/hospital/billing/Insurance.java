package com.solvd.hospital.billing;

import com.solvd.hospital.exceptions.ExceptionInsurance;

import java.util.regex.Pattern;

public class Insurance {
    private String insuranceName;
    private String insuranceNumber;

    public String getInsuranceName() {
        return this.insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        String regex = "[A-Za-z ]+";
        if (!Pattern.matches(regex, insuranceName)) {
            throw new ExceptionInsurance("Not a Insurance Name");
        } else {
            this.insuranceName = insuranceName;
        }
    }

    public String getInsuranceNumber() {

        return this.insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        String regex = "[0-9]+";
        if (!Pattern.matches(regex, insuranceNumber)) {
            throw new ExceptionInsurance("Not Valid Insurance Number");
        }
        this.insuranceNumber = insuranceNumber;
    }
}
