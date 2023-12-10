package com.solvd.hospital.interfaces;

import com.solvd.hospital.patient.PatientRecord;

public interface IPayment {
    PatientRecord checkFinancialBenefits(PatientRecord patientRecord);

}
