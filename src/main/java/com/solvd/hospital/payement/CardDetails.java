package com.solvd.hospital.payement;

public abstract class CardDetails {
    private String cardNumber;
    private String cardName;
    private String cvvNumber;

    public String getCardNumber() {
        return this.cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCardName() {
        return this.cardName;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    public String getCvvNumber() {
        return this.cvvNumber;
    }
    public void setCvvNumber(String cvvNumber) {
        this.cvvNumber = cvvNumber;
    }
}
