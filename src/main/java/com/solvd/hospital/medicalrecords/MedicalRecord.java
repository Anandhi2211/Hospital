package com.solvd.hospital.medicalrecords;

import com.solvd.hospital.patientrecord.PatientRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MedicalRecord implements IMedicalRecords{
    private static final Logger logger = LogManager.getLogger(PatientRecord.class);

    private boolean prescriptionStatus;
    private String testName;

    public boolean getPrescriptionStatus() {

        return this.prescriptionStatus;
    }
    public void setPrescriptionStatus(boolean prescriptionStatus) {
        this.prescriptionStatus = prescriptionStatus;
    }
    public String getTestName() {

        if(this.testName == null)
        {
            this.testName = "No Test Assigned";
        }
        return this.testName;
    }
    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Override
    public String toString() {
        return "prescriptionStatus= " + prescriptionStatus + "\n"+
                "testName= " + testName + "\n";
    }

    @Override
    public void printPatientMedicalRecords() {

//        logger.info("Patient Id: " + this.getPatient().getPatientId());
//        logger.info("Patient Name: " + this.getPatient().getPersonalInformation().getFirstName());
//        logger.info("Patient Symptoms: " + this.getPatient().getSymptoms().getPatientSymptom());
        logger.info("Doctor Prescribed to Patient: " + this.getTestName());
        logger.info("Patient Prescription Status: " + this.getPrescriptionStatus());

    }
}
