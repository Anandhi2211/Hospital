package com.solvd.hospital.enums;

public enum HospitalDepartment {
    DERMATOLOGY(100),
    OTOLARYNGOLOGY(101),
    ORTHOPEDIC(102);
    final int deptCode;

    HospitalDepartment(int deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptCode() {
        return String.valueOf(this.deptCode);
    }
}
