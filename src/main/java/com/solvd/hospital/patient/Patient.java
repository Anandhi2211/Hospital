package com.solvd.hospital.patient;

import com.solvd.hospital.Hospital;
import com.solvd.hospital.absctractclasses.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Patient extends Person {
    private static final Logger logger = LogManager.getLogger(Hospital.class);
    private String patientId;
    private Symptoms symptoms;

    public Patient() {
    }

    public Symptoms getSymptoms() {
        return this.symptoms;
    }

    public void setSymptoms(Symptoms symptoms) {
        this.symptoms = symptoms;
    }

    public String getPatientId() {
        return this.patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void printPatientSymptoms(Symptoms category) {
        logger.info("Symptoms: " + category.getPatientSymptom());
    }

    public void printInformation() {
        logger.info(this.getPersonalInformation().getFirstName());
        logger.info(this.getPatientId());
        logger.info(this.getSymptoms().getPatientSymptom());
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                ", symptoms=" + symptoms +
                '}';
    }
}
