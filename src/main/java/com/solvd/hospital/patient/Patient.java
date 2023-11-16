package com.solvd.hospital.patient;

import com.solvd.hospital.medicalrecords.Symptoms;
import com.solvd.hospital.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Patient   {
    private static final Logger logger = LogManager.getLogger(Patient.class);

    private String patientId;

    public Symptoms getSymptoms() {
        return this.symptoms;
    }

    public void setSymptoms(Symptoms symptoms) {


        this.symptoms = symptoms;
    }

    private Symptoms symptoms;
    private Person person;


    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Patient() {
        if (this.symptoms == null) {
            this.symptoms = new Symptoms();
        }
    }


    public void printPatientSymtoms(Symptoms category) {

        logger.info("Symptoms: " + category.getPatientSymptom());
    }

    public void printInformation() {

        logger.info(this.getPerson().getFirstName());
    }
}
