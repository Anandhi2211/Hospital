package com.solvd.hospital.enums;


public enum Treatment {
    LASER_TEST(2000),
    BLOOD_TEST(1000),
    X_RAY(700),
    PHYSIOTHERAPY(400),
    ANTIBIOTICS(200),
    PAIN_KILLERS(200);
    final int priceAmt;

    Treatment(int priceAmt) {
        this.priceAmt = priceAmt;
    }

    public int getPriceAmt() {
        return this.priceAmt;
    }
}
