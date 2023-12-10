package com.solvd.hospital.enums;

public enum CoPay {
    DERMATOLOGY_CO_PAY(50, HospitalDepartment.DERMATOLOGY.getDeptCode()),
    OTOLARYNGOLOGY_CO_PAY(70, HospitalDepartment.OTOLARYNGOLOGY.getDeptCode()),
    ORTHOPEDIC_CO_PAY(100, HospitalDepartment.ORTHOPEDIC.getDeptCode());
    final int coPayAmt;
    final String depCode;

    CoPay(int coPayAmt, String depCode) {
        this.coPayAmt = coPayAmt;
        this.depCode = depCode;
    }

    public int getCoPayAmt() {
        return this.coPayAmt;
    }

    public String getDepCode() {
        return this.depCode;
    }
}
