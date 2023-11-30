package com.solvd.hospital.medicalrecords;


public enum Treatment {
    laserTest(2000),
    bloodTest(1000),
    xRay(700),
    physiotherapy(400),
    antibiotics(200),
    painKillers(200);

    public int getPriceAmt() {
        return priceAmt;
    }

    final int priceAmt;

    Treatment( int priceAmt) {
        this.priceAmt = priceAmt;
    }
}
