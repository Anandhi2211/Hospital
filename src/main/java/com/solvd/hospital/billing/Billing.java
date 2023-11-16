package com.solvd.hospital.billing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Billing implements IBilling {
    private static final Logger logger = LogManager.getLogger(Billing.class);
    private String billingNumber;
    public String getBillingNumber() {
        return billingNumber;
    }
    public void setBillingNumber(String billingNumber) {
        this.billingNumber = billingNumber;
    }
}

