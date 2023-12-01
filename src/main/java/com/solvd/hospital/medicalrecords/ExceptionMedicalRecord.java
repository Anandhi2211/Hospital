package com.solvd.hospital.medicalrecords;

public class ExceptionMedicalRecord extends RuntimeException {
    public ExceptionMedicalRecord(String message) {
        super(message);
    }
}
