package com.solvd.hospital.doctor;

import com.solvd.hospital.department.Department;

public class Doctor extends Department {

    private String doctorId;
    private Boolean doctorAvailableStatus;

   private Department departmentInfo;


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


    public Boolean getDoctorAvailableStatus() {

        return doctorAvailableStatus;
    }

    public void setDoctorAvailableStatus(Boolean doctorAvailableStatus) {

        this.doctorAvailableStatus = doctorAvailableStatus;
    }

    public String toString()
    {
        return
                this.doctorId+"\t"+departmentInfo.getDepartmentCode()+"\t"+departmentInfo.getDepartmentName()+"\t";

    }

    @Override
    public void assignedDoctor() {



    }
}
