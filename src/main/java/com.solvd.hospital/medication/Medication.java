package com.solvd.hospital.medication;

public class Medication {
    private String medicationStatus;
    public String getMedicationStatus() {

        return medicationStatus;
    }
    public void setMedicationStatus(String medicationStatus) {

        this.medicationStatus = medicationStatus;
    }
    public String toString()
    {
        return this.getMedicationStatus();
    }
}
