package com.solvd.hospital.billing;

public class Billing implements IBilling {
    private String billingNumber;
    private int billingAmount;
    private boolean billingStatus;
    public boolean isBillingStatus() {
        return this.billingStatus;
    }
    public void setBillingStatus(boolean billingStatus) {
        this.billingStatus = billingStatus;
    }
    public int getBillingAmount() {
        return this.billingAmount;
    }
    public void setBillingAmount(int billingAmount) {
        this.billingAmount = this.billingAmount + billingAmount;
    }
    public String getBillingNumber() {
        return this.billingNumber;
    }
    public void setBillingNumber(String billingNumber) {
        this.billingNumber = billingNumber;
    }
    @Override
    public String toString() {
        return "\tbillingNumber= " + this.billingNumber + "\n" +
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
    public void billCalculation() {
    }
}

