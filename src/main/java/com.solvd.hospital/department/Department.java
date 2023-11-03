package com.solvd.hospital.department;

import com.solvd.hospital.doctor.Doctor;
import com.solvd.hospital.patient.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Department  {
    private String departmentName;
    private String departmentCode;
   // private String[] symptoms;

    public String getDepartmentName() {
        return this.departmentName;
    }

    public String getDepartmentCode() {
        return this.departmentCode;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public abstract void assignedDoctor(String patientName, ArrayList<Patient> patientList, Scanner in, ArrayList<Doctor> doctorList);
}
