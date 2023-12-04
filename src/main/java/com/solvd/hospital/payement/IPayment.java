package com.solvd.hospital.payement;

import com.solvd.hospital.patientrecord.PatientRecord;

import java.util.HashMap;
import java.util.Scanner;

public interface IPayment {
    PatientRecord checkFinancialBenefits( PatientRecord patientRecord);

}
