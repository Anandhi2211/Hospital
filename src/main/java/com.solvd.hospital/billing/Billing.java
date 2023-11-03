package com.solvd.hospital.billing;

public class Billing {
    private String billingNumber;
    public String getBillingNumber() {
        return this.billingNumber;
    }

    public void setBillingNumber(String billingNumber) {
        this.billingNumber = billingNumber;
    }

    public String toString()
    {
        return this.billingNumber;
    }
}
