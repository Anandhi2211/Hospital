package com.solvd.hospital.medicalrecords;


public enum Treatment {
    laserTest(2000),
    bloodTest(1000),
    xRay(700),
    physiotherapy(400),
    antibiotics(200),
    painKillers(200);
    final int priceAmt;
    public int getPriceAmt() {
        return this.priceAmt;
    }
    Treatment( int priceAmt) {
        this.priceAmt = priceAmt;
    }
}
