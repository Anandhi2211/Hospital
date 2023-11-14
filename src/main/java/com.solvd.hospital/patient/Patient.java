package com.solvd.hospital.patient;

import com.solvd.hospital.medicalCategory.MedicalCategory;
import com.solvd.hospital.personalInformation.PersonalInformation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Patient extends PersonalInformation {
    private static final Logger logger = LogManager.getLogger(Patient.class);

    private String patientId;
    private MedicalCategory category;

    public Patient() {
        if (this.category == null) {
            this.category = new MedicalCategory();
        }
    }

    public String getPatientId() {

        return this.patientId;
    }

    public void setPatientId(String patientId) {

        this.patientId = patientId;
    }

    public MedicalCategory getCategory() {

        return this.category;
    }

    public void setCategory(MedicalCategory category) {

        this.category = category;
    }

    public void printPatientSymtoms(MedicalCategory category) {

        logger.info("Symptoms: " + category.getPatientSymtom());
    }

    @Override

    public void printInformation() {

        logger.info(this.getFirstName());
    }
}
