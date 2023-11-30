package com.solvd.hospital.department;

public enum HospitalDepartment {
    DERMATOLOGY(100),
    OTOLARYNGOLOGY(101),
    ORTHOPEDIC(102);

    public String getDeptCode() {
        return String.valueOf(deptCode);
    }

    final int deptCode;

    HospitalDepartment(int deptCode) {
        this.deptCode = deptCode;
    }
}
