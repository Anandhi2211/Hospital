package com.solvd.hospital.billing;

public enum CoPay {
    DERMATOLOGY_CO_PAY(50),
    OTOLARYNGOLOGY_CO_PAY(70),
    ORTHOPEDIC_CO_PAY(100);
    final int coPayAmt;


    CoPay(int coPayAmt) {
        this.coPayAmt = coPayAmt;
    }
}
