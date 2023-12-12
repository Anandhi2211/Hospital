package com.solvd.hospital.interfaces;

import com.solvd.hospital.patient.PatientRecord;

public interface IBilling {
    void billCalculation(PatientRecord patientRecord);
}
