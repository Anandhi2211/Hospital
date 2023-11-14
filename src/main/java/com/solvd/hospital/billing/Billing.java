package com.solvd.hospital.billing;

import com.solvd.hospital.PatientRecord.PatientRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class Billing implements IBilling {
    private static final Logger logger = LogManager.getLogger(Billing.class);

    public String getBillingNumber() {
        return billingNumber;
    }

    public void setBillingNumber(String billingNumber) {
        this.billingNumber = billingNumber;
    }

    public String billingNumber;

    @Override
    public void billNumberGenerated(String patientId, HashMap<String, PatientRecord> patientRecordHashMap, String departmentCode, HashSet<String> billNumber) {
        if (departmentCode.equals("100")) {
            PatientRecord p = patientRecordHashMap.get(patientId);
            Billing billing = new Billing();
            this.billingNumber = UUID.randomUUID().toString();
            logger.info("Bill Generated for the Patient : " + this.billingNumber);
            billing.setBillingNumber(this.billingNumber);
            p.setBillingsList(billing);
            patientRecordHashMap.put(patientId, p);
            billNumber.add(this.billingNumber);
            logger.info("Co-pay amount for Dermatology visit: " + Billing.dermatologyCoPay);
        } else if (departmentCode.equals("101")) {
            PatientRecord p = patientRecordHashMap.get(patientId);
            Billing billing = new Billing();
            this.billingNumber = UUID.randomUUID().toString();
            logger.info("Bill Generated for the Patient : " + this.billingNumber);
            billing.setBillingNumber(this.billingNumber);
            p.setBillingsList(billing);
            patientRecordHashMap.put(patientId, p);
            billNumber.add(this.billingNumber);
            logger.info("Co-pay amount for Otolaryngology visit: " + Billing.OtolaryngologyCoPay);
        } else if (departmentCode.equals("102")) {
            PatientRecord p = patientRecordHashMap.get(patientId);
            Billing billing = new Billing();
            this.billingNumber = UUID.randomUUID().toString();
            logger.info("Bill Generated for the Patient : " + this.billingNumber);
            billing.setBillingNumber(this.billingNumber);
            p.setBillingsList(billing);
            patientRecordHashMap.put(patientId, p);
            billNumber.add(this.billingNumber);
            logger.info("Co-pay amount for Orthopedic visit: " + Billing.OrthopedicCoPay);
        }
    }
}
