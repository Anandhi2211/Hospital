package com.solvd.hospital.patient;
import com.solvd.hospital.symptoms.Symptoms;
import com.solvd.hospital.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Patient extends Person {
    private static final Logger logger = LogManager.getLogger(Patient.class);
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
        return patientId;
    }
    public void setPatientId(String patientId) {
//        this.patientId = String.valueOf(Hospital.patientId);
//        Hospital.patientId = Integer.valueOf(patientId);
        this.patientId=patientId;
    }
    public void printPatientSymptoms(Symptoms category) {
        logger.info("Symptoms: " + category.getPatientSymptom());
    }
    public void printInformation() {
        logger.info(this.getPersonalInformation().getFirstName());
    }
}
