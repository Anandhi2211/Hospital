package com.solvd.hospital.medicalrecords;

public class MedicalRecord {

    private Boolean prescriptionStatus;
    private String testName;

    public Boolean getPrescriptionStatus() {
        return this.prescriptionStatus;
    }

    public void setPrescriptionStatus(Boolean prescriptionStatus) {

        this.prescriptionStatus = prescriptionStatus;
    }

    public String getTestName() {
        return this.testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
}
