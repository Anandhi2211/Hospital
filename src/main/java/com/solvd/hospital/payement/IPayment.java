package com.solvd.hospital.payement;

import com.solvd.hospital.patientrecord.PatientRecord;

public interface IPayment {
    PatientRecord checkFinancialBenefits( PatientRecord patientRecord);

}
