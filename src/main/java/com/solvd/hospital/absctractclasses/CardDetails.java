package com.solvd.hospital.absctractclasses;

import com.solvd.hospital.exceptions.ExceptionCardDetails;
import com.solvd.hospital.exceptions.ExceptionInsurance;

import java.util.regex.Pattern;

public abstract class CardDetails {
    private String cardNumber;
    private String cardName;
    private String cvvNumber;

    public void setCardNumber(String cardNumber) {
        String regex = "[0-9]+";
        if (!Pattern.matches(regex, cardNumber) || (!(cardNumber.length() == 16))) {
            throw new ExceptionCardDetails("Not a Valid Card Number");
        } else {
            this.cardNumber = cardNumber;
        }
    }

    public void setCardName(String cardName) {
        String regex = "[A-Za-z ]+";
        if (!Pattern.matches(regex, cardName)) {
            throw new ExceptionCardDetails("Not a Valid Card Name");
        } else {
            this.cardName = cardName;
        }
    }

    public void setCvvNumber(String cvvNumber) {
        String regex = "[0-9]+";
        if (!Pattern.matches(regex, cvvNumber) && !(this.cvvNumber.length() == 3)) {
            throw new ExceptionInsurance("Not a Valid Cvv Number");
        } else {
            this.cvvNumber = cvvNumber;
        }
    }

    @Override
    public String toString() {
        return "CardDetails{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cvvNumber='" + cvvNumber + '\'' +
                '}';
    }
}
