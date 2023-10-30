package main.java.com.solvd.hospital.doctor;

import main.java.com.solvd.hospital.department.Department;
import main.java.com.solvd.hospital.personalInformation.PersonalInformation;

public class Doctor {
    private String doctorId;
    private String doctorAvailableStatus;
    private PersonalInformation personalInfo;
    private Department departmentInfo;


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
