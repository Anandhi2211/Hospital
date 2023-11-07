package com.solvd.hospital.patient;

import com.solvd.hospital.medicalCategory.MedicalCategory;
import com.solvd.hospital.personalInformation.PersonalInformation;

public class Patient extends PersonalInformation {

    private String patientId;
    private MedicalCategory category = new MedicalCategory();


    public Patient() {
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

        System.out.println("Symptoms: " + category.getPatientSymtom());
    }

    @Override

    public void printInformation() {

        System.out.println(this.getFistName());
    }


}
