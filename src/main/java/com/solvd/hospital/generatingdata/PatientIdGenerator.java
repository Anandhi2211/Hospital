package com.solvd.hospital.generatingdata;

public class PatientIdGenerator {
    private static PatientIdGenerator patientIdGenerator = null;
    private static long patientId = 999;

    public PatientIdGenerator() {
    }

    public static PatientIdGenerator patientIdGenerator() {
        if (patientIdGenerator == null) {
            patientIdGenerator = new PatientIdGenerator();
        }
        return patientIdGenerator;
    }

    public String getPatientIdGenerator() {
        patientId++;
        return String.valueOf(this.patientId);
    }
}
