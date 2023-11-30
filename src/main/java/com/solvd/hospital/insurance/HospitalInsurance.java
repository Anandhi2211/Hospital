package com.solvd.hospital.insurance;

public enum HospitalInsurance {
    CIGNA(10),
    MEDICAID(5),
    ANTHEM(20),
    CAREPLUS(15);

    public int getPercentConcession() {
        return percentConcession;
    }

    final int percentConcession;

    HospitalInsurance(int percentConcession) {
        this.percentConcession = percentConcession;
    }
}
