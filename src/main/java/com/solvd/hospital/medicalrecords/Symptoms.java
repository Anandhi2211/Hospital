package com.solvd.hospital.medicalrecords;

import java.util.regex.Pattern;

public class Symptoms {

    private String patientSymptom;

    public String getPatientSymptom() {
        return this.patientSymptom;
    }

    public void setPatientSymptom(String patientSymptom) throws ExceptionMedicalRecord {
        String regex = "[A-Za-z ]+";
        if (!Pattern.matches(regex, patientSymptom)) {
            throw new ExceptionMedicalRecord("Not a Valid Symptom");
        } else {
            this.patientSymptom = patientSymptom;
        }
    }

}
