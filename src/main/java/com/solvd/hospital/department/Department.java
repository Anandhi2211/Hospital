package com.solvd.hospital.department;

import com.solvd.hospital.doctor.Doctor;

public class Department extends Doctor {
    private String departmentName;
    private String departmentCode;

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return this.departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + this.getDepartmentName() + '\'' +
                ", departmentCode='" + this.getDepartmentCode() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        return (this.departmentCode.equals(((Department) obj).getDepartmentCode()) &&

                this.departmentName.equals(((Department) obj).getDepartmentName()));
    }

    @Override
    public int hashCode() {
        return departmentName.hashCode() ^ departmentCode.hashCode();
    }
}
