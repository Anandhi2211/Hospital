package main.java.com.solvd.hospital.doctor;

import main.java.com.solvd.hospital.department.Department;
import main.java.com.solvd.hospital.personalInformation.PersonalInformation;

import java.util.ArrayList;

public class Doctor {
    public Doctor() {

    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    private String doctorId;
    private String doctorAvailableStatus;
    private PersonalInformation personalInfo;

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    private String departmentCode;
    public Department getDepartmentInfo() {
        return departmentInfo;
    }

    public void setDepartmentInfo(Department departmentInfo) {
        this.departmentInfo = departmentInfo;
    }

    private Department departmentInfo;


    public void setPersonalInfo(PersonalInformation personalInfo) {
        this.personalInfo = personalInfo;
    }

    public PersonalInformation getPersonalInfo() {
        return personalInfo;
    }

    public Doctor(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorAvailableStatus() {
        return doctorAvailableStatus;
    }

    public void setDoctorAvailableStatus(String doctorAvailableStatus) {
        this.doctorAvailableStatus = doctorAvailableStatus;
    }


}
