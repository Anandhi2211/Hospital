package com.solvd.hospital.billing;

import com.solvd.hospital.absctractclasses.FinancialBenefits;
import com.solvd.hospital.interfaces.IBilling;
import com.solvd.hospital.interfaces.IPayment;
import com.solvd.hospital.patient.PatientRecord;

public class Billing extends FinancialBenefits implements IBilling, IPayment {
    private String billingNumber;
    private int billingAmount;
    private boolean billingGeneratedStatus;

    public boolean isBillingGeneratedStatus() {
        return this.billingGeneratedStatus;
    }

    public void setBillingGeneratedStatus(boolean billingGeneratedStatus) {
        this.billingGeneratedStatus = billingGeneratedStatus;
    }

    public int getBillingAmount() {
        return this.billingAmount;
    }

    public void setBillingAmount(int billingAmount) {
        this.billingAmount = billingAmount;
    }

    public String getBillingNumber() {
        return this.billingNumber;
    }

    public void setBillingNumber(String billingNumber) {
        this.billingNumber = billingNumber;
    }

    @Override
    public String toString() {
        return "\n" +
                "\tBillingNumber= " + this.billingNumber + "\n" +
                "\tBilling Amount='" + this.billingAmount + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        return (this.billingNumber.equals(((Billing) obj).billingNumber));
    }

    @Override
    public int hashCode() {
        return billingNumber.hashCode();
    }

    @Override
    public PatientRecord checkFinancialBenefits(PatientRecord patientRecord) {
        if (patientRecord.getPatient().getAnnualIncome() < 50000) {
            this.setBenefitPercent(75);
            this.setBenefitStatus(true);
        } else if ((patientRecord.getPatient().getAnnualIncome() >= 50000) && (patientRecord.getPatient().getAnnualIncome() < 75000)) {
            this.setBenefitPercent(50);
            this.setBenefitStatus(true);
        } else if ((patientRecord.getPatient().getAnnualIncome() >= 75000) && (patientRecord.getPatient().getAnnualIncome() < 100000)) {
            this.setBenefitPercent(25);
            this.setBenefitStatus(true);
        } else if ((patientRecord.getPatient().getAnnualIncome() >= 100000)) {
            this.setBenefitPercent(1);
            this.setBenefitStatus(false);
        }
        patientRecord.setBilling(this);
        return patientRecord;
    }

    @Override
    public void billCalculation(PatientRecord patientRecord) {
    }
}

