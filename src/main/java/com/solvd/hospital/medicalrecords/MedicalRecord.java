package com.solvd.hospital.medicalrecords;

public class MedicalRecord {

    private boolean prescriptionStatus;
    private String testName;

    public boolean getPrescriptionStatus() {
        return this.prescriptionStatus;
    }

    public void setPrescriptionStatus(boolean prescriptionStatus) {

        this.prescriptionStatus = prescriptionStatus;
    }

    public String getTestName() {
        return this.testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
}
