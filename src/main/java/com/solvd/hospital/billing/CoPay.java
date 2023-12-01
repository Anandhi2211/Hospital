package com.solvd.hospital.billing;

public enum CoPay {
    DERMATOLOGY_CO_PAY(50, 100),
    OTOLARYNGOLOGY_CO_PAY(70, 101),
    ORTHOPEDIC_CO_PAY(100, 102);
    final int coPayAmt;
    final int depCode;
    public int getCoPayAmt() {
        return this.coPayAmt;
    }
    public int getDepCode() {
        return this.depCode;
    }
    CoPay(int coPayAmt, int depCode) {
        this.coPayAmt = coPayAmt;
        this.depCode = depCode;
    }
}
