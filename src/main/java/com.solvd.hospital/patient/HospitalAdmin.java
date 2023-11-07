package com.solvd.hospital.patient;

import com.solvd.hospital.PatientRecord.PatientRecord;
import com.solvd.hospital.doctor.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalAdmin implements IHospitalAdmin {
    Scanner in = new Scanner(System.in);
    public static ArrayList<PatientRecord> patientRecords = new ArrayList<PatientRecord>();
    public static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();

    @Override
    public void welcomePage() {
        System.out.println("Welcome to Hospital Portal!");
        System.out.println("Please choose the options");
        System.out.println("List Patients Name -- option 1");
        System.out.println("List Doctors Name --- option 2");
        System.out.println("Assign Doctor for each Patient -- option 3");
        System.out.println("Look up particular patient -- option 4");
        System.out.println("Generate Bill for each patient: -- option 5 ");
        System.out.println("View all the patient Details  -- option 6");
        System.out.println("Exit Portal -- option 7");
        System.out.print("Please Enter your option");
    }

    public String getPatientName() {
        System.out.print("Enter the Patient Name: ");
        String patientName = in.next();
        return patientName;
    }
}
