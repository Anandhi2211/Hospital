package com.solvd.hospital.billing;

public class Billing implements IBilling {
    private String billingNumber;




    public String getBillingNumber() {
        return billingNumber;
    }

    public void setBillingNumber(String billingNumber) {
        this.billingNumber = billingNumber;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "billingNumber='" + billingNumber + '\'' +
                '}';
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

}

