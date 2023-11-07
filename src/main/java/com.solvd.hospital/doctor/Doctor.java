package com.solvd.hospital.doctor;

import com.solvd.hospital.department.Department;
import com.solvd.hospital.personalInformation.PersonalInformation;

import java.util.ArrayList;

public class Doctor extends PersonalInformation {

    private String doctorId;
    public Department departmentInfo;
    private ArrayList<String> treatableSymtomList = new ArrayList<String>();


    public String getDoctorId() {

        return this.doctorId;
    }

    public void setDoctorId(String doctorId) {

        this.doctorId = doctorId;
    }

    public Department getDepartmentInfo() {

        return departmentInfo;
    }

    public void setDepartmentInfo(Department departmentInfo) {

        this.departmentInfo = departmentInfo;
    }

    public ArrayList<String> getTreatableSymtomList() {

        return this.treatableSymtomList;
    }

    public void setTreatableSymtom(String symtom) {

        this.treatableSymtomList.add(symtom);
    }

    public boolean isTreatable(String symtom) {

        return this.treatableSymtomList.contains(symtom);
    }

    public String toString() {

        return this.doctorId;
    }

    @Override
    public void printInformation() {

        System.out.println("Doctor Details");
        System.out.println("Name: " + this.getFistName());
        System.out.println("Id: " + this.getDoctorId());
        System.out.println("Department Code: " + this.getDepartmentInfo().getDepartmentCode());
        System.out.println("Contact Number:" + this.getContactNumber());

    }
}
