package com.solvd.hospital.enums;

public enum HospitalInsurance {
    CIGNA(10),
    MEDICAID(5),
    ANTHEM(20),
    CAREPLUS(15);
    final int percentageConcession;

    HospitalInsurance(int percentConcession) {
        this.percentageConcession = percentConcession;
    }

    public int getPercentageConcession() {
        return this.percentageConcession;
    }
}
