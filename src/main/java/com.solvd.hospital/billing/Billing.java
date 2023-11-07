package com.solvd.hospital.billing;

import java.util.UUID;

public class Billing implements IBilling {
    String billingNumber;

    @Override
    public void billNumberGenerated(String departmentCode) {

        if (departmentCode.equals("100")) {
            this.billingNumber = UUID.randomUUID().toString();
            System.out.println("Bill Generated for the Patient : " + this.billingNumber);
            System.out.println("Copay amount for Dermatology visit: " + Billing.dermatologyCoPay);
        } else if (departmentCode.equals("101")) {
            this.billingNumber = UUID.randomUUID().toString();
            System.out.println("Bill Generated for the Patient : " + this.billingNumber);
            System.out.println("Copay amount for Otolaryngology visit: " + Billing.OtolaryngologyCoPay);
        } else if (departmentCode.equals("102")) {
            this.billingNumber = UUID.randomUUID().toString();
            System.out.println("Bill Generated for the Patient : " + this.billingNumber);
            System.out.println("Copay amount for Orthopedic visit: " + Billing.OrthopedicCoPay);
        }
    }
}
