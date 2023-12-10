package com.solvd.hospital.enums;

public enum ListOfSymptoms {
    SKIN_INFECTION(1, HospitalDepartment.DERMATOLOGY.getDeptCode()),
    PIGMENTATION_REMOVAL(2, HospitalDepartment.DERMATOLOGY.getDeptCode()),
    SKIN_RASHES(3, HospitalDepartment.DERMATOLOGY.getDeptCode()),
    TAN_REMOVAL(4, HospitalDepartment.DERMATOLOGY.getDeptCode()),

    EAR_FLUID(5, HospitalDepartment.OTOLARYNGOLOGY.getDeptCode()),
    EAR_PAIN(6, HospitalDepartment.OTOLARYNGOLOGY.getDeptCode()),
    EAR_INFECTION(7, HospitalDepartment.OTOLARYNGOLOGY.getDeptCode()),

    NECK_PAIN(8, HospitalDepartment.OTOLARYNGOLOGY.getDeptCode()),
    BACK_PAIN(9, HospitalDepartment.OTOLARYNGOLOGY.getDeptCode()),
    KNEE_PAIN(10, HospitalDepartment.OTOLARYNGOLOGY.getDeptCode());


    final int value;
    final String deptCode;

    ListOfSymptoms(int value, String deptCode) {
        this.value = value;
        this.deptCode = deptCode;
    }

    public int getValue() {
        return value;
    }

    public String getDeptCode() {
        return deptCode;
    }
}
