package com.solvd.hospital.doctor;

import com.solvd.hospital.department.Department;
import com.solvd.hospital.medicalCategory.MedicalCategory;
import com.solvd.hospital.patient.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class Doctor extends Department {

    private String doctorId;
    private Department departmentInfo;
    private ArrayList<String> treatableSymtomList = new ArrayList<String>();

    public ArrayList<String> getTreatableSymtomList() {
        return this.treatableSymtomList;
    }

    public void setTreatableSymtom(String symtom) {
        this.treatableSymtomList.add(symtom);
    }

    public boolean isTreatable(String symtom) {
        return this.treatableSymtomList.contains(symtom);
    }

    public String getDoctorId() {

        return doctorId;
    }

    public void setDoctorId(String doctorId) {

        this.doctorId = doctorId;
    }

    public Department getDepartmentInfo() {

        return departmentInfo;
    }

    public void setDepartmentInfo(Doctor doctor) {

        this.departmentInfo = doctor;
    }

    public String toString() {
        return
                this.doctorId + "\n\t";

    }

    @Override
    public void assignedDoctor(String patientName, ArrayList<Patient> patientList, Scanner in, ArrayList<Doctor> doctorList) {

        for (Patient p : patientList) {
            if (p.getPersonalInfo().getFistName().equalsIgnoreCase(patientName)) {
                String patientSymtom = p.getCategory().getPatientSymtom();
                System.out.println("Patient Symtoms: " + patientSymtom);

                System.out.println("Do you want to make appointment?  Y/N ");
                String answer = in.next();

                if (answer.equalsIgnoreCase("y")) {
                    Doctor d = new Doctor();
                    for (Doctor doctor : doctorList) {
                        if (doctor.isTreatable(patientSymtom)) {
                            System.out.println("This Doctor ID " + doctor + "is assigned for this Patient");
                            break;
                        }
                    }
                    System.out.println("");
                } else if (answer.equalsIgnoreCase("N")) {
                    System.out.println("Doctor is not assigned..!!");
                    break;
                } else {
                    System.out.println("Enter the correct Value and Start from the beginning");
                }
            }
        }

    }

}
