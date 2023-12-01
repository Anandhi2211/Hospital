package com.solvd.hospital.insurance;

public enum HospitalInsurance {
    CIGNA(10),
    MEDICAID(5),
    ANTHEM(20),
    CAREPLUS(15);
    final int percentageConcession;
    public int getPercentageConcession() {
        return this.percentageConcession;
    }
    HospitalInsurance(int percentConcession) {
        this.percentageConcession = percentConcession;
    }
}
