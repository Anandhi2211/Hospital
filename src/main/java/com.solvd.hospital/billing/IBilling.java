package com.solvd.hospital.billing;

import com.solvd.hospital.PatientRecord.PatientRecord;

import java.util.HashMap;
import java.util.HashSet;

public interface IBilling {

    final static String dermatologyCoPay = "$50";
    final static String OtolaryngologyCoPay = "$70";
    final static String OrthopedicCoPay = "$100";

    void billNumberGenerated(String patientId, HashMap<String, PatientRecord> patientRecordHashMap, String departmentCode, HashSet<String> billNumber);

}
