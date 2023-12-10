package com.solvd.hospital.billing;

import com.solvd.hospital.absctractclasses.CardDetails;

public class Payment extends CardDetails {

    private boolean paymentStatus;

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
