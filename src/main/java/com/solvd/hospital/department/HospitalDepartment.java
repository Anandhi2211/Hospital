package com.solvd.hospital.department;

public enum HospitalDepartment {
    DERMATOLOGY(100),
    OTOLARYNGOLOGY(101),
    ORTHOPEDIC(102);
    final int deptCode;
    public String getDeptCode() {
        return String.valueOf(this.deptCode);
    }
    HospitalDepartment(int deptCode) {
        this.deptCode = deptCode;
    }
}
