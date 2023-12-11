package com.solvd.hospital.billing;

import com.solvd.hospital.absctractclasses.CardDetails;

public class Payment extends CardDetails {

    private boolean paymentPaidStatus;

    public boolean isPaymentPaidStatus() {
        return this.paymentPaidStatus;
    }

    public void setPaymentPaidStatus(boolean paymentPaidStatus) {
        this.paymentPaidStatus = paymentPaidStatus;
    }
}
