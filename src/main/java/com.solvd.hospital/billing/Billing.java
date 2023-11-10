package com.solvd.hospital.billing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class Billing implements IBilling {
    private static final Logger logger = LogManager.getLogger(Billing.class);
    String billingNumber;

    @Override
    public void billNumberGenerated(String departmentCode) {

        if (departmentCode.equals("100")) {
            this.billingNumber = UUID.randomUUID().toString();
            logger.info("Bill Generated for the Patient : " + this.billingNumber);
            logger.info("Co-pay amount for Dermatology visit: " + Billing.dermatologyCoPay);
        } else if (departmentCode.equals("101")) {
            this.billingNumber = UUID.randomUUID().toString();
            logger.info("Bill Generated for the Patient : " + this.billingNumber);
            logger.info("Co-pay amount for Otolaryngology visit: " + Billing.OtolaryngologyCoPay);
        } else if (departmentCode.equals("102")) {
            this.billingNumber = UUID.randomUUID().toString();
            logger.info("Bill Generated for the Patient : " + this.billingNumber);
            logger.info("Co-pay amount for Orthopedic visit: " + Billing.OrthopedicCoPay);
        }
    }
}
