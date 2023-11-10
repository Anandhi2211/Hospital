package com.solvd.hospital.department;

import com.solvd.hospital.doctor.Doctor;

public class Department extends Doctor {
    private String departmentName;
    private String departmentCode;

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


}
